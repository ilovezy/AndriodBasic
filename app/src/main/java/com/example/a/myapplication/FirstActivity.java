package com.example.a.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FirstActivity extends Activity {
    private Button btn1;
    private Button btn2;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_activity);

        /**
         * click btn1
         * startActivity
         */
        btn1 = (Button) findViewById(R.id.button_first);
        btn2 = (Button) findViewById(R.id.button_second);
        textViewResult = (TextView) findViewById(R.id.textView_showResult);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

        /**
         * startActivityForResult
         */

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                startActivityForResult(intent, 1);
            }
        });
    }

    /**
     * by startActivityForResult, 返回数据的方法
     * requestCode 请求标识
     * resultCode 第二个页面返回的标识
     * data 第二个页面返回的数据
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1 && resultCode == 2) {
            String backStr = data.getStringExtra("data");
            System.out.println(backStr);
            textViewResult.setText(backStr);
        }
    }
}
