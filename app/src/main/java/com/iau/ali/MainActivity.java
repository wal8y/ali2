package com.iau.ali;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private Chart chartView;
    private ListView expensesListView;
    private DBmang dbManager;
    private listAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chartView = findViewById(R.id.chartView);
        expensesListView = findViewById(R.id.expensesListView);
        Button addExpenseButton = findViewById(R.id.addExpenseButton);

        dbManager = new DBmang(this);
        loadExpenses();

        addExpenseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, inserting.class);
                startActivity(intent);
            }
        });
    }

    private void loadExpenses() {
        List<Expense> expenses = dbManager.getAllExpenses();
        chartView.setData(expenses);
        adapter = new listAdapter(this, expenses);
        expensesListView.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadExpenses();
    }
}