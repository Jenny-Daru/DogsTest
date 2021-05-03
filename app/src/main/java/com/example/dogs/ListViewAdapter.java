package com.example.dogs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

public class ListViewAdapter extends BaseAdapter {
//   테스트 테스트 테스트

    private ArrayList<ListViewItem> listViewItemList = new ArrayList<ListViewItem>();

        @Override
        //ListView가 Adapter에게 데이터 몇 개 가지고 있니? 물어보는 함수
        public int getCount() {
            return listViewItemList.size();
        }

        @Override
        public Object getItem(int position) {
            return listViewItemList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }


        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            final Context context = parent.getContext();

            if(convertView == null) {
                LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.listview_item,parent,false);
            }

            ListViewItem listViewItem = listViewItemList.get(position);
            ImageView imageView = (ImageView)convertView.findViewById(R.id.image);
            TextView textView = (TextView)convertView.findViewById(R.id.name);

            imageView.setBackgroundResource(listViewItem.getId());
            textView.setText(listViewItem.getName());

            LinearLayout clickView = (LinearLayout)convertView.findViewById(R.id.clickView);
            clickView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(),listViewItemList.get(position).getName(),Toast.LENGTH_SHORT).show();
                }
            });

            return convertView;
        }

        public void addItem(int id, String name) {
            ListViewItem item = new ListViewItem();

            item.setId(id);
            item.setName(name);

            listViewItemList.add(item);
        }
}
