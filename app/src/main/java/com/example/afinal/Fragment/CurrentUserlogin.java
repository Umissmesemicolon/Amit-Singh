package com.example.afinal.Fragment;

import android.content.Context;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.fragment.app.Fragment;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.afinal.DataBaseclss;
import com.example.afinal.MainActivity;
import com.example.afinal.R;

public class CurrentUserlogin extends Fragment {
    Button logout;
    TextView homescreentextview,homescreenimg1;
    ImageView  imageView;
    SharedPreferences sh;
    SharedPreferences.Editor editor;
    String name,email;
    DataBaseclss userDatabase;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_current_userlogin, container, false);


        homescreentextview = view.findViewById(R.id.cusername);
        homescreenimg1 = view.findViewById(R.id.cemail);
        imageView=view.findViewById(R.id.profileimage);
        logout = view.findViewById(R.id.logout);
        sh = getContext().getSharedPreferences("Data", Context.MODE_PRIVATE);
        editor = sh.edit();

       userDatabase=DataBaseclss.getInstance(getContext());



        name = sh.getString("Logged_user", null);
        email =sh.getString("Logged_email",null);
        homescreentextview.setText(name);
        homescreenimg1.setText(email);


        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToAttract(v);
            }
        });
        return view;
    }

    public void goToAttract(View v)
    {
        Intent intent = new Intent(getActivity().getApplication(), MainActivity.class);
        startActivity(intent);
    }

}