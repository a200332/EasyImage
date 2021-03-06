package com.example.zane.easyimageprovider.download.policy;

import android.util.Log;

import com.example.zane.easyimageprovider.download.request.BitmapRequest;

/**
 * Created by Zane on 16/9/23.
 * Email: zanebot96@gmail.com
 */

//先进后出策略

public class FILOPolicy implements ImageLoadPolicy{
    @Override
    public int compare(BitmapRequest request1, BitmapRequest request2) {
        if (request1.ID == request2.ID){
            throw new IllegalStateException("the ID in two imageview cann't be same!");
        }
        Log.i("FILOPolicy", request1.ID + " " + request2.ID);
        return request2.ID - request1.ID;
    }

    @Override
    public int compare(int policy1, int policy2) {
        Log.i("FILOPolicy", "policy " + policy1 + " " + policy2);
        return policy2 - policy1;
    }
}
