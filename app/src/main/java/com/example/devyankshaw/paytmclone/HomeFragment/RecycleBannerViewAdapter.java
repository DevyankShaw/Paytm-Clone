package com.example.devyankshaw.paytmclone.HomeFragment;

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

public class RecycleBannerViewAdapter extends RecyclerView.Adapter<RecycleBannerViewAdapter.ViewHolder>{

    List<RecycleBannerItem> recycleBannerItems ;
    Context context;

    public RecycleBannerViewAdapter(Context context, ArrayList<RecycleBannerItem> recycleBannerItems) {
        this.recycleBannerItems = recycleBannerItems;
        this.context = context;
    }

    @Override
    public RecycleBannerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_banner_items, parent, false);
        return new RecycleBannerViewAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        RecycleBannerItem all = recycleBannerItems.get(position);
        holder.image.setImageResource(all.imageBannerId);
    }


    @Override
    public int getItemCount() {
        return recycleBannerItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView image;

        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.banner_images);
        }
    }
}
