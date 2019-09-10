package com.pvkhaicd.samngoclinh.ViewController.Worm;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.pvkhaicd.samngoclinh.Model.WormNewsEvent.Worm;
import com.pvkhaicd.samngoclinh.Model.WormNewsEvent.WormNews;
import com.pvkhaicd.samngoclinh.Network.APIService;
import com.pvkhaicd.samngoclinh.Network.RetrofitClient;
import com.pvkhaicd.samngoclinh.R;
import com.pvkhaicd.samngoclinh.ViewController.Adapter.WormNewsEventAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsFragment extends Fragment {

    ListView listView ;
    WormNews data = new WormNews();
    List<Worm> wormList = new ArrayList<>();
    WormNewsEventAdapter adapter;

    public NewsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_base, container, false);

        init(view);
        requestGetWormNews();
        adapter = new WormNewsEventAdapter(wormList,getContext());
        listView.setAdapter(adapter);
        return view;
    }
    void requestGetWormNews(){
        RetrofitClient.getClient().create(APIService.class)
                .getWormNews().enqueue(new Callback<WormNews>() {
            @Override
            public void onResponse(Call<WormNews> call, Response<WormNews> response) {
                if(response.isSuccessful()){
                    Toast.makeText(getContext(), "oke", Toast.LENGTH_SHORT).show();
                    adapter.setData(response.body().getWorm());
                }
            }

            @Override
            public void onFailure(Call<WormNews> call, Throwable t) {
                Log.d("AA", t.getMessage() );
                Toast.makeText(getContext(), "Lỗi! xin thử lại", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void init(View view) {
        listView = view.findViewById(R.id.list_view);
    }
}
