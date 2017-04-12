package com.ma.mj.hw6;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Main2Activity extends AppCompatActivity {
    EditText en, et, em1,em2, em3, eh;
    RadioButton rc, rp, rh;
    int rb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        en = (EditText)findViewById(R.id.etname);
        et = (EditText)findViewById(R.id.ettel);
        em1 = (EditText)findViewById(R.id.etmenu1);
        em2 = (EditText)findViewById(R.id.etmenu2);
        em3 = (EditText)findViewById(R.id.etmenu3);
        eh = (EditText)findViewById(R.id.etaddr);
        rc = (RadioButton)findViewById(R.id.radio1);
        rp = (RadioButton)findViewById(R.id.radio2);
        rh = (RadioButton)findViewById(R.id.radio3);
    }

    public void onClick(View v){
        if (v.getId() == R.id.btnAdd){
            long now = System.currentTimeMillis();
            Date date = new Date(now);
            SimpleDateFormat currentDateFormat = new SimpleDateFormat("yyy/MM/dd");
            final String currentDate= currentDateFormat.format(date);

            Intent intent = getIntent();

            if(rc.isChecked()){
                rb = 1;
            }
            else if(rp.isChecked()){
                rb = 2;
            }
            else if(rh.isChecked()){
                rb = 3;
            }
            String name = en.getText().toString();
            String tel = et.getText().toString();
            String menu1 = em1.getText().toString();
            String menu2 = em2.getText().toString();
            String menu3 = em3.getText().toString();
            String address = eh.getText().toString();
            String time = currentDate;

            Info info = new Info(name, rb, tel, menu1, menu2, menu3, address, time);

            intent.putExtra("store_info",info);
            setResult(2,intent);

            finish();
        }
        else if(v.getId() == R.id.btnCancel){
            finish();
        }
    }


}
