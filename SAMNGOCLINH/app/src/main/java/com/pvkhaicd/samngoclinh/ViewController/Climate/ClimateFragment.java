package com.pvkhaicd.samngoclinh.ViewController.Climate;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import com.pvkhaicd.samngoclinh.Model.Climate;
import com.pvkhaicd.samngoclinh.Model.ClimateN;
import com.pvkhaicd.samngoclinh.Network.APIService;
import com.pvkhaicd.samngoclinh.Network.RetrofitClient;
import com.pvkhaicd.samngoclinh.R;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class ClimateFragment extends Fragment {

    ListView listView;
    ArrayAdapter arrayAdapter;
    List<Climate> arrayList = new ArrayList<Climate>();

    public ClimateFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_climate, container, false);
//        arrayList = ReadJson.readClimateNews(getContext());
        requestGetClimateNews();
        ArrayList<String> listTitle = new ArrayList<>();
        for (int i = 0; i <arrayList.size() ; i++) {
            listTitle.add(arrayList.get(i).getTitle());
        }


        init(view);
        configListView(listTitle);

        return view;
    }

    private void configListView(ArrayList<String> listTitle) {

        arrayAdapter = new ArrayAdapter(getContext(),android.R.layout.simple_list_item_1,listTitle);
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

    void requestGetClimateNews(){
        RetrofitClient.getCilent().create(APIService.class)
                .getClimateNews().enqueue(new Callback<ClimateN>() {
            @Override
            public void onResponse(Call<ClimateN> call, Response<ClimateN> response) {
                if(response.isSuccessful()){
                    Toast.makeText(getContext(), "oke", Toast.LENGTH_SHORT).show();
                    arrayList = response.body().getClimate();
                    arrayAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<ClimateN> call, Throwable t) {
                Log.i("AA", t.getMessage());
                Toast.makeText(getActivity(), "Đã có lỗi xảy ra", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
