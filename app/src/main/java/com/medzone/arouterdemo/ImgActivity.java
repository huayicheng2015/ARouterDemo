package com.medzone.arouterdemo;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.bumptech.glide.Glide;

/**
 * @author Administrator
 * @since 2017/6/23 14:14
 */

@Route(group = "img", path = "/img/chat/gm_bp_1.png")
public class ImgActivity extends AppCompatActivity {
    private ImageView ivImg;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_img);
        ivImg = (ImageView) findViewById(R.id.iv_img);
        String uriStr = getIntent().getStringExtra(ARouter.RAW_URI);
        Glide.with(this).load(uriStr).into(ivImg);
    }
}
