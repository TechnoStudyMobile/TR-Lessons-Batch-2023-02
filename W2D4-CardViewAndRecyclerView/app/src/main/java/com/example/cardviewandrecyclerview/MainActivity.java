package com.example.cardviewandrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements CompanyAdapter.CompanyItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView companyRecyclerView = findViewById(R.id.recyclerViewCompany);

        ArrayList<CompanyModel>  companyModelArrayList = new ArrayList<CompanyModel>();

        companyModelArrayList.add(new CompanyModel("Apple","1976",R.drawable.ic_apple));
        companyModelArrayList.add(new CompanyModel("Google","1998",R.drawable.ic_google));
        companyModelArrayList.add(new CompanyModel("Amazon","1994",R.drawable.ic_amazon));
        companyModelArrayList.add(new CompanyModel("Microsoft","1975",R.drawable.ic_microsoft));
        companyModelArrayList.add(new CompanyModel("Apple","1976",R.drawable.ic_apple));
        companyModelArrayList.add(new CompanyModel("Google","1998",R.drawable.ic_google));
        companyModelArrayList.add(new CompanyModel("Amazon","1994",R.drawable.ic_amazon));
        companyModelArrayList.add(new CompanyModel("Microsoft","1975",R.drawable.ic_microsoft));
        companyModelArrayList.add(new CompanyModel("Apple","1976",R.drawable.ic_apple));
        companyModelArrayList.add(new CompanyModel("Google","1998",R.drawable.ic_google));
        companyModelArrayList.add(new CompanyModel("Amazon","1994",R.drawable.ic_amazon));
        companyModelArrayList.add(new CompanyModel("Microsoft","1975",R.drawable.ic_microsoft));
        companyModelArrayList.add(new CompanyModel("Apple","1976",R.drawable.ic_apple));
        companyModelArrayList.add(new CompanyModel("Google","1998",R.drawable.ic_google));
        companyModelArrayList.add(new CompanyModel("Amazon","1994",R.drawable.ic_amazon));
        companyModelArrayList.add(new CompanyModel("Microsoft","1975",R.drawable.ic_microsoft));

        CompanyAdapter companyAdapter = new CompanyAdapter(this,companyModelArrayList,this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        companyRecyclerView.setLayoutManager(linearLayoutManager);
        companyRecyclerView.setAdapter(companyAdapter);
    }
    @Override
    public void onItemClicked(CompanyModel companyModel) {

        Intent intent = new Intent(MainActivity.this ,SecondActivity.class);
        intent.putExtra("name",companyModel.getCompanyName());
        intent.putExtra("date", companyModel.getCompanyYear());
        intent.putExtra("image", companyModel.getCompanyLogo());
        intent.putExtra("company", companyModel);
        startActivity(intent);
    }
}