package com.example.a.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by a on 2017/1/4.
 */

public class TestGridView extends Activity {
    private GridView gridView;
    private List<Map<String, Object>> dataList;
    private int[]icon = {
        R.drawable.common_google_signin_btn_icon_light,
        R.drawable.cat,
        R.drawable.common_google_signin_btn_icon_dark_disabled,
        R.drawable.common_google_signin_btn_icon_light,
        R.drawable.cat,
        R.drawable.common_google_signin_btn_icon_dark_disabled,
        R.drawable.common_google_signin_btn_icon_light,
        R.drawable.cat,
        R.drawable.common_google_signin_btn_icon_dark_disabled,
        R.drawable.common_google_signin_btn_icon_light,
        R.drawable.cat,
        R.drawable.common_google_signin_btn_icon_dark_disabled
    };
    private String[] iconName = {"good", "bad ", "not good","good", "bad ", "not good","good", "bad ", "not good","good", "bad ", "not good",};
    private SimpleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid_view);

        gridView = (GridView) findViewById(R.id.gridView1);
        // 准备数据源
        // 新建适配器 (SimpleAdapter)
        // GridView 加载适配器
        // GridView 配置事件监听器 (OnItemClickListener)
        dataList = new ArrayList<>();
        adapter = new SimpleAdapter(this, getData(), R.layout.grid_view_item, new String[]{"image", "text"}, new int[]{R.id.image1, R.id.text1});
        gridView.setAdapter(adapter);
    }

    private List<Map<String, Object>> getData() {
        for(int i = 0; i < icon.length; i++) {
            Map<String, Object>map = new HashMap<>();
            map.put("image", icon[i]);
            map.put("text", iconName[i]);
            dataList.add(map);
        }
        return dataList;
    }
}
