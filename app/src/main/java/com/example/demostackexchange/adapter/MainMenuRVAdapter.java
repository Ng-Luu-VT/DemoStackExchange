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
import com.example.demostackexchange.interfaces.ItemRVMainMenuInterface;
import com.example.demostackexchange.item.ItemRVLeftMenu;
import com.example.demostackexchange.item.ItemRVMainMenu;

import java.util.ArrayList;

public class MainMenuRVAdapter extends RecyclerView.Adapter<MainMenuRVAdapter.NewViewHolder> {
    private ArrayList<ItemRVMainMenu> mData;
    private ItemRVMainMenuInterface mItemRVMainMenuInterface;

    public MainMenuRVAdapter(ArrayList<ItemRVMainMenu> mData) {
        this.mData = mData;
    }

    @NonNull
    @Override
    public NewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recyclerview_mainmenu,parent,false);
        return new NewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewViewHolder holder, int position) {
        ItemRVMainMenu item = mData.get(position);
        holder.binData(item);
    }

    @Override
    public int getItemCount() {
        return mData != null ? mData.size() : 0;
    }

    public class NewViewHolder extends RecyclerView.ViewHolder {
        //LinearLayout linearItem;
        ImageView ivItem;
        TextView tvItem;
        public NewViewHolder(@NonNull View itemView) {
            super(itemView);
            //linearItem = itemView.findViewById(R.id.itemMainMenu_linearItem);
            ivItem = itemView.findViewById(R.id.itemMainMenu_ivItem);
            tvItem = itemView.findViewById(R.id.itemMainMenu_tvItem);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mItemRVMainMenuInterface != null) mItemRVMainMenuInterface.itemClicked(getAdapterPosition());
                }
            });
        }
        void binData(ItemRVMainMenu itemRVMainMenu) {
            ivItem.setImageResource(itemRVMainMenu.getIvItemMainMenu());
            tvItem.setText(itemRVMainMenu.getTvItemMainMenu());
        }
    }
    public void setItemRVMainMenuInterface(ItemRVMainMenuInterface mItemRVMainMenuInterface) {
        this.mItemRVMainMenuInterface = mItemRVMainMenuInterface;
    }
    public ArrayList<ItemRVMainMenu> getData() {
        return mData;
    }
}
