package com.example.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editTextUrl = findViewById(R.id.editTextUrl);
        Button buttonGetSecondActivity = findViewById(R.id.buttonGetSecondActivity);

        buttonGetSecondActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String url = editTextUrl.getText().toString();
                Intent myIntent = new Intent(MainActivity.this,SecondActivity.class);
                myIntent.putExtra("urlKey",url);
               // myIntent.putExtra("testKey", "TEST");
                startActivity(myIntent);
            }
        });

        Log.d("Main Activity Life Cycle:", "onCreate");

    }

    @Override
    protected void  onStart(){
        super.onStart();
        Log.d("Main Activity Life Cycle:", "onStart");
    }



    @Override
    protected void  onResume(){
        super.onResume();
        Log.d("Main Activity Life Cycle:", "onResume");
    }


    @Override
    protected void  onPause(){
        super.onPause();
        Log.d("Main Activity Life Cycle:", "onPause");
    }


    @Override
    protected void  onStop(){
        super.onStop();
        Log.d("Main Activity Life Cycle:", "onStop");
    }


    @Override
    protected void  onDestroy(){
        super.onDestroy();
        Log.e("Main Activity Life Cycle:", "onDestroy");
    }
}