package com.example.afinal.Fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.afinal.DataBaseclss;
import com.example.afinal.R;
import com.example.afinal.UserInfo;

import java.util.ArrayList;
import java.util.List;


public class LoginFragment extends Fragment {



    public LoginFragment() {
        // Required empty public constructor
    }
    Button loginbtn;
    List<UserInfo> list;
    DataBaseclss database;
    EditText editText;
    EditText editText1;
    CheckBox checkBox;
    String Username, Password;

    SharedPreferences sh;
    SharedPreferences.Editor editor;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_login2, container, false);

        list = new ArrayList<>();
        editText = view.findViewById(R.id.edittext1);
        editText1 = view.findViewById(R.id.editTextTextPassword2);
        loginbtn = view.findViewById(R.id.button2);
        database=DataBaseclss.getInstance(getContext());


        sh = requireContext().getSharedPreferences("Data", Context.MODE_PRIVATE);
        editor =  sh.edit();


        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Username  =  editText.getText().toString();
                Password = editText1.getText().toString();


                if (Username.isEmpty() || Password.isEmpty()){
                    Toast.makeText(getContext(), "Field cannot be Empty", Toast.LENGTH_SHORT).show();
                }else{

                    new Thread(new Runnable() {
                        @Override
                        public void run() {

                            UserInfo userInfo =database.getDao().login(Username, Password);

                            if (userInfo.getUsername().equals(Username)
                                    &&  userInfo.getPassword().equals(Password)){

                                new Handler(Looper.getMainLooper()).post(new Runnable() {
                                    @Override
                                    public void run() {

                                        editor.putString("Logged_user", userInfo.getUsername());
                                        editor.putString("Looged_email", userInfo.getEmail());
                                        editor.apply();
                                        Toast.makeText(getContext(), "Logged in With : " + userInfo.getUsername(), Toast.LENGTH_SHORT).show();
                                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.linearlayoutfirst,  new CurrentUserlogin()).commit();
                                    }
                                });

                            }
                            else{

                            }

                        }
                    }).start();
                }



            }



        });


        return view;
    }
}