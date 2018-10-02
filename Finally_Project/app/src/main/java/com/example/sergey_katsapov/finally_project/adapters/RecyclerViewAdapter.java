package com.example.sergey_katsapov.finally_project.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.sergey_katsapov.finally_project.activities.SportActivity;
import com.example.sergey_katsapov.finally_project.model.Sport;
import com.example.sergey_katsapov.finally_project.R;

import java.util.List;



public class RecyclerViewAdapter extends RecyclerView.Adapter <RecyclerViewAdapter.MyViewHolder>
{
    private Context mContext;
    private List<Sport> mData;
    RequestOptions option;

    public RecyclerViewAdapter(Context mContext, List<Sport> mData) {
        this.mContext = mContext;
        this.mData = mData;

        // Request Option for Glide
        option = new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {

        View view;

        LayoutInflater inflater = LayoutInflater.from(mContext);
        view = inflater.inflate(R.layout.sport_row_item, parent,false);
        final MyViewHolder viewHolder = new MyViewHolder(view);
        viewHolder.view_container.setOnClickListener(new View.OnClickListener()
                                                     {

                                                         @Override
                                                         public void onClick(View v) {
                                                             Intent i = new Intent(mContext, SportActivity.class);
                                                             i.putExtra("name", mData.get(viewHolder.getAdapterPosition()).getName());
                                                             i.putExtra("description", mData.get(viewHolder.getAdapterPosition()).getDescription());
                                                             i.putExtra("thumbnail", mData.get(viewHolder.getAdapterPosition()).getImage_url());

                                                             mContext.startActivity(i);

                                                             }
                                                     }
        );
        return viewHolder;



    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tv_name.setText(mData.get(position).getName());
        holder.tv_description.setText(mData.get(position).getDescription());


        Glide.with(mContext).load(mData.get(position).getImage_url()).apply(option).into(holder.img_thumbail);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{


        TextView tv_name;
        TextView tv_description;
        ImageView img_thumbail;
        LinearLayout view_container;


        public MyViewHolder(View itemView)
        {
            super(itemView);

            view_container = itemView.findViewById(R.id.container);
            tv_name = itemView.findViewById(R.id.name);
            tv_description = itemView.findViewById(R.id.description);
            img_thumbail =  itemView.findViewById(R.id.thumbnail);
        }
    }
}
