package com.example.a.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestListView extends Activity implements OnItemClickListener, OnScrollListener {
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

        test_data_list = new ArrayList<>();

        simple_adapter = new SimpleAdapter(this, getData(), R.layout.list_view_item, new String[]{"pic", "text"}, new int[]{R.id.pic, R.id.text_part});

//        list_view.setAdapter(arr_adapter);
        list_view.setAdapter(simple_adapter);
        list_view.setOnItemClickListener(this);
        list_view.setOnScrollListener(this);
    }

    private List<Map<String, Object>> getData() {
        for (int i = 0; i<20; i++){
            Map<String, Object> map = new HashMap<>();
            map.put("pic", R.drawable.common_google_signin_btn_icon_light);
            map.put("text", "慕课网" + i);
            test_data_list.add(map);
        }

        return test_data_list;
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        switch (scrollState) {
            case SCROLL_STATE_FLING:
                Log.i("main ", "用户在手指离开屏幕之前，由于用力滑了一下，视图任然依靠惯性继续滑动");
                Map<String, Object>map = new HashMap<>();
                map.put("pic", R.drawable.common_google_signin_btn_text_dark);
                map.put("text", "增加项目");
                test_data_list.add(map);
                simple_adapter.notifyDataSetChanged();
                break;
            case SCROLL_STATE_IDLE:
                Log.i("main ", "视图已经停止滑动");
                break;
            case SCROLL_STATE_TOUCH_SCROLL:
                Log.i("main ", "正在滑动,手指没有离开屏幕");
                break;
            default:
                break;
        }
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String text = list_view.getItemAtPosition(position) + "";
        Toast.makeText(this, "position= " + position + " text= " + text, Toast.LENGTH_SHORT).show();
    }
}
