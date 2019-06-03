package com.example.devyankshaw.paytmclone.MallFragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.devyankshaw.paytmclone.R;

import java.util.ArrayList;
import java.util.List;

public class RecycleBannerMallItem1Adapter extends RecyclerView.Adapter<RecycleBannerMallItem1Adapter.ViewHolder>{
    List<RecyclerBannerMallItem1> recyclerBannerMallItem1s ;
    Context context;

    public RecycleBannerMallItem1Adapter(Context context, ArrayList<RecyclerBannerMallItem1> recyclerBannerMallItem1s) {
        this.recyclerBannerMallItem1s = recyclerBannerMallItem1s;
        this.context = context;
    }

    @Override
    public RecycleBannerMallItem1Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_banner_mall_items_1, parent, false);
        return new RecycleBannerMallItem1Adapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        RecyclerBannerMallItem1 all = recyclerBannerMallItem1s.get(position);
        holder.image.setImageResource(all.imageMallBanner1Id);
    }

    @Override
    public int getItemCount() {
        return recyclerBannerMallItem1s.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView image;

        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.mall_banner_1_images);
        }
    }
}
