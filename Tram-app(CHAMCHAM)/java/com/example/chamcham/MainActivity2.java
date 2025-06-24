package com.example.chamcham;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity2 extends AppCompatActivity {
    ImageView mainS;
    TextView number;
    TextView name;
    TextView noti;
    TextView date;
    TextView seat;
    View b;
    TextView textViewName, textViewAddress;

    Button bt_tram;
    Button bt_info;
    Button bt_home;
    Button bt_card;
    //qr code scanner object
    private IntentIntegrator qrScan;
    private Button buttonScan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_mainp2);
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
        number = (TextView) findViewById(R.id.number2);
        noti = (TextView) findViewById(R.id.noti2);
        name = (TextView) findViewById(R.id.name2);
        date = (TextView) findViewById(R.id.date2);
        seat = (TextView) findViewById(R.id.Seat);
        b = (View) findViewById(R.id.box2);

        mainS = (ImageView) findViewById(R.id.MainScreen2);
        bt_tram = (Button) findViewById(R.id.btntramp2);
        bt_home = (Button) findViewById(R.id.btnhomep2);
        bt_card = (Button) findViewById(R.id.btncard2);
        bt_info = (Button) findViewById(R.id.btninfop2);
        buttonScan = (Button) findViewById(R.id.scanQr);
        if(Number.save == 1) seat.setText("4호차 1A자리에서  QR코드를 태깅해주세요");
        else if(Number.save == 2) seat.setText("4호차 2A자리에서  QR코드를 태깅해주세요");
        //intializing scan object
        qrScan = new IntentIntegrator(this);
        //button onClick
        buttonScan.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                qrScan.setOrientationLocked(false); // default가 세로모드인데 휴대폰 방향에 따라 가로, 세로로 자동 변경됩니다.
                if(Number.save == 1) qrScan.setPrompt("4호차 1A자리를 태깅해주세요");
                else if(Number.save == 2) qrScan.setPrompt("4호차 2A자리를 태깅해주세요");
                qrScan.initiateScan();
            }
        });

        final Intent intent0 = new Intent(this, MainActivity2.class);
        final Intent intent2 = new Intent(this, SubActivity2.class);
        final Intent intent3 = new Intent(this, SubActivity3.class);
        final Intent intent4 = new Intent(this, SubActivity4.class);

        bt_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent0);
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

    //Getting the scan results
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        final Intent intent1 = new Intent(this, MainActivity1.class);
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.toast_border2, (ViewGroup)findViewById(R.id.toast_layout_root));

        if (result != null) {
            //qrcode 가 없으면
            if (result.getContents() == null) {
                TextView text = (TextView) layout.findViewById(R.id.text);
                text.setText("취소되었습니다.");

                Toast toast = new Toast(getApplicationContext());
                int offsetX = 0;
                int offsetY = 0;
                toast.setGravity(Gravity.CENTER, offsetX, offsetY);
                toast.setDuration(Toast.LENGTH_SHORT);
                //toast.setGravity(Gravity.TOP|Gravity.LEFT, 200, 200);
                toast.setView(layout);
                toast.show();
//                Toast.makeText(MainActivity2.this, "취소!", Toast.LENGTH_SHORT).show();
            } else {
                //qrcode 결과가 있으면
                try {
                    //data를 json으로 변환
                    JSONObject obj = new JSONObject(result.getContents());
                    if(("RESERVATION OF CHAMONE").equals(obj.getString("name")) && (Number.save == 1)){
                        TextView text = (TextView) layout.findViewById(R.id.text);
                        text.setText("4호차 1A자리를 태깅완료");

                        Toast toast = new Toast(getApplicationContext());
                        int offsetX = 0;
                        int offsetY = 0;
                        toast.setGravity(Gravity.CENTER, offsetX, offsetY);
                        toast.setDuration(Toast.LENGTH_SHORT);
                        //toast.setGravity(Gravity.TOP|Gravity.LEFT, 200, 200);
                        toast.setView(layout);
                        toast.show();
//                        Toast.makeText(MainActivity2.this, "4호차 1A자리를 태깅완료", Toast.LENGTH_SHORT).show();
                        Number.save = 0;
                        startActivity(intent1);
                    } else if(("RESERVATION OF CHAMTWO").equals(obj.getString("name")) && (Number.save == 2)){
                        TextView text = (TextView) layout.findViewById(R.id.text);
                        text.setText("4호차 2A자리를 태깅완료");

                        Toast toast = new Toast(getApplicationContext());
                        int offsetX = 0;
                        int offsetY = 0;
                        toast.setGravity(Gravity.CENTER, offsetX, offsetY);
                        toast.setDuration(Toast.LENGTH_SHORT);
                        //toast.setGravity(Gravity.TOP|Gravity.LEFT, 200, 200);
                        toast.setView(layout);
                        toast.show();
                        Number.save = 0;
                        startActivity(intent1);

//                        Toast.makeText(MainActivity2.this, "4호차 2A자리를 태깅완료", Toast.LENGTH_SHORT).show();
                    } else {
                        TextView text = (TextView) layout.findViewById(R.id.text);
                        text.setText("잘못된 태깅입니다.");

                        Toast toast = new Toast(getApplicationContext());
                        int offsetX = 0;
                        int offsetY = 0;
                        toast.setGravity(Gravity.CENTER, offsetX, offsetY);
                        toast.setDuration(Toast.LENGTH_SHORT);
                        //toast.setGravity(Gravity.TOP|Gravity.LEFT, 200, 200);
                        toast.setView(layout);
                        toast.show();

//                        Toast.makeText(MainActivity2.this, "잘못된 태깅입니다.", Toast.LENGTH_SHORT).show();
                }} catch (JSONException e) {
                    e.printStackTrace();
                    //Toast.makeText(MainActivity.this, result.getContents(), Toast.LENGTH_LONG).show();
                    //textViewResult.setText(result.getContents());
                }
            }

        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
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
