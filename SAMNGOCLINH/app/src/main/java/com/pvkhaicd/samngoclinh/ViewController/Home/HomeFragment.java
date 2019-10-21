package com.pvkhaicd.samngoclinh.ViewController.Home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pvkhaicd.samngoclinh.Model.Home;
import com.pvkhaicd.samngoclinh.R;
import com.pvkhaicd.samngoclinh.ViewController.Adapter.HomeAdapter;
import com.pvkhaicd.samngoclinh.ViewController.Adapter.OnItemClickListener;
import com.pvkhaicd.samngoclinh.ViewController.MainActivity;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements OnItemClickListener {

    private OnHomeItemClickListener mOnHomeItemClickListener;
    private RecyclerView mRecyclerViewHome;
    private HomeAdapter mHomeAdapter;
    private ViewFlipper mViewFlipper;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        setHasOptionsMenu(true);
        mRecyclerViewHome = view.findViewById(R.id.recycler_home);
        mViewFlipper = view.findViewById(R.id.view_flipper);
        setUpViewFlipper();
        List<Home> icons = createListHome();
        mHomeAdapter = new HomeAdapter(getContext(), icons);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        mRecyclerViewHome.setLayoutManager(gridLayoutManager);
        mRecyclerViewHome.setAdapter(mHomeAdapter);
        mHomeAdapter.setOnItemClickListener(this);
        return view;
    }

    public void setOnHomeItemClickListener(OnHomeItemClickListener onHomeItemClickListener) {
        mOnHomeItemClickListener = onHomeItemClickListener;
    }

    private List<Home> createListHome() {
        List<Home> homes = new ArrayList<>();
        homes.add(new Home(MainActivity.TAG_NEWS, getResources().getString(R.string.news), R.drawable.icon_news_32));
        homes.add(new Home(MainActivity.TAG_FAIR, getResources().getString(R.string.fair), R.drawable.icon_fair_32));
        homes.add(new Home(MainActivity.TAG_ADVICE, getResources().getString(R.string.advice), R.drawable.icon_advice_32));
        homes.add(new Home(MainActivity.TAG_DIAGNOSIS, getResources().getString(R.string.diagnosis), R.drawable.icon_diagnosis_32));
        homes.add(new Home(MainActivity.TAG_SOURCE, getResources().getString(R.string.source), R.drawable.icon_source_32));
        homes.add(new Home(MainActivity.TAG_QUESTION, getResources().getString(R.string.question), R.drawable.icon_question_new_32));
        return homes;
    }

    @Override
    public void onItemClicked(int position) {
        if (mHomeAdapter != null) {
            Home home = mHomeAdapter.getData().get(position);
            if (mOnHomeItemClickListener != null)
                mOnHomeItemClickListener.onHomeItemClick(home.getTagName());
        }
    }

    private void setUpViewFlipper() {
        int[] image = new int[]{R.drawable.slide1, R.drawable.slide2, R.drawable.slide3};
        for (Integer id : image) {
            addImage(id);
        }

    }

    private void addImage(int id) {
        ImageView imageView = new ImageView(getContext());
        imageView.setBackgroundResource(id);
        mViewFlipper.addView(imageView);
        mViewFlipper.setFlipInterval(4000);
        mViewFlipper.setAutoStart(true);
        mViewFlipper.setInAnimation(getContext(), android.R.anim.slide_in_left);
        mViewFlipper.setOutAnimation(getContext(), android.R.anim.slide_out_right);

    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.menu_home, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }
}
