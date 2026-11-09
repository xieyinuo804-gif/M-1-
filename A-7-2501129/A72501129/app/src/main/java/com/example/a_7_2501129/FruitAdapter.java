package com.example.a_7_2501129;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class FruitAdapter extends ArrayAdapter<Fruit> {
    Context context;
    ArrayList<Fruit> fruitList;

    public FruitAdapter(Context context, ArrayList<Fruit> list) {
        super(context,0,list);
        this.context = context;
        this.fruitList = list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Fruit fruit = getItem(position);
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.fruit,parent,false);
        }
        ImageView img = convertView.findViewById(R.id.imgFruit);
        TextView tvName = convertView.findViewById(R.id.tvFruitName);
        Button btnDel = convertView.findViewById(R.id.btnDel);

        img.setImageResource(fruit.getImgId());
        tvName.setText(fruit.getName());

        btnDel.setOnClickListener(v -> {
            fruitList.remove(position);
            notifyDataSetChanged();
        });
        return convertView;
    }
}