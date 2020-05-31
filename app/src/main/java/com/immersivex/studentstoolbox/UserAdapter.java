package com.immersivex.studentstoolbox;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class UserAdapter extends BaseAdapter {
    private Context context;
    private List<User> userList;

    @Override
    public int getCount() {
        return userList.size();
    }

    @Override
    public Object getItem(int position) {
        return userList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return userList.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(R.layout.user_list_item, parent,false);
        //User user = AppDatabase.getInstance(this).userDao().getstudentName();
        User user = userList.get(position);

        TextView itemTitle = convertView.findViewById(R.id.item_title);
        TextView itemDesciption = convertView.findViewById(R.id.item_description);
        itemTitle.setText(user.getStudentName());
        itemDesciption.setText(user.getStudentSurname());

        return convertView;
    }
}
