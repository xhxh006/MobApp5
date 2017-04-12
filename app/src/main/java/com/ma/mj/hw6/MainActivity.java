package com.ma.mj.hw6;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listview;
    TextView textView;

    ArrayList<Info>store_info;
    ArrayList<String> foodstore;
    ArrayAdapter<String> adapter;

    int count = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.tv);
        store_info = new ArrayList<>();
        foodstore = new ArrayList<>();
        setListView();
    }

    public void setListView(){
        listview = (ListView)findViewById(R.id.listview);

        adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,foodstore);
        listview.setAdapter(adapter);



        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent newIntent = new Intent(MainActivity.this, Main3Activity.class);
                newIntent.putExtra("data", store_info.get(position));
                startActivityForResult(newIntent,20);
            }
        });
        listview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, final View view, final int position, long id) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);

                dialog.setTitle("삭제여부 최종 확인")
                        .setMessage("정말로 삭제 하시겠습니까?")
                        .setNegativeButton("닫기", null)
                        .setPositiveButton("삭제", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                foodstore.remove(position);
                                store_info.remove(position);
                                count--;
                                textView.setText("맛집 리스트(" + Integer.toString(count) + ")");
                                Toast.makeText(getApplicationContext(),"삭제되었습니다.",Toast.LENGTH_SHORT).show();
                                adapter.notifyDataSetChanged();
                            }
                        })
                        .show();
                return false;
            }
        });
    }
    public void onClick(View v){
        if(v.getId() == R.id.restAdd) {
            Intent intent = new Intent(MainActivity.this, Main2Activity.class);
            startActivityForResult(intent,10);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 10 && resultCode == 2) {
            Info info = data.getParcelableExtra("store_info");

            store_info.add(info);
            foodstore.add(info.getEn());

            count++;

            textView.setText("맛집 리스트(" + Integer.toString(count) + ")");
            adapter.notifyDataSetChanged();

        }
    }
}
