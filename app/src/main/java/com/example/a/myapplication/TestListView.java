package com.example.a.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class TestListView extends Activity {
    private ListView list_view;
    private ArrayAdapter<String> arr_adapter;
    private SimpleAdapter simple_adapter;
    private List<Map<String, Object>> test_data_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);

        list_view = (ListView) findViewById(R.id.list_view_test);
        String[]arr_data = {"慕课网1","慕课网2","慕课网3","慕课网4","慕课网5"};
        arr_adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arr_data);

        test_data_list = new ArrayList<Map<String, Object>>();

        simple_adapter = new SimpleAdapter(this, getData(), R.layout.list_view_item, new String[]{"pic", "text"}, new int[]{R.id.pic, R.id.text_part});

//        list_view.setAdapter(arr_adapter);
        list_view.setAdapter(simple_adapter);
    }

    private List<Map<String, Object>> getData() {
        for (int i = 0; i<20; i++){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("pic", R.drawable.common_google_signin_btn_icon_light);
            map.put("text", "慕课网" + i);
            test_data_list.add(map);
        }

        return test_data_list;
    }
}
