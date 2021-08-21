package com.example.afinal;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.afinal.Fragment.ListofuserFragment;
import com.example.afinal.Fragment.LoginFragment;
import com.example.afinal.Fragment.MyItemRecyclerViewAdapter;
import com.example.afinal.Fragment.SignUp;
import com.example.afinal.Fragment.placeholder.PlaceholderContent;

import java.util.List;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private MyItemRecyclerViewAdapter myItemRecyclerViewAdapter;
    //DataBaseclss dataBaseclss;
    List<UserInfo> list;
    Button buttonlogin , buttonuser, buttonsignup,buttonSi;
    LinearLayout linearLayout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonlogin=findViewById(R.id.buttonlogin);
        buttonsignup=findViewById(R.id.buttonsignup);
        buttonuser=findViewById(R.id.buttonuser);
        linearLayout=findViewById(R.id.linearlayoutfirst);


      getSupportFragmentManager().beginTransaction().replace(R.id.linearlayoutfirst,new LoginFragment()).commit();
        buttonlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginFragment loginFragment=new LoginFragment();
                FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.linearlayoutfirst,loginFragment);
                transaction.commit();

            }
        });
        buttonsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SignUp signUp =new SignUp();
                FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.linearlayoutfirst,signUp);
                transaction.commit();

            }
        });

       buttonuser.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
             getSupportFragmentManager().beginTransaction().replace(R.id.linearlayoutfirst,new ListofuserFragment()).commit();
           }
       });



        }
}