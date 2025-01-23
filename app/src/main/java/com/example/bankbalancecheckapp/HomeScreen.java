package com.example.bankbalancecheckapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HomeScreen extends AppCompatActivity {

    private UserData userData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home_screen);


        userData = (UserData) getIntent().getSerializableExtra("user");

        TextView welcomeText = findViewById(R.id.welcomeText);
        welcomeText.setText("Welcome. \n" + userData.getName());


        findViewById(R.id.btnAccountDetails).setOnClickListener(v -> {
            Intent intent = new Intent(this, AccountDetails.class);
            intent.putExtra("user", userData);
            startActivity(intent);
        });
        findViewById(R.id.btnTransferMoney).setOnClickListener(v -> {
            Intent intent = new Intent(this, TransferMoney.class);
            intent.putExtra("user", userData);
            startActivity(intent);
        });
        findViewById(R.id.btnTransactionHistory).setOnClickListener(v -> {
            Intent intent = new Intent(this, TransactionHistory.class);
            intent.putExtra("user", userData);
            startActivity(intent);
        });
        findViewById(R.id.btnLoanServices).setOnClickListener(v -> {
            Intent intent = new Intent(this, LoanServices.class);
            intent.putExtra("user", userData);
            startActivity(intent);
        });findViewById(R.id.btnSetting).setOnClickListener(v -> {
            Intent intent = new Intent(this, Settings.class);
            intent.putExtra("user", userData);
            startActivity(intent);
        });
    }
}