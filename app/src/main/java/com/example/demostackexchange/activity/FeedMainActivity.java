package com.example.demostackexchange.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.demostackexchange.R;
import com.example.demostackexchange.adapter.LeftMenuRVAdapter;
import com.example.demostackexchange.adapter.MainMenuRVAdapter;
import com.example.demostackexchange.interfaces.ItemRVLeftMenuInterface;
import com.example.demostackexchange.interfaces.ItemRVMainMenuInterface;
import com.example.demostackexchange.item.ItemRVLeftMenu;
import com.example.demostackexchange.item.ItemRVMainMenu;

import java.util.ArrayList;

public class FeedMainActivity extends AppCompatActivity implements ItemRVLeftMenuInterface, ItemRVMainMenuInterface {
    private RecyclerView rvLeft;
    private RecyclerView rvMain;
    private LeftMenuRVAdapter mLeftMenuRVAdapter;
    private MainMenuRVAdapter mMainMenuRVAdapter;
    private ImageView ivHamburgerMain;
    private ImageView ivHamburgerLeft;
    private DrawerLayout dlFeed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_main);
        init();
        bindEvent();
    }

    private void init() {
        dlFeed = findViewById(R.id.actFeedMain_drawerLayout);
        rvMain = findViewById(R.id.actFeedMain_rvMain);
        rvLeft = findViewById(R.id.actFeedMain_rvLeft);
        ivHamburgerMain = findViewById(R.id.viewToolbar_ivHamburger);
        ivHamburgerMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dlFeed.openDrawer(Gravity.LEFT);
            }
        });

        mLeftMenuRVAdapter = new LeftMenuRVAdapter(genDataLeft());
        mMainMenuRVAdapter = new MainMenuRVAdapter(genDataMain());
        rvLeft.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rvMain.setLayoutManager(new LinearLayoutManager(this));
        rvMain.setHasFixedSize(true);
        rvLeft.setAdapter(mLeftMenuRVAdapter);
        rvMain.setAdapter(mMainMenuRVAdapter);
    }


    private ArrayList<ItemRVMainMenu> genDataMain() {
        ArrayList<ItemRVMainMenu> listItem = new ArrayList<>();
        for (int i = 0; i < 7; i++){

            ItemRVMainMenu item = new ItemRVMainMenu();
            item.setIvItemMainMenu(R.drawable.ic_btn_stackexchange);
            item.setTvItemMainMenu("Title "+ (i+1));
            listItem.add(item);
        }
        return listItem;
    }

    private ArrayList<ItemRVLeftMenu> genDataLeft() {
        ArrayList<ItemRVLeftMenu> listItem = new ArrayList<>();
        for (int i = 0; i < 7; i++){
            ItemRVLeftMenu item = new ItemRVLeftMenu();
            item.setIvItemToolbar(R.drawable.ic_btn_stackexchange);
            item.setTvItemToolbar("Title "+ (i+1));
            listItem.add(item);
        }
        return listItem;
    }

    private void bindEvent() {
        mLeftMenuRVAdapter.setItemToolbarInterface(this);
        mMainMenuRVAdapter.setItemRVMainMenuInterface(this);
    }


    @Override
    public void itemClicked(int position) {
        Intent intent = new Intent(this, FuntionActivity.class);
        intent.putExtra("DATA", mLeftMenuRVAdapter.getData().get(position).getTvItemToolbar());
        startActivity(intent);
    }
}