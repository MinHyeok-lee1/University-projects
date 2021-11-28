package com.example.chamcham;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity1 extends AppCompatActivity {
    ImageView mainS;
    TextView number;
    TextView name;
    TextView noti;
    TextView date;
    View b;

    Button bt_tram;
    Button bt_info;
    Button bt_home;
    Button bt_card;
    Button bt_reservation;
    Button bt_like;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_mainp);
        int uiOptions = getWindow().getDecorView().getSystemUiVisibility();
        int newUiOptions = uiOptions;
        boolean isImmersiveModeEnabled = ((uiOptions | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY) == uiOptions);
        if (isImmersiveModeEnabled) {
            Log.i("Is on?", "Turning immersive mode mode off. ");
        } else {
            Log.i("Is on?", "Turning immersive mode mode on.");
        }
// 몰입 모드
        newUiOptions ^= View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
        newUiOptions ^= View.SYSTEM_UI_FLAG_FULLSCREEN;
        newUiOptions ^= View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        getWindow().getDecorView().setSystemUiVisibility(newUiOptions);
        number = (TextView) findViewById(R.id.number);
        noti = (TextView) findViewById(R.id.noti);
        name = (TextView) findViewById(R.id.name);
        date = (TextView) findViewById(R.id.date);
        b = (View) findViewById(R.id.box);

        mainS = (ImageView) findViewById(R.id.MainScreen);
        bt_tram = (Button) findViewById(R.id.btnTramp);
        bt_reservation = (Button) findViewById(R.id.btnReservation);
        bt_home = (Button) findViewById(R.id.btnHomep);
        bt_card = (Button) findViewById(R.id.btnCard);
        bt_info = (Button) findViewById(R.id.btnInfop);
        bt_like = (Button) findViewById(R.id.like);
        final Intent intent0 = new Intent(this, MainActivity1.class);
        final Intent intent1 = new Intent(this, SubActivity1.class);
        final Intent intent2 = new Intent(this, SubActivity2.class);
        final Intent intent3 = new Intent(this, SubActivity3.class);
        final Intent intent4 = new Intent(this, SubActivity4.class);
        final Intent intent5 = new Intent(this, SubActivity5.class);


        bt_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent0);
            }
        });
        bt_reservation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent1);
            }
        });
        bt_tram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent2);
            }
        });
        bt_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent3);
            }
        });
        bt_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent4);
            }
        });
        bt_like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent5);
            }
        });

    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }

}
