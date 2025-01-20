package com.example.bankbalancecheckapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home_screen);

        findViewById(R.id.btnAccountDetails).setOnClickListener(v-> startActivity(new Intent(this, AccountDetails.class)));
        findViewById(R.id.btnTransferMoney).setOnClickListener(v-> startActivity(new Intent(this, TransferMoney.class)));
        findViewById(R.id.btnTransactionHistory).setOnClickListener(v-> startActivity(new Intent(this, TransactionHistory.class)));
        findViewById(R.id.btnLoanServices).setOnClickListener(v-> startActivity(new Intent(this, LoanServices.class)));
        findViewById(R.id.btnSetting).setOnClickListener(v-> startActivity(new Intent(this, Settings.class)));

    }
}