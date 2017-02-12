package com.a0x80bits.multitouchtester;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import java.nio.channels.AlreadyBoundException;

public class Home extends AppCompatActivity {
    private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        final TextView touchspace = (TextView) findViewById(R.id.touchspace);
        final TextView touchesinfo = (TextView) findViewById(R.id.touchesinfo);
        touchspace.setOnTouchListener(new View.OnTouchListener(){

            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int pointerCount = motionEvent.getPointerCount();
                int pointerId = motionEvent.getPointerId(0);
                touchesinfo.setText("Total Active Touches : "+pointerCount);
                String touchdata="Touch Data: ";
                for(int i=0;i<pointerCount;i++)
                {
                    int x = (int) motionEvent.getX(i);
                    int y = (int) motionEvent.getY(i);
                    int id = motionEvent.getPointerId(i);
                    int action = motionEvent.getActionMasked();
                    int actionIndex = motionEvent.getActionIndex();
                    touchdata = touchdata + "\n Point "+(id+1)+":"+x+","+y;
                    touchspace.setText(touchdata);

                }
                return true;
            }
        });

        // Admob

        MobileAds.initialize(getApplicationContext(), "ca-app-pub-2447577947606854~8948069326");
        mAdView = (AdView) findViewById(R.id.adView);
        /*
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)        // All emulators
                .addTestDevice("CB6BE4AD7D2225D1F360AA4D436B14EA")  // An example device ID
                .build();
         */
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.menu_help:
                startActivity(new Intent(Home.this, Help.class));
                return true;
            case R.id.menu_about:
                startActivity(new Intent(Home.this, about.class));
                return true;
            case R.id.menu_exit:
                System.exit(0);
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
