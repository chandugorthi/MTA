package com.csg.mta;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.transit.realtime.GtfsRealtime;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class TrainTimings extends AppCompatActivity {

    private Animation btnAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle getData = getIntent().getExtras();
        String train = getData.getString("train");
        String station = getData.getString("station");
        String stationName = getData.getString("stationName");
        setContentView(R.layout.activity_train_timings);
        btnAnim = AnimationUtils.loadAnimation(this,R.anim.anim_alpha);
        TextView name = (TextView) findViewById(R.id.textView154);
        name.setText(stationName);
        TextView number = (TextView) findViewById(R.id.textView4);
        if (Build.VERSION.SDK_INT >= 21) {
            Drawable image;
            switch (train){
                case ("1"):
                    image = getDrawable(R.drawable.black_1);
                    break;
                case ("2"):
                    image = getDrawable(R.drawable.black_2);
                    break;
                case ("3"):
                    image = getDrawable(R.drawable.black_3);
                    break;
                case ("4"):
                    image = getDrawable(R.drawable.black_4);
                    break;
                case ("5"):
                    image = getDrawable(R.drawable.black_5);
                    break;
                case ("6"):
                    image = getDrawable(R.drawable.black_6);
                    break;
                case ("L"):
                    image = getDrawable(R.drawable.black_l);
                    break;
                case ("GS"):
                    image = getDrawable(R.drawable.black_s);
                    break;
                case ("SI"):
                    image = getDrawable(R.drawable.black_sir);
                    break;
                default:
                    image = null;
            }
            number.setBackground(image);
        } else {
            switch (train){
                case ("1"):
                    number.setBackgroundResource(R.drawable.black_1);
                    break;
                case ("2"):
                    number.setBackgroundResource(R.drawable.black_2);
                    break;
                case ("3"):
                    number.setBackgroundResource(R.drawable.black_3);
                    break;
                case ("4"):
                    number.setBackgroundResource(R.drawable.black_4);
                    break;
                case ("5"):
                    number.setBackgroundResource(R.drawable.black_5);
                    break;
                case ("6"):
                    number.setBackgroundResource(R.drawable.black_6);
                    break;
                case ("L"):
                    number.setBackgroundResource(R.drawable.black_l);
                    break;
                case ("GS"):
                    number.setBackgroundResource(R.drawable.black_s);
                    break;
                case ("SI"):
                    number.setBackgroundResource(R.drawable.black_sir);
                    break;
            }
        }

        FindTrip trip = new FindTrip();
        ArrayList<String> details = new ArrayList<String>();
        details.add(train);
        details.add(station);
        trip.execute(details);
    }

    private class Trains {
        private List<Long> northBound;
        private List<Long> southBound;

        public Trains(){
            northBound = new ArrayList<Long>();
            southBound = new ArrayList<Long>();
        }

        public void sort(){
            Collections.sort(northBound);
            Collections.sort(southBound);
        }

        public void addNorth(long value){
            northBound.add(value);
        }

        public void addSouth(long value){
            southBound.add(value);
        }

        public long getNorth(int index){
            return northBound.get(index);
        }

        public long getSouth(int index){
            return southBound.get(index);
        }

        public int getNorthSize(){
            return northBound.size();
        }

        public int getSouthSize(){
            return southBound.size();
        }

    }

    private class FindTrip extends AsyncTask<ArrayList<String> , Long, Trains> {

        @Override
        protected Trains doInBackground(ArrayList<String>... params) {
            GtfsRealtime.FeedMessage feed;
            String train = params[0].get(0);
            String station = params[0].get(1);
            Trains allTrains = new Trains();
            try {
                feed = trackSubways(train);
                int i = 0;
                long time = System.currentTimeMillis()/1000;
                for (GtfsRealtime.FeedEntity entity : feed.getEntityList()){
                    if(entity.hasTripUpdate()){
                        GtfsRealtime.TripUpdate update = entity.getTripUpdate();
                        if (update.getTrip().getRouteId().contains(train)) {
                            if (update.getTrip().getTripId().contains("..N")) {
                                for (GtfsRealtime.TripUpdate.StopTimeUpdate stopTime : update.getStopTimeUpdateList()) {
                                    if (stopTime.getStopId().contains(station)) {
                                        long arr = stopTime.getArrival().getTime();
                                        if (arr == 0) {
                                            arr = stopTime.getDeparture().getTime();
                                        }
                                        allTrains.addNorth(arr);
                                    }
                                }
                            }
                        }
                        if (update.getTrip().getRouteId().contains(train)){
                            if (update.getTrip().getTripId().contains("..S")) {
                                for (GtfsRealtime.TripUpdate.StopTimeUpdate stopTime : update.getStopTimeUpdateList()) {
                                    if (stopTime.getStopId().contains(station)) {
                                        long arr = stopTime.getArrival().getTime();
                                        if (arr == 0) {
                                            arr = stopTime.getDeparture().getTime();
                                        }
                                        allTrains.addSouth(arr);
                                    }
                                }
                            }
                        }
                    }
                }
                allTrains.sort();
                return allTrains;
            } catch (Exception e){
                e.printStackTrace();
            }
            return null;
        }


        @Override
        protected void onPostExecute(Trains trains) {
            int trainIndex = 0,iter = 0;
            long time = System.currentTimeMillis()/1000;
            if(trains.getNorthSize()==0){
                TextView arrival = (TextView) findViewById(R.id.textView5);
                arrival.setText("Currently there are no trains in this direction");
            }
            int[] textIdsNorth = {R.id.textView5, R.id.textView6, R.id.textView7, R.id.textView8, R.id.textView9, R.id.textView10};
            while(trainIndex < trains.getNorthSize() && iter < 6){
                long arrTimeN = trains.getNorth(trainIndex);
                long etaN = arrTimeN - time;
                if(etaN<0){
                    trainIndex++;
                    continue;
                }
                Date date = new Date(arrTimeN*1000);
                SimpleDateFormat dateFormat = new SimpleDateFormat("h:mm a", Locale.US);
                dateFormat.setTimeZone(TimeZone.getTimeZone("America/New_York"));
                String formattedDate = dateFormat.format(date);
                TextView arrival = (TextView) findViewById(textIdsNorth[iter]);
                arrival.setText(formattedDate);
                iter++;
                TextView remTime = (TextView) findViewById(textIdsNorth[iter]);
                if (etaN/60 < 1){
                    remTime.setText("Now");
                } else if(etaN/60 == 1) {
                    remTime.setText(etaN/60 + " min");
                } else {
                    remTime.setText(etaN/60 + " mins");
                }
                trainIndex++;
                iter++;
            }
            trainIndex = 0;
            iter = 0;
            if(trains.getSouthSize()==0){
                TextView arrival = (TextView) findViewById(R.id.textView13);
                arrival.setText("Currently there are no trains in this direction");
            }
            int[] textIdsSouth = {R.id.textView13, R.id.textView14, R.id.textView15, R.id.textView16, R.id.textView17, R.id.textView18};
            while(trainIndex < trains.getSouthSize() && iter < 6){
                long arrTimeS = trains.getSouth(trainIndex);
                long etaS = arrTimeS - time;
                if(etaS<0){
                    trainIndex++;
                    continue;
                }
                Date date = new Date(arrTimeS*1000);
                SimpleDateFormat dateFormat = new SimpleDateFormat("h:mm a", Locale.US);
                dateFormat.setTimeZone(TimeZone.getTimeZone("America/New_York"));
                String formattedDate = dateFormat.format(date);
                TextView arrival = (TextView) findViewById(textIdsSouth[iter]);
                arrival.setText(formattedDate.toString());
                iter++;
                TextView remTime = (TextView) findViewById(textIdsSouth[iter]);
                if (etaS/60 < 1){
                    remTime.setText("Now");
                } else if(etaS/60 == 1) {
                    remTime.setText(etaS/60 + " min");
                } else {
                    remTime.setText(etaS/60 + " mins");
                }
                trainIndex++;
                iter++;
            }
            SimpleDateFormat dateFormat = new SimpleDateFormat("h:mm a", Locale.US);
            dateFormat.setTimeZone(TimeZone.getTimeZone("America/New_York"));
            TextView currTime = (TextView) findViewById(R.id.textView157);
            String currDate = dateFormat.format(new Date());
            currTime.setText("Now: " + currDate + " EDT");
            super.onPostExecute(trains);
        }
    }

    public GtfsRealtime.FeedMessage trackSubways (String line) throws Exception{
        URL url;
        if(line.equals("L")) {
            url = new URL("http://datamine.mta.info/mta_esi.php?key=80484f68ab9762f2341eac75d9a44feb&feed_id=2");
        } else if (line.equals("SI")){
            url = new URL("http://datamine.mta.info/mta_esi.php?key=80484f68ab9762f2341eac75d9a44feb&feed_id=11");
        } else {
            url = new URL("http://datamine.mta.info/mta_esi.php?key=80484f68ab9762f2341eac75d9a44feb&feed_id=1");
        }
        GtfsRealtime.FeedMessage feed = GtfsRealtime.FeedMessage.parseFrom(url.openStream());
        return feed;
    }

    public void directiveButton(View view){
        Intent i;
        view.startAnimation(btnAnim);
        switch ((view.getId())){
            case (R.id.button10):
                i = new Intent(this, WelcomeScreen.class);
                startActivity(i);
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_train_timings, menu);
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
