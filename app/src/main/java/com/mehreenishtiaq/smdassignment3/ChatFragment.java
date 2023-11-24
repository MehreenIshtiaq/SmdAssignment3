package com.mehreenishtiaq.smdassignment3;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class ChatFragment extends Fragment {

    private RecyclerView rv;
    private ChatFragmentAdapter adapter;


    //messages class
    public class Messages{

        String name;
        Integer message_count;

        public Messages(String name, Integer message_count) {
            this.name = name;
            this.message_count = message_count;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getMessage_count() {
            return message_count;
        }

        public void setMessage_count(Integer message_count) {
            this.message_count = message_count;
        }
    }



    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_chat, container, false);


        rv = view.findViewById(R.id.chatRv); // Replace with the actual RecyclerView ID in fragment_home.xml

        List<Messages> ls = new ArrayList<>();
        ls.add(new Messages("Mehreen Ishtiaq",1));
        ls.add(new Messages("Hello there",0));
        ls.add(new Messages("Anam Fatima",3));

        // Sort the list based on message_count in descending order
        Collections.sort(ls, new Comparator<Messages>() {
            @Override
            public int compare(Messages messages1, Messages messages2) {
                // Compare the message_count in descending order
                return messages2.getMessage_count().compareTo(messages1.getMessage_count());
            }
        });

        adapter = new ChatFragmentAdapter(requireContext(), ls);

        LinearLayoutManager layoutManager = new LinearLayoutManager(requireContext());
        rv.setLayoutManager(layoutManager);
        rv.setAdapter(adapter);

        return view;
    }
}