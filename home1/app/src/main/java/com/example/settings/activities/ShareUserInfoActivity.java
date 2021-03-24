package com.example.settings.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.settings.R;

public class ShareUserInfoActivity extends AppCompatActivity {

    String[] addresses = {"kvantor_sasha@list.ru"};
    String subject = "Sign in information";
    String emailText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in_info_activity);

        setTitle("Sign in information");

        Intent receivedOrderIntent = getIntent();
        String userName = receivedOrderIntent.getStringExtra("userName");
        String userEmail = receivedOrderIntent.getStringExtra("email");
        String userPassword = receivedOrderIntent.getStringExtra("password");
        String userConfirmedPassword = receivedOrderIntent.getStringExtra("confirmedPassword");

        emailText = "User name: " + userName + "\n" +  "Users email: " + userEmail + "\n" +
                "Users password: " + userPassword + "\n" + "Users confirmed password: " + userConfirmedPassword + "\n";

        TextView tvTextView = findViewById(R.id.tv_shared_info);
        tvTextView.setTextColor(getResources().getColor(R.color.m_blue_main)); ;
        tvTextView.setText(emailText);
        Button butSendInfo=findViewById(R.id.but_send_info);
        butSendInfo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.d("myTag", "shareInfo()");
                shareInfo(v);
            }
        });

    }

    public void shareInfo(View view) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("*/*");
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, emailText);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }


}
