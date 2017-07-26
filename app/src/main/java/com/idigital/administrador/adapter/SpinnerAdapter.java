package com.idigital.administrador.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.idigital.administrador.R;
import com.idigital.administrador.entities.Category;
import com.idigital.administrador.entities.Place;
import com.idigital.administrador.entities.User;

import java.util.List;

/**
 * Created by USUARIO on 26/07/2017.
 */

public class SpinnerAdapter extends ArrayAdapter {

    Context context;
    List<User> userList;
    List<Place> placeList;
    List<Category> categoryList;
    List<String> stringList;
    int type;

    public SpinnerAdapter(Context context, int textViewResourceId, List<? extends Object> data, int type) {
        super(context, textViewResourceId, data);
        this.context = context;
        this.type = type;
        if (type == 1)
            userList = (List<User>) data;
        else if (type == 2)
            placeList = (List<Place>) data;
        else if (type == 3)
            stringList = (List<String>) data;
        else if (type == 4)
            categoryList = (List<Category>) data;
        else
            throw new RuntimeException("invalid value type");
    }

    public View getCustomView(int position, View convertView,
                              ViewGroup parent) {

        View layout = LayoutInflater.from(context).inflate(R.layout.spinner_item, parent, false);

        TextView itemTxt = (TextView) layout.findViewById(R.id.item_text);

        if (type == 1) {
            itemTxt.setText(userList.get(position).getNombre());
        } else if (type == 2)
            itemTxt.setText(placeList.get(position).getName());
        else if (type == 3)
            itemTxt.setText(stringList.get(position));
        else if (type == 4)
            itemTxt.setText(categoryList.get(position).getCategory());
        else
            throw new RuntimeException("invalid value type");
        return layout;
    }

    // It gets a View that displays in the drop down popup the data at the specified position
    @Override
    public View getDropDownView(int position, View convertView,
                                ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    // It gets a View that displays the data at the specified position
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }
}
