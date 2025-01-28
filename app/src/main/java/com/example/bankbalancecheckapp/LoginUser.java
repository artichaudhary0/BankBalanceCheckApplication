package com.example.bankbalancecheckapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginUser extends AppCompatActivity {

    private EditText etAccountNumber , etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login_user);


        etAccountNumber = findViewById(R.id.etAccountNumber);
        etPassword = findViewById(R.id.etPassword);

        findViewById(R.id.btnLogin).setOnClickListener(v->loginUser());

        findViewById(R.id.etDontHaveAccount).setOnClickListener(v->{
            startActivity(new Intent(this, Signup.class));
            finish();
        });
    }

    private void loginUser(){
        String enteredAccountNumber = etAccountNumber.getText().toString().trim();
        String enteredPassword = etPassword.getText().toString().trim();

        SharedPreferences prefs = getSharedPreferences("BankAppPrefs",MODE_PRIVATE);
        String storedAccountNumber = prefs.getString("accountNumber",null);
        String storedPassword = prefs.getString("password",null);

        if(TextUtils.isEmpty(enteredAccountNumber) || TextUtils.isEmpty(enteredPassword)){
            Toast.makeText(this,"Please fill all details",Toast.LENGTH_SHORT).show();
            return ;
        }



        if(enteredAccountNumber.equals(storedAccountNumber) && enteredPassword.equals(storedPassword))
        {
            prefs.edit().putBoolean("isLoggedIn",true).apply();

            String name = prefs.getString("name", "user");
            UserData userData = new UserData(name,storedAccountNumber,10000.0 );


            // redired to home home screen
            Intent intent = new Intent(this, HomeScreen.class);
            intent.putExtra("user",userData);
            startActivity(intent);
            finish();
        }else{
            Toast.makeText(this,"does not match",Toast.LENGTH_SHORT).show();
        }
    }
}