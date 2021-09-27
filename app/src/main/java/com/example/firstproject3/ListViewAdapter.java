package com.example.firstproject3;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListViewAdapter extends BaseAdapter {
    private ArrayList<Todo_Item> listTimer = new ArrayList<Todo_Item>() ;

    public ListViewAdapter() {

    }

    @Override
    public int getCount() {
        return listTimer.size() ;
    }

    @Override
    public Object getItem(int position) {
        return listTimer.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        // "listview_item" Layout을 inflate하여 convertView 참조 획득.
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.timer_listview, parent, false);
        }

        // 화면에 표시될 View(Layout이 inflate된)으로부터 위젯에 대한 참조 획득
        ImageView imgGraph = (ImageView) convertView.findViewById(R.id.imageGraph) ;
        TextView textTitle = (TextView) convertView.findViewById(R.id.textTitle) ;
        TextView textRecord = (TextView) convertView.findViewById(R.id.textRecord) ;

        // Data Set(listViewItemList)에서 position에 위치한 데이터 참조 획득
        Todo_Item listViewItem = listTimer.get(position);

        // 아이템 내 각 위젯에 데이터 반영
        imgGraph.setImageDrawable(listViewItem.getImg());
        textRecord.setText(listViewItem.getRecord());
        textTitle.setText(listViewItem.getTitle());
        
        textRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),TimerActivity.class);
                ((Activity) context).startActivityForResult(intent, 100);
            }
        });

        return convertView;
    }

    public void addTimer(Drawable img, String title, String record) {
        Todo_Item item = new Todo_Item();

        item.setImg(img);
        item.setTitle(title);
        item.setRecord(record);

        listTimer.add(item);
    }
}
