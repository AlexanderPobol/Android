package com.pobol.home.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.pobol.home.R;

public class RegistrationActivity extends AppCompatActivity {
Button butBack ;

TextView tvOnLoginActivity;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        butBack= (Button)findViewById(R.id.but_back);

        butBack.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.d("myTag", "button click");
                        startActivity(new Intent(RegistrationActivity.this, StartActivity.class));
                    }
                });
        butBack = (Button) findViewById(R.id.but_back);

        tvOnLoginActivity= (TextView) findViewById(R.id.tv_registr);
        tvOnLoginActivity.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.d("myTag", "button click");
                        startActivity(new Intent(RegistrationActivity.this, LoginActivity.class));
                    }
                });


    }
}
