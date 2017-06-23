package com.medzone.arouterdemo.service.impl;

import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.medzone.arouterdemo.service.HelloService;

/**
 * @author Administrator
 * @since 2017/6/23 16:01
 */

@Route(path = "/service/hello")
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String name) {
        return "Hello ".concat(name);
    }

    @Override
    public void init(Context context) {

    }
}
