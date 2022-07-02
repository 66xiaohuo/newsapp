package com.example.myapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.myapp.bean.News;
import com.example.myapp.http.DataCallBack;
import com.example.myapp.http.HttpUtil;
import com.example.myapp.http.UrlConstant;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SecondFragment extends Fragment {
    private ViewPager2 viewPager2;
    ViewPager2Adapter adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_second, null);
        viewPager2 = view.findViewById(R.id.viewpager);
        viewPager2.setOrientation(ViewPager2.ORIENTATION_VERTICAL);
        initData();
        return view;
    }


    private void initData() {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("id", "2");
        hashMap.put("username", "123");
        hashMap.put("password", "123");
        hashMap.put("nickname", "a");
        hashMap.put("createtime", "");
        HttpUtil.sendPost(getContext(), UrlConstant.getNews, hashMap)
                .execute((new DataCallBack<List<News>>(getContext(), new TypeToken<List<News>>() {
                }.getType()) {
                    @Override
                    public void onSuccess(List<News> result) {
                        adapter = new ViewPager2Adapter(getContext(), result);
                        viewPager2.setAdapter(adapter);
                        adapter.notifyDataSetChanged();
                    }
                }));

    }
}
