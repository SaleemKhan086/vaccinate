package com.example.vaccinate;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class parentHomepageAdapter extends RecyclerView.Adapter<parentHomepageAdapter.parentHomepageViewHolder> {

    private String [] data;
    parentHomepageAdapter(String [] data)
    {
        this.data = data;
    }
    @NonNull
    @Override
    public parentHomepageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.simple_row,parent,false);
        return new parentHomepageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull parentHomepageViewHolder holder, int position) {

        String title = data[position];
        holder.rowTextView.setText(title);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class parentHomepageViewHolder extends RecyclerView.ViewHolder{
        TextView rowTextView ;
        public parentHomepageViewHolder(@NonNull View itemView) {
            super(itemView);
            rowTextView= itemView.findViewById(R.id.rowTextView);
        }
    }

}
