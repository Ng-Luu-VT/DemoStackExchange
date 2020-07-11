package com.example.demostackexchange.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

public class FeedMainActivity extends AppCompatActivity {
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
        ivHamburgerLeft = findViewById(R.id.viewToolbarLeft_ivHamburger);
        ivHamburgerMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dlFeed.openDrawer(Gravity.LEFT);
            }
        });
        ivHamburgerLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dlFeed.closeDrawer(v);
            }
        });
        mLeftMenuRVAdapter = new LeftMenuRVAdapter(genDataLeft());
        mMainMenuRVAdapter = new MainMenuRVAdapter(genDataMain());
        rvLeft.setLayoutManager(new LinearLayoutManager(this));
        rvMain.setLayoutManager(new LinearLayoutManager(this));
        rvLeft.setAdapter(mLeftMenuRVAdapter);
        rvMain.setAdapter(mMainMenuRVAdapter);
    }

    private ArrayList<ItemRVMainMenu> genDataMain() {
        ArrayList<ItemRVMainMenu> listItem = new ArrayList<>();
        ItemRVMainMenu item = new ItemRVMainMenu();
        for (int i = 0; i <=10; i++){
            item.setIvItemMainMenu(R.drawable.ic_btn_stackexchange);
            item.setTvItemMainMenu("Title "+ (i+1));
            listItem.add(item);
        }
        return listItem;
    }

    private ArrayList<ItemRVLeftMenu> genDataLeft() {
        ArrayList<ItemRVLeftMenu> listItem = new ArrayList<>();
        ItemRVLeftMenu item = new ItemRVLeftMenu();
        for (int i = 0; i <=10; i++){
            item.setIvItemToolbar(R.drawable.ic_btn_stackexchange);
            item.setTvItemToolbar("Title "+ (i+1));
            listItem.add(item);
        }
        return listItem;
    }

    private void bindEvent() {
        mLeftMenuRVAdapter.setmItemToolbarInterface((ItemRVLeftMenuInterface) this);
        mMainMenuRVAdapter.setItemRVMainMenuInterface((ItemRVMainMenuInterface) this);
    }

}