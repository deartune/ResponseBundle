package com.jmk.edu.responsebundle;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Bundle bundle=getIntent().getExtras();
        editText=(EditText)findViewById(R.id.editText);
        editText.setText(bundle.getString("message","no"));
    }
    @Override
    public void finish() {

        Intent intent = new Intent();
        Bundle bundle1 = new Bundle();
        bundle1.putString("resultValue", ((EditText)editText).getText().toString());
        intent.putExtras(bundle1);
        setResult(Activity.RESULT_FIRST_USER, intent);
        super.finish();
}}
