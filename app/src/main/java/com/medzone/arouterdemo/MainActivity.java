package com.medzone.arouterdemo;

import android.content.Intent;
import android.net.Uri;
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
    private Button btn2Baidu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnA = (Button) findViewById(R.id.btn_activity_a);
        btnB = (Button) findViewById(R.id.btn_activity_b);
        btnC = (Button) findViewById(R.id.btn_activity_c);
        btn2Baidu = (Button) findViewById(R.id.btn_to_baidu);
        btnA.setOnClickListener(this);
        btnB.setOnClickListener(this);
        btnC.setOnClickListener(this);
        btn2Baidu.setOnClickListener(this);
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
            case R.id.btn_to_baidu:
                Uri uri = new Uri.Builder()
                        .scheme("http")
                        .authority("dev.mcloudlife.com")
                        .path("/img/chat/gm_bp_1.png")
                        .query("time=1451275894")
                        .build();
                Intent it = new Intent(this, SchemaFilterActivity.class);
                it.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                it.setData(uri);
                startActivity(it);
                break;
            default:
                break;
        }
    }
}
