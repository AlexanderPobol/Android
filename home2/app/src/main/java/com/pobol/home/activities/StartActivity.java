package com.pobol.home.activities;


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

import com.pobol.home.R;

import java.util.Locale;

public class StartActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String PREFS_NAME = "theme_prefs";
    public static final String KEY_THEME = "prefs.theme";
    public static final int THEME_UNDEFINED = -1;
    public static final int THEME_LIGHT = 0;
    public static final int THEME_DARK = 1;


    SharedPreferences sharedPrefs;
    Switch switchDay;
    Button butRus;
    Button butRusOff;
    Button butEn;
    Button butEnOff;
    Button butRobotCtrl;
    Button butLogin;
    Button butRegistr;
    TextView tvEn;
    TextView tvRus;
    Boolean localeTune;


    Boolean langE;
    String lang;

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sw_day_night:
                Log.d("myTag", "button day/night");
                break;
            case R.id.but_rus_off:
                Log.d("myTag", "button rus");
                changeIcon();
                setAppLocale("ru");
                lang = Locale.getDefault().getLanguage();
                langE = Locale.getDefault().getLanguage().contentEquals(lang);
                localeTune = langE ? true : false;
                Log.d("myTag", "lang=" + lang + " , langE=" + langE.toString() + ",  localeTune=" + localeTune);
                setLang();
                break;

            case R.id.but_en_off:
                Log.d("myTag", "button en");
                setAppLocale("en");
                lang = Locale.getDefault().getLanguage();
                langE = Locale.getDefault().getLanguage().contentEquals(lang);
                localeTune = langE ? true : false;
                Log.d("myTag", "lang=" + lang + " , langE=" + langE.toString() + ",  localeTune=" + localeTune);
                changeIcon();
                setLang();
                break;
            case R.id.but_robot_control:
                Log.d("myTag", "button calculator");
                startActivity(new Intent(StartActivity.this, CalculatorActivity.class));
                break;
            case R.id.but_login:
                Log.d("myTag", "button login ");
                startActivity(new Intent(StartActivity.this, LoginActivity.class));
                break;

            case R.id.but_registration:
                Log.d("myTag", "button registr click");
                startActivity(new Intent(StartActivity.this, RegistrationActivity.class));

        }
    }

    private void setLang() {
        Log.d("myTag", "button setLang");

        if (localeTune) {
            tvRus.setTextSize(12);
            tvEn.setTextSize(18);
        } else {
            tvRus.setTextSize(18);
            tvEn.setTextSize(12);
        }

    }

    private void changeIcon() {
        // localTune=true  -- english
        Log.d("myTag", "changeIcon()");
        if (localeTune) {
            Log.d("myTag", "localeTune =true ");
            butRus.setVisibility(View.INVISIBLE);
            butEn.setVisibility(View.VISIBLE);
            butRusOff.setVisibility(View.VISIBLE);
            butEnOff.setVisibility(View.INVISIBLE);
        } else {
            Log.d("myTag", "localeTune =false ");
            butRus.setVisibility(View.VISIBLE);
            butEn.setVisibility(View.INVISIBLE);
            butRusOff.setVisibility(View.INVISIBLE);
            butEnOff.setVisibility(View.VISIBLE);
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("myTag","StartActivity");
        setContentView(R.layout.start);
        //       setAppLocale("ru");

        lang = Locale.getDefault().getLanguage();
        langE = Locale.getDefault().getLanguage().contentEquals(lang);
        localeTune = langE ? true : false;
        Log.d("myTag", "lang=" + lang + " , langE=" + langE.toString() + ",  localeTune=" + localeTune);


        sharedPrefs = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        initFind();
        initTheme();
        initThemeListener();

        setListener();
    }


    private void initFind() {
        switchDay = (Switch) findViewById(R.id.sw_day_night);

        butRegistr = (Button) findViewById(R.id.but_registration);
        butLogin = (Button) findViewById(R.id.but_login);
        butRobotCtrl = (Button) findViewById(R.id.but_robot_control);

        butEn = (Button) findViewById(R.id.but_en);
        butRus = (Button) findViewById(R.id.but_rus);
        butEnOff = (Button) findViewById(R.id.but_en_off);
        butRusOff = (Button) findViewById(R.id.but_rus_off);
        tvRus = (TextView) findViewById(R.id.tv_rus);
        tvEn = (TextView) findViewById(R.id.tv_en);

    }

    private void setAppLocale(String localeCode) {
        Resources resources = getResources();
        Log.d("myTag", "setAppLocale(String " + localeCode + " )");
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


    private void setListener() {

        butRusOff.setOnClickListener(this);
        butEnOff.setOnClickListener(this);
        switchDay.setOnClickListener(this);
        butRobotCtrl.setOnClickListener(this);
        butLogin.setOnClickListener(this);
        butRegistr.setOnClickListener(this);


    }


}

