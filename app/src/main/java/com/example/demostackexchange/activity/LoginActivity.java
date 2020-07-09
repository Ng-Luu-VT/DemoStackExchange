package com.example.demostackexchange.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.demostackexchange.R;

public class LoginActivity extends AppCompatActivity {
    private LinearLayout lỉnarGoogle;
    private LinearLayout lỉnarFacebook;
    private LinearLayout lỉnarStack;
    private LinearLayout lỉnarOpenID;
    private TextView tvTitle;
    private ImageView ivBack;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
        bindEvent();
    }

    private void bindEvent() {
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void init() {
        lỉnarGoogle = findViewById(R.id.actLogin_linearGoogle);
        lỉnarFacebook = findViewById(R.id.actLogin_linearFacebook);
        lỉnarStack = findViewById(R.id.actLogin_linearStack);
        lỉnarOpenID = findViewById(R.id.actLogin_linearOpenID);
        tvTitle = findViewById(R.id.viewBackToolBar_tvTitle);
        ivBack = findViewById(R.id.viewBackToolBar_ivBack);
        Intent intent = getIntent();
        tvTitle.setText(intent.getStringExtra("Login"));
    }
}