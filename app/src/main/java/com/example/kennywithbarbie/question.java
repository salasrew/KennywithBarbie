package com.example.kennywithbarbie;

import android.app.DatePickerDialog;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.content.Intent;
import java.util.Calendar;

public class question extends AppCompatActivity {

    private TextView text_question;
    private TextView text_ask;
    private TextView text_bgin;
    private TextView text_end;

    private Button btn_confirm;
    private Button btn_forgot;
    private Button btn_bgin;
    private Button btn_end;
    private int mYear, mMonth, mDay;

    //private int date0_y=0,date0_m=0,date0_d=0;
    private int date1_y=0,date1_m=0,date1_d=0;
    //private  int y=0,m=0,d=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        text_question = (TextView) findViewById(R.id.text_question);
        text_ask = (TextView) findViewById(R.id.text_ask);
        text_bgin = (TextView) findViewById(R.id.text_bgin);
        text_end = (TextView) findViewById(R.id.text_end);
        btn_confirm = (Button) findViewById(R.id.btn_confirm);
        btn_forgot = (Button) findViewById(R.id.btn_forgot);
        btn_bgin = (Button) findViewById(R.id.btn_bgin);
        btn_end = (Button) findViewById(R.id.btn_end);

        btn_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //    String result = et_email.getText().toString();
                Intent intent = new Intent();
                intent.setClass(question.this,main_frame.class);

                /*
                y = Math.abs(date0_y - date1_y);
                m = Math.abs(date0_m - date1_m);
                d = Math.abs(date0_d - date1_d);
                */
                intent.putExtra("date",date1_d);  // 有空再寫
                // 結束時間 + 28 - 現在時間
                startActivity(intent);
            }

        });

        btn_forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //    String result = et_email.getText().toString();
                Intent intent = new Intent();
                intent.setClass(question.this,main_frame.class);
                startActivity(intent);
            }
        });

        btn_bgin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);
                new DatePickerDialog(question.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        String format = setDateFormat(year,month,day);
                        btn_bgin.setText(format);
                    }
                }, mYear,mMonth, mDay).show();
            }
        });
        btn_end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);
                new DatePickerDialog(question.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day)
                    {
                        String format = setDateFormat(year,month,day);
                        btn_end.setText(format);

                        date1_y = year;
                        date1_m = month;
                        date1_d = day;
                    }
                }, mYear,mMonth, mDay).show();
            }
        });

    }

    private String setDateFormat(int year,int monthOfYear,int dayOfMonth){
        return String.valueOf(year) + "-"
                + String.valueOf(monthOfYear + 1) + "-"
                + String.valueOf(dayOfMonth);
        //http://givemepass.blogspot.com/2011/11/datepickerdialog.html
    }

}
