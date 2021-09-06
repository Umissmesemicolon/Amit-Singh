package com.example.afinal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.afinal.databinding.DatabindingitemsBinding;

import java.util.List;


public class DataBindingAdapter extends RecyclerView.Adapter<DataBindingAdapter.viewHolder> {
    List<DataBindingUser>dataBindingUsers;

    public DataBindingAdapter(List<DataBindingUser> dataBindingUsers, Context context) {
        this.dataBindingUsers = dataBindingUsers;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        DatabindingitemsBinding databindingitemsBinding = DatabindingitemsBinding.inflate(layoutInflater,parent,false);
        return new viewHolder(databindingitemsBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        DataBindingUser dataBindingUser=dataBindingUsers.get(position);
        holder.databindingitemsBinding.setUser(dataBindingUser);

    }

    @Override
    public int getItemCount() {
        return dataBindingUsers.size();
    }


    class viewHolder extends RecyclerView.ViewHolder{
        DatabindingitemsBinding databindingitemsBinding;
        public viewHolder (DatabindingitemsBinding databindingitemsBinding){
            super(databindingitemsBinding.getRoot());
            this.databindingitemsBinding=databindingitemsBinding;
        }


    }
}
