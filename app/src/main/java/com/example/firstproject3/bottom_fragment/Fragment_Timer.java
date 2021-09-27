package com.example.firstproject3.bottom_fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.firstproject3.ActivityResultEvent;
import com.example.firstproject3.BusProvider;
import com.example.firstproject3.CustomChoiceListViewAdapter;
import com.example.firstproject3.ListViewAdapter;
import com.example.firstproject3.R;
import com.example.firstproject3.SaveActivity;
import com.example.firstproject3.TimerActivity;
import com.squareup.otto.Subscribe;

import java.util.Timer;
import java.util.TimerTask;

import static android.app.Activity.RESULT_OK;

public class Fragment_Timer extends Fragment {

    private View view, viewList;
    private Button btnGirok;
    private LinearLayout layoutRecordPaper;
    private RecyclerView recyclerView;
    public String text, str;
    private TextView textRecord, textTitlt;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_timer, container, false);
        viewList = inflater.inflate(R.layout.timer_listview, container, false);

        textRecord = view.findViewById(R.id.textRecord);
        btnGirok = view.findViewById(R.id.girokButton);
        layoutRecordPaper = view.findViewById(R.id.layoutRecordPaper);
        recyclerView = view.findViewById(R.id.rec_timer);
        textTitlt = viewList.findViewById(R.id.textTitle);

        btnGirok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Intent intent = new Intent(getContext(), SaveActivity.class);
                getActivity().startActivityForResult(new Intent(getContext(), SaveActivity.class), 101);
            }
        });

        layoutRecordPaper.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);

        if (getArguments() != null) {
        }

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        BusProvider.getInstance().register(this);
    }

    @Override
    public void onDestroyView() {
        BusProvider.getInstance().unregister(this);
        super.onDestroyView();

    }

    @SuppressWarnings("unused")
    @Subscribe
    public void onActivityResultEvent(@NonNull ActivityResultEvent event) {
        onActivityResult(event.getRequestCode(), event.getResultCode(), event.getData());
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 100: {
                if (data != null) {
                    String str = data.getStringExtra("str");
                    Toast.makeText(getContext(), str, Toast.LENGTH_LONG).show();
                }
            }
//            case 101: {
//                if (data != null) {
//                    text = data.getStringExtra("strName");
//
//                    ListViewAdapter adapter;
//
//                    // Adapter 생성
//                    adapter = new ListViewAdapter() ;
//
//                    // 리스트뷰 참조 및 Adapter달기
//
//                    recyclerView.setAdapter(adapter);
//
//                    // 첫 번째 아이템 추가.
//                    adapter.addTimer(ContextCompat.getDrawable(getContext(), R.drawable.chara),
//                            text, "기록하기");
//
//                    // 두 번째 아이템 추가.
//                    adapter.addTimer(ContextCompat.getDrawable(getContext(), R.drawable.chara),
//                            "타이머2", "기록하기");
//
//                    // 세 번째 아이템 추가.
//                    adapter.addTimer(ContextCompat.getDrawable(getContext(), R.drawable.chara),
//                            "타이머3", "기록하기");
//
//                    layoutRecordPaper.setVisibility(View.GONE);
//                    recyclerView.setVisibility(View.VISIBLE);
//                }
//                break;
//            }
//        }//switch
        }


    }
}
