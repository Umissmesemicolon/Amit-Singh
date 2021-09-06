package com.example.afinal;


import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.afinal.Fragment.FragmentRetrofit;
import com.example.afinal.Fragment.ListofuserFragment;
import com.example.afinal.Fragment.LoginFragment;
import com.example.afinal.Fragment.MyItemRecyclerViewAdapter;
import com.example.afinal.Fragment.SignUp;
import com.example.afinal.Fragment.placeholder.PlaceholderContent;
import com.example.afinal.R;
import com.example.afinal.UserInfo;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private MyItemRecyclerViewAdapter myItemRecyclerViewAdapter;
    //DataBaseclss dataBaseclss;
    List<UserInfo> list;
    //Button buttonlogin , buttonuser, buttonsignup,buttonretro;
    LinearLayout linearLayout;
    BottomNavigationView bottomNavigationView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
/*
        buttonlogin=findViewById(R.id.buttonlogin);
        buttonsignup=findViewById(R.id.buttonsignup);
        buttonuser=findViewById(R.id.buttonuser);
        buttonretro=findViewById(R.id.buttonrtro);*/
        bottomNavigationView=findViewById(R.id.bottonbtn);
        linearLayout=findViewById(R.id.linearlayoutfirst);


      getSupportFragmentManager().beginTransaction().replace(R.id.linearlayoutfirst,new LoginFragment()).commit();
      bottomNavigationView.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
          @Override
          public void onNavigationItemReselected(@NonNull MenuItem item) {
              Fragment temp=null;
              switch (item.getItemId()){
                  case R.id.buttonlogin:temp=new LoginFragment();
                  break;
                  case R.id.buttonsignup:temp=new SignUp();
                  break;
                  case R.id.buttonuser:temp=new ListofuserFragment();
                  break;
                  case R.id.buttonrtro:temp=new FragmentRetrofit();
                  break;
                  case R.id.dataBinding:temp=new FragmentBindData();
                  break;
              }
              getSupportFragmentManager().beginTransaction().replace(R.id.linearlayoutfirst,temp).commit();
          }
      });
       /* buttonlogin.setOnClickListener(new View.OnClickListener() {
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

       buttonretro.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               getSupportFragmentManager().beginTransaction().replace(R.id.linearlayoutfirst,new FragmentRetrofit()).commit();
           }
       });


*/
        }
}