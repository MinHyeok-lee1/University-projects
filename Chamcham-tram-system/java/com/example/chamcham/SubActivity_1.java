package com.example.chamcham;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class SubActivity_1 extends AppCompatActivity {
    TextView Option, one, two, three, four, five;
    ImageView tram1, tram2, tram3, tram4, tram5;
    TextView A,B,C,D,E;
    Button a,aa,b,bb,c,cc,d,dd,e,ee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_blue1);
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

        tram1 = (ImageView) findViewById(R.id.tram01);
        tram2 = (ImageView) findViewById(R.id.tram02);
        tram3 = (ImageView) findViewById(R.id.tram03);
        tram4 = (ImageView) findViewById(R.id.tram04);
        tram5 = (ImageView) findViewById(R.id.tram05);

        Option = (TextView) findViewById(R.id.Optionn);
        one = (TextView) findViewById(R.id.onee);
        two = (TextView) findViewById(R.id.twoo);
        three = (TextView) findViewById(R.id.threee);
        four = (TextView) findViewById(R.id.fourr);
        five = (TextView) findViewById(R.id.fivee);

        A = (TextView) findViewById(R.id.AA);
        B = (TextView) findViewById(R.id.BB);
        C = (TextView) findViewById(R.id.CC);
        D = (TextView) findViewById(R.id.DD);
        E = (TextView) findViewById(R.id.EE);

        a = (Button) findViewById(R.id.button1aa);
//        aa = (Button) findViewById(R.id.button2aa);
//
//        b = (Button) findViewById(R.id.button1bb);
//        bb = (Button) findViewById(R.id.button2bb);
//
//        c = (Button) findViewById(R.id.button1cc);
//        cc = (Button) findViewById(R.id.button2cc);
//
//        d = (Button) findViewById(R.id.button1dd);
//        dd = (Button) findViewById(R.id.button2dd);
//
//        e = (Button) findViewById(R.id.button1ee);
//        ee = (Button) findViewById(R.id.button2ee);

        final Intent intent0 = new Intent(this, Popup2Activity.class);

        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent0);
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

