package com.example.profilukm;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class ListUkmActivity extends AppCompatActivity{
    private DatabaseHelper databaseHelper;
    private CustomCursorAdapter customCursorAdapter;
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listukm);
        listView = findViewById(R.id.lv_ukm); // Replace with your actual ListView ID
        databaseHelper = new DatabaseHelper(this);

        displayData();
    }
    private void displayData() {
        Cursor cursor = databaseHelper.getAllData();
        customCursorAdapter = new CustomCursorAdapter(this, cursor);
        listView.setAdapter(customCursorAdapter);
    }
}