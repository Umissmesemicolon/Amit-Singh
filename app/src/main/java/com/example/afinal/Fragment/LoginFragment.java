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
    String name="admin";
    String password="admin";
    SharedPreferences sh;
    SharedPreferences.Editor editor;
    boolean isLoggedIn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login2, container, false);

        loginbtn=view.findViewById(R.id.button2);
        editText=view.findViewById(R.id.editTextTextPassword2);
        editText1=view.findViewById(R.id.edittext1);
        checkBox=view.findViewById(R.id.checkbox);
        sh= getActivity().getSharedPreferences("DATA", Context.MODE_PRIVATE);
        editor=sh.edit();
        editText.setText(sh.getString("N",""));
        editText1.setText(sh.getString("P",""));
        isLoggedIn= sh.getBoolean("IsLOGGEDIN",false);
        if (isLoggedIn)
        {
            Bundle bundle=new Bundle();
            bundle.putString("key",editText.getText().toString());
            CurrentUserlogin currentUserlogin = new CurrentUserlogin();
            FragmentTransaction transaction= getFragmentManager().beginTransaction();;
            transaction.replace(R.id.linearlayoutfirst,currentUserlogin);
            transaction.commit();
        }
        database=DataBaseclss.getInstance(getContext());
        list=new ArrayList<>();

               /** loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        list=database.getDao().getAllUserinfos();
                        for (UserInfo ob : list)
                        {
                            //if

                            new Handler(Looper.getMainLooper()).post(new Runnable() {
                                @Override
                                public void run() {

                                    Toast.makeText(getContext(), ob.getEmail(), Toast.LENGTH_SHORT).show();
                                }
                            });


                        }
                    }
                }).start();
            }
        });**/

       loginbtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               String username=editText.getText().toString();
               String password=editText1.getText().toString();
               if (username.equals(name) && password.equals(password)){
                   if (checkBox.isChecked()){
                       editor.putString("N",username);
                       editor.putString("P",password);
                       editor.putBoolean("IsLOGGEDIN",true);
                       editor.apply();
                       Bundle bundle=new Bundle();
                       bundle.putString("key",editText.getText().toString());
                       CurrentUserlogin currentUserlogin = new CurrentUserlogin();
                       FragmentTransaction transaction= getFragmentManager().beginTransaction();;
                       transaction.replace(R.id.linearlayoutfirst,currentUserlogin);
                       transaction.commit();
                   }
                   else {
                       Bundle bundle=new Bundle();
                       bundle.putString("key",editText.getText().toString());
                       CurrentUserlogin currentUserlogin = new CurrentUserlogin();
                       FragmentTransaction transaction= getFragmentManager().beginTransaction();;
                       transaction.replace(R.id.linearlayoutfirst,currentUserlogin);
                       transaction.commit();
                   }

               }else {
                   Toast.makeText(getContext(), "invalid", Toast.LENGTH_SHORT).show();
               }

           }
       });
     return view;
    }
}