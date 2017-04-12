package com.ma.mj.hw6;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import static com.ma.mj.hw6.R.drawable.chicken;
import static com.ma.mj.hw6.R.drawable.hamburger;
import static com.ma.mj.hw6.R.drawable.pizza;

public class Main3Activity extends AppCompatActivity {
    ImageView img;
    TextView tn, tm1,tm2,tm3,tt,th,td;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        tn = (TextView)findViewById(R.id.txtname);
        tm1 = (TextView)findViewById(R.id.etmenu1);
        tm2 = (TextView)findViewById(R.id.etmenu2);
        tm3 = (TextView)findViewById(R.id.etmenu3);
        tt = (TextView)findViewById(R.id.tvTel);
        th = (TextView)findViewById(R.id.tvURL);
        td = (TextView)findViewById(R.id.tvRegdate);
        img = (ImageView)findViewById(R.id.imgno);

        Intent intent = getIntent();
        Info data = intent.getParcelableExtra("data");

        tn.setText(data.getEn());
        if(data.getRb() == 1){
            img.setImageResource(R.drawable.chicken);
        }
        else if(data.getRb() ==  2){
            img.setImageResource(R.drawable.pizza);
        }
        else if (data.getRb() == 3){
            img.setImageResource(R.drawable.hamburger);
        }
        tm1.setText(data.getEm1());
        tm2.setText(data.getEm2());
        tm3.setText(data.getEm3n());
        tt.setText(data.getEt());
        th.setText(data.getEh());
        td.setText(data.getDate());
    }
    public void onClick(View v){
        if(v.getId() == R.id.btnback){
            finish();
        }
        else if(v.getId() == R.id.imageView2){
            String tel = tt.getText().toString();
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:/"+tel));
            startActivity(intent);
        }
        else if(v.getId() == R.id.imageView3){
            String web = th.getText().toString();
            Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse(web));
            startActivity(intent);
        }
    }
}
