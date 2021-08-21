package com.example.afinal.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.afinal.DataBaseclss;
import com.example.afinal.R;
import com.example.afinal.UserInfo;

import java.util.ArrayList;
import java.util.List;


public class ListofuserFragment extends Fragment {



    public ListofuserFragment() {
        // Required empty public constructor
    }

RecyclerView recyclerView;
    DataBaseclss database;
    List<UserInfo>  list;
    MyItemRecyclerViewAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
    View view=inflater.inflate(R.layout.fragment_listofuser, container, false);
        list=new ArrayList<>();



recyclerView=view.findViewById(R.id.RecyclerView);
recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

database=DataBaseclss.getInstance(getContext());
      /* imageView=view.findViewById(R.id.img_View);
        String[] urls ={"https://s3.ap-south-1.amazonaws.com/mindorks-server-uploads/download-show-image-glide-banner.png"};
        Glide.with(this.getActivity()).load(urls[0]).into(imageView);*/



new Thread(new Runnable() {
    @Override
    public void run() {
    list= database.getDao().getAllUserinfos();
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                adapter=new MyItemRecyclerViewAdapter(list,getContext());
                recyclerView.setAdapter(adapter);
            }
        });


    }
}).start();

// Inflate the layout for this fragment
        return view;
    }
}