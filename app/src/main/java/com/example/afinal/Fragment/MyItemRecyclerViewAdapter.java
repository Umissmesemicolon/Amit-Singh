package com.example.afinal.Fragment;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.afinal.DataBaseclss;
import com.example.afinal.Fragment.placeholder.PlaceholderContent.PlaceholderItem;
import com.example.afinal.R;
import com.example.afinal.UserInfo;

//import com.example.afinal.Fragment.databinding.FragmentItemBinding;

import java.io.ByteArrayOutputStream;
import java.util.List;

public class MyItemRecyclerViewAdapter extends RecyclerView.Adapter<MyItemRecyclerViewAdapter.myVewHoldercls> {
     List<UserInfo> alist;
     Context context;
     List<UserInfo> templist;
     DataBaseclss dataBaseclss;
     int id;

    public MyItemRecyclerViewAdapter(List<UserInfo> items,Context context) {
            this.context=context;
            this.alist=items;
            templist=alist;
           dataBaseclss=DataBaseclss.getInstance(context.getApplicationContext());
    }


    @NonNull
    @Override
    public myVewHoldercls onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(context).inflate(R.layout.listiitemlayout,parent,false);
        return new myVewHoldercls(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myVewHoldercls holder, int position) {
        UserInfo user= alist.get(position);
        holder.title.setText(user.getUsername());
        holder.des.setText(user.getEmail());



    }

    @Override
    public int getItemCount() {
        return alist.size();
    }

   public class myVewHoldercls extends RecyclerView.ViewHolder {
        TextView title;
        TextView des;
        ImageButton deletebtn;


        public myVewHoldercls(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.titlelist);
            des = itemView.findViewById(R.id.deslist);

            deletebtn = itemView.findViewById(R.id.deletebtn);

                deletebtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            dataBaseclss = DataBaseclss.getInstance(itemView.getContext());

                            UserInfo userInfo = templist.get(getAdapterPosition());
                            id = userInfo.getId();


                            new Thread(new Runnable() {
                                @Override
                                public void run() {

                                    UserInfo ue = dataBaseclss.getDao().getId(id);
                                    dataBaseclss.getDao().deleteUser(ue);

                                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                                        @Override
                                        public void run() {

                                            Toast.makeText(context, "User Deleted Successfully", Toast.LENGTH_SHORT).show();
                                        }
                                    });
                                }
                            }).start();
                            ;
                        }
                    });

                }
            }
        }
