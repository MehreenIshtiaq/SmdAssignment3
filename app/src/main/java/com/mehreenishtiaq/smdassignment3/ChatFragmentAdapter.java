package com.mehreenishtiaq.smdassignment3;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ChatFragmentAdapter extends RecyclerView.Adapter<ChatFragmentAdapter.MyViewHolder> {

    Context context;
    List<ChatFragment.Messages> ls;

    public ChatFragmentAdapter(Context context, List<ChatFragment.Messages> ls) {
        this.context = context;
        this.ls = ls;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View row = LayoutInflater.from(context).inflate(R.layout.contact,parent,false);
        return new MyViewHolder(row);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        TextView name, new_msg;
        View line ;

        String notification = null;

        holder.name.setText(ls.get(position).getName());

        Integer count = ls.get(position).getMessage_count();

        if(count!=0){

            holder.line.setVisibility(View.VISIBLE);
            holder.new_msg.setTextColor(ContextCompat.getColor(context, R.color.orange));

            if(count.equals(1)){
                notification = count + " new message";


            }
            else{

                notification = count + " new messages";
            }


            holder.new_msg.setText(notification);

        }

        else {

            holder.new_msg.setTextColor(ContextCompat.getColor(context, R.color.medium_gray));

            holder.new_msg.setText("No new messages");
        }


    }

    @Override
    public int getItemCount() {
        return ls.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView name, new_msg;
        View line;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);

            name = itemView.findViewById(R.id.contact_name);
            new_msg = itemView.findViewById(R.id.new_msg);
            line= itemView.findViewById(R.id.line1);

        }

        @Override
        public void onClick(View v) {


            int position = this.getAdapterPosition();
            String name = ls.get(position).getName();


            Intent intent = new Intent(context, OpenChat.class);
            intent.putExtra("name",name);

            context.startActivity(intent);

        }
    }
}
