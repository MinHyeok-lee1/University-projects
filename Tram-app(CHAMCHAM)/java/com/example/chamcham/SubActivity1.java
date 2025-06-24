package com.example.chamcham;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class SubActivity1 extends AppCompatActivity {
    TextView Option, one, two, three, four, five;
    ImageView tram1, tram2, tram3, tram4, tram5;
    TextView A,B,C,D,E;
    Button a,aa,aaa,aaaa,b,bb,bbb,bbbb,c,cc,ccc,cccc,d,dd,ddd,dddd,e,ee,eee,eeee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_pink1);
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

        tram1 = (ImageView) findViewById(R.id.tram1);
        tram2 = (ImageView) findViewById(R.id.tram2);
        tram3 = (ImageView) findViewById(R.id.tram3);
        tram4 = (ImageView) findViewById(R.id.tram4);
        tram5 = (ImageView) findViewById(R.id.tram5);

        Option = (TextView) findViewById(R.id.Option);
        one = (TextView) findViewById(R.id.one);
        two = (TextView) findViewById(R.id.two);
        three = (TextView) findViewById(R.id.three);
        four = (TextView) findViewById(R.id.four);
        five = (TextView) findViewById(R.id.five);

        A = (TextView) findViewById(R.id.A);
        B = (TextView) findViewById(R.id.B);
        C = (TextView) findViewById(R.id.C);
        D = (TextView) findViewById(R.id.D);
        E = (TextView) findViewById(R.id.E);

        a = (Button) findViewById(R.id.button1A);
        aa = (Button) findViewById(R.id.button2A);
//        aaa = (Button) findViewById(R.id.button3A);
//        aaaa = (Button) findViewById(R.id.button4A);
//
//        b = (Button) findViewById(R.id.button1B);
//        bb = (Button) findViewById(R.id.button2B);
//        bbb = (Button) findViewById(R.id.button3B);
//        bbbb = (Button) findViewById(R.id.button4B);
//
//        c = (Button) findViewById(R.id.button1C);
//        cc = (Button) findViewById(R.id.button2C);
//        ccc = (Button) findViewById(R.id.button3C);
//        cccc = (Button) findViewById(R.id.button4C);
//
//
//        d = (Button) findViewById(R.id.button1E);
//        dd = (Button) findViewById(R.id.button2E);
//        ddd = (Button) findViewById(R.id.button3E);
//        dddd = (Button) findViewById(R.id.button4E);
//
//        e = (Button) findViewById(R.id.button1E);
//        ee = (Button) findViewById(R.id.button2E);
//        eee = (Button) findViewById(R.id.button3E);
//        eeee = (Button) findViewById(R.id.button4E);
        final Intent intent0 = new Intent(this, PopupActivity1.class);
        final Intent intent1 = new Intent(this, PopupActivity2.class);


        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent0);
            }
        });
        aa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent1);
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

