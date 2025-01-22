package com.example.bankbalancecheckapp;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class TransactionHistory extends AppCompatActivity {

    private ListView transactionListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_transaction_history);

        transactionListView = findViewById(R.id.transactionHistory);

        ArrayList<String> transaction = new ArrayList<>();

        transaction.add("₹500 sent to Account 12345 1234");
        transaction.add("₹1500 received from Account 12345 1234");
        transaction.add("₹500 sent to Account 12345 1234");
        transaction.add("₹1500 received from Account 12345 1234");
        transaction.add("₹500 sent to Account 12345 1234");
        transaction.add("₹1500 received from Account 12345 1234");
        transaction.add("₹500 sent to Account 12345 1234");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,transaction);
        transactionListView.setAdapter(adapter);



    }
}