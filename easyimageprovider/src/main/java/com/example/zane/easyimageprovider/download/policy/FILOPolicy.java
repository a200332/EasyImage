package com.example.zane.easyimageprovider.download.policy;

import com.example.zane.easyimageprovider.download.execute.LoadTask;
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
        return request1.ID - request2.ID;
    }

    @Override
    public int compare(int policy1, int policy2) {
        return policy1 - policy2;
    }
}
