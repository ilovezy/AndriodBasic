package com.example.a.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Calculator extends Activity implements View.OnClickListener {
    Button btn_0;
    Button btn_1;
    Button btn_2;
    Button btn_3;
    Button btn_4;
    Button btn_5;
    Button btn_6;
    Button btn_7;
    Button btn_8;
    Button btn_9;
    Button btn_plus;
    Button btn_minus;
    Button btn_multiply;
    Button btn_divide;
    Button btn_clear;
    Button btn_delete;
    Button btn_equals;
    Button btn_point;

    EditText edit_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator);

        btn_0 = (Button) findViewById(R.id.btn0);
        btn_1 = (Button) findViewById(R.id.btn1);
        btn_2 = (Button) findViewById(R.id.btn2);
        btn_3 = (Button) findViewById(R.id.btn3);
        btn_4 = (Button) findViewById(R.id.btn4);
        btn_5 = (Button) findViewById(R.id.btn5);
        btn_6 = (Button) findViewById(R.id.btn6);
        btn_7 = (Button) findViewById(R.id.btn7);
        btn_8 = (Button) findViewById(R.id.btn8);
        btn_9 = (Button) findViewById(R.id.btn9);
        btn_plus = (Button) findViewById(R.id.btnPlus);
        btn_minus = (Button) findViewById(R.id.btnMinus);
        btn_multiply = (Button) findViewById(R.id.btnMultiply);
        btn_divide = (Button) findViewById(R.id.btnDivide);
        btn_clear = (Button) findViewById(R.id.btnClear);
        btn_equals = (Button) findViewById(R.id.btnEquals);
        btn_point = (Button) findViewById(R.id.btnPoint);
        btn_delete = (Button) findViewById(R.id.btnDelete);

        edit_text = (EditText) findViewById(R.id.editText);

        btn_0.setOnClickListener(this);
        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
        btn_4.setOnClickListener(this);
        btn_5.setOnClickListener(this);
        btn_6.setOnClickListener(this);
        btn_7.setOnClickListener(this);
        btn_8.setOnClickListener(this);
        btn_9.setOnClickListener(this);
        btn_plus.setOnClickListener(this);
        btn_minus.setOnClickListener(this);
        btn_multiply.setOnClickListener(this);
        btn_divide.setOnClickListener(this);
        btn_clear.setOnClickListener(this);
        btn_equals.setOnClickListener(this);
        btn_point.setOnClickListener(this);
        btn_delete.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        String str = edit_text.getText().toString();

        switch (v.getId()) {
            case R.id.btn0:
                break;
            case R.id.btn1:
                break;
            case R.id.btn2:
                break;
            case R.id.btn3:
                break;
            case R.id.btn4:
                break;
            case R.id.btn5:
                break;
            case R.id.btn6:
                break;
            case R.id.btn7:
                break;
            case R.id.btn8:
                break;
            case R.id.btn9:
                break;
            case R.id.btnPlus:
                break;
            case R.id.btnMinus:
                break;
            case R.id.btnMultiply:
                break;
            case R.id.btnDivide:
                edit_text.setText(str + " " + ((Button)v).getText() + " ");
                break;
            case R.id.btnClear:
                edit_text.setText("");
                break;
            case R.id.btnEquals:
                getResult();
                break;
            case R.id.btnPoint:
                edit_text.setText(str + ((Button)v).getText());
                break;
            case R.id.btnDelete:
                if (!str.equals("")) {
                    edit_text.setText(str.substring(0, str.length() - 1));
                }
                break;
            default:
                break;
        }
    }

    public void getResult (){
        String exp = edit_text.getText().toString();
        if(exp.equals("")){
            return;
        }

        if (!exp.contains(" ")) {
            return;
        }

        double result = 0;
        String s1 = exp.substring(0, exp.indexOf(" "));
        String option = exp.substring(exp.indexOf(" ") + 1, exp.indexOf(" ") + 2);
        String s2 = exp.substring(exp.indexOf(" ") + 3);

        if (!s1.equals("") && !s2.equals("")) {
            double d1 = Double.parseDouble(s1);
            double d2 = Double.parseDouble(s2);

            if (option.equals("+")) {
                result = d1 + d2;
            } else if(option.equals("-")) {
                result = d1 - d2;
            } else if(option.equals("*")) {
                result = d1 * d2;
            } else if(option.equals("/")) {
                if(d2 == 0) {
                    result = 0;
                } else {
                    result = d1 / d2;
                }
            }

            if (!s1.contains(".") && !s2.contains(".")) {
                int r = (int) result;
                edit_text.setText(r + "");
            } else {
                edit_text.setText(result + "");
            }
        } else if(!s1.equals("") && s2.equals("")){
            edit_text.setText(exp);
        } else if(s1.equals("") && !s2.equals("")){

        } else {
            edit_text.setText("");
        }
    }
}
