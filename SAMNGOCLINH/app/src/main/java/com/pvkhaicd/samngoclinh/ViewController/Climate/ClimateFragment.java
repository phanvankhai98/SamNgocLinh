package com.pvkhaicd.samngoclinh.ViewController.Climate;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.pvkhaicd.samngoclinh.Model.pojo.ClimateNews;
import com.pvkhaicd.samngoclinh.R;
import com.pvkhaicd.samngoclinh.ViewController.Adapter.ReadJson;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ClimateFragment extends Fragment {

    ListView listView;
    ArrayList<ClimateNews> arrayList = new ArrayList<ClimateNews>();

    public ClimateFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_climate, container, false);
        arrayList = ReadJson.readClimateNews(getContext());
        ArrayList<String> listTitle = new ArrayList<>();
        for (int i = 0; i <arrayList.size() ; i++) {
            listTitle.add(arrayList.get(i).getTitle());
        }


        init(view);
        configListView(listTitle);

        return view;
    }

    private void configListView(ArrayList<String> listTitle) {
        ArrayAdapter arrayAdapter = new ArrayAdapter(getContext(),android.R.layout.simple_list_item_1,listTitle);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getContext(),ClimateDetailActivity.class);
                intent.putExtra("data",arrayList.get(position));
                startActivity(intent);
            }
        });
    }

    private void init(View view) {
        listView = view.findViewById(R.id.list_view);
    }

}
