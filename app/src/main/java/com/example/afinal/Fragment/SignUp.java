package com.example.afinal.Fragment;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.afinal.DataBaseclss;
import com.example.afinal.R;
import com.example.afinal.UserInfo;

import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.Calendar;


public class SignUp extends Fragment {

DataBaseclss database;
    Button btn;
    EditText username,password,confirm_password,email,date;
    int year,month,day;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sign_up, container, false);
        btn=view.findViewById(R.id.buttonSi);
        username=view.findViewById(R.id.editTextTextPersonName);
        password=view.findViewById(R.id.editTextTextPassword2);
        confirm_password=view.findViewById(R.id.editTextTextPassword3);
        email=view.findViewById(R.id.editTextTextEmailAddress);
        date=view.findViewById(R.id.date);
        database=DataBaseclss.getInstance(getContext());
        Calendar calendar = Calendar.getInstance();
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                year = calendar.get(calendar.YEAR);
                month = calendar.get(calendar.MONTH);
                day = calendar.get(calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        calendar.set(Calendar.YEAR,year);
                        calendar.set(Calendar.MONTH,month);
                        calendar.set(Calendar.DAY_OF_MONTH,dayOfMonth);
                    date.setText(SimpleDateFormat.getDateInstance().format(calendar.getTime()));
                    }
                },year,month,day);

                datePickerDialog.show();
            }
        });



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        UserInfo userInfo = new UserInfo();
                        userInfo.setUsername(username.getText().toString());
                        userInfo.setPassword(password.getText().toString());
                        userInfo.setEmail(email.getText().toString());
                        database.getDao().insertUserDetails(userInfo);
                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getContext(), "User Added", Toast.LENGTH_SHORT).show();
                            }
                        });

                    }
                }).start();


            }
        });

        return view;
    }
}