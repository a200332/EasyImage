package com.example.zane.easyimageprovider.provider.listener;

import android.content.Context;
import android.content.Intent;

import com.example.zane.easyimageprovider.builder.EasyImageProvideRecord;

/**
 * Created by Zane on 16/5/11.
 */
public interface ImageProvider {
    Intent getIntent(Context context);
    int getRequestCode();
    void onActivityResult(EasyImageProvideRecord record,  Intent data);
}
