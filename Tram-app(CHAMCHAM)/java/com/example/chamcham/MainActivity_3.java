package com.example.chamcham;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity_3 extends AppCompatActivity {
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

    private View decorView;
    private int	uiOption;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_mainb3);


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

        decorView = getWindow().getDecorView();
        uiOption = getWindow().getDecorView().getSystemUiVisibility();
        if( Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH )
            uiOption |= View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
        if( Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN )
            uiOption |= View.SYSTEM_UI_FLAG_FULLSCREEN;
        if( Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT )
            uiOption |= View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;

        number = (TextView) findViewById(R.id.numberr2);
        noti = (TextView) findViewById(R.id.notii2);
        name = (TextView) findViewById(R.id.namee2);
        date = (TextView) findViewById(R.id.datee2);
        b = (View) findViewById(R.id.boxx2);
        mainS = (ImageView) findViewById(R.id.MainScreenn2);

        bt_tram = (Button) findViewById(R.id.btntrampp2);
        bt_home = (Button) findViewById(R.id.btnhomepp2);
        bt_card = (Button) findViewById(R.id.btncardd2);
        bt_info = (Button) findViewById(R.id.btninfopp2);

        number.bringToFront();
        noti.bringToFront();
        name.bringToFront();
        date.bringToFront();

        final Intent intent = new Intent(this, MainActivity_1.class);
        final Intent intent0 = new Intent(this, MainActivity_2.class);
        final Intent intent1 = new Intent(this, MainActivity_3.class);
        final Intent intent2 = new Intent(this, SubActivity_2.class);
        final Intent intent3 = new Intent(this, SubActivity_3.class);
        final Intent intent4 = new Intent(this, SubActivity_4.class);

        bt_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Number.save == 0) startActivity(intent);
                else if(Number.save != 0 && Number.mag == 1) startActivity(intent0);
                else startActivity(intent1);
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
