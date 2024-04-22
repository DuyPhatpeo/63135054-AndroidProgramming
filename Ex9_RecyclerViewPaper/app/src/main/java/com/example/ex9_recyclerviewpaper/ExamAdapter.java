package com.example.ex9_recyclerviewpaper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ExamAdapter extends RecyclerView.Adapter<ExamAdapter.ItemExamHolder> {
    Context context;
    ArrayList<ExamData> listData;

    public ExamAdapter(Context context, ArrayList<ExamData> listData) {
        this.context = context;
        this.listData = listData;
    }

    @NonNull
    @Override
    public ItemExamHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater cai_bom = LayoutInflater.from(context);
        View vItem = cai_bom.inflate(R.layout.item_card,parent,false);
        ItemExamHolder viewHolderCreated =  new ItemExamHolder(vItem);
        return viewHolderCreated;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemExamHolder holder, int position) {
        ExamData data =listData.get(position);
        String name =data.getName();
        String date =data.getDate();
        String message =data.getMessage();
        holder.examName.setText(name);
        holder.examDate.setText(date);
        holder.examMessage.setText(message);
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }
    public class ItemExamHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView examName;
        TextView examMessage;
        TextView examDate;
        View view;

        public ItemExamHolder(@NonNull View itemView)
        {
            super(itemView);
            examName = (TextView)itemView.findViewById(R.id.examName);
            examDate = (TextView)itemView.findViewById(R.id.examDate);
            examMessage = (TextView)itemView.findViewById(R.id.examMessage);
            view  = itemView;
            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View v) {
            int viTriOnClick = getAdapterPosition();
            ExamData ptDuocClick = listData.get(viTriOnClick);
            //Bóc thông tin
            String ten = ptDuocClick.getName();
            String date = ptDuocClick.getDate();
            String message = ptDuocClick.getMessage();
            //Toast ten
            String chuoiThongBao="Bạn vừa click vào " + ten;
            Toast.makeText(v.getContext(),chuoiThongBao,Toast.LENGTH_SHORT).show();
        }
    }
}