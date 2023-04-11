package com.example.cardviewandrecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CompanyAdapter extends RecyclerView.Adapter<CompanyAdapter.CompanyViewHolder> {
    private final ArrayList<CompanyModel> companyList;
    private final LayoutInflater mInflater;
    private CompanyItemClickListener companyItemClickListener;

    @NonNull
    @Override
    public CompanyAdapter.CompanyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.card_layout, parent,false);
        return new CompanyViewHolder(itemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull CompanyAdapter.CompanyViewHolder holder, int position) {
        CompanyModel currentCompany = companyList.get(position);
        holder.companyName.setText(currentCompany.getCompanyName());
        holder.companyDate.setText(currentCompany.getCompanyYear());
        holder.companyLogo.setImageResource(currentCompany.getCompanyLogo());

        holder.companyName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                companyItemClickListener.onItemClicked(currentCompany);
            }
        });

    }

    @Override
    public int getItemCount() {
        return companyList.size();
    }


    class CompanyViewHolder extends  RecyclerView.ViewHolder{

        public final TextView companyName;

        public final TextView companyDate;

        public final ImageView companyLogo;

        public final ConstraintLayout rootLayout;

        public final CompanyAdapter mAdapter;

        public CompanyViewHolder(@NonNull View itemView , CompanyAdapter companyAdapter) {
            super(itemView);
            companyName = itemView.findViewById(R.id.textViewCompanyName);
            companyDate = itemView.findViewById(R.id.textViewCompanyDate);
            companyLogo = itemView.findViewById(R.id.imageViewLogo);
            rootLayout = itemView.findViewById(R.id.rootLayout);
            this.mAdapter = companyAdapter;

        }
    }

    public CompanyAdapter(Context context, ArrayList<CompanyModel> companyList,CompanyItemClickListener companyItemClickListener){
        mInflater = LayoutInflater.from(context);
        this.companyList = companyList;
        this.companyItemClickListener = companyItemClickListener;
    }
    public interface CompanyItemClickListener{
        void onItemClicked(CompanyModel companyModel);
    }
}


