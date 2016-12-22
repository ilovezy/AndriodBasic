package com.example.a.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 将布局xml文件引入到 activity 中
        setContentView(R.layout.activity_main);

        /**
         * init 当前所需要的控件
         * @return 返回的是一个 view 的对象
         */
        loginButton =(Button)findViewById(R.id.button1);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 在当前onClick方法中监听点击Button的动作
                System.out.println("我的按钮被点击了");
            }
        });
    }
}