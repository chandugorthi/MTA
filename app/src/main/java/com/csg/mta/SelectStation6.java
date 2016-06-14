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

public class SelectStation6 extends AppCompatActivity {

    private Animation btnAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_station6);

        btnAnim = AnimationUtils.loadAnimation(this,R.anim.anim_alpha);
    }

    public void scrollStations(View view){
        view.startAnimation(btnAnim);
        ScrollView scroller = (ScrollView) findViewById(R.id.tableScroller);
        switch(view.getId()){
            case (R.id.button22):
                scroller.scrollTo(0,0);
                break;
            case (R.id.button23):
                scroller.scrollTo(0,1500);
                break;
        }
    }

    public void directiveButton(View view){
        Intent i;
        view.startAnimation(btnAnim);
        switch ((view.getId())){
            case (R.id.button93):
                i = new Intent(this, WelcomeScreen.class);
                startActivity(i);
                break;
            case (R.id.button92):
                i = new Intent(this, ShowLegend.class);
                startActivity(i);
                break;
        }
    }

    public void getTrainTime(View view) {
        Intent i;
        view.startAnimation(btnAnim);
        Bundle data = new Bundle();
        data.putString("train", "6");
        switch (view.getId()) {
            case (R.id.button19):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "601");
                i.putExtras(data);
                break;
            case (R.id.button21):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "602");
                i.putExtras(data);
                break;
            case (R.id.button24):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "603");
                i.putExtras(data);
                break;
            case (R.id.button25):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "604");
                i.putExtras(data);
                break;
            case (R.id.button26):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "606");
                i.putExtras(data);
                break;
            case (R.id.button27):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "607");
                i.putExtras(data);
                break;
            case (R.id.button28):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "608");
                i.putExtras(data);
                break;
            case (R.id.button29):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "609");
                i.putExtras(data);
                break;
            case (R.id.button30):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "610");
                i.putExtras(data);
                break;
            case (R.id.button31):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "611");
                i.putExtras(data);
                break;
            case (R.id.button20):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "612");
                i.putExtras(data);
                break;
            case (R.id.button32):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "613");
                i.putExtras(data);
                break;
            case (R.id.button33):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "614");
                i.putExtras(data);
                break;
            case (R.id.button34):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "615");
                i.putExtras(data);
                break;
            case (R.id.button35):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "616");
                i.putExtras(data);
                break;
            case (R.id.button36):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "617");
                i.putExtras(data);
                break;
            case (R.id.button37):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "618");
                i.putExtras(data);
                break;
            case (R.id.button38):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "619");
                i.putExtras(data);
                break;
            case (R.id.button40):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "621");
                i.putExtras(data);
                break;
            case (R.id.button39):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "622");
                i.putExtras(data);
                break;
            case (R.id.button41):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "623");
                i.putExtras(data);
                break;
            case (R.id.button42):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "624");
                i.putExtras(data);
                break;
            case (R.id.button43):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "625");
                i.putExtras(data);
                break;
            case (R.id.button44):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "626");
                i.putExtras(data);
                break;
            case (R.id.button45):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "627");
                i.putExtras(data);
                break;
            case (R.id.button46):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "628");
                i.putExtras(data);
                break;
            case (R.id.button47):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "629");
                i.putExtras(data);
                break;
            case (R.id.button48):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "630");
                i.putExtras(data);
                break;
            case (R.id.button49):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "631");
                i.putExtras(data);
                break;
            case (R.id.button50):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "632");
                i.putExtras(data);
                break;
            case (R.id.button51):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "633");
                i.putExtras(data);
                break;
            case (R.id.button52):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "634");
                i.putExtras(data);
                break;
            case (R.id.button53):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "635");
                i.putExtras(data);
                break;
            case (R.id.button54):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "636");
                i.putExtras(data);
                break;
            case (R.id.button55):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "637");
                i.putExtras(data);
                break;
            case (R.id.button56):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "638");
                i.putExtras(data);
                break;
            case (R.id.button57):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "639");
                i.putExtras(data);
                break;
            case (R.id.button58):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "640");
                i.putExtras(data);
                break;
            default:
                i = new Intent(this, SelectStation6.class);
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
        getMenuInflater().inflate(R.menu.menu_select_station6, menu);
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
