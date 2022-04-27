package com.example.bottomnavigation;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.bottomnavigation.databinding.ActivityProductDetailBinding;

import java.util.Objects;

public class ProductDetailActivity extends AppCompatActivity {
    ActivityProductDetailBinding layoutBinding;
    private Context mContext;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        layoutBinding = ActivityProductDetailBinding.inflate(getLayoutInflater());
        setContentView(layoutBinding.getRoot());
        mContext = ProductDetailActivity.this;
        setToolBar();
        setClickListener();
    }
    //--------------- set Toolbar
    private void setToolBar(){
        setSupportActionBar(layoutBinding.toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle(null);
        layoutBinding.toolbar.setTitle("Back");
        layoutBinding.toolbar.setNavigationIcon(R.drawable.ic_back_arrow);
        layoutBinding.toolbar.setNavigationOnClickListener(v -> onBackPressed());
    }

    //---------------------- Listeners-----------
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void setClickListener() {
        layoutBinding.addToCartBtn.setOnClickListener(v -> Toast.makeText(mContext, "Product added in cart", Toast.LENGTH_LONG).show());
        layoutBinding.sixByThreeSizeText.setOnClickListener(v -> {
           changeSizeBackground(1);
        });
        layoutBinding.sixByFourSizeText.setOnClickListener(v -> changeSizeBackground(2));
        layoutBinding.sixByFiveSizeText.setOnClickListener(v -> changeSizeBackground(3));
        layoutBinding.sixBySixSizeText.setOnClickListener(v -> changeSizeBackground(4));
    }
    //-------------- select size---------------
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void changeSizeBackground(int position){
        if (position==1){
            layoutBinding.sixByThreeSizeText.setBackground(getDrawable(R.drawable.bg_size));
            layoutBinding.sixByFourSizeText.setBackground(getDrawable(R.drawable.bg_light_size));
            layoutBinding.sixByFiveSizeText.setBackground(getDrawable(R.drawable.bg_light_size));
            layoutBinding.sixBySixSizeText.setBackground(getDrawable(R.drawable.bg_light_size));
        }else if (position==2){
            layoutBinding.sixByThreeSizeText.setBackground(getDrawable(R.drawable.bg_light_size));
            layoutBinding.sixByFourSizeText.setBackground(getDrawable(R.drawable.bg_size));
            layoutBinding.sixByFiveSizeText.setBackground(getDrawable(R.drawable.bg_light_size));
            layoutBinding.sixBySixSizeText.setBackground(getDrawable(R.drawable.bg_light_size));
        }else if (position==3){
            layoutBinding.sixByThreeSizeText.setBackground(getDrawable(R.drawable.bg_light_size));
            layoutBinding.sixByFourSizeText.setBackground(getDrawable(R.drawable.bg_light_size));
            layoutBinding.sixByFiveSizeText.setBackground(getDrawable(R.drawable.bg_size));
            layoutBinding.sixBySixSizeText.setBackground(getDrawable(R.drawable.bg_light_size));
        }else {
            layoutBinding.sixByThreeSizeText.setBackground(getDrawable(R.drawable.bg_light_size));
            layoutBinding.sixByFourSizeText.setBackground(getDrawable(R.drawable.bg_light_size));
            layoutBinding.sixByFiveSizeText.setBackground(getDrawable(R.drawable.bg_light_size));
            layoutBinding.sixBySixSizeText.setBackground(getDrawable(R.drawable.bg_size));
        }

    }
}