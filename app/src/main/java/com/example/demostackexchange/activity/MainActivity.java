package com.example.demostackexchange.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.demostackexchange.R;

public class MainActivity extends AppCompatActivity {
    private Button btnLogin;
    private Button btnSignup;
    private TextView tvStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        bindEvent();
    }

    private void bindEvent() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                intent.putExtra("Login", btnLogin.getText());
                startActivity(intent);
            }
        });
    }

    private void init() {
        btnLogin = findViewById(R.id.actMain_btnLogin);
        btnSignup = findViewById(R.id.actMain_btnSingup);
        tvStart = findViewById(R.id.actMain_tvStart);

    }
}