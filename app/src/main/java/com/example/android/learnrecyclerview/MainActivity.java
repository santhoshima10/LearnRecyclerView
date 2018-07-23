package com.example.android.learnrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    RecyclerView mRecyclerView;
    ExampleAdapter mAdapter;
    RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ArrayList<ExampleItem> exampleItems = new ArrayList();
        exampleItems.add(new ExampleItem(R.drawable.ic_android, "Line 1", "Line 2"));
        exampleItems.add(new ExampleItem(R.drawable.ic_beach, "Line 1", "Line 2"));
        exampleItems.add(new ExampleItem(R.drawable.ic_time_to_leave, "Line 1", "Line 2"));

        mRecyclerView = findViewById(R.id.recycler_view_id);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ExampleAdapter(exampleItems);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new ExampleAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(int position) {
                ExampleItem exampleItem = exampleItems.get(position);
                exampleItem.setmText1("Clicked");
                mAdapter.notifyItemChanged(position);
            }

            @Override
            public void OnDeleteItemClick(int position) {

                exampleItems.remove(position);
                mAdapter.notifyItemRemoved(position);

            }
        });

    }
}
