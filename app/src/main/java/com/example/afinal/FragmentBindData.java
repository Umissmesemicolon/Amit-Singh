package com.example.afinal;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class FragmentBindData extends Fragment {
    RecyclerView recyclerView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bind_data, container, false);
        recyclerView=view.findViewById(R.id.DataBindingRecyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        DataBindingAdapter dataBindingAdapter=new DataBindingAdapter(list(),getContext());
        recyclerView.setAdapter(dataBindingAdapter);
        return view;
    }
    private List<DataBindingUser> list()

    {
        List<DataBindingUser> mylist=new ArrayList<>();
        mylist.add(new DataBindingUser("Siddhart Malhotra", 40,true,"https://upload.wikimedia.org/wikipedia/commons/6/69/Sidharth_Malhotra_2016.jpg"));
        return mylist;
    }
}
