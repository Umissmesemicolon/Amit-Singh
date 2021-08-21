package com.example.afinal.Fragment;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.afinal.Fragment.placeholder.PlaceholderContent.PlaceholderItem;
import com.example.afinal.R;
import com.example.afinal.UserInfo;

//import com.example.afinal.Fragment.databinding.FragmentItemBinding;

import java.io.ByteArrayOutputStream;
import java.util.List;

public class MyItemRecyclerViewAdapter extends RecyclerView.Adapter<MyItemRecyclerViewAdapter.myVewHoldercls> {
    private List<UserInfo> alist;

    Context context;

    public MyItemRecyclerViewAdapter(List<UserInfo> items,Context context) {
            this.context=context;
            this.alist=items;
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

    class myVewHoldercls extends RecyclerView.ViewHolder {
        TextView title;
        TextView des;

        public myVewHoldercls(@NonNull View itemView) {
        super(itemView);

                title=itemView.findViewById(R.id.titlelist);
                des=itemView.findViewById(R.id.deslist);


            }
}


}