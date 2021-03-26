package com.pobol.home.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.pobol.home.R;
import com.pobol.home.UserInfo;

public class LoginActivity extends AppCompatActivity {


    Button butBack;
    Button butLogin;
    Button butShareInfo;
    EditText etName;
    EditText etEmail;
    EditText etPassword;
    EditText etConfirmPassword;
    ImageView imgLock1;
    ImageView imgPerson;
    TextView tvNewAccount;
    TextView tvDontHaveAccount;
    TextView tvEnter;
    TextView onRegistrActivity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        tvNewAccount = (TextView) findViewById(R.id.tv_create_accaunt);
        tvNewAccount.setText(R.string.signinContinue);
        tvDontHaveAccount = (TextView) findViewById(R.id.tv_have_account);
        tvDontHaveAccount.setText(R.string.dont_have_account);
        tvEnter = (TextView) findViewById(R.id.tv_registr);
        tvEnter.setText(R.string.register1);

        etConfirmPassword = (EditText) findViewById(R.id.ed_password1);
        etConfirmPassword.setVisibility(View.INVISIBLE);

        etName = (EditText) findViewById(R.id.ed_name);
        etName.setVisibility(View.INVISIBLE);

        etEmail = (EditText) findViewById(R.id.ed_email);
        etPassword = (EditText) findViewById(R.id.ed_password);

        imgLock1 = (ImageView) findViewById(R.id.img_lock1);
        imgLock1.setVisibility(View.GONE);

        imgPerson=(ImageView) findViewById(R.id.img_person);
        imgPerson.setVisibility(View.GONE);

        butLogin = (Button) findViewById(R.id.but_registration1);
        butLogin.setText(R.string.but_login);

        butBack = (Button) findViewById(R.id.but_back);
        butBack.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.d("myTag", "button click");
                        startActivity(new Intent(LoginActivity.this, StartActivity.class));
                    }
                });
        onRegistrActivity = (TextView) findViewById(R.id.tv_registr);
        onRegistrActivity.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.d("myTag", "button click");
                        startActivity(new Intent(LoginActivity.this, RegistrationActivity.class));
                    }
                });

        butShareInfo = (Button) findViewById(R.id.but_registration1);
        butShareInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addUserInfo(v);
            }
        });

    }

    private void addUserInfo(View view) {
        UserInfo userInfo = new UserInfo();
        userInfo.userName = etName.getText().toString();
        userInfo.userEmail = etEmail.getText().toString();
        userInfo.password = etPassword.getText().toString();
        userInfo.confirmedPassword = etConfirmPassword.getText().toString();
        userInfo.getAll();

        Intent userInfoIntent=new Intent(LoginActivity.this,ShareUserInfoActivity.class);
        userInfoIntent.putExtra("userName",userInfo.userName);
        userInfoIntent.putExtra("email",userInfo.userEmail);
        userInfoIntent.putExtra("password",userInfo.password);
        userInfoIntent.putExtra("confirmPassword",userInfo.confirmedPassword);
        startActivity(userInfoIntent);
    }
}


