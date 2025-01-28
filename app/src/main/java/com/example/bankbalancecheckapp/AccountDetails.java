package com.example.bankbalancecheckapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AccountDetails extends AppCompatActivity {

    private  UserData userData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_account_details);

        userData = (UserData) getIntent().getSerializableExtra("user");

        TextView  nameText = findViewById(R.id.nameText);
        TextView  accountNumberText = findViewById(R.id.accountNumber);
        TextView  balanceText = findViewById(R.id.balanceText);


        nameText.setText(String.format("Name : %s", userData.getName()));
        accountNumberText.setText(String.format("Account Number : %s", userData.getAccountNumber()));
        balanceText.setText(String.format("Account Balance : %s", userData.getBalance()));
    }
    public void logoutUser(View view){

        SharedPreferences pref = getSharedPreferences("BankAppPrefs", MODE_PRIVATE);

        pref.edit().putBoolean("isLoggedIn",false).apply();

        Toast.makeText(this,"User logout successfully", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this , LoginUser.class);

        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }
}