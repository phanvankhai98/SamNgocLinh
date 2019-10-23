package com.pvkhaicd.samngoclinh.ViewController.Question;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.pvkhaicd.samngoclinh.Model.MessageAdapter;
import com.pvkhaicd.samngoclinh.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MessageFragment extends Fragment {

    Button btn;
    ListView lv;
    EditText edt;
    ArrayList<String> send = new ArrayList<>();
    String[] recive = new String[]{"Đây là hệ thống trả lời tự động.","Chúc bạn có một ngày tốt lành"," Mình có thể giúp gì cho bạn?"};
    public MessageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_message, container, false);
        init(view);
        send.add("Xin chao");
        final MessageAdapter adapter = new MessageAdapter(send,getContext());
        final ArrayAdapter arrayAdapter = new ArrayAdapter(getContext(),android.R.layout.simple_list_item_1,send);
        lv.setAdapter(adapter);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tmp = edt.getText().toString();
                if(tmp.length()!=0){
                    send.add(tmp);
                    adapter.notifyDataSetChanged();
                }
            }
        });

        return view;
    }

    private void init(View view) {
        btn = view.findViewById(R.id.btn);
        edt = view.findViewById(R.id.edt);
        lv = view.findViewById(R.id.lv);

    }

}
