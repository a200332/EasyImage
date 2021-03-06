package com.example.zane.easyimageprovider.download;

import android.app.Application;
import android.content.Context;

import com.example.zane.easyimageprovider.download.dispatch.RequestQueue;
import com.example.zane.easyimageprovider.download.policy.FIFOPolicy;
import com.example.zane.easyimageprovider.download.policy.ImageLoadPolicy;

/**
 * Created by Zane on 16/5/15.
 */

//整体加载配置Builder类,必须在Applicaiton中进行全局初始化
public class EasyImageLoadConfiguration {

    /**
     * 加载策略,默认先进先加载
     */
    private ImageLoadPolicy loadPolicy = new FIFOPolicy();

    /**
     * 线程池线程最高数
     */
    private int threadCount = Runtime.getRuntime().availableProcessors() + 1;

    /**
     * 在Application中初始化
     */
    private Context mApplicationContext = null;

    /**
     * 保持单例
     */

    private EasyImageLoadConfiguration(){

    }

    private static class InstanceHolder{
        private static final EasyImageLoadConfiguration instance = new EasyImageLoadConfiguration();
    }

    public static EasyImageLoadConfiguration getInstance(){
        return InstanceHolder.instance;
    }

    public EasyImageLoadConfiguration setLoadPolicy(ImageLoadPolicy policy){
        loadPolicy = policy;
        return this;
    }

    public EasyImageLoadConfiguration setThreadCount(int count){
        threadCount = count;
        return this;
    }

    public void init(Application app) {
        mApplicationContext = app.getApplicationContext();
        //在这里开启队列循环
        RequestQueue.getIstacne().start();
    }

    public ImageLoadPolicy getLoadPolicy() {
        return loadPolicy;
    }

    public int getThreadCount() {
        return threadCount;
    }

    public Context getmApplicationContext() {
        return mApplicationContext;
    }
}
