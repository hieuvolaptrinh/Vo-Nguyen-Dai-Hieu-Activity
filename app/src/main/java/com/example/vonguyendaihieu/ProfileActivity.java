package com.example.vonguyendaihieu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ProfileActivity extends AppCompatActivity {
    // Khai báo các View
    TextView txtName, txtUsername;
    Button btnShowInfo;
    ImageButton btnSetting;
    LinearLayout layoutDetailInfo;
    private boolean isInfoVisible = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        txtName = findViewById(R.id.txtName);
        txtUsername = findViewById(R.id.txtUsername);
        btnShowInfo = findViewById(R.id.btnShowInfo);
        btnSetting = findViewById(R.id.btnSetting);
        layoutDetailInfo = findViewById(R.id.layoutDetailInfo);


        String name = getIntent().getStringExtra("username");
        String password = getIntent().getStringExtra("password");


        if (name != null && !name.isEmpty()) {
            txtName.setText(name);
            // Tạo username từ name (chuyển thành chữ thường, bỏ khoảng trắng)
            txtUsername.setText("@" + name.toLowerCase().replace(" ", ""));
        }

        btnShowInfo.setOnClickListener(v -> {
            if (isInfoVisible) {
                // Nếu đang hiển thị -> Ẩn đi
                layoutDetailInfo.setVisibility(View.GONE);
                btnShowInfo.setText("Xem All Thông Tin");
                isInfoVisible = false;
            } else {

                layoutDetailInfo.setVisibility(View.VISIBLE);
                btnShowInfo.setText("Ẩn Thông Tin");
                isInfoVisible = true;
            }
        });


        btnSetting.setOnClickListener(v -> {
            // Tạo Intent để quay về MainActivity
            Intent intent = new Intent(ProfileActivity.this, MainActivity.class);

            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
        });
    }
}