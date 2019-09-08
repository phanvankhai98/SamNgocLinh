package com.pvkhaicd.samngoclinh.ViewController.Adapter;

import android.content.Context;

import com.pvkhaicd.samngoclinh.Model.ClimateNews;
import com.pvkhaicd.samngoclinh.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ReadJson {
    public static ArrayList<ClimateNews> readClimateNews (Context context){
        ArrayList <ClimateNews> arrayList = new ArrayList<ClimateNews>();
        String json = readText(context, R.raw.climate);
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray jsonArray = jsonObject.getJSONArray("climate");
            for (int i = 0; i < jsonArray.length(); i++){
                JSONObject object = (JSONObject) jsonArray.get(i);
                String title = object.getString("title");
                String content = object.getString("content");
                ClimateNews tmp = new ClimateNews(title,content);
                arrayList.add(tmp);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return arrayList;
    }
    public static ArrayList<ClimateNews> readWormNews (Context context){
        ArrayList <ClimateNews> arrayList = new ArrayList<ClimateNews>();
        String json = readText(context, R.raw.climate);
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray jsonArray = jsonObject.getJSONArray("worm");
            for (int i = 0; i < jsonArray.length(); i++){
                JSONObject object = (JSONObject) jsonArray.get(i);
                String title = object.getString("title");
                String content = object.getString("content");
                ClimateNews tmp = new ClimateNews(title,content);
                arrayList.add(tmp);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return arrayList;
    }
    private static String readText(Context context, int climate) {
        InputStream is = context.getResources().openRawResource(climate);
        BufferedReader br= new BufferedReader(new InputStreamReader(is));
        StringBuilder sb= new StringBuilder();
        String s= null;
        while(true) {
            try {
                if (!((  s = br.readLine())!=null)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            sb.append(s);
            sb.append("\n");
        }
        return sb.toString();
    }
}
