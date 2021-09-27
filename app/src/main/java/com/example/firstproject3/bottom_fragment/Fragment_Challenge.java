package com.example.firstproject3.bottom_fragment;

import android.app.AppComponentFactory;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.firstproject3.ClickTransActivity;
import com.example.firstproject3.R;

public class Fragment_Challenge extends Fragment {



    private View view;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_challenge, container, false);

        LinearLayout challenge1 = view.findViewById(R.id.challenge1);
        LinearLayout challenge2 = view.findViewById(R.id.challenge2);
        LinearLayout challenge3 = view.findViewById(R.id.challenge3);
        LinearLayout challenge4 = view.findViewById(R.id.challenge4);

        View.OnClickListener ocl = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(view.getContext(), ClickTransActivity.class);
                startActivity(i);
            }
        };

        challenge1.setOnClickListener(ocl);
        challenge2.setOnClickListener(ocl);
        challenge3.setOnClickListener(ocl);
        challenge4.setOnClickListener(ocl);

        return view;

    }
}
