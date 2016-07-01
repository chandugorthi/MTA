package com.csg.mta;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by chand on 6/26/2016.
 */
public class StationList extends Fragment {

    private Map<LatLng,String[]> stops = new HashMap<LatLng,String[]>();
    private LocationPointer pointer;
    private List<String[]> details = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.station_list,container,false);
        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            pointer = (LocationPointer) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement TextClicked");
        }
    }

    public void init(Map<LatLng,String[]> origList){
        stops = origList;
    }

    public int update(String updatedString){
        details.clear();
        for(Map.Entry<LatLng,String[]> stop: stops.entrySet()){
            if (stop.getValue()[2].toLowerCase().contains(updatedString.toLowerCase())){
                details.add(stop.getValue());
            }
        }
        if(details.size()==0){
            details.add(new String[]{"No stations found"});
        }
        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(super.getActivity(),R.layout.station_name,finalList);
        StationListAdapter adapter1 = new StationListAdapter(super.getActivity(),R.layout.station_name,details);
        ListView displayList = (ListView)getActivity().findViewById(R.id.listView);
        displayList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                helper(position);
            }
        });
        displayList.setAdapter(adapter1);
        return details.size();
    }

    public interface LocationPointer{
        public void moveCamera(String[] position);
    }

    public void helper(int position){
        if (!details.get(0)[0].equals("No stations found")) {
            pointer.moveCamera(details.get(position));
        } else {
            pointer.moveCamera(null);
        }
    }

}
