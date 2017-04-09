package com.example.bs058.myapplication;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Random;

/**
 * Created by BS058 on 12/18/2016.
 */

public abstract class ScrollCustomAdapter extends RecyclerView.Adapter<ScrollCustomAdapter.CustomViewHolder> {
    public List<StockListModel> stockListModels;
    private OnItemClickListener onItemClickListener;
    Context mContext;

    Random randomGenerator = new Random();
    float min = -0.5f;
    float max = 0.5f;
    DecimalFormat df = new DecimalFormat();

    public OnItemClickListener getOnItemClickListener() {
        return onItemClickListener;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public ScrollCustomAdapter(Context context, List<StockListModel> stockListModels) {
        this.stockListModels = stockListModels;
        this.mContext = context;
    }

    public abstract void load();

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_scroll_stock, null);
        // RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        //view.setLayoutParams(lp);
        CustomViewHolder viewHolder = new CustomViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {

        if ((position >= getItemCount() - 1)) {
            load();
        } else {
            df.setMaximumFractionDigits(3);
            float percantage = randomGenerator.nextFloat() * (max - min) + min;
            holder.bind(stockListModels.get(position), onItemClickListener);
            holder.txt_percantage_price.setText(df.format(percantage) + " %");
            holder.txt_stock_name.setText(stockListModels.get(position).getShortName());

            if (percantage < 0) {
                Picasso.with(mContext).load(R.mipmap.down).into(holder.img_up);
                holder.txt_percantage_price.setTextColor(Color.parseColor("#EC3030"));
            } else {
                Picasso.with(mContext).load(R.mipmap.up).into(holder.img_up);
                holder.txt_percantage_price.setTextColor(Color.parseColor("#8DCF5F"));
            }
        }
    }

    @Override
    public int getItemCount() {
        return stockListModels.size();
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {
        TextView txt_percantage_price;
        TextView txt_stock_name;
        ImageView img_up;

        public CustomViewHolder(View itemView) {
            super(itemView);
            this.txt_percantage_price = (TextView) itemView.findViewById(R.id.txt_percantage_price);
            this.txt_stock_name = (TextView) itemView.findViewById(R.id.txt_stock_name);
            this.img_up = (ImageView) itemView.findViewById(R.id.img_up);
        }

        public void bind(final StockListModel item, final OnItemClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(item);
                }
            });
        }
    }
}
