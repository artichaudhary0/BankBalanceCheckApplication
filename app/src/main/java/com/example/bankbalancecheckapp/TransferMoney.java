package com.example.bankbalancecheckapp;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

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

    private  void sendMoney(View view){}

}