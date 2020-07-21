package com.example.demostackexchange.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.demostackexchange.R;
import com.example.demostackexchange.adapter.FuntionRVAdapter;
import com.example.demostackexchange.adapter.MainMenuRVAdapter;
import com.example.demostackexchange.interfaces.ItemRVFuntionInterface;
import com.example.demostackexchange.item.ItemRVFuntionMenu;
import com.example.demostackexchange.item.ItemRVMainMenu;

import java.util.ArrayList;

public class FuntionActivity extends AppCompatActivity implements ItemRVFuntionInterface {
    private DrawerLayout dlFeed;
    private ImageView ivHamburgerMain;
    private String mTitle;
    private TextView tvToolBarTitle;
    private RecyclerView rvFuntion;
    private FuntionRVAdapter mFuntionRVAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_funtion);
        init();
        binEvent();
    }



    private void init() {
        tvToolBarTitle = findViewById(R.id.viewToolBarQuestion_tvTitle);
        Intent intent = getIntent();
        mTitle = intent.getStringExtra("DATA");
        tvToolBarTitle.setText(mTitle);

        rvFuntion = findViewById(R.id.actFuntion_rvItem);
        mFuntionRVAdapter = new FuntionRVAdapter(genData());
        rvFuntion.setLayoutManager(new LinearLayoutManager(this));
        rvFuntion.setHasFixedSize(true);
        rvFuntion.setAdapter(mFuntionRVAdapter);
    }

    private ArrayList<ItemRVFuntionMenu> genData() {
        ArrayList<ItemRVFuntionMenu> listItem = new ArrayList<>();
        for (int i = 0; i < 7; i++){

            ItemRVFuntionMenu item = new ItemRVFuntionMenu();
            item.setTvUp(""+(i+1));
            item.setTvQuestion(""+(i+1));
            item.setTvTitle("aaaaaaaaaaaaa");
            item.setTvType("bbbbbbbb");
            item.setTvTime("ccccccc");
            listItem.add(item);
        }

        return listItem;
    }


    private void binEvent() {
        mFuntionRVAdapter.setItemRVFuntionInterface(this);
    }

    @Override
    public void itemClicked(int position) {
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
    }
}