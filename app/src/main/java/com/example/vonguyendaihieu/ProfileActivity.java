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
    TextView txtName_2217, txtUsername_2217;
    Button btnShowInfo_2217;
    ImageButton btnSetting_2217;
    LinearLayout layoutDetailInfo_2217;
    private boolean isInfoVisible_2217 = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main_2217), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        txtName_2217 = findViewById(R.id.txtName_2217);
        txtUsername_2217 = findViewById(R.id.txtUsername_2217);
        btnShowInfo_2217 = findViewById(R.id.btnShowInfo_2217);
        btnSetting_2217 = findViewById(R.id.btnSetting_2217);
        layoutDetailInfo_2217 = findViewById(R.id.layoutDetailInfo_2217);


        String name = getIntent().getStringExtra("username");
        String password = getIntent().getStringExtra("password");


        if (name != null && !name.isEmpty()) {
            txtName_2217.setText(name);
            // Tạo username từ name (chuyển thành chữ thường, bỏ khoảng trắng)
            txtUsername_2217.setText("@" + name.toLowerCase().replace(" ", ""));
        }

        btnShowInfo_2217.setOnClickListener(v -> {
            if (isInfoVisible_2217) {
                // Nếu đang hiển thị -> Ẩn đi
                layoutDetailInfo_2217.setVisibility(View.GONE);
                btnShowInfo_2217.setText("Xem All Thông Tin");
                isInfoVisible_2217 = false;
            } else {

                layoutDetailInfo_2217.setVisibility(View.VISIBLE);
                btnShowInfo_2217.setText("Ẩn Thông Tin");
                isInfoVisible_2217 = true;
            }
        });


        btnSetting_2217.setOnClickListener(v -> {
            // Tạo Intent để quay về MainActivity
            Intent intent = new Intent(ProfileActivity.this, MainActivity.class);

            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
        });
    }
}