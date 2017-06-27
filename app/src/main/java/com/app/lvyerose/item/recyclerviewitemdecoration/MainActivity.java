package com.app.lvyerose.item.recyclerviewitemdecoration;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {


    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.menu_view_rlv);
        setRecyclerView();

    }

    private void setRecyclerView() {
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        recyclerView.setAdapter(new MeAdapter(this));
        recyclerView.addItemDecoration(new DividerGridItemDecoration(this));
    }
}
