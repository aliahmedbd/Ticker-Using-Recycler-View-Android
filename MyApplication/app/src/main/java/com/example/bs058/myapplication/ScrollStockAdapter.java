package com.example.bs058.myapplication;

import android.graphics.Color;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Random;

/**
 * Created by BS058 on 10/19/2016.
 */

public class ScrollStockAdapter extends BaseQuickAdapter<StockListModel> {
    Random randomGenerator = new Random();
    float min = -0.5f;
    float max = 0.5f;
    DecimalFormat df = new DecimalFormat();

    public ScrollStockAdapter(List<StockListModel> data) {
        super(R.layout.layout_scroll_stock, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, StockListModel item) {
        df.setMaximumFractionDigits(3);
        float percantage = randomGenerator.nextFloat() * (max - min) + min;
            helper.setText(R.id.txt_stock_name,item.getShortName())
                    .setText(R.id.txt_current_price,randomGenerator.nextInt(200)+"");

        if(percantage < 0){
            helper.setImageResource(R.id.img_up,R.mipmap.down);
            helper.setTextColor(R.id.txt_percantage_price, Color.parseColor("#EC3030"));
            helper.setText(R.id.txt_percantage_price, df.format(percantage) +"%" );
        }
        else{
            helper.setImageResource(R.id.img_up,R.mipmap.up);
            helper.setTextColor(R.id.txt_percantage_price, Color.parseColor("#8DCF5F"));
            helper.setText(R.id.txt_percantage_price,"+"+ df.format(percantage) +"%" );
        }
    }
}
