package com.jmk.edu.responsebundle;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button =(Button)findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        CheckBox checkBox1 = (CheckBox)findViewById(R.id.checkBox1);
        checkBox1.setOnClickListener(this);
        CheckBox checkBox2 = (CheckBox)findViewById(R.id.checkBox2);
        checkBox2.setOnClickListener(this);
        CheckBox checkBox3 = (CheckBox)findViewById(R.id.checkBox3);
        checkBox3.setOnClickListener(this);
        CheckBox checkBox4 = (CheckBox)findViewById(R.id.checkBox4);
        checkBox4.setOnClickListener(this);
        String message = "";
        if(checkBox1.isChecked() == true) message += checkBox1.getText().toString()+" ";
        if(checkBox2.isChecked() == true) message += checkBox2.getText().toString()+" ";
        if(checkBox3.isChecked() == true) message += checkBox3.getText().toString()+" ";
        if(checkBox4.isChecked() == true) message += checkBox4.getText().toString();


        if(v.getId()==R.id.button){
            Bundle bundle=new Bundle();
            bundle.putString("message",message);
            Intent intent=new Intent(this, ResultActivity.class);
            intent.putExtras(bundle);
            startActivityForResult(intent,Activity.RESULT_FIRST_USER);
        }

    }

    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        EditText editText=(EditText)findViewById(R.id.editText);
        if(data.hasExtra("resultValue")){
            editText.setText(data.getStringExtra("resultValue"));
        }

    }
}
