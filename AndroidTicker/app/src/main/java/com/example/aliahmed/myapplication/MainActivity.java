package com.example.aliahmed.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btnFromActivity)
    Button btnFromActivity;

    @BindView(R.id.btnFromFragment)
    Button btnFromFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        btnFromActivity.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AutoScrollActivity.class);
            startActivity(intent);
        });

        btnFromFragment.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, FragmentContainerActivity.class);
            startActivity(intent);
        });
    }
}
