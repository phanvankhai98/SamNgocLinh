package com.pvkhaicd.samngoclinh.ViewController.Climate;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import com.pvkhaicd.samngoclinh.Model.Product;
import com.pvkhaicd.samngoclinh.R;
import com.pvkhaicd.samngoclinh.ViewController.Adapter.ProductAdapter;

import java.util.ArrayList;


public class ProductFragment extends Fragment {

    public ProductFragment() {
        // Required empty public constructor
    }


    String[] title = new String[]{"Hội chợ sâm","Tham gia","Sản Phẩm"};

    ArrayList<Product> data = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_product, container, false);
        data.add(new Product("https://samngoclinhkontum.com/wp-content/uploads/2019/09/binh-sam-ngoc-linh-13-nam-tuoi-02-1-300x300.jpg","Bình Rượu Ngâm Sâm Ngọc Linh tự nhiên"));
        data.add(new Product("https://samngoclinhkontum.com/wp-content/uploads/2019/01/DSC01540-copy-300x300.jpg","Dịch chiết Sâm Ngọc Linh K5"));
        data.add(new Product("https://samngoclinhkontum.com/wp-content/uploads/2019/09/binh-sam-ngoc-linh-13-nam-tuoi-02-1-300x300.jpg","Bình Rượu Ngâm Sâm Ngọc Linh tự nhiên"));
        data.add(new Product("https://samngoclinhkontum.com/wp-content/uploads/2019/01/DSC01540-copy-300x300.jpg","Dịch chiết Sâm Ngọc Linh K5"));
        data.add(new Product("https://samngoclinhkontum.com/wp-content/uploads/2019/09/binh-sam-ngoc-linh-13-nam-tuoi-02-1-300x300.jpg","Bình Rượu Ngâm Sâm Ngọc Linh tự nhiên"));
        data.add(new Product("https://samngoclinhkontum.com/wp-content/uploads/2019/01/DSC01540-copy-300x300.jpg","Dịch chiết Sâm Ngọc Linh K5"));

        ProductAdapter productAdapter = new ProductAdapter(data,getContext());

        GridView gridView = view.findViewById(R.id.gridView);
        ArrayAdapter<String> arrayAdapter
                = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1 , title);
        gridView.setAdapter(productAdapter);

        return view;
    }


}
