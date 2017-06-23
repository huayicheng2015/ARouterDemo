package com.medzone.arouterdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

@Route(path = "/arouterdemo/MainActivity")
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnA;
    private Button btnB;
    private Button btnC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnA = (Button) findViewById(R.id.btn_activity_a);
        btnB = (Button) findViewById(R.id.btn_activity_b);
        btnC = (Button) findViewById(R.id.btn_activity_c);
        btnA.setOnClickListener(this);
        btnB.setOnClickListener(this);
        btnC.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_activity_a:
                ARouter.getInstance().build("/arouterdemo/AActivity").navigation();
                break;
            case R.id.btn_activity_b:
                ARouter.getInstance().build("/arouterdemo/BActivity").navigation();
                break;
            case R.id.btn_activity_c:
                ARouter.getInstance().build("/arouterdemo/CActivity").navigation();
                break;
            default:
                break;
        }
    }
}
