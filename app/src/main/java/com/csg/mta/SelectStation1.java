package com.csg.mta;

import android.content.Context;
import android.content.DialogInterface;
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

public class SelectStation1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_select_station1);
    }

    public void scrollStations(View view){
        ScrollView scroller = (ScrollView) findViewById(R.id.tableScroller);
        int location;
        switch(view.getId()){
            case (R.id.button22):
                scroller.scrollTo(0,0);
                break;
            case (R.id.button23):
                scroller.scrollTo(0,300);
                break;
        }
    }

    public void directiveButton(View view){
        Intent i;
        switch ((view.getId())){
            case (R.id.button100):
                i = new Intent(this, WelcomeScreen.class);
                startActivity(i);
                break;
            case (R.id.button101):
                i = new Intent(this, ShowLegend.class);
                startActivity(i);
                break;
        }
    }

    public void getTrainTime(View view){
        Intent i;
        Bundle data = new Bundle();
        data.putString("train", "1");
        switch(view.getId()) {
            case (R.id.button19):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "101");
                i.putExtras(data);
                break;
            case (R.id.button21):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "103");
                i.putExtras(data);
                break;
            case (R.id.button24):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "104");
                i.putExtras(data);
                break;
            case (R.id.button25):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "106");
                i.putExtras(data);
                break;
            case (R.id.button26):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "107");
                i.putExtras(data);
                break;
            case (R.id.button27):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "108");
                i.putExtras(data);
                break;
            case (R.id.button28):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "109");
                i.putExtras(data);
                break;
            case (R.id.button29):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "110");
                i.putExtras(data);
                break;
            case (R.id.button30):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "111");
                i.putExtras(data);
                break;
            case (R.id.button31):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "112");
                i.putExtras(data);
                break;
            case (R.id.button20):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "113");
                i.putExtras(data);
                break;
            case (R.id.button32):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "114");
                i.putExtras(data);
                break;
            case (R.id.button33):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "115");
                i.putExtras(data);
                break;
            case (R.id.button34):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "116");
                i.putExtras(data);
                break;
            case (R.id.button35):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "117");
                i.putExtras(data);
                break;
            case (R.id.button36):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "118");
                i.putExtras(data);
                break;
            case (R.id.button37):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "119");
                i.putExtras(data);
                break;
            case (R.id.button38):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "120");
                i.putExtras(data);
                break;
            case (R.id.button39):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "121");
                i.putExtras(data);
                break;
            case (R.id.button40):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "122");
                i.putExtras(data);
                break;
            case (R.id.button41):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "123");
                i.putExtras(data);
                break;
            case (R.id.button42):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "124");
                i.putExtras(data);
                break;
            case (R.id.button43):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "125");
                i.putExtras(data);
                break;
            case (R.id.button44):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "126");
                i.putExtras(data);
                break;
            case (R.id.button45):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "127");
                i.putExtras(data);
                break;
            case (R.id.button46):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "128");
                i.putExtras(data);
                break;
            case (R.id.button47):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "129");
                i.putExtras(data);
                break;
            case (R.id.button48):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "130");
                i.putExtras(data);
                break;
            case (R.id.button49):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "131");
                i.putExtras(data);
                break;
            case (R.id.button50):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "132");
                i.putExtras(data);
                break;
            case (R.id.button51):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "133");
                i.putExtras(data);
                break;
            case (R.id.button52):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "134");
                i.putExtras(data);
                break;
            case (R.id.button53):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "135");
                i.putExtras(data);
                break;
            case (R.id.button54):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "136");
                i.putExtras(data);
                break;
            case (R.id.button55):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "137");
                i.putExtras(data);
                break;
            case (R.id.button56):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "138");
                i.putExtras(data);
                break;
            case (R.id.button57):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "139");
                i.putExtras(data);
                break;
            case (R.id.button58):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "140");
                i.putExtras(data);
                break;
            default:
                i = new Intent(this, SelectStation1.class);
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
        getMenuInflater().inflate(R.menu.menu_select_station1, menu);
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
