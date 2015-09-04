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

public class SelectStation5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_station5);
    }

    public void scrollStations(View view){
        ScrollView scroller = (ScrollView) findViewById(R.id.tableScroller);
        int location;
        switch(view.getId()){
            case (R.id.button84):
                scroller.scrollTo(0,0);
                break;
            case (R.id.button9):
                scroller.scrollTo(0,1340);
                break;
            case (R.id.button8):
                scroller.scrollTo(0,2300);
                break;
        }
    }

    public void directiveButton(View view){
        Intent i;
        switch ((view.getId())){
            case (R.id.button89):
                i = new Intent(this, WelcomeScreen.class);
                startActivity(i);
                break;
            case (R.id.button88):
                i = new Intent(this, ShowLegend.class);
                startActivity(i);
                break;
        }
    }

    public void getTrainTime(View view) {
        Intent i;
        Bundle data = new Bundle();
        data.putString("train", "5");
        switch (view.getId()) {
            case (R.id.button19):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "501");
                i.putExtras(data);
                break;
            case (R.id.button21):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "502");
                i.putExtras(data);
                break;
            case (R.id.button24):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "503");
                i.putExtras(data);
                break;
            case (R.id.button25):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "504");
                i.putExtras(data);
                break;
            case (R.id.button26):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "505");
                i.putExtras(data);
                break;
            case (R.id.button27):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "213");
                i.putExtras(data);
                break;
            case (R.id.button28):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "214");
                i.putExtras(data);
                break;
            case (R.id.button29):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "215");
                i.putExtras(data);
                break;
            case (R.id.button30):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "216");
                i.putExtras(data);
                break;
            case (R.id.button31):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "217");
                i.putExtras(data);
                break;
            case (R.id.button20):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "218");
                i.putExtras(data);
                break;
            case (R.id.button32):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "219");
                i.putExtras(data);
                break;
            case (R.id.button33):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "220");
                i.putExtras(data);
                break;
            case (R.id.button34):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "221");
                i.putExtras(data);
                break;
            case (R.id.button35):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "222");
                i.putExtras(data);
                break;
            case (R.id.button36):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "416");
                i.putExtras(data);
                break;
            case (R.id.button38):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "225");
                i.putExtras(data);
                break;
            case (R.id.button39):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "626");
                i.putExtras(data);
                break;
            case (R.id.button40):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "629");
                i.putExtras(data);
                break;
            case (R.id.button37):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "631");
                i.putExtras(data);
                break;
            case (R.id.button41):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "635");
                i.putExtras(data);
                break;
            case (R.id.button42):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "640");
                i.putExtras(data);
                break;
            case (R.id.button43):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "418");
                i.putExtras(data);
                break;
            case (R.id.button44):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "419");
                i.putExtras(data);
                break;
            case (R.id.button45):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "420");
                i.putExtras(data);
                break;
            case (R.id.button47):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "423");
                i.putExtras(data);
                break;
            case (R.id.button48):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "234");
                i.putExtras(data);
                break;
            case (R.id.button49):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "235");
                i.putExtras(data);
                break;
            case (R.id.button50):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "239");
                i.putExtras(data);
                break;
            case (R.id.button51):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "241");
                i.putExtras(data);
                break;
            case (R.id.button52):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "242");
                i.putExtras(data);
                break;
            case (R.id.button53):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "243");
                i.putExtras(data);
                break;
            case (R.id.button54):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "244");
                i.putExtras(data);
                break;
            case (R.id.button55):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "245");
                i.putExtras(data);
                break;
            case (R.id.button56):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "246");
                i.putExtras(data);
                break;
            case (R.id.button57):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "247");
                i.putExtras(data);
                break;
            default:
                i = new Intent(this,SelectStation5.class);
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
            AlertDialog exitMsg = new AlertDialog.Builder(this).setIcon(android.R.drawable.ic_dialog_alert).setTitle("Info")
                    .setMessage("Network not available. Check your Internet connection and try again")
                    .setPositiveButton("Ok", null).show();
        }
    }

            @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_select_station5, menu);
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
