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

public class SignUpActivity extends AppCompatActivity {
    private LinearLayout linearGoogle;
    private LinearLayout linearFacebook;
    private LinearLayout linearStack;
    private ImageView ivBack;
    private TextView tvTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        init();
        bindEvent();
    }

    private void init() {
        linearFacebook = findViewById(R.id.actSignup_linearFacebook);
        linearGoogle = findViewById(R.id.actSignup_linearGoogle);
        linearStack = findViewById(R.id.actSignup_linearStack);
        ivBack = findViewById(R.id.viewBackToolBar_ivBack);
        tvTitle = findViewById(R.id.viewBackToolBar_tvTitle);
        Intent intent = getIntent();
        tvTitle.setText(intent.getStringExtra("Sign"));
    }

    private void bindEvent() {
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}