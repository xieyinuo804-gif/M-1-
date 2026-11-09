package com.example.a_7_2501129;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<String> items = new ArrayList<>();
        items.add("CustomListView");
        items.add("RecyclerView");
        items.add("ExpandableListView");
        items.add("Spinner");
        items.add("CustomSpinner");
        items.add("GridView");
        items.add("CustomGrid");
        items.add("Gallery");
        items.add("ListActivity");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                items);

        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                handleItemClick(position);
            }
        });
    }

    private void handleItemClick(int position) {
        Intent intent = null;
        switch (position) {
            case 0:
                intent = new Intent(this, CustomListView.class);
                break;
            case 1:
                intent = new Intent(this, MyRecyclerView.class);
                break;
            case 2:
                intent = new Intent(this, MyExpandableListView.class);
                break;
            case 3:
                intent = new Intent(this, SpinnerList.class);
                break;
            case 4:
                intent = new Intent(this, SpinnerList1.class);
                break;
            case 5:
                intent = new Intent(this, MyGridView.class);
                break;
            case 6:
                intent = new Intent(this, CustomGrid.class);
                break;
            case 7:
                intent = new Intent(this, Gallery.class);
                break;
            case 8:
                intent = new Intent(this, MyListActivity.class);
                break;
        }
        if (intent != null) {
            startActivity(intent);
        }
    }
}