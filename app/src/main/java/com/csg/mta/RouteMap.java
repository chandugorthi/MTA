package com.csg.mta;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.app.FragmentTransaction;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class RouteMap extends FragmentActivity implements GoogleMap.OnMarkerClickListener, SearchStations.TextChangeListener,StationList.LocationPointer{

    private GoogleMap mMap; // Might be null if Google Play services APK is not available.
    private Map<String,String[]> stations = new HashMap<String, String[]>();
    private Map<String,Marker> dup = new HashMap<>();
    private Marker prevMarker = null;
    private Location ny;
    private List<String> codes = new ArrayList<String>(Arrays.asList("10001", "10002", "10003", "10004", "10005", "10006", "10007", "10009", "10010", "10011", "10012", "10013", "10014", "10016", "10017", "10018", "10019", "10020", "10021", "10022", "10023", "10024", "10025", "10026", "10027", "10028", "10029", "10030", "10031", "10032", "10033", "10034", "10035", "10036", "10037", "10038", "10039", "10040", "10044", "10065", "10069", "10075", "10103", "10110", "10111", "10112", "10115", "10119", "10128", "10152", "10153", "10154", "10162", "10165", "10167", "10168", "10169", "10170", "10171", "10172", "10173", "10174", "10177", "10199", "10271", "10278", "10279", "10280", "10282", "10301", "10302", "10303", "10304", "10305", "10306", "10307", "10308", "10309", "10310", "10311", "10312", "10314", "10451", "10452", "10453", "10454", "10455", "10456", "10457", "10458", "10459", "10460", "10461", "10462", "10463", "10464", "10465", "10466", "10467", "10468", "10469", "10470", "10471", "10472", "10473", "10474", "10475", "11004", "11005", "11101", "11102", "11103", "11104", "11105", "11106", "11109", "11201", "11203", "11204", "11205", "11206", "11207", "11208", "11209", "11210", "11211", "11212", "11213", "11214", "11215", "11216", "11217", "11218", "11219", "11220", "11221", "11222", "11223", "11224", "11225", "11226", "11228", "11229", "11230", "11231", "11232", "11233", "11234", "11235", "11236", "11237", "11238", "11239", "11351", "11354", "11355", "11356", "11357", "11358", "11359", "11360", "11361", "11362", "11363", "11364", "11365", "11366", "11367", "11368", "11369", "11370", "11371", "11372", "11373", "11374", "11375", "11377", "11378", "11379", "11385", "11411", "11412", "11413", "11414", "11415", "11416", "11417", "11418", "11419", "11420", "11421", "11422", "11423", "11424", "11425", "11426", "11427", "11428", "11429", "11430", "11432", "11433", "11434", "11435", "11436", "11451", "11691", "11692", "11693", "11694", "11697"));
    private Map<LatLng,String[]> stops = new HashMap<LatLng,String[]>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route_map);
        setUpMapIfNeeded();
        mMap.getUiSettings().setMyLocationButtonEnabled(false);
        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(RouteMap.this.getCurrentFocus().getWindowToken(),0);
            }
        });
    }

    public void onMapReady(GoogleMap map) {
        if (!inCity()) {
            ny = new Location("");
            ny.setLatitude(40.754244);
            ny.setLongitude(-73.982678);
        }
        InputStream inputStream = getResources().openRawResource(R.raw.stops);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        map.setOnMarkerClickListener(this);
        try {
            String csvLine;

            while ((csvLine = reader.readLine()) != null) {
                String[] row = csvLine.split(",");
                if(row[0].equals("stop_id")){
                    continue;
                }
                LatLng position = new LatLng(Float.parseFloat(row[4]),Float.parseFloat(row[5]));
                Marker halt = map.addMarker(new MarkerOptions()
                        .title(row[2])
                        .position(position).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
                if (!stops.containsKey(row[2])){
                    LatLng pos = new LatLng(Double.parseDouble(row[4]),Double.parseDouble(row[5]));
                    stops.put(pos,row);
                }
                String id = halt.getId();
                dup.put(id,halt);
                stations.put(id,row);
            }
        }
        catch (IOException ex) {
            throw new RuntimeException("Error in reading CSV file: "+ex);
        }
        finally {
            try {
                inputStream.close();
            }
            catch (IOException e) {
                throw new RuntimeException("Error closing input stream: "+e);
            }
        }
        map.setMyLocationEnabled(true);
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(ny.getLatitude(),ny.getLongitude()),14));

        map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.setCustomAnimations(R.anim.abc_slide_in_bottom, R.anim.abc_slide_out_bottom);
        StationInfo info = (StationInfo) getFragmentManager().findFragmentById(R.id.infoFragment);
        RelativeLayout layout = (RelativeLayout) findViewById(R.id.infoFragment);
        layout.setVisibility(View.VISIBLE);
        if (prevMarker != null){
            prevMarker.setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));
        }
        prevMarker = marker;
        marker.setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
        String id = marker.getId();
        info.setInfo(stations.get(id),marker);
        ft.commit();

        /*FragmentManager fm = getFragmentManager();
        fm.beginTransaction().setCustomAnimations(R.anim.abc_fade_in,R.anim.abc_fade_out).show(getFragmentManager().
                findFragmentById(R.id.infoFragment)).commit();*/
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }

    /**
     * Sets up the map if it is possible to do so (i.e., the Google Play services APK is correctly
     * installed) and the map has not already been instantiated.. This will ensure that we only ever
     * call {@link #setUpMap()} once when {@link #mMap} is not null.
     * <p/>
     * If it isn't installed {@link SupportMapFragment} (and
     * {@link com.google.android.gms.maps.MapView MapView}) will show a prompt for the user to
     * install/update the Google Play services APK on their device.
     * <p/>
     * A user can return to this FragmentActivity after following the prompt and correctly
     * installing/updating/enabling the Google Play services. Since the FragmentActivity may not
     * have been completely destroyed during this process (it is likely that it would only be
     * stopped or paused), {@link #onCreate(Bundle)} may not be called again so we should call this
     * method in {@link #onResume()} to guarantee that it will be called.
     */
    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                onMapReady(mMap);
            }
        }

        FragmentTransaction ft = getFragmentManager().beginTransaction();
        //ft.setCustomAnimations(R.anim.abc_fade_in, R.anim.abc_fade_out);
        SearchStations info = (SearchStations) getFragmentManager().findFragmentById(R.id.searchFragment);
        RelativeLayout layout = (RelativeLayout) findViewById(R.id.searchFragment);
        info.init();
        layout.setVisibility(View.VISIBLE);
        ft.commit();

    }

    /**
     * This is where we can add markers or lines, add listeners or move the camera. In this case, we
     * just add a marker near Africa.
     * <p/>
     * This should only be called once and when we are sure that {@link #mMap} is not null.
     */
    private void setUpMap() {
        mMap.addMarker(new MarkerOptions().position(new LatLng(0, 0)).title("Marker"));
    }

    private boolean inCity(){
        final LocationManager locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);

