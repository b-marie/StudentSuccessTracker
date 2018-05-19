package com.example.hsport.c196mobileappdevelopmentbheller;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TermEditActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY = "com.example.android.wordlistsql.REPLY";

    private EditText mEditTermName;
    private EditText mEditTermStart;
    private EditText mEditTermEnd;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_term_edit);
        mEditTermName = findViewById(R.id.edit_term_name);
        mEditTermStart = findViewById(R.id.edit_term_start);
        mEditTermEnd = findViewById(R.id.edit_term_end);


        final Button button = findViewById(R.id.button_save);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent replyIntent = new Intent();
                if (TextUtils.isEmpty(mEditTermName.getText())) {
                    setResult(RESULT_CANCELED, replyIntent);
                } else {
                    String tName = mEditTermName.getText().toString();
                    String tStart = mEditTermStart.getText().toString();
                    String tEnd = mEditTermEnd.getText().toString();
                    replyIntent.putExtra(EXTRA_REPLY, tName);
                    setResult(RESULT_OK, replyIntent);
                }
                finish();
            }
        });
    }

}
