package com.busanit.ex_viewpager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class OfficeAdapter extends RecyclerView.Adapter<OfficeAdapter.ViewHolder>{
    ArrayList<Office> items = new ArrayList<Office>();

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.office_item, parent, false);
        return new OfficeAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Office item = items.get(position);
        holder.textView1.setText(item.getRank());
        holder.textView2.setText(item.getName());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setItems(ArrayList<Office> items){
        this.items = items;
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView textView1, textView2;

        public ViewHolder(View itemView) {// listener는 8에서 추가
            super(itemView);
            textView1 = itemView.findViewById(R.id.textView1);
            textView2 = itemView.findViewById(R.id.textView2);
        }
    }
}
