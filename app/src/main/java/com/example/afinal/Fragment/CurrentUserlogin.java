package com.example.afinal.Fragment;

import android.app.Activity;
import android.content.Context;

import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


import com.example.afinal.R;

public class CurrentUserlogin extends Fragment {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Button button;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        sharedPreferences= getActivity().getSharedPreferences("DATA",Context.MODE_PRIVATE);
        editor=sharedPreferences.edit();
        editor.clear();
        editor.apply();
        // need to add a intent for splash
        //getActivity().finish();
        //((Activity) getContext()).finish();


      button=getView().findViewById(R.id.logout);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginFragment loginFragment=new LoginFragment();
                FragmentTransaction transaction= getFragmentManager().beginTransaction();;
                transaction.replace(R.id.login_1,loginFragment);
                transaction.commit();
            }
        });



        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_current_userlogin, container, false);
        return view;


    }


}