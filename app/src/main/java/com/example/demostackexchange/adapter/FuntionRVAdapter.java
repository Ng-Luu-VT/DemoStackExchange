package com.example.demostackexchange.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demostackexchange.R;
import com.example.demostackexchange.interfaces.ItemRVFuntionInterface;
import com.example.demostackexchange.item.ItemRVFuntionMenu;

import java.util.ArrayList;

public class FuntionRVAdapter extends RecyclerView.Adapter<FuntionRVAdapter.NewViewHolder>  {

    private ArrayList<ItemRVFuntionMenu> mData;
    private ItemRVFuntionInterface mItemRVFuntionInterface;
    public FuntionRVAdapter(ArrayList<ItemRVFuntionMenu> mData) {
        this.mData = mData;
    }


    @NonNull
    @Override
    public NewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recyclerview_funtion,parent,false);
        return new NewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewViewHolder holder, int position) {
        ItemRVFuntionMenu item = mData.get(position);
        holder.binData(item);
    }

    @Override
    public int getItemCount() {
        return mData != null ? mData.size() : 0;
    }

    public class NewViewHolder extends RecyclerView.ViewHolder {
        TextView tvUp;
        TextView tvQuestion;
        TextView tvTitle;
        TextView tvType;
        TextView tvTime;


        public NewViewHolder(@NonNull View itemView) {
            super(itemView);
            tvUp = itemView.findViewById(R.id.itemRVFution_tvUp);
            tvQuestion = itemView.findViewById(R.id.itemRVFution_tvQuestion);
            tvTitle = itemView.findViewById(R.id.itemRVFution_tvTitle);
            tvType = itemView.findViewById(R.id.itemRVFution_tvType);
            tvTime = itemView.findViewById(R.id.itemRVFution_tvTime);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mItemRVFuntionInterface != null) mItemRVFuntionInterface.itemClicked(getAdapterPosition());
                }
            });
        }

        public void binData(ItemRVFuntionMenu item) {
            tvUp.setText(item.getTvUp());
            tvQuestion.setText(item.getTvQuestion());
            tvTitle.setText(item.getTvTitle());
            tvType.setText(item.getTvType());
            tvTime.setText(item.getTvTime());
        }
    }

    public void setItemRVFuntionInterface(ItemRVFuntionInterface mItemRVFuntionInterface) {
        this.mItemRVFuntionInterface = mItemRVFuntionInterface;
    }
    public ArrayList<ItemRVFuntionMenu> getData() {
        return mData;
    }
}
