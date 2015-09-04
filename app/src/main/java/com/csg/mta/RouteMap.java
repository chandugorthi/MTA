package com.csg.mta;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class RouteMap extends FragmentActivity implements GoogleMap.OnMarkerClickListener{

    private GoogleMap mMap; // Might be null if Google Play services APK is not available.
    private Map<String,String[]> stations = new HashMap<String, String[]>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route_map);
        setUpMapIfNeeded();
        Button b;
    }

    public void onMapReady(GoogleMap map) {
        LatLng ny = new LatLng(40.7314339,-74.0287157);
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
                String id = halt.getId();
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
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(ny, 10));

        map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.setCustomAnimations(R.anim.abc_fade_in, R.anim.abc_fade_out);
        StationInfo info = (StationInfo) getSupportFragmentManager().findFragmentById(R.id.infoFragment);
        RelativeLayout layout = (RelativeLayout) findViewById(R.id.infoFragment);
        layout.setVisibility(View.VISIBLE);
        String id = marker.getId();
        info.setInfo(stations.get(id));

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



}
