package com.example.bankbalancecheckapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Signup extends AppCompatActivity {

    private EditText etName , etAccountNumber , etPhoneNumber, etPassword, etConfirmPassword ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_signup);

        etName = findViewById(R.id.etUserName);
        etAccountNumber = findViewById(R.id.etAccountNumber);
        etPhoneNumber = findViewById(R.id.etPhoneNumber);
        etPassword = findViewById(R.id.etPassword);
        etConfirmPassword = findViewById(R.id.etConfirmPassword);

        findViewById(R.id.btnSignUp).setOnClickListener(v->signUpUser());


        findViewById(R.id.etAlreadyHaveAccount).setOnClickListener(v->{
            startActivity(new Intent(this, LoginUser.class));
            finish();
        });
    }


    private  void signUpUser(){
        String name = etName.getText().toString().trim();
        String accountNumber = etAccountNumber.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        String confirmPassword = etConfirmPassword.getText().toString().trim();
        String phoneNumber = etPhoneNumber.getText().toString().trim();


        if(TextUtils.isEmpty(name) || TextUtils.isEmpty(accountNumber)||TextUtils.isEmpty(password)||TextUtils.isEmpty(confirmPassword)||TextUtils.isEmpty(phoneNumber)){
            Toast.makeText(this,"Please fill all details",Toast.LENGTH_SHORT).show();
            return ;
        }

        getSharedPreferences("BankAppPrefs",MODE_PRIVATE).edit().putString("name",name).putString("accountNumber",accountNumber).putString("phoneNumber",phoneNumber).putString("password",password).putBoolean("isLoggedIn",false).apply();
        Toast.makeText(this,"SignUp Successfully",Toast.LENGTH_SHORT).show();

        startActivity(new Intent(Signup.this, LoginUser.class));
        finish();


    }








}