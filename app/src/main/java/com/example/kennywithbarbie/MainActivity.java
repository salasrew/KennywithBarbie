package com.example.kennywithbarbie;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    private TextView text_title;
    private EditText et_email;
    private EditText et_password;
    private EditText et_number;
    private Button btn_login;
    private Button btn_try;
    private Button btn_apply;
    private RadioButton rdiobtn_kenny;
    private RadioButton rdiobtn_barbie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        RadioGroup sex = findViewById(R.id.radioGroup_sex);

        text_title = findViewById(R.id.text_title);
        et_email = findViewById(R.id.et_email);
        et_password =  findViewById(R.id.et_password);
        et_number = findViewById(R.id.et_number);
        btn_login = findViewById(R.id.btn_login);
        btn_try = findViewById(R.id.btn_try);
        btn_apply = findViewById(R.id.btn_apply);

        rdiobtn_kenny = findViewById(R.id.rdionbtn_kenny);
        rdiobtn_barbie = findViewById(R.id.rdionbtn_barbie);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //    String result = et_email.getText().toString();
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,question.class);
                startActivity(intent);
            }
        });

        btn_try.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //    String result = et_email.getText().toString();
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,question.class);
                startActivity(intent);
            }
        });

    }
}
