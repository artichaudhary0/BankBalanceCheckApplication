package com.example.bankbalancecheckapp;

import android.app.AlertDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TransferMoney extends AppCompatActivity {

    private EditText etRecipient , etAmount ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_transfer_money);

        etRecipient = findViewById(R.id.etRecipient);
        etAmount = findViewById(R.id.etAmount);

        findViewById(R.id.btnSendMoney).setOnClickListener(this::sendMoney);
    }

    private  void sendMoney(View view){


        String recipient = etRecipient.getText().toString().trim();
        String amount = etAmount.getText().toString().trim();

        if(TextUtils.isEmpty(recipient)){
            etRecipient.setError("Recipient account number is Empty");
            return ;
        }

        if(TextUtils.isEmpty(amount)){
            etAmount.setError("Amount is Empty");
            return ;
        }


        new AlertDialog.Builder(this).setTitle("Confirm transaction").setMessage("Transfer ₹"+ amount + " to Account no. "+recipient+" ?").setPositiveButton("Yes",(dialog, which) -> {
            Toast.makeText(this,"Transaction Successfully proceed",Toast.LENGTH_SHORT).show();
            etRecipient.setText("");
            etAmount.setText("");
        }).setNegativeButton("No",null).show();
    }

}