package com.example.firstproject3;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class ClickTransActivity extends AppCompatActivity {
    ImageView imgarrow;
    TextView textChallAttend;

    public void onClickBack(View v) {
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_click_trans);

       /* ActionBar actionBar = getSupportActionBar();
        actionBar.hide();*/

        imgarrow = findViewById(R.id.imageViewarrow);
        textChallAttend = findViewById(R.id.textViewAttend);

        imgarrow.setColorFilter(Color.parseColor("#F4385E"), PorterDuff.Mode.SRC_IN);
        textChallAttend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ClickTransActivity.this, PopupActivity.class));

                textChallAttend.setText("참가중...");
            }
        });

    }
}