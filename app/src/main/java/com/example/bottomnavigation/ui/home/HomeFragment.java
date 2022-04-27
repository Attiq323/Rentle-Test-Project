package com.example.bottomnavigation.ui.home;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bottomnavigation.ProductDetailActivity;
import com.example.bottomnavigation.R;
import com.example.bottomnavigation.adapter.ProductAdapter;
import com.example.bottomnavigation.adapter.RecentViewedProductAdapter;
import com.example.bottomnavigation.databinding.FragmentHomeBinding;
import com.example.bottomnavigation.listener.ClickListener;

public class HomeFragment extends Fragment implements ClickListener, AdapterView.OnItemSelectedListener {
    FragmentHomeBinding layoutBinding;

    private HomeViewModel homeViewModel;

    ProductAdapter productAdapter;
    RecentViewedProductAdapter recentViewedProductAdapter;
    String[] country = { "Gurgaon", "Islamabad", "Ottawa"};


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

//        homeViewModel =
//                new ViewModel(this).get(HomeViewModel.class);
        layoutBinding = FragmentHomeBinding.inflate(inflater,container,false);

        layoutBinding.searchList.setQueryHint("Search View");
        layoutBinding.searchList.setIconifiedByDefault(false);
        setAdapter();
//        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//            }
//        });

        setSpinner();

        return layoutBinding.getRoot();
    }
    //-----------------------
    private void setSpinner(){
        layoutBinding.spinnerCity.setOnItemSelectedListener(this);

        //Creating the ArrayAdapter instance having the country list
        ArrayAdapter spinnerAdapter = new ArrayAdapter(requireActivity(),android.R.layout.simple_spinner_item,country);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        layoutBinding.spinnerCity.setAdapter(spinnerAdapter);

    }

    private void setAdapter() {
        productAdapter = new ProductAdapter(requireContext());
        recentViewedProductAdapter = new RecentViewedProductAdapter(requireContext());
        layoutBinding.trendingRcv.setAdapter(productAdapter);
        layoutBinding.recentViewedProductsRcv.setAdapter(recentViewedProductAdapter);
        productAdapter.setClickListener(this);

    }

    @Override
    public void onClick(int position) {
        Intent intent = new Intent(requireActivity(), ProductDetailActivity.class);
        startActivity(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        layoutBinding = null;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        ((TextView) adapterView.getChildAt(0)).setTextColor(Color.WHITE);

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}