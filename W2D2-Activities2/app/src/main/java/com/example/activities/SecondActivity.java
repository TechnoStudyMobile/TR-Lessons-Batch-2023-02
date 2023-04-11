package com.example.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        //İlk sayfadan gelen değeri aldık
        Intent secondIntent = getIntent();
        String url = secondIntent.getStringExtra("urlKey");

        //Alınan değeri ekranda gösterdik
        TextView urlTextView = findViewById(R.id.textViewUrl);
        urlTextView.setText(url);


        //Butonu tanımladık
        Button getWebPage = findViewById(R.id.buttonGetWebPage);
        getWebPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Butona tıklanınca taracıyı açtık
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www."+url));
                startActivity(browserIntent);
            }
        });


        Button buttonShare = findViewById(R.id.buttonShare);
        buttonShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Intent oluşturduk
                Intent shareIntent = new Intent(Intent.ACTION_SEND);

                //Intente text göndereciğimiz belirttik
                shareIntent.setType("text/plain");

                //Neyi belirttik, yani url
                shareIntent.putExtra(Intent.EXTRA_TEXT, url);

                //Intenti başlattık
                startActivity(Intent.createChooser(shareIntent, "Şununla Paylaş"));

            }
        });


        Button buttonCall = findViewById(R.id.buttonCall);
        buttonCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent callIntent = new Intent(Intent.ACTION_CALL , Uri.parse("tel:" + "4440444"));
               startActivity(callIntent);
            }
        });


    }
}