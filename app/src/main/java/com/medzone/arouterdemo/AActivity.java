package com.medzone.arouterdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.medzone.arouterdemo.service.HelloService;

/**
 * @author Administrator
 * @since 2017/6/23 9:34
 */

@Route(path = "/arouterdemo/AActivity")
public class AActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnTestHelloService;

    @Autowired
    HelloService helloService;

    @Autowired(name = "/service/hello")
    HelloService helloService1;

    HelloService helloService2;
    HelloService helloService3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ARouter.getInstance().inject(this);
        setContentView(R.layout.activity_a);
        btnTestHelloService = (Button) findViewById(R.id.btn_test_hello_service);
        btnTestHelloService.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_test_hello_service:
                Toast.makeText(this, helloService.sayHello("Lily"), Toast.LENGTH_LONG).show();
                Toast.makeText(this, helloService1.sayHello("LiLei"), Toast.LENGTH_LONG).show();

                helloService2 = (HelloService) ARouter.getInstance().build("/service/hello").navigation();
                Toast.makeText(this, helloService2.sayHello("HanMei"), Toast.LENGTH_LONG).show();

                helloService3 = ARouter.getInstance().navigation(HelloService.class);
                Toast.makeText(this, helloService3.sayHello("Poly"), Toast.LENGTH_LONG).show();
                break;
            default:
                break;
        }
    }
}
