package com.example.apidemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.apidemo.Sqllite.DBManager;

public class AddDetailActivity extends AppCompatActivity implements View.OnClickListener {

    private Button addTodoBtn;
    private EditText subjectEditText;
    private EditText descEditText;
    DBManager dbManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Add Record");

        setContentView(R.layout.activity_add_detail);
        subjectEditText = (EditText) findViewById(R.id.subject_edittext);
        descEditText = (EditText) findViewById(R.id.description_edittext);

        addTodoBtn = (Button) findViewById(R.id.add_record);

        dbManager=new DBManager(this);
        dbManager.open();
        addTodoBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
      switch (view.getId())
      {
          case R.id.add_record:
            dbManager.insert(subjectEditText.getText().toString(),descEditText.getText().toString());
              Intent main = new Intent(AddDetailActivity.this, SqlliteActivity.class)
                      .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

              startActivity(main);
      }
    }
}
