package com.pvkhaicd.samngoclinh.ViewController.WeatherInfo;


import android.app.Activity;
import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.pvkhaicd.samngoclinh.Model.Weather.WeatherData;
import com.pvkhaicd.samngoclinh.Network.APIService;
import com.pvkhaicd.samngoclinh.Network.WeatherClient;
import com.pvkhaicd.samngoclinh.R;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class WeatherFragment extends Fragment implements OnMapReadyCallback {

    private GoogleMap mGoogleMap;
    private LatLng mLatLngDefault = new LatLng(15.87944, 108.335);
    private WeatherData mWeatherData = null;
    private ImageView mImageViewWeatherDetail;
    private String markedName = "Hoi An";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_weather, container, false);
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.fragment_map);
        mapFragment.getMapAsync(this);
        setHasOptionsMenu(true);
        mImageViewWeatherDetail = view.findViewById(R.id.image_weather);
        mImageViewWeatherDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getChildFragmentManager();
                WeatherDetailDialog weatherDetailDialog = new WeatherDetailDialog();
                Bundle bundle = new Bundle();
                bundle.putParcelable("weather",mWeatherData);
                bundle.putString("city_name",markedName);
                weatherDetailDialog.setArguments(bundle);
                weatherDetailDialog.show(fragmentManager,"weather");
            }
        });
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_question_screen, menu);
        final MenuItem searchItem = menu.findItem(R.id.menu_search);
        final SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setQueryHint("Search for address");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                try {
                    geoLocate(s);
                    hideKeyboardFrom(getContext(),searchView);
                    searchView.clearFocus();
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
                return true;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });
    }

    private void moveCamera(LatLng latLng, float zoom, String title) {
        mGoogleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, zoom));
        MarkerOptions markerOptions = new MarkerOptions().title(title).position(latLng);
        mGoogleMap.addMarker(markerOptions);
    }

    private void geoLocate(String query) throws IOException {
        Geocoder geocoder = new Geocoder(getContext());
        List<Address> list;
        list = geocoder.getFromLocationName(query, 1);
        if (list.size() > 0) {
            Address address = list.get(0);
            double lat = address.getLatitude();
            double lon = address.getLongitude();
            mLatLngDefault = new LatLng(lat, lon);
            markedName = address.getLocality();
            Log.d("test", "geoLocate: " + markedName);
            moveCamera(mLatLngDefault, 15f, address.getLocality());
            setWeatherDetail(lat, lon);
        }
    }

    private void setWeatherDetail(double lat, double lon) {

        APIService.WeatherService service = WeatherClient.getClient().create(APIService.WeatherService.class);
        service.getWeatherData(lat, lon, getResources().getString(R.string.weather_api_key)).enqueue(new Callback<WeatherData>() {
            @Override
            public void onResponse(Call<WeatherData> call, Response<WeatherData> response) {
                if (response.isSuccessful()) {
                    mWeatherData = response.body();
                }
            }

            @Override
            public void onFailure(Call<WeatherData> call, Throwable t) {
                Log.d("test", "onFailure: "+ t.getMessage());
            }
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mGoogleMap = googleMap;
        CameraPosition googlePlex = CameraPosition.builder()
                .target(mLatLngDefault)
                .zoom(10)
                .bearing(0)
                .tilt(45)
                .build();
        mGoogleMap.animateCamera(CameraUpdateFactory.newCameraPosition(googlePlex), 10000, null);
        mGoogleMap.addMarker(new MarkerOptions().position(mLatLngDefault).title("Hoi An"));
        setWeatherDetail(mLatLngDefault.latitude, mLatLngDefault.longitude);
    }
    public static void hideKeyboardFrom(Context context, View view) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
