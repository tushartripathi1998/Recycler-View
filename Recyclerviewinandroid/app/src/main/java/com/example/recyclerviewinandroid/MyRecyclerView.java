package com.example.recyclerviewinandroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyRecyclerView extends RecyclerView.Adapter<MyRecyclerView.ViewHolder> {

    private MClickListner mClickListner;
    private List<String> animals;
    private LayoutInflater mInflater;

    public MyRecyclerView(Context context, List<String> animals) {
        this.mInflater = LayoutInflater.from(context);
        this.animals = animals;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.list_content, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String animal = animals.get(position);
        holder.animal.setText(animal);
    }

    @Override
    public int getItemCount() {
        return animals.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView animal;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            animal = (TextView)itemView.findViewById(R.id.animal);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(mClickListner!=null){
                        mClickListner.onItemClick(itemView, getAdapterPosition());
                    }
                }
            });
        }
    }

    String getItem(int position){
        return animals.get(position);
    }

    void setmClickListner(MClickListner mClickListner){
        this.mClickListner = mClickListner;
    }

    public interface MClickListner{
        void onItemClick(View view, int position);
    }

}
