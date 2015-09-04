package com.csg.mta;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;

public class SelectStationS extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_station_s);
    }

    public void directiveButton(View view){
        Intent i;
        switch ((view.getId())){
            case (R.id.button97):
                i = new Intent(this, WelcomeScreen.class);
                startActivity(i);
                break;
            case (R.id.button96):
                i = new Intent(this, ShowLegend.class);
                startActivity(i);
                break;
        }
    }

    public void getTrainTime(View view) {
        Intent i;
        Bundle data = new Bundle();
        data.putString("train", "GS");
        switch (view.getId()) {
            case (R.id.button98):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "901");
                i.putExtras(data);
                break;
            case (R.id.button99):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "902");
                i.putExtras(data);
                break;
            default:
                i = new Intent(this, SelectStationS.class);
        }
        Button b = (Button) findViewById(view.getId());
        String text = b.getText().toString();
        System.out.println("Psyther: " + text);
        data.putString("stationName", text);
        i.putExtras(data);
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            startActivity(i);
        } else {
            AlertDialog exitMsg = new AlertDialog.Builder(this).setIcon(android.R.drawable.ic_dialog_alert).setTitle("Info")
                    .setMessage("Network not available. Check your Internet connection and try again")
                    .setPositiveButton("Ok", null).show();
        }
    }

            @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_select_station, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
