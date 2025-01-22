package com.example.bankbalancecheckapp;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoanServices extends AppCompatActivity {

    private EditText etLoanAmount,etLoanDuration;
    private TextView tvEmiResult ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_loan_services);


        etLoanAmount = findViewById(R.id.etLoanAmount);
        etLoanDuration = findViewById(R.id.etLoanDuration);
        tvEmiResult = findViewById(R.id.tvEmiResult);


        findViewById(R.id.btnCalculateEmi).setOnClickListener(this::calculateEMI);
    }

    private void calculateEMI(View view)
    {
        double loanAmount = Double.parseDouble(etLoanAmount.getText().toString().trim());
        int duration = Integer.parseInt(etLoanDuration.getText().toString().trim());
        double intrestRate = 12; // 12%
        double emi = (loanAmount * intrestRate/duration) ; // 12 *12/12

        tvEmiResult.setText(String.format("EMI : ₹%.2f",emi));


    }
}