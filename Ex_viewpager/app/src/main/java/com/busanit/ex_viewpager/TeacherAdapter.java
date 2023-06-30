package com.busanit.ex_viewpager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TeacherAdapter extends RecyclerView.Adapter<TeacherAdapter.ViewHolder>{
    ArrayList<Teacher> items = new ArrayList<Teacher>();

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.teacher_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Teacher item = items.get(position);
        holder.txtDivision.setText(item.getDivision());
        holder.txtName.setText(item.getName());
        holder.txtSubject.setText(item.getSubject());
        holder.txtClass.setText(item.getClassroom());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setItems(ArrayList<Teacher> items){
        this.items = items;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtDivision, txtName, txtSubject, txtClass;

        public ViewHolder(View itemView) {// listener는 8에서 추가
            super(itemView);
            txtDivision = itemView.findViewById(R.id.txtDivision);
            txtName = itemView.findViewById(R.id.txtName);
            txtSubject = itemView.findViewById(R.id.txtSubject);
            txtClass = itemView.findViewById(R.id.txtClass);
        }
    }
}
