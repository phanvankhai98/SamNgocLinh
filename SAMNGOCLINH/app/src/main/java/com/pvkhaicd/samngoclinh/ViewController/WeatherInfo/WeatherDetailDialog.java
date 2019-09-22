package com.pvkhaicd.samngoclinh.ViewController.WeatherInfo;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.pvkhaicd.samngoclinh.Model.Weather.Weather;
import com.pvkhaicd.samngoclinh.Model.Weather.WeatherData;
import com.pvkhaicd.samngoclinh.R;

public class WeatherDetailDialog extends DialogFragment {

    private TextView mTextViewTitle;
    private TextView mTextViewMain;
    private TextView mTextViewTemp;
    private TextView mTextViewHumid;
    private Button mButtonClose;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_dialog_detail, container, false);
        mTextViewTitle = view.findViewById(R.id.text_city_name);
        mTextViewMain = view.findViewById(R.id.text_weather_main);
        mTextViewTemp = view.findViewById(R.id.text_temp);
        mTextViewHumid = view.findViewById(R.id.text_humid);
        mButtonClose = view.findViewById(R.id.button_close);
        Bundle bundle = getArguments();
        WeatherData data = bundle.getParcelable("weather");
        String city_name = bundle.getString("city_name");
        if(data!=null){
            setData(data,city_name);
        }
        mButtonClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
        return view;
    }

    private void setData(WeatherData data,String city_name) {
        if(city_name == null) city_name = data.getName();
        mTextViewTitle.setText(city_name);
        double temp = (data.getMain().getTemp()-272.15);
        mTextViewTemp.setText("Nhiệt độ: "+Math.round(temp*10)/10+" C");
        mTextViewHumid.setText("Độ ẩm: " + data.getMain().getHumidity()+" %");
        mTextViewMain.setText("Thời tiết hôm nay: " + data.getWeather().get(0).getMain());
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        return dialog;
    }
}
