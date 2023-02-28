package com.obasoglu.android.androidviews;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button okButton;
    private ImageView mainImage;

    private TextView rakamText;

    private int toplamRakam = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        // Access views
        okButton = findViewById(R.id.ok_button);
        mainImage = findViewById(R.id.image_main);
        rakamText = findViewById(R.id.text_content);
        //  Change image resource. First layout resource set in attribute, later this
        // function changes it.
        mainImage.setImageResource(R.drawable.background_wild);

        okButton.setOnClickListener(new View.OnClickListener() {
            // Will be triggered when user clicks on "okButton"
            @Override
            public void onClick(View view) {
                Log.d("MainActivity", "Button is clicked.");
                toplamRakam++;
                String toplamRakamText = String.valueOf(toplamRakam);
                rakamText.setText(toplamRakamText);
                Toast.makeText(MainActivity.this, toplamRakamText , Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}