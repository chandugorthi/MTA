package com.csg.mta;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by chand on 6/28/2016.
 */
public class StationListAdapter extends ArrayAdapter<String[]> {

    private Activity context;
    private List<String[]> shortList;
    int[] imageIds = {R.id.imageView2, R.id.imageView3, R.id.imageView4, R.id.imageView5};

    public StationListAdapter(Activity context, int resource, List<String[]> objects) {
        super(context, resource, objects);
        shortList = objects;
        this.context = context;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent){
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.station_name, null, true);
        TextView stationName = (TextView) rowView.findViewById(R.id.textView159);
        String[] details = shortList.get(position);
        if (shortList.size()==1 && shortList.get(0)[0].equals("No stations found")){
            stationName.setText(shortList.get(0)[0]);
        } else {
            stationName.setText(details[2]);
            int iter = 0;
            String[] trains = details[8].split(" ");
            for (String train : trains) {
                ImageView img = (ImageView) rowView.findViewById(imageIds[iter]);
                switch (train) {
                    case ("1"):
                        img.setBackgroundResource(R.drawable.red_1);
                        break;
                    case ("2"):
                        img.setBackgroundResource(R.drawable.red_2);
                        break;
                    case ("3"):
                        img.setBackgroundResource(R.drawable.red_3);
                        break;
                    case ("4"):
                        img.setBackgroundResource(R.drawable.green_4);
                        break;
                    case ("5"):
                        img.setBackgroundResource(R.drawable.green_5);
                        break;
                    case ("6"):
                        img.setBackgroundResource(R.drawable.green_6);
                        break;
                    case ("L"):
                        img.setBackgroundResource(R.drawable.grey_l);
                        break;
                    case ("GS"):
                        img.setBackgroundResource(R.drawable.grey_s);
                        break;
                    case ("SI"):
                        img.setBackgroundResource(R.drawable.blue_sir);
                        break;
                }
                iter++;
            }
        }
        return rowView;
    }
}
