package com.example.aliahmed.myapplication;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class AutoScrollFragment extends Fragment {
    @BindView(R.id.rec_scroll_stock)
    RecyclerView rvTickerList;

    List<StockListModel> stockListModels = new ArrayList<>();
    private ScrollStockAdapter scrollStockAdapter;
    StockListModel model = new StockListModel();
    int scrollCount = 0;

    public AutoScrollFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_auto_scroll, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

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

        scrollStockAdapter = new ScrollStockAdapter(stockListModels);
        rvTickerList.setAdapter(scrollStockAdapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext()) {

            @Override
            public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int position) {
                try {
                    LinearSmoothScroller smoothScroller = new LinearSmoothScroller(Objects.requireNonNull(getContext())) {
                        private static final float SPEED = 3500f;// Change this value (default=25f)

                        @Override
                        protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                            return SPEED / displayMetrics.densityDpi;
                        }
                    };
                    smoothScroller.setTargetPosition(position);
                    startSmoothScroll(smoothScroller);
                } catch (Exception e) {
                    e.printStackTrace();
                }
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

        scrollStockAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Toast.makeText(getContext(), "Item clicked", Toast.LENGTH_LONG).show();
            }
        });


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
