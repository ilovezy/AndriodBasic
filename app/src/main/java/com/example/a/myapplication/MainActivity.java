package com.example.a.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btn1;
    private Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 将布局xml文件引入到 activity 中
        setContentView(R.layout.activity_main);

        btn1 = (Button) findViewById(R.id.button1);
        btn2 = (Button) findViewById(R.id.button2);

        /**
         * 点击事件外部类写法和作用
         */
        btn1.setOnClickListener(new MyOnClickListener() {
            @Override
            public void onClick(View v) {
                // 调用父类的onclick事件
                super.onClick(v);
                Toast.makeText(MainActivity.this, "btn1要执行的逻辑", 1).show();
            }
        });
        btn2.setOnClickListener(new MyOnClickListener() {
            @Override
            public void onClick(View v) {
                // 调用父类的onclick事件
                super.onClick(v);
                Toast.makeText(MainActivity.this, "btn2要执行的逻辑", 1).show();
            }
        });
    }
}

class MyOnClickListener implements View.OnClickListener {
    @Override
    public void onClick(View v) {
        v.setAlpha(0.5f);
        Log.i("tag", "父类的onClick事件");
    }
}