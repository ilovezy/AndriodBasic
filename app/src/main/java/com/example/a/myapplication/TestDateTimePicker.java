package com.example.a.myapplication;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;
import android.widget.TextView;
import android.widget.TimePicker;
import java.util.Calendar;

public class TestDateTimePicker extends Activity {
    private TextView showDate;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.date_picker);
        Calendar cal1 = Calendar.getInstance();
        int year = cal1.get(Calendar.YEAR);
        int month = cal1.get(Calendar.MONTH) + 1;
        int day = cal1.get(Calendar.DAY_OF_MONTH);
        int hour = cal1.get(Calendar.HOUR);
        int minute = cal1.get(Calendar.MINUTE);

        String tempStr = year + "-" + month + "-" + day + " " + hour + ":" + minute;
        showDate = (TextView) findViewById(R.id.showDate);
        showDate.setText(tempStr);
        setTitle(tempStr);

        DatePicker datePicker1 = (DatePicker) findViewById(R.id.datePicker1);
        TimePicker timePicker1 = (TimePicker) findViewById(R.id.timePicker1);

        datePicker1.init(year, cal1.get(Calendar.MONTH), day, new OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                String tempStr = year + "-" + monthOfYear + "-" + dayOfMonth;
                showDate.setText(tempStr);
                setTitle(tempStr);
            }
        });

        timePicker1.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                String tempStr = hourOfDay + ":" + minute;
                showDate.setText(tempStr);
                setTitle(tempStr);
            }
        });

        new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                String tempStr = year + "-" + month + "-" + dayOfMonth;
                showDate.setText(tempStr);
                setTitle(tempStr);
            }
        }, year, cal1.get(Calendar.MONTH), day).show();

        new TimePickerDialog(this, new OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                String tempStr = hourOfDay + ":" + minute;
                showDate.setText(tempStr);
                setTitle(tempStr);
            }
        }, hour, minute, true).show();
    }
}
