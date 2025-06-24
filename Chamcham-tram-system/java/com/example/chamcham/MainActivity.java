package com.example.chamcham;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button bt_pre; // 임산부 버튼
    Button bt_dis; // 휠체어 버튼
    Button bt_adi; // Analog 휠체어
    Button bt_mdi; // Magnetic 휠체어

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN); requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
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

        bt_pre = (Button) findViewById(R.id.btnPre);
        bt_dis = (Button) findViewById(R.id.btnDis);
        bt_adi = (Button) findViewById(R.id.btnAdi);
        bt_mdi = (Button) findViewById(R.id.btnMdi);
        final Intent intent = new Intent(this, MainActivity1.class);
        final Intent intent1 = new Intent(this, MainActivity_1.class);

        bt_pre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });
        bt_dis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bt_adi.setVisibility(View.VISIBLE);
                bt_mdi.setVisibility(View.VISIBLE);
            }
        });
        bt_mdi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Number.mag = 1;
                startActivity(intent1);
            }
        });
        bt_adi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Number.mag = 0;
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