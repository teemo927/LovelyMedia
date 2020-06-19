package com.teem.lovelymedia.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.teem.lovelymedia.R;
import com.teem.lovelymedia.databinding.ActivityMainBinding;
import com.teem.lovelymedia.view.adapter.ImageAdapter;
import com.youth.banner.adapter.BannerAdapter;
import com.youth.banner.indicator.CircleIndicator;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        List<String> list = new ArrayList<>();
        list.add("https://pic49.photophoto.cn/20181102/0011034129834196_b.jpg");
        list.add("https://picnew5.photophoto.cn/20110508/bingshangyundongtupian-12909053_1.jpg");

        BannerAdapter adapter = new ImageAdapter(list);
        binding.banner.addBannerLifecycleObserver(this)
                .setAdapter(adapter)
                .setIndicator(new CircleIndicator(this))
                .start();
    }
}
