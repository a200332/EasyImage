package com.example.zane.sample;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.zane.easyimageprovider.builder.ImageLoadBuidler;
import com.example.zane.easyimageprovider.builder.core.EasyImage;
import com.example.zane.easyimageprovider.builder.factory.EasyImageFactory;
import com.example.zane.easyimageprovider.builder.factory.LoadFactory;

/**
 * Created by Zane on 16/9/29.
 * Email: zanebot96@gmail.com
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

    private LayoutInflater inflater;
    private Context context;
    private EasyImageFactory factory;
    private EasyImage easyImage;

    public MyAdapter(Context context){
        inflater = LayoutInflater.from(context);
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(inflater.inflate(R.layout.item_layout, parent ,false));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Log.i("MyAdapter", position + " position");
        ImageLoadBuidler buidler = new ImageLoadBuidler().with(context)
                                           .load(Data.URLS[position])
                                           .setError(R.drawable.avatar)
                                           .setHolderPlace(R.drawable.ic_launcher)
                                           .useDiskCache()
                                           .into(holder.mImageView);
        factory = new LoadFactory(buidler);
        easyImage = factory.init();
        easyImage.execute();

//        Glide.with(context)
//                .load(Data.URLS[position])
//                .placeholder(R.drawable.ic_launcher)
//                .error(R.drawable.avatar)
//                .into(holder.mImageView);
    }

    @Override
    public int getItemCount() {
        return Data.URLS.length;
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView mImageView;
        public MyViewHolder(View itemView) {
            super(itemView);
            mImageView = (ImageView) itemView.findViewById(R.id.imageview_item);
        }
    }
}
