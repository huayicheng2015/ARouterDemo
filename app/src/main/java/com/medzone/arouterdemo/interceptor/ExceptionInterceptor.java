package com.medzone.arouterdemo.interceptor;

import android.content.Context;
import android.util.Log;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;

/**
 * @author Administrator
 * @since 2017/6/23 15:03
 */

@Interceptor(priority = 1)
public class ExceptionInterceptor implements IInterceptor {
    @Override
    public void process(Postcard postcard, InterceptorCallback callback) {
        callback.onInterrupt(new RuntimeException());
    }

    @Override
    public void init(Context context) {
        Log.i(getClass().getSimpleName(), "interceptor inits");
    }
}
