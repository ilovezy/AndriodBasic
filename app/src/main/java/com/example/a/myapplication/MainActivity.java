package com.example.a.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AutoCompleteTextView;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    private AutoCompleteTextView acTextView;
    private String[] res = {"beijing1", "beijing2", "beijing3", "hangzhou1", "shanghai2"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 将布局xml文件引入到 activity 中
        setContentView(R.layout.activity_main);

    }

}
