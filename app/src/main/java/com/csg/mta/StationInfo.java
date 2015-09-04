package com.csg.mta;

import android.app.ActionBar;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Chandu on 8/23/2015.
 */

public class StationInfo extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.station_info,container,false);
        return view;
    }

    public void setInfo(final String[] details){
        RelativeLayout layout = (RelativeLayout) getView().findViewById(R.id.infoFragment);
        layout.removeAllViews();
        int txtId = 1;
        TextView stopName = new TextView(getActivity());
        int textHeight = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 40, getResources().getDisplayMetrics());
        int textWidth = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 50, getResources().getDisplayMetrics());
        RelativeLayout.LayoutParams textParams = new RelativeLayout.LayoutParams(new ActionBar.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        textParams.setMargins(20, 10, 0, 0);
        textParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        textParams.addRule(RelativeLayout.ALIGN_PARENT_START);
        textParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        stopName.setLayoutParams(textParams);
        stopName.setText(details[2]);
        stopName.setTextColor(Color.WHITE);
        stopName.setTextSize(24);
        stopName.setId(txtId);
        layout.addView(stopName);
        Button close = new Button(getActivity());
        int cButtonHeight = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 15, getResources().getDisplayMetrics());
        int cButtonWidth = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 15, getResources().getDisplayMetrics());
        RelativeLayout.LayoutParams cButtonParams = new RelativeLayout.LayoutParams(new ActionBar.LayoutParams(cButtonWidth,cButtonHeight));
        cButtonParams.setMargins(0,15,15,0);
        cButtonParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        cButtonParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        cButtonParams.addRule(RelativeLayout.ALIGN_PARENT_END);
        close.setLayoutParams(cButtonParams);
        close.setBackgroundResource(R.drawable.close_button);
        layout.addView(close);
        String[] trains = details[8].split(" ");
        int id = 2,iter = 1;
        for(final String train:trains) {
            Button b = new Button(getActivity());
            int height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 40, getResources().getDisplayMetrics());
            int width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 50, getResources().getDisplayMetrics());
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(new ActionBar.LayoutParams(width,height));
            if (train.equals("GS")) {
                b.setText("S");
            } else if (train.equals("SI")){
                b.setText("SIR");
            } else {
                b.setText(train);
            }
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i;
                    Bundle data = new Bundle();
                    data.putString("train", train);
                    i = new Intent(getActivity().getBaseContext(), TrainTimings.class);
                    data.putString("station", details[0]);
                    i.putExtras(data);
                    data.putString("stationName", details[2]);
                    i.putExtras(data);
                    startActivity(i);
                }
            });
            b.setBackgroundColor(Color.WHITE);
            b.setId(id);
            if (iter==1) {
                params.addRule(RelativeLayout.BELOW, txtId);
                params.setMargins(10, 5, 5, 10);
                params.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
                params.addRule(RelativeLayout.ALIGN_PARENT_START);
            } else {
                params.addRule(RelativeLayout.ALIGN_TOP,id-1);
                params.addRule(RelativeLayout.RIGHT_OF,id-1);
                params.addRule(RelativeLayout.END_OF,id-1);
                params.setMargins(10,0,5,0);
            }
            b.setLayoutParams(params);
            b.setTextColor(Color.BLACK);
            layout.addView(b);
            iter++;
            id++;
        }
    }



}
