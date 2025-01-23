package com.example.bankbalancecheckapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash_screen);

        UserData userData = new UserData("Arti Chuadhary","67234523674",345345.54);


        new Handler().postDelayed(()->{
            Intent intent = new Intent(this, HomeScreen.class);
            intent.putExtra("user",userData);
            startActivity(intent);
            finish();
        },3000);

    }
}