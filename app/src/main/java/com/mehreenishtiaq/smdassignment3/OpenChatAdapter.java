package com.mehreenishtiaq.smdassignment3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class OpenChatAdapter extends RecyclerView.Adapter<OpenChatAdapter.MyViewHolder> {

    Context context;
    List<OpenChat.Messages2> ls;

    public OpenChatAdapter(Context context, List<OpenChat.Messages2> ls) {
        this.context = context;
        this.ls = ls;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View row = LayoutInflater.from(context).inflate(R.layout.chat,parent,false);
        return new MyViewHolder(row);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        RelativeLayout layout1,layout2;
        TextView msg1, msg2, date1, date2;


        Integer user = ls.get(position).getUser(); //1 or 2

        if(user.equals(1)) {

            holder.layout1.setVisibility(View.VISIBLE);
            holder.layout2.setVisibility(View.INVISIBLE);

            holder.msg1.setText(ls.get(position).getMessage());
            holder.date1.setText(ls.get(position).getDate());
        }


        else if(user.equals(2)){

            holder.layout2.setVisibility(View.VISIBLE);
            holder.layout1.setVisibility(View.INVISIBLE);

            holder.msg2.setText(ls.get(position).getMessage());
            holder.date2.setText(ls.get(position).getDate());
        }







    }

    @Override
    public int getItemCount() {
        return ls.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        RelativeLayout layout1,layout2;
        TextView msg1, msg2, date1, date2;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);




            layout1 = itemView.findViewById(R.id.layout1);
            layout2 = itemView.findViewById(R.id.layout2);
            msg1 = itemView.findViewById(R.id.msg1);
            msg2 = itemView.findViewById(R.id.msg2);
            date1 = itemView.findViewById(R.id.date1);
            date2 = itemView.findViewById(R.id.date2);


        }

        @Override
        public void onClick(View v) {

        }
    }
}
