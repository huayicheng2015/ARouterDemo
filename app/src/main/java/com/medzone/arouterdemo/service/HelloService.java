package com.medzone.arouterdemo.service;

import com.alibaba.android.arouter.facade.template.IProvider;

/**
 * @author Administrator
 * @since 2017/6/23 15:59
 */

public interface HelloService extends IProvider {
    String sayHello(String name);
}
