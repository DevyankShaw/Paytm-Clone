package com.example.devyankshaw.paytmclone.MallFragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.devyankshaw.paytmclone.R;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerBannerMallItem3Adapter extends RecyclerView.Adapter<RecyclerBannerMallItem3Adapter.ViewHolder> {
    List<RecycleBannerMallItem3> recycleBannerMallItem3s ;
    Context context;

    public RecyclerBannerMallItem3Adapter(Context context, ArrayList<RecycleBannerMallItem3> recycleBannerMallItem3s) {
        this.recycleBannerMallItem3s = recycleBannerMallItem3s;
        this.context = context;
    }

    @Override
    public RecyclerBannerMallItem3Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_banner_mall_items_3, parent, false);
        return new RecyclerBannerMallItem3Adapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        RecycleBannerMallItem3 all = recycleBannerMallItem3s.get(position);
        holder.name.setText(all.txt);
        holder.image.setImageResource(all.imageId);
    }

    @Override
    public int getItemCount() {
        return recycleBannerMallItem3s.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        CircleImageView image;
        TextView name;

        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.name);
        }
    }

}
