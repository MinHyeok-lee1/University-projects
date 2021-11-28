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

public class MainActivity_2 extends AppCompatActivity {
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

    Button bt_selDe;
    EditText edit_selHi;
    Button bt_sleHir;
    private View decorView;
    private int	uiOption;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_mainb2);


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

        bt_selDe = (Button) findViewById(R.id.selectDevice);
        edit_selHi = (EditText) findViewById(R.id.selectHigh);
        bt_sleHir = (Button) findViewById(R.id.selectHigher);

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
        bt_selDe.setOnClickListener(new View.OnClickListener() {
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
        bt_sleHir.setOnClickListener(new View.OnClickListener() {
            LayoutInflater inflater = getLayoutInflater();
            View layout = inflater.inflate(R.layout.toast_border_2, (ViewGroup)findViewById(R.id.toast_layout_root));

            @Override
            public void onClick(View v) {
                String str = edit_selHi.getText().toString().trim();

                //아래 str에 숫자만 있을 경우는 NumberFormatException이
                //발생치 않으나 숫자 이외의 어떤 문자가 포함되면
                //NumberFormatException이 발생한다.
                //따라서 이 Exception이 발생하면 숫자 이외의 값이 입력되었다고
                //판단하고 재 입력 받도록 처리하면된다.
                int rt = Integer.parseInt(str);

                // rt를 전송해주는 코드가 필요하다 도르
                if(50 <= rt && rt <= 78){
                    TextView text = (TextView) layout.findViewById(R.id.text);
                    text.setText("입력이 완료되었습니다.");

                    Toast toast = new Toast(getApplicationContext());
                    int offsetX = 0;
                    int offsetY = 0;
                    toast.setGravity(Gravity.CENTER, offsetX, offsetY);
                    toast.setDuration(Toast.LENGTH_SHORT);
                    //toast.setGravity(Gravity.TOP|Gravity.LEFT, 200, 200);
                    toast.setView(layout);
                    toast.show();
                }else{
                    TextView text = (TextView) layout.findViewById(R.id.text);
                    text.setText("50에서 78의 값으로 입력해주세요!");

                    Toast toast = new Toast(getApplicationContext());
                    int offsetX = 0;
                    int offsetY = 0;
                    toast.setGravity(Gravity.CENTER, offsetX, offsetY);
                    toast.setDuration(Toast.LENGTH_SHORT);
                    //toast.setGravity(Gravity.TOP|Gravity.LEFT, 200, 200);
                    toast.setView(layout);
                    toast.show();
                }
                onWindowFocusChanged(hasWindowFocus());
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
