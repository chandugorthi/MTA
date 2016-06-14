package com.csg.mta;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

public class SelectStationSIR extends AppCompatActivity {

    private Animation btnAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_station_sir);

        btnAnim = AnimationUtils.loadAnimation(this,R.anim.anim_alpha);
    }

    public void scrollStations(View view){
        ScrollView scroller = (ScrollView) findViewById(R.id.tableScroller);
        view.startAnimation(btnAnim);
        switch(view.getId()){
            case (R.id.button22):
                scroller.scrollTo(0,0);
                break;
            case (R.id.button23):
                scroller.scrollTo(0,scroller.getBottom());
                break;
        }
    }

    public void directiveButton(View view){
        Intent i;
        view.startAnimation(btnAnim);
        switch ((view.getId())){
            case (R.id.button107):
                i = new Intent(this, WelcomeScreen.class);
                startActivity(i);
                break;
            case (R.id.button108):
                i = new Intent(this, ShowLegend.class);
                startActivity(i);
                break;
        }
    }

    public void getTrainTime(View view) {
        Intent i;
        view.startAnimation(btnAnim);
        Bundle data = new Bundle();
        data.putString("train", "SI");
        switch (view.getId()) {
            case (R.id.button19):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "S09");
                i.putExtras(data);
                break;
            case (R.id.button21):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "S10");
                i.putExtras(data);
                break;
            case (R.id.button24):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "S12");
                i.putExtras(data);
                break;
            case (R.id.button25):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "S13");
                i.putExtras(data);
                break;
            case (R.id.button26):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "S14");
                i.putExtras(data);
                break;
            case (R.id.button27):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "S15");
                i.putExtras(data);
                break;
            case (R.id.button28):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "S16");
                i.putExtras(data);
                break;
            case (R.id.button29):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "S17");
                i.putExtras(data);
                break;
            case (R.id.button30):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "S18");
                i.putExtras(data);
                break;
            case (R.id.button31):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "S19");
                i.putExtras(data);
                break;
            case (R.id.button20):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "S20");
                i.putExtras(data);
                break;
            case (R.id.button32):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "S21");
                i.putExtras(data);
                break;
            case (R.id.button33):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "S22");
                i.putExtras(data);
                break;
            case (R.id.button34):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "S23");
                i.putExtras(data);
                break;
            case (R.id.button35):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "S24");
                i.putExtras(data);
                break;
            case (R.id.button36):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "S25");
                i.putExtras(data);
                break;
            case (R.id.button37):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "S26");
                i.putExtras(data);
                break;
            case (R.id.button38):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "S27");
                i.putExtras(data);
                break;
            case (R.id.button39):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "S28");
                i.putExtras(data);
                break;
            case (R.id.button40):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "S29");
                i.putExtras(data);
                break;
            case (R.id.button41):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "S30");
                i.putExtras(data);
                break;
            case (R.id.button42):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "S31");
                i.putExtras(data);
                break;
            default:
                i = new Intent(this, SelectStationSIR.class);
        }
        Button b = (Button) findViewById(view.getId());
        String text = b.getText().toString();
        data.putString("stationName", text);
        i.putExtras(data);
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            startActivity(i);
        } else {
            Toast.makeText(this, "Network Unavailable", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_select_station_sir, menu);
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
