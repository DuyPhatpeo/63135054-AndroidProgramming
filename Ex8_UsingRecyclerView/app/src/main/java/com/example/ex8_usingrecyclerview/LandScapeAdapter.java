package com.example.ex8_usingrecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LandScapeAdapter extends RecyclerView.Adapter<LandScapeAdapter.ItemLandHolder> {

    Context context;
    ArrayList<LandScape> lstData;

    public LandScapeAdapter(Context context, ArrayList<LandScape> lstData) {
        this.context = context;
        this.lstData = lstData;
    }

    @NonNull
    @Override
    public ItemLandHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater cai_bom = LayoutInflater.from(context);
        View vItem = cai_bom.inflate(R.layout.item_land,parent,false);
        ItemLandHolder viewHolderCreated =  new ItemLandHolder(vItem);
        return viewHolderCreated;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemLandHolder holder, int position) {
        //Lấy đối tượng hiển thị
        LandScape landScapeShow =  lstData.get(position);
        // Trích thông tin
        String caption = landScapeShow.getLandscapeCaption();
        String tenFileAnh = landScapeShow.getLandscapeImg();
        //Đặt vào các trường thông tin của holder
        holder.tvCaption.setText(caption);
        //Đặt ảnh
        String packageName = holder.itemView.getContext().getPackageName();
        int imgId = holder.itemView.getResources().getIdentifier(tenFileAnh,"mipmap",packageName);
        holder.ivLandScape.setImageResource(imgId);
    }

    @Override
    public int getItemCount() {
        return lstData.size();
    }

    class ItemLandHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView tvCaption;
        ImageView ivLandScape;

        public ItemLandHolder(@NonNull View itemView) {
            super(itemView);
            tvCaption = itemView.findViewById(R.id.textViewCaption);
            ivLandScape = itemView.findViewById(R.id.img_land);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int viTriOnClick = getAdapterPosition();
            LandScape ptDuocClick = lstData.get(viTriOnClick);
            //Bóc thông tin
            String ten = ptDuocClick.getLandscapeCaption();
            String tenFile = ptDuocClick.getLandscapeImg();
            //Toast ten
            String chuoiThongBao="Bạn vừa click vào " + ten;
            Toast.makeText(v.getContext(),chuoiThongBao,Toast.LENGTH_SHORT).show();
        }
    }
}