// Define a listener that responds to location updates
        LocationListener locationListener = new LocationListener() {
            public void onLocationChanged(Location location) {
                // Called when a new location is found by the network location provider.
                ny = location;

            }

            public void onStatusChanged(String provider, int status, Bundle extras) {}

            public void onProviderEnabled(String provider) {
                ny = locationManager.getLastKnownLocation(provider);
            }

            public void onProviderDisabled(String provider) {}
        };

// Register the listener with the Location Manager to receive location updates
        if(locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 2, locationListener);
            ny = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        } else {
            Toast.makeText(this,"GPS is not enabled", Toast.LENGTH_SHORT).show();
            return false;
        }

        locationManager.removeUpdates(locationListener);
        Geocoder gcd = new Geocoder(this, Locale.getDefault());
        try {
            if (ny!=null) {
                List<Address> addresses = gcd.getFromLocation(ny.getLatitude(), ny.getLongitude(), 1);
                String code = addresses.get(0).getPostalCode();
                if (codes.contains(code)) {
                    return true;
                }
            }
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setMessage("You are out of New York City. Taking you back to the city.").setTitle("Out of city");
            //mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(ny.getLatitude(),ny.getLongitude()),14));
            alert.setPositiveButton("Ok",new DialogInterface.OnClickListener(){
                public void onClick(DialogInterface dialog, int id){

                }
            });
            AlertDialog dialog = alert.create();
            dialog.show();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
        }


        return false;
    }

    @Override
    public void onTextChange(String updated) {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        //ft.setCustomAnimations(R.anim.abc_fade_in, R.anim.abc_fade_out);
        StationList list = (StationList) getFragmentManager().findFragmentById(R.id.listFragment);
        LinearLayout layout = (LinearLayout) findViewById(R.id.listFragment);
        list.init(stops);
        if (!updated.equals("")) {
            layout.setVisibility(View.VISIBLE);
            layout.bringToFront();
            int items = list.update(updated);
            ViewGroup.LayoutParams params = layout.getLayoutParams();
            if (items > 3){
                params.height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 150, getResources().getDisplayMetrics());
                layout.setLayoutParams(params);
            } else {
                params.height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 50*items, getResources().getDisplayMetrics());
                layout.setLayoutParams(params);
            }
            ft.commit();
        } else {
            layout.setVisibility(View.GONE);
            ft.commit();
        }
    }

    @Override
    public void moveCamera(String[] position) {
        if (position!= null) {
            LatLng camera = new LatLng(Float.parseFloat(position[4]), Float.parseFloat(position[5]));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(camera, 16));
            String id = "";
            for (Map.Entry<String, String[]> station : stations.entrySet()) {
                if (station.getValue().equals(position)) {
                    id = station.getKey();
                    break;
                }
            }
            onMarkerClick(dup.get(id));
        }
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        //ft.setCustomAnimations(R.anim.abc_fade_in, R.anim.abc_fade_out);
        SearchStations info = (SearchStations) getFragmentManager().findFragmentById(R.id.searchFragment);
        info.clearText();
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(this.getCurrentFocus().getWindowToken(),0);
        ft.commit();
    }

    public void relocate(View v){
        final LocationManager locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);

// Define a listener that responds to location updates
        LocationListener locationListener = new LocationListener() {
            public void onLocationChanged(Location location) {
                // Called when a new location is found by the network location provider.
                ny = location;

            }

            public void onStatusChanged(String provider, int status, Bundle extras) {}

            public void onProviderEnabled(String provider) {
                ny = locationManager.getLastKnownLocation(provider);
            }

            public void onProviderDisabled(String provider) {}
        };

// Register the listener with the Location Manager to receive location updates
        if(locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 2, locationListener);
            ny = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        } else {
            Toast.makeText(this,"GPS is not enabled", Toast.LENGTH_SHORT).show();
        }

        locationManager.removeUpdates(locationListener);
        if (ny!=null) {
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(ny.getLatitude(),ny.getLongitude()), 16));
        } else {
            Toast.makeText(this,"Unable to get location", Toast.LENGTH_SHORT).show();
        }
    }

}
