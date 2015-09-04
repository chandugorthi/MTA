package com.csg.mta;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.view.View;

public class SelectLine extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_line);
    }

    public void trainStation(View view){
        Intent i;
        switch(view.getId()){
            case (R.id.button2):
                i = new Intent(this,SelectStation1.class);
                break;
            case (R.id.button):
                i = new Intent(this,SelectStation2.class);
                break;
            case (R.id.button3):
                i = new Intent(this,SelectStation3.class);
                break;
            case (R.id.button6):
                i = new Intent(this,SelectStation4.class);
                break;
            case (R.id.button4):
                i = new Intent(this,SelectStation5.class);
                break;
            case (R.id.button5):
                i = new Intent(this,SelectStation6.class);
                break;
            case (R.id.button8):
                i = new Intent(this,SelectStationS.class);
                break;
            case (R.id.button7):
                i = new Intent(this,SelectStationL.class);
                break;
            case (R.id.button18):
                i = new Intent(this,SelectStationSIR.class);
                break;
            default:
                i = new Intent(this,SelectLine.class);
        }
        startActivity(i);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_select_line, menu);
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
