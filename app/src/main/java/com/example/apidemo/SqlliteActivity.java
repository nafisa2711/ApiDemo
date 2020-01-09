package com.example.apidemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import com.example.apidemo.Sqllite.DBHelper;
import com.example.apidemo.Sqllite.DBManager;

public class SqlliteActivity extends AppCompatActivity {

    ImageView add;
    ListView addlist;
    DBManager dbManager;
    private SimpleCursorAdapter adapter;

    final String[] from = new String[]{DBHelper._ID,
            DBHelper.NAME, DBHelper.SUBJECT};

    final int[] to = new int[]{R.id.id, R.id.title, R.id.desc};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqllite);
        add = findViewById(R.id.add);
        addlist = findViewById(R.id.addlist);
        dbManager = new DBManager(this);
        dbManager.open();


            Cursor cursor = dbManager.fetch();
            adapter = new SimpleCursorAdapter(this, R.layout.activity_view_record, cursor, from, to, 0);
            adapter.notifyDataSetChanged();
            addlist.setAdapter(adapter);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent add_mem = new Intent(SqlliteActivity.this, AddDetailActivity.class);
                startActivity(add_mem);
            }
        });

        addlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView idTextView = (TextView) view.findViewById(R.id.id);
                TextView titleTextView = (TextView) view.findViewById(R.id.title);
                TextView descTextView = (TextView) view.findViewById(R.id.desc);

                String id = idTextView.getText().toString();
                String title = titleTextView.getText().toString();
                String desc = descTextView.getText().toString();
                Intent modify_intent = new Intent(getApplicationContext(), UpdateActivity.class);
                modify_intent.putExtra("title", title);
                modify_intent.putExtra("desc", desc);
                modify_intent.putExtra("id", id);

                startActivity(modify_intent);
            }
        });
    }
}
