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

public class SelectStation4 extends AppCompatActivity {

    private Animation btnAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_station4);

        btnAnim = AnimationUtils.loadAnimation(this,R.anim.anim_alpha);
    }

    public void scrollStations(View view){
        view.startAnimation(btnAnim);
        ScrollView scroller = (ScrollView) findViewById(R.id.tableScroller);
        switch(view.getId()){
            case (R.id.button85):
                scroller.scrollTo(0,0);
                break;
            case (R.id.button9):
                scroller.scrollTo(0,1170);
                break;
            case (R.id.button84):
                scroller.scrollTo(0,3060);
        }
    }

    public void directiveButton(View view){
        Intent i;
        view.startAnimation(btnAnim);
        switch ((view.getId())){
            case (R.id.button86):
                i = new Intent(this, WelcomeScreen.class);
                startActivity(i);
                break;
            case (R.id.button87):
                i = new Intent(this, ShowLegend.class);
                startActivity(i);
                break;
        }
    }

    public void getTrainTime(View view){
        Intent i;
        view.startAnimation(btnAnim);
        Bundle data = new Bundle();
        data.putString("train", "4");
        switch(view.getId()){
            case (R.id.button19):
                i = new Intent(this,TrainTimings.class);
                data.putString("station", "401");
                i.putExtras(data);
                break;
            case (R.id.button21):
                i = new Intent(this,TrainTimings.class);
                data.putString("station", "402");
                i.putExtras(data);
                break;
            case (R.id.button24):
                i = new Intent(this,TrainTimings.class);
                data.putString("station", "405");
                i.putExtras(data);
                break;
            case (R.id.button25):
                i = new Intent(this,TrainTimings.class);
                data.putString("station", "406");
                i.putExtras(data);
                break;
            case (R.id.button26):
                i = new Intent(this,TrainTimings.class);
                data.putString("station", "407");
                i.putExtras(data);
                break;
            case (R.id.button27):
                i = new Intent(this,TrainTimings.class);
                data.putString("station", "408");
                i.putExtras(data);
                break;
            case (R.id.button28):
                i = new Intent(this,TrainTimings.class);
                data.putString("station", "409");
                i.putExtras(data);
                break;
            case (R.id.button29):
                i = new Intent(this,TrainTimings.class);
                data.putString("station", "410");
                i.putExtras(data);
                break;
            case (R.id.button30):
                i = new Intent(this,TrainTimings.class);
                data.putString("station", "411");
                i.putExtras(data);
                break;
            case (R.id.button31):
                i = new Intent(this,TrainTimings.class);
                data.putString("station", "412");
                i.putExtras(data);
                break;
            case (R.id.button20):
                i = new Intent(this,TrainTimings.class);
                data.putString("station", "413");
                i.putExtras(data);
                break;
            case (R.id.button32):
                i = new Intent(this,TrainTimings.class);
                data.putString("station", "414");
                i.putExtras(data);
                break;
            case (R.id.button33):
                i = new Intent(this,TrainTimings.class);
                data.putString("station", "415");
                i.putExtras(data);
                break;
            case (R.id.button34):
                i = new Intent(this,TrainTimings.class);
                data.putString("station", "416");
                i.putExtras(data);
                break;
            case (R.id.button36):
                i = new Intent(this,TrainTimings.class);
                data.putString("station", "621");
                i.putExtras(data);
                break;
            case (R.id.button37):
                i = new Intent(this,TrainTimings.class);
                data.putString("station", "622");
                i.putExtras(data);
                break;
            case (R.id.button38):
                i = new Intent(this,TrainTimings.class);
                data.putString("station", "623");
                i.putExtras(data);
                break;
            case (R.id.button39):
                i = new Intent(this,TrainTimings.class);
                data.putString("station", "624");
                i.putExtras(data);
                break;
            case (R.id.button40):
                i = new Intent(this,TrainTimings.class);
                data.putString("station", "625");
                i.putExtras(data);
                break;
            case (R.id.button35):
                i = new Intent(this,TrainTimings.class);
                data.putString("station", "626");
                i.putExtras(data);
                break;
            case (R.id.button41):
                i = new Intent(this,TrainTimings.class);
                data.putString("station", "627");
                i.putExtras(data);
                break;
            case (R.id.button42):
                i = new Intent(this,TrainTimings.class);
                data.putString("station", "628");
                i.putExtras(data);
                break;
            case (R.id.button43):
                i = new Intent(this,TrainTimings.class);
                data.putString("station", "629");
                i.putExtras(data);
                break;
            case (R.id.button44):
                i = new Intent(this,TrainTimings.class);
                data.putString("station", "630");
                i.putExtras(data);
                break;
            case (R.id.button45):
                i = new Intent(this,TrainTimings.class);
                data.putString("station", "631");
                i.putExtras(data);
                break;
            case (R.id.button46):
                i = new Intent(this,TrainTimings.class);
                data.putString("station", "632");
                i.putExtras(data);
                break;
            case (R.id.button47):
                i = new Intent(this,TrainTimings.class);
                data.putString("station", "633");
                i.putExtras(data);
                break;
            case (R.id.button48):
                i = new Intent(this,TrainTimings.class);
                data.putString("station", "634");
                i.putExtras(data);
                break;
            case (R.id.button49):
                i = new Intent(this,TrainTimings.class);
                data.putString("station", "635");
                i.putExtras(data);
                break;
            case (R.id.button50):
                i = new Intent(this,TrainTimings.class);
                data.putString("station", "636");
                i.putExtras(data);
                break;
            case (R.id.button51):
                i = new Intent(this,TrainTimings.class);
                data.putString("station", "637");
                i.putExtras(data);
                break;
            case (R.id.button52):
                i = new Intent(this,TrainTimings.class);
                data.putString("station", "638");
                i.putExtras(data);
                break;
            case (R.id.button53):
                i = new Intent(this,TrainTimings.class);
                data.putString("station", "639");
                i.putExtras(data);
                break;
            case (R.id.button54):
                i = new Intent(this,TrainTimings.class);
                data.putString("station", "640");
                i.putExtras(data);
                break;
            case (R.id.button55):
                i = new Intent(this,TrainTimings.class);
                data.putString("station", "418");
                i.putExtras(data);
                break;
            case (R.id.button56):
                i = new Intent(this,TrainTimings.class);
                data.putString("station", "419");
                i.putExtras(data);
                break;
            case (R.id.button57):
                i = new Intent(this,TrainTimings.class);
                data.putString("station", "420");
                i.putExtras(data);
                break;
            case (R.id.button59):
                i = new Intent(this,TrainTimings.class);
                data.putString("station", "423");
                i.putExtras(data);
                break;
            case (R.id.button60):
                i = new Intent(this,TrainTimings.class);
                data.putString("station", "234");
                i.putExtras(data);
                break;
            case (R.id.button61):
                i = new Intent(this,TrainTimings.class);
                data.putString("station", "235");
                i.putExtras(data);
                break;
            case (R.id.button62):
                i = new Intent(this,TrainTimings.class);
                data.putString("station", "236");
                i.putExtras(data);
                break;
            case (R.id.button63):
                i = new Intent(this,TrainTimings.class);
                data.putString("station", "237");
                i.putExtras(data);
                break;
            case (R.id.button64):
                i = new Intent(this,TrainTimings.class);
                data.putString("station", "238");
                i.putExtras(data);
                break;
            case (R.id.button65):
                i = new Intent(this,TrainTimings.class);
                data.putString("station", "239");
                i.putExtras(data);
                break;
            case (R.id.button58):
                i = new Intent(this,TrainTimings.class);
                data.putString("station", "248");
                i.putExtras(data);
                break;
            case (R.id.button67):
                i = new Intent(this,TrainTimings.class);
                data.putString("station", "249");
                i.putExtras(data);
                break;
            case (R.id.button68):
                i = new Intent(this,TrainTimings.class);
                data.putString("station", "250");
                i.putExtras(data);
                break;
            case (R.id.button69):
                i = new Intent(this,TrainTimings.class);
                data.putString("station", "251");
                i.putExtras(data);
                break;
            case (R.id.button70):
                i = new Intent(this,TrainTimings.class);
                data.putString("station", "252");
                i.putExtras(data);
                break;
            case (R.id.button71):
                i = new Intent(this,TrainTimings.class);
                data.putString("station", "253");
                i.putExtras(data);
                break;
            case (R.id.button72):
                i = new Intent(this,TrainTimings.class);
                data.putString("station", "254");
                i.putExtras(data);
                break;
            case (R.id.button73):
                i = new Intent(this,TrainTimings.class);
                data.putString("station", "255");
                i.putExtras(data);
                break;
            case (R.id.button74):
                i = new Intent(this,TrainTimings.class);
                data.putString("station", "256");
                i.putExtras(data);
                break;
            case (R.id.button75):
                i = new Intent(this,TrainTimings.class);
                data.putString("station", "257");
                i.putExtras(data);
                break;
            default:
                i = new Intent(this,SelectStation4.class);
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
        getMenuInflater().inflate(R.menu.menu_select_station4, menu);
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
