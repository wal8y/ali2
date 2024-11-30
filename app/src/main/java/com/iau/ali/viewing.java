package com.iau.ali;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.*;

import java.util.List;

public class viewing extends AppCompatActivity {
    private DBmang dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewing);

        dbManager = new DBmang(this);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ListView expensesListView = findViewById(R.id.expensesListView);
        List<Expense> expenses = dbManager.getAllExpenses();

        listAdapter adapter = new listAdapter(this, expenses);
        expensesListView.setAdapter(adapter);
    }
}
