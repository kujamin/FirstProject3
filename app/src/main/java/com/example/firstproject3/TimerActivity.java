package com.example.firstproject3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.firstproject3.bottom_fragment.Fragment_Timer;

import org.jetbrains.annotations.Nullable;

import java.util.Timer;
import java.util.TimerTask;

public class TimerActivity extends AppCompatActivity {

    TextView timerText;
    Button stopStartButton;
    Timer timer;
    TimerTask timerTask;
    Double time = 0.0;
    boolean timerStarted = false;
    TextView timerPause;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        timerText = (TextView) findViewById(R.id.timerText);
        stopStartButton = (Button) findViewById(R.id.startStopButton);
        timerPause = findViewById(R.id.timerPause);

        stopStartButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                ConstraintLayout backGround = (ConstraintLayout) findViewById(R.id.backGround);

                if (timerStarted == false) {
                    timerStarted = true;
                    setButtonUI("일시정지", R.color.colorwhite);
                    backGround.setBackgroundResource(R.color.colorblack);
                    timerText.setTextColor(getResources().getColor(R.color.colorwhite));
                    ImageView imgTimer = findViewById(R.id.imageView);
                    startTimer();
                    timerPause.setVisibility(View.VISIBLE);
                    timerPause.setTextColor(getResources().getColor(R.color.colorwhite));
                    timerPause.setText("기록하기");
                } else {
                    timerStarted = false;
                    setButtonUI("계속", R.color.colorPrimary);
                    timerText.setTextColor(getResources().getColor(R.color.colorPrimary));
                    backGround.setBackgroundResource(R.color.colorwhite);
                    timerTask.cancel();
                    timerPause.setText("초기화");
                    timerPause.setTextColor(getResources().getColor(R.color.colorPrimary));
                }
            }
        });

        timerPause.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(timerStarted == false) resetTimer();
                else {
                    String str = timerText.getText().toString();

                    Intent intent = new Intent();

                    intent.putExtra("str", str);
                    setResult(RESULT_OK,intent);
                    finish();
                }
            }
        });

        timer = new Timer();

    }

    private void setButtonUI(String start, int color) {
        stopStartButton.setText(start);
        stopStartButton.setTextColor(ContextCompat.getColor(getApplicationContext(), color));
    }



    private void startTimer()
    {

        timerTask = new TimerTask()
        {
            @Override
            public void run()
            {
                Handler handler = new Handler(Looper.getMainLooper());
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        time++;
                        timerText.setText(getTimerText());
                    }
                });

            }


        };
        timer.scheduleAtFixedRate(timerTask, 0, 1000);
    }

    private void resetTimer() {
        timerTask = new TimerTask()
        {
            @Override
            public void run()
            {
                Handler handler = new Handler(Looper.getMainLooper());
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        timerTask.cancel();
                        time = 0.0;
                        timerText.setText(getTimerText());
                    }
                });

            }


        };
        timer.scheduleAtFixedRate(timerTask, 0, 1000);
    }

    private String getTimerText() {

        int rounded = (int) Math.round(time);

        int seconds = ((rounded % 86400) % 3600) % 60;
        int minutes = ((rounded % 86400) % 3600) / 60;
        int hours = ((rounded % 86400) / 3600);

        return formatTime(seconds, minutes, hours);
    }

    private String formatTime(int seconds, int minutes, int hours) {
        return String.format("%02d", hours) + " : " + String.format("%02d", minutes) + " : " + String.format("%02d", seconds);
    }

}
