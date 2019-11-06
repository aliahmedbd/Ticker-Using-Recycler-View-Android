package com.example.aliahmed.myapplication;

import android.os.Handler;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AutoScroll extends AppCompatActivity {

    @BindView(R.id.rec_scroll_stock)
    RecyclerView rvTickerList;

    List<StockListModel> stockListModels = new ArrayList<>();
    private ScrollStockAdapter scrollStockAdapter;
    StockListModel model = new StockListModel();
    int scrollCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_scroll);
        ButterKnife.bind(this);

        //Dummy Value
        model.setAskerName("Ali Ahmed");
        model.setBidderName("Tanzim");
        model.setId("abc");
        model.setType("BUY");
        model.setIsSyncedWithServer(true);
        model.setTransactionTime("12/12/2016");
        model.setShortName("ABC");
        model.setShareQuantity(10);

        //add to the list
        stockListModels.add(model);
        stockListModels.add(model);
        stockListModels.add(model);
        stockListModels.add(model);
        stockListModels.add(model);
        stockListModels.add(model);
        stockListModels.add(model);
        stockListModels.add(model);
        stockListModels.add(model);
        stockListModels.add(model);
        stockListModels.add(model);
        stockListModels.add(model);
        stockListModels.add(model);
        stockListModels.add(model);
        stockListModels.add(model);
        stockListModels.add(model);
        stockListModels.add(model);
        stockListModels.add(model);
        stockListModels.add(model);
        stockListModels.add(model);
    }


    @Override
    protected void onResume() {
        super.onResume();
        scrollStockAdapter = new ScrollStockAdapter(stockListModels);
        rvTickerList.setAdapter(scrollStockAdapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(AutoScroll.this) {

            @Override
            public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int position) {
                LinearSmoothScroller smoothScroller = new LinearSmoothScroller(AutoScroll.this) {
                    private static final float SPEED = 3500f;// Change this value (default=25f)

                    @Override
                    protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                        return SPEED / displayMetrics.densityDpi;
                    }
                };
                smoothScroller.setTargetPosition(position);
                startSmoothScroll(smoothScroller);
            }
        };
        //  LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        autoScrollAnother();
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        rvTickerList.setLayoutManager(layoutManager);
        rvTickerList.setHasFixedSize(true);
        rvTickerList.setItemViewCacheSize(1000);
        rvTickerList.setDrawingCacheEnabled(true);
        rvTickerList.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
        rvTickerList.setAdapter(scrollStockAdapter);
    }

    /**
     * Autoscroll detected from here, where counter, time and runnable is declared.
     */
    public void autoScrollAnother() {
        scrollCount = 0;
        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                rvTickerList.smoothScrollToPosition((scrollCount++));
                if (scrollCount == scrollStockAdapter.getData().size() - 4) {
                    stockListModels.addAll(stockListModels);
                    scrollStockAdapter.notifyDataSetChanged();
                }
                handler.postDelayed(this, 2000);
            }
        };
        handler.postDelayed(runnable, 2000);
    }
}
