package com.example.task;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;


import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Vector;

class Array_adapter extends ArrayAdapter {
    Vector<MyItems> myitem;
    Context _context;
    public Array_adapter(Context context, int resource, int textViewResourceId, List Items) {
        super(context, resource, textViewResourceId, Items);
        _context=context;
        myitem= (Vector<MyItems>) Items;

    }
    public View getView(final int position, View convertView, final ViewGroup ListView) {
        View row=convertView;
        final Holder holder;
        if (row==null)
        {
            LayoutInflater inflater= (LayoutInflater) _context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row=inflater.inflate(R.layout.customeview, ListView,false);
            holder=new Holder(row);
            row.setTag(holder);
        }
        else
        {
            holder= (Holder) row.getTag();
        }
        holder.get_brand().setText(myitem.get(position).getCarType());
        holder.getCarType().setText(myitem.get(position).getBrand());
        holder.get_counstruction_Year().setText(myitem.get(position).getConYear());
        ImageView imageView=holder.get_carImage();
        String link= myitem.get(position).getIcon_image();
        Picasso.get().load(link).fit().into(imageView);
        return row;
    }
}

