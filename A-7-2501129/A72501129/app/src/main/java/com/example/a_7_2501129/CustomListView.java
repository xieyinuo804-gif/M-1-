package com.example.a_7_2501129;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import java.util.ArrayList;

public class CustomListView extends AppCompatActivity {
    EditText etFruitName;
    ListView listView;
    ArrayList<Fruit> fruitList;
    FruitAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list_view);

        etFruitName = findViewById(R.id.et_fruit);
        listView = findViewById(R.id.listview);
        fruitList = new ArrayList<>();

        fruitList.add(new Fruit("Apple", R.drawable.apple));
        fruitList.add(new Fruit("Pear", R.drawable.pear));
        fruitList.add(new Fruit("Banana", R.drawable.banana));
        fruitList.add(new Fruit("Strawberry", R.drawable.strawberry));
        fruitList.add(new Fruit("Pineapple", R.drawable.pineapple));
        fruitList.add(new Fruit("Cherry", R.drawable.cherry));

        adapter = new FruitAdapter(this, fruitList);
        listView.setAdapter(adapter);
    }

    public void addFruit(View view){
        String name = etFruitName.getText().toString();
        if(!name.isEmpty()){
            fruitList.add(new Fruit(name, R.mipmap.ic_launcher));
            adapter.notifyDataSetChanged();
            etFruitName.setText("");
        }
    }
}