package com.example.cardviewandrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toolbar;

import java.util.Objects;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

      getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        CompanyModel companyModel = (CompanyModel) getIntent().getSerializableExtra("company");



        Intent intent = getIntent();
        intent.getStringExtra("name");
        intent.getStringExtra("date");
        intent.getIntExtra("image", 0);


        ImageView imageView = findViewById(R.id.imageViewLogo);

        imageView.setImageResource(companyModel.getCompanyLogo());



    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}