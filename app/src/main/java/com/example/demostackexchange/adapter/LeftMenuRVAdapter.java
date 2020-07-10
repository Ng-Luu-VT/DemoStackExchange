package com.example.demostackexchange.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demostackexchange.R;
import com.example.demostackexchange.interfaces.ItemRVLeftMenuInterface;
import com.example.demostackexchange.item.ItemRVLeftMenu;

import java.util.ArrayList;

public class LeftMenuRVAdapter extends RecyclerView.Adapter<LeftMenuRVAdapter.NewViewHolder> {

    private ArrayList<ItemRVLeftMenu> mData;
    private ItemRVLeftMenuInterface mItemRVLeftMenuInterface;

    public LeftMenuRVAdapter(ArrayList<ItemRVLeftMenu> mData) {
        this.mData = mData;
    }

    @NonNull
    @Override
    public NewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recyclerview_leftmenu,parent,false);
        return new NewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LeftMenuRVAdapter.NewViewHolder holder, int position) {
        ItemRVLeftMenu item = mData.get(position);
        holder.binData(item);
    }

    @Override
    public int getItemCount() {
        return mData != null ? mData.size() : 0;
    }

    public class NewViewHolder extends RecyclerView.ViewHolder {
        LinearLayout linearItem;
        ImageView ivItem;
        TextView tvItem;

        public NewViewHolder(@NonNull View itemView) {
            super(itemView);
            linearItem = itemView.findViewById(R.id.itemToolbar_linearItem);
            ivItem = itemView.findViewById(R.id.itemToolbar_ivItem);
            tvItem = itemView.findViewById(R.id.itemToolbar_tvItem);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mItemRVLeftMenuInterface != null) mItemRVLeftMenuInterface.itemClicked(getAdapterPosition());
                }
            });
        }
        void binData(ItemRVLeftMenu itemRVLeftMenu) {
            ivItem.setImageResource(itemRVLeftMenu.getIvItemToolbar());
            tvItem.setText(itemRVLeftMenu.getTvItemToolbar());
        }
    }

    public void setItemToolbarInterface(ItemRVLeftMenuInterface mItemRVLeftMenuInterface) {
        this.mItemRVLeftMenuInterface = mItemRVLeftMenuInterface;
    }

    public ArrayList<ItemRVLeftMenu> getData() {
        return mData;
    }
}
