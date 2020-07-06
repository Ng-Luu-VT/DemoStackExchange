package com.example.demostackexchange.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.demostackexchange.R;

public class SignUpActivity extends AppCompatActivity {
    private Button btnGoogle;
    private Button btnFacebook;
    private Button btnStack;
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
        btnFacebook = findViewById(R.id.actSignup_btnFacebook);
        btnGoogle = findViewById(R.id.actSignup_btnGoogle);
        btnStack = findViewById(R.id.actSignup_btnStackexchange);
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