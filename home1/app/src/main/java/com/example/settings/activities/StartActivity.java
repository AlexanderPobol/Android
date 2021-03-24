package com.example.settings.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import com.example.settings.R;

import java.util.Locale;


public class StartActivity extends AppCompatActivity {

    public static final String PREFS_NAME = "theme_prefs";
    public static final String KEY_THEME = "prefs.theme";
    public static final int THEME_UNDEFINED = -1;
    public static final int THEME_LIGHT = 0;
    public static final int THEME_DARK = 1;


    SharedPreferences sharedPrefs;
    Button butLogin;
    Button butRegistr;
    Button butRobotCtrl;
    Button butRus;
    Button butEn;
    Switch switchDay;
    TextView tvEnter;
    Boolean localeTune;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.start);

        localeTune=true;
       // setAppLocale("ru");



        sharedPrefs = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        switchDay = (Switch) findViewById(R.id.sw_day_night);

        butRegistr = (Button) findViewById(R.id.but_registration);
        butLogin = (Button) findViewById(R.id.but_login);
        butRobotCtrl = (Button) findViewById(R.id.but_robot_control);

        butEn= (Button) findViewById(R.id.but_en);
        butRus= (Button) findViewById(R.id.but_rus);

        butLogin.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.d("myTag", "button login click");
                        startActivity(new Intent(StartActivity.this, LoginActivity.class));
                    }
                });

        butRegistr.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.d("myTag", "button registr click");
                        startActivity(new Intent(StartActivity.this, RegistrationActivity.class));
                    }
                });

        butRobotCtrl.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.d("myTag", "button robotctrl click");
                        startActivity(new Intent(StartActivity.this, RemoteCtrlActivity.class));
                    }
                });



        initTheme();
        initThemeListener();

        butRus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("myTag","butRus.setOnClickListener   ");
                       if ( localeTune ){
                      //     butRus.setBackground(R.drawable.ic_back_on);
                           Log.d("myTag","butRus.setOnClickListener localeTune =true ");
                     setAppLocale("en");

                  localeTune=false;
                        }else {
                    Log.d("myTag","butRus.setOnClickListener localeTune =false ");
                     setAppLocale("ru");

                    localeTune=true;
                   }
            }
        });



    }

    private void setAppLocale(String localeCode) {
        Resources resources = getResources();
        Log.d("myTag","setAppLocale(String "+localeCode+" )");
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        Configuration configuration = resources.getConfiguration();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            configuration.setLocale(new Locale(localeCode.toLowerCase()));
        } else {
            configuration.locale = new Locale(localeCode.toLowerCase());
        }
        resources.updateConfiguration(configuration, displayMetrics);
    }


    private void initThemeListener() {
        Log.d("myTag", "initThemeListener()");
        switchDay.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Log.d("myTag", "isChecked true. Dark mode turned on");
                    setTheme(AppCompatDelegate.MODE_NIGHT_YES, THEME_DARK);
                } else {
                    Log.d("myTag", "isChecked false. Light mode turned on");
                    setTheme(AppCompatDelegate.MODE_NIGHT_NO, THEME_LIGHT);
                }


            }
        });
    }

    private void setTheme(int themeMode, int prefsMode) {
        AppCompatDelegate.setDefaultNightMode(themeMode);
        saveTheme(prefsMode);
    }

    private void saveTheme(int theme) {
        sharedPrefs.edit().putInt(KEY_THEME, theme).apply();
    }

    private int getSavedTheme() {
        return sharedPrefs.getInt(KEY_THEME, THEME_UNDEFINED);
    }

    private void initTheme() {
        Log.d("myTag", " initTheme()");
        switch (getSavedTheme()) {
            case THEME_LIGHT:
                Log.d("myTag", "sharedPrefs THEME_LIGHT");
                switchDay.setChecked(false);
                break;
            case THEME_DARK:
                Log.d("myTag", "sharedPrefs THEME_DARK");
                switchDay.setChecked(true);
                break;
            case THEME_UNDEFINED:
                Log.d("myTag", "THEME_UNDEFINED getResources().getConfiguration().uiMode=" + getResources().getConfiguration().uiMode);
                switch (getResources().getConfiguration().uiMode & (Configuration.UI_MODE_NIGHT_MASK)) {
                    case Configuration.UI_MODE_NIGHT_NO:
                        Log.d("myTag", " Configuration.UI_MODE_NIGHT_NO: THEME_UNDEFINED");
                        switchDay.setChecked(false);
                        break;
                    case Configuration.UI_MODE_NIGHT_YES:
                        Log.d("myTag", " UI_MODE_NIGHT_YES: THEME_UNDEFINED");
                        switchDay.setChecked(true);
                        break;
                    case Configuration.UI_MODE_NIGHT_UNDEFINED:
                        Log.d("myTag", " UI_MODE_NIGHT_UNDEFINED: THEME_UNDEFINED");
                        switchDay.setChecked(false);
                }
        }

    }
}

