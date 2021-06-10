package com.example.recyclesql;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class myAdapter extends RecyclerView.Adapter<myAdapter.myviewholder>
{   ArrayList<modelClass> dataholder;

    public myAdapter(ArrayList<modelClass> dataholder) {
        this.dataholder = dataholder;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow,parent,false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {

        holder.dname.setText(dataholder.get(position).getName());
        holder.dcontact.setText(dataholder.get(position).getContacts());
        holder.dmail.setText(dataholder.get(position).getEmail());
    }

    @Override
    public int getItemCount() {
        return dataholder.size();
    }

    class myviewholder extends RecyclerView.ViewHolder
{

    TextView dname,dcontact,dmail;
    public myviewholder(@NonNull View itemView) {
        super(itemView);
        dname=(TextView)itemView.findViewById(R.id.displayName);
        dcontact=(TextView)itemView.findViewById(R.id.displayContact);
        dmail=(TextView)itemView.findViewById(R.id.displayEmail);
    }
}



}
