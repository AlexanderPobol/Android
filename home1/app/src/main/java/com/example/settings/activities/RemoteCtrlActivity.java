package com.example.settings.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.settings.R;

public class RemoteCtrlActivity extends AppCompatActivity {

    Button butBack;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.remote_control_activity);

        butBack = (Button) findViewById(R.id.but_back_reg);
        butBack.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.d("myTag", "button click");
                        startActivity(new Intent(RemoteCtrlActivity.this, StartActivity.class));
                    }
                });

    }
}
