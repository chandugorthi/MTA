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

public class SelectStation2 extends AppCompatActivity{

    private Animation btnAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_station2);

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
                scroller.scrollTo(0,1650);
                break;
        }
    }

    public void directiveButton(View view){
        Intent i;
        view.startAnimation(btnAnim);
        switch ((view.getId())){
            case (R.id.button66):
                i = new Intent(this, WelcomeScreen.class);
                startActivity(i);
                break;
            case (R.id.button83):
                i = new Intent(this, ShowLegend.class);
                startActivity(i);
                break;
        }
    }

    public void getTrainTime(View view) {
        Intent i;
        view.startAnimation(btnAnim);
        Bundle data = new Bundle();
        data.putString("train", "2");
        switch (view.getId()) {
            case (R.id.button19):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "201");
                i.putExtras(data);
                break;
            case (R.id.button21):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "204");
                i.putExtras(data);
                break;
            case (R.id.button24):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "205");
                i.putExtras(data);
                break;
            case (R.id.button25):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "206");
                i.putExtras(data);
                break;
            case (R.id.button26):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "207");
                i.putExtras(data);
                break;
            case (R.id.button27):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "208");
                i.putExtras(data);
                break;
            case (R.id.button28):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "209");
                i.putExtras(data);
                break;
            case (R.id.button29):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "210");
                i.putExtras(data);
                break;
            case (R.id.button30):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "211");
                i.putExtras(data);
                break;
            case (R.id.button31):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "212");
                i.putExtras(data);
                break;
            case (R.id.button20):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "213");
                i.putExtras(data);
                break;
            case (R.id.button32):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "214");
                i.putExtras(data);
                break;
            case (R.id.button33):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "215");
                i.putExtras(data);
                break;
            case (R.id.button34):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "216");
                i.putExtras(data);
                break;
            case (R.id.button35):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "217");
                i.putExtras(data);
                break;
            case (R.id.button36):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "218");
                i.putExtras(data);
                break;
            case (R.id.button37):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "219");
                i.putExtras(data);
                break;
            case (R.id.button38):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "220");
                i.putExtras(data);
                break;
            case (R.id.button39):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "221");
                i.putExtras(data);
                break;
            case (R.id.button40):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "220");
                i.putExtras(data);
                break;
            case (R.id.button41):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "224");
                i.putExtras(data);
                break;
            case (R.id.button42):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "225");
                i.putExtras(data);
                break;
            case (R.id.button43):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "226");
                i.putExtras(data);
                break;
            case (R.id.button44):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "227");
                i.putExtras(data);
                break;
            case (R.id.button45):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "120");
                i.putExtras(data);
                break;
            case (R.id.button46):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "121");
                i.putExtras(data);
                break;
            case (R.id.button47):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "122");
                i.putExtras(data);
                break;
            case (R.id.button48):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "123");
                i.putExtras(data);
                break;
            case (R.id.button49):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "124");
                i.putExtras(data);
                break;
            case (R.id.button50):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "125");
                i.putExtras(data);
                break;
            case (R.id.button51):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "126");
                i.putExtras(data);
                break;
            case (R.id.button52):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "127");
                i.putExtras(data);
                break;
            case (R.id.button53):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "128");
                i.putExtras(data);
                break;
            case (R.id.button54):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "129");
                i.putExtras(data);
                break;
            case (R.id.button55):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "130");
                i.putExtras(data);
                break;
            case (R.id.button56):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "131");
                i.putExtras(data);
                break;
            case (R.id.button57):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "132");
                i.putExtras(data);
                break;
            case (R.id.button58):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "133");
                i.putExtras(data);
                break;
            case (R.id.button59):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "134");
                i.putExtras(data);
                break;
            case (R.id.button60):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "135");
                i.putExtras(data);
                break;
            case (R.id.button61):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "136");
                i.putExtras(data);
                break;
            case (R.id.button62):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "137");
                i.putExtras(data);
                break;
            case (R.id.button63):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "228");
                i.putExtras(data);
                break;
            case (R.id.button64):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "229");
                i.putExtras(data);
                break;
            case (R.id.button65):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "230");
                i.putExtras(data);
                break;
            case (R.id.button67):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "231");
                i.putExtras(data);
                break;
            case (R.id.button68):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "232");
                i.putExtras(data);
                break;
            case (R.id.button69):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "233");
                i.putExtras(data);
                break;
            case (R.id.button70):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "234");
                i.putExtras(data);
                break;
            case (R.id.button71):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "235");
                i.putExtras(data);
                break;
            case (R.id.button72):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "236");
                i.putExtras(data);
                break;
            case (R.id.button73):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "237");
                i.putExtras(data);
                break;
            case (R.id.button74):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "238");
                i.putExtras(data);
                break;
            case (R.id.button75):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "239");
                i.putExtras(data);
                break;
            case (R.id.button76):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "241");
                i.putExtras(data);
                break;
            case (R.id.button77):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "242");
                i.putExtras(data);
                break;
            case (R.id.button78):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "243");
                i.putExtras(data);
                break;
            case (R.id.button79):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "244");
                i.putExtras(data);
                break;
            case (R.id.button80):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "245");
                i.putExtras(data);
                break;
            case (R.id.button81):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "246");
                i.putExtras(data);
                break;
            case (R.id.button82):
                i = new Intent(this, TrainTimings.class);
                data.putString("station", "247");
                i.putExtras(data);
                break;
            default:
                i = new Intent(this, SelectStation2.class);
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
        getMenuInflater().inflate(R.menu.menu_select_station2, menu);
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
