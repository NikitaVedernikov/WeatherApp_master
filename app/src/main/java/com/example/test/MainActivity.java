package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    private DatabaseAdapter adapter;

    public void mapGo(View view){
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }

    public void listGo(View view){
        Intent intent = new Intent(this, ListActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int id = 0;

        Bundle arguments = getIntent().getExtras();
        if (arguments != null)
        {
            id = arguments.getInt("id");
        }

        adapter = new DatabaseAdapter(this);
        adapter.open();
        String city = adapter.getCity(id).city;
        adapter.close();

    }
}