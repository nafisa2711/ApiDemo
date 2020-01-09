package com.example.apidemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.apidemo.Sqllite.DBManager;

public class UpdateActivity extends AppCompatActivity {

    private EditText titleText;
    private Button updateBtn, deleteBtn;
    private EditText descText;

    private long _id;

    private DBManager dbManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Modify Record");
        setContentView(R.layout.activity_update);

        dbManager = new DBManager(this);
        dbManager.open();

        titleText = (EditText) findViewById(R.id.subject_edittext);
        descText = (EditText) findViewById(R.id.description_edittext);

        updateBtn = (Button) findViewById(R.id.btn_update);
        deleteBtn = (Button) findViewById(R.id.btn_delete);

        String id = getIntent().getStringExtra("id");
        String name = getIntent().getStringExtra("title");
        String desc = getIntent().getStringExtra("desc");
        _id = Long.parseLong(id);

        titleText.setText(name);
        descText.setText(desc);

        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbManager.update(_id, titleText.getText().toString(), descText.getText().toString());
                returnHome();
            }
        });
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbManager.delete(_id);
                returnHome();
            }
        });

    }
    public void returnHome() {
        Intent home_intent = new Intent(getApplicationContext(), SqlliteActivity.class)
                .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(home_intent);
    }
}
