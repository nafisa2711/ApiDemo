package com.example.apidemo.Retrofit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.apidemo.R;

import java.util.List;

public class GenerAdapter extends RecyclerView.Adapter<GenerAdapter.MyViewholder> {
    private List<GenereListResponse> genereListResponses;
    private Context context;

    public GenerAdapter(Context context, List<GenereListResponse> genereListResponses) {
        this.context = context;
        this.genereListResponses = genereListResponses;
    }

    @NonNull
    @Override
    public MyViewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.row, viewGroup, false);
        return new MyViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewholder myViewholder, int i) {
        Glide.with(context)
                .load(genereListResponses.get(i).getImage())
                .placeholder(R.drawable.icon)
                .dontAnimate()
                .into(myViewholder.img);
        myViewholder.txtDelivery.setText(genereListResponses.get(i).getGenresName());

    }

    @Override
    public int getItemCount() {
        return genereListResponses.size();
    }

    class MyViewholder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView txtDelivery;

        MyViewholder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            txtDelivery = itemView.findViewById(R.id.txtDelivery);
        }
    }
}
