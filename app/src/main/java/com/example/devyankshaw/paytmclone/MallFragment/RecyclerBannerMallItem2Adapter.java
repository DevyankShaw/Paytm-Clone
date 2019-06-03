package com.example.devyankshaw.paytmclone.MallFragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.devyankshaw.paytmclone.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerBannerMallItem2Adapter extends RecyclerView.Adapter<RecyclerBannerMallItem2Adapter.ViewHolder>{
    List<RecyclerBannerMallItem2> recyclerBannerMallItem2s ;
    Context context;

    public RecyclerBannerMallItem2Adapter(Context context, ArrayList<RecyclerBannerMallItem2> recyclerBannerMallItem2s) {
        this.recyclerBannerMallItem2s = recyclerBannerMallItem2s;
        this.context = context;
    }
    @Override
    public RecyclerBannerMallItem2Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_banner_mall_items_2, parent, false);
        return new RecyclerBannerMallItem2Adapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        RecyclerBannerMallItem2 all = recyclerBannerMallItem2s.get(position);
        holder.image1.setImageResource(all.imageMallBanner2Id1);
        holder.image2.setImageResource(all.imageMallBanner2Id2);
        holder.text1.setText(all.textMallBanner2Id1);
        holder.text2.setText(all.textMallBanner2Id2);
    }

    @Override
    public int getItemCount() {
        return recyclerBannerMallItem2s.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView image1;
        ImageView image2;
        TextView text1;
        TextView text2;

        public ViewHolder(View itemView) {
            super(itemView);
            image1 = itemView.findViewById(R.id.mall_banner_1_images);
            image2 = itemView.findViewById(R.id.mall_banner_2_images);
            text1 = itemView.findViewById(R.id.txtBanner1);
            text2 = itemView.findViewById(R.id.txtBanner2);
        }
    }
}
