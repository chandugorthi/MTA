package com.csg.mta;

import android.app.ActionBar;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class WelcomeScreen extends AppCompatActivity {

    private Animation btnAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);

        btnAnim = AnimationUtils.loadAnimation(this,R.anim.anim_alpha);

        final View view = findViewById(R.id.mainScreen);
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                @Override
                public void onGlobalLayout() {
                    view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    addButtons(view.getWidth(),view.getHeight());
                }
            });
        }

    }

    private void addButtons(int width, int height){
        RelativeLayout screen = (RelativeLayout) findViewById(R.id.mainScreen);

        Button mapButton = new Button(this);
        Button lineButton = new Button(this);

        int buttonHeight = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 54*height/649, getResources().getDisplayMetrics());
        int buttonWidth = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 212*width/365, getResources().getDisplayMetrics());
        RelativeLayout.LayoutParams mparams = new RelativeLayout.LayoutParams(new ActionBar.LayoutParams(212*width/365,54*height/649));
        RelativeLayout.LayoutParams lparams = new RelativeLayout.LayoutParams(new ActionBar.LayoutParams(212*width/365,54*height/649));

        mparams.setMargins(72*width/365, 220*height/649,0,0);
        mapButton.setLayoutParams(mparams);
        mapButton.setText("Find closest station");
        mapButton.setTextColor(Color.parseColor("#E8E8E8"));
        mapButton.setTypeface(null,Typeface.BOLD);
        mapButton.setTextSize(17);
        mapButton.setPadding(34*width/365,0,0,0);
        mapButton.setBackgroundResource(R.drawable.map_bg);
        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToMap(v);
            }
        });
        screen.addView(mapButton);

        lparams.setMargins(72*width/365, 280*height/649,0,0);
        lineButton.setLayoutParams(lparams);
        lineButton.setText("Select train");
        lineButton.setTypeface(null,Typeface.BOLD);
        lineButton.setTextColor(Color.parseColor("#E8E8E8"));
        lineButton.setTextSize(18);
        lineButton.setBackgroundResource(R.drawable.line_bg);
        lineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectLine(v);
            }
        });

        screen.addView(lineButton);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_welcome_screen, menu);
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

    public void goToMap(View view){
        view.startAnimation(btnAnim);
        if (isNetworkAvailable(this)){
            Intent i = new Intent(this,RouteMap.class);
            startActivity(i);
        } else {
            Toast.makeText(this, "Network Unavailable", Toast.LENGTH_SHORT).show();
        }
    }

    public boolean isNetworkAvailable(Context con){
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();

        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public void selectLine(View view){
        view.startAnimation(btnAnim);
        Intent i = new Intent(this,SelectLine.class);
        startActivity(i);
    }

    @Override
    public void onBackPressed() {
        AlertDialog exitMsg = new AlertDialog.Builder(this).setIcon(android.R.drawable.ic_dialog_alert).setTitle("Exit")
                .setMessage("Are you sure?")
                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Intent intent = new Intent(Intent.ACTION_MAIN);
                        intent.addCategory(Intent.CATEGORY_HOME);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                        finish();
                    }
                }).setNegativeButton("no", null).show();
    }

}
