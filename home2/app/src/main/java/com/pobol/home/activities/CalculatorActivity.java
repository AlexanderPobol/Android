package com.pobol.home.activities;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;

import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.pobol.home.R;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

import java.util.Locale;

import static java.lang.Math.sqrt;

public class CalculatorActivity extends AppCompatActivity implements View.OnClickListener {

    EditText number1;
    EditText number2;
    EditText number1or2;
    EditText result;
    TextView error_message;
    TextView chosen_sign;
    String aText;
    Double a = 0.0;
    Double b = 0.0;
    Double resultAB = 0.0;
    String mathSign = "";
    Boolean editFocus = true;
    private InputMethodManager im;
    String abStr;
    Button but_gr1;
    Button but_gr2;
    Button but_gr3;
    Button but_gr4;
    Button but_gr5;
    Button but_gr6;
    Button but_gr7;
    Button but_gr8;
    Button but_gr9;
    Button but_gr10;
    Button but_gr11;
    Button but_gr12;
    Button but_gr13;
    Button but_gr14;
    Button but_gr15;
    Button but_gr16;
    Button but_gr17;
    Button but_gr18;
    Button but_gr19;
    Button but_gr20;
    Button reset;
    Button back;
    DecimalFormat resultFormat;
    ImageView handShake;
    Boolean langE;
    String lang;

    @Override
    public void onClick(View v) {



        error_message.setText("");
        handShake.setVisibility(View.INVISIBLE);
        String aStr = number1.getText().toString();
        String bStr = number2.getText().toString();
        a = aStr.isEmpty() ? 0.0 : Double.valueOf(number1.getText().toString());
        b = bStr.isEmpty() ? 0.0 : Double.valueOf(number2.getText().toString());
        Double ab;
        Log.d("myTag", "editFocus=" + editFocus);
        if (editFocus) {
            number1or2 = number1;
            abStr = aStr;
            ab = a;
        } else {
            number1or2 = number2;
            abStr = bStr;
            ab = b;
        }


        switch (v.getId()) {
            case R.id.but_back:
                Log.d("myTag", "button click");
                startActivity(new Intent(CalculatorActivity.this, StartActivity.class));
            case R.id.but_gr1:
                number1or2.setText(number1or2.getText() + "1");
                Log.d("myTag", " but_gr1=1");
                break;
            case R.id.but_gr2:
                number1or2.setText(number1or2.getText() + "2");
                Log.d("myTag", " but_gr2=2");
                break;
            case R.id.but_gr3:
                number1or2.setText(number1or2.getText() + "3");
                Log.d("myTag", " but_gr3=3");
                break;
            case R.id.but_gr4:
                Log.d("myTag", " but_gr4=sqrt");
                handShake.setVisibility(View.VISIBLE);
                mathSign = "sqrt";
                resultAB = sqrt(a);
                result.setText(resultFormat.format(resultAB));
                break;
            case R.id.but_gr5:
                number1or2.setText(number1or2.getText() + "4");
                Log.d("myTag", " but_gr5=4");
                break;
            case R.id.but_gr6:
                number1or2.setText(number1or2.getText() + "5");
                Log.d("myTag", " but_gr6=5");
                break;
            case R.id.but_gr7:
                number1or2.setText(number1or2.getText() + "6");
                Log.d("myTag", " but_gr7=6");
                break;
            case R.id.but_gr8:
                Log.d("myTag", " but_gr8=x2");
                mathSign = "X^2";
                resultAB = a * a;
                handShake.setVisibility(View.VISIBLE);
                result.setText(resultFormat.format(resultAB));
                break;
            case R.id.but_gr9:
                number1or2.setText(number1or2.getText() + "7");
                Log.d("myTag", " but_gr9=7");
                break;
            case R.id.but_gr10:
                number1or2.setText(number1or2.getText() + "8");
                Log.d("myTag", " but_gr10=8");
                break;
            case R.id.but_gr11:

                number1or2.setText(number1or2.getText() + "9");
                Log.d("myTag", " but_gr11=9");
                break;

            case R.id.but_gr12:
                Log.d("myTag", " but_gr12=settings");
                break;
            case R.id.but_gr13:
                Log.d("myTag", " but_gr13= +/-");
                ab = ab * (-1);
                number1or2.setText(ab.toString());
                break;
            case R.id.but_gr14:
                Log.d("myTag", " but_gr14=0");
                number1or2.setText(number1or2.getText() + "0");
                break;
            case R.id.but_gr15:
                aText = delChar(abStr);
                Log.d("myTag", " but_gr15= del=" + aText);

                number1or2.setText(aText);
                break;
            case R.id.but_gr16:
                Log.d("myTag", " but_gr16=");

                if (number1or2.getText().toString().indexOf(".") < 0) {
                    number1or2.setText(number1or2.getText() + ".");
                }
                break;
            case R.id.but_gr17:
                Log.d("myTag", " but_gr17=  a=" + a + ", b=" + b);
                mathSign = "/";

                if (b == 0.0) {
                    error_message.setTextColor(Color.parseColor("#FF3333"));
                    error_message.setText(R.string.error_div_null);
                    break;
                } else {
                    handShake.setVisibility(View.VISIBLE);
                    resultAB = a / b;
                    result.setText(resultFormat.format(resultAB));
                }
                break;

            case R.id.but_gr18:
                Log.d("myTag", " but_gr18=");
                handShake.setVisibility(View.VISIBLE);
                mathSign = "+";
                resultAB = a + b;
                result.setText(resultFormat.format(resultAB));
                break;
            case R.id.but_gr19:
                Log.d("myTag", " but_gr19=");
                handShake.setVisibility(View.VISIBLE);
                mathSign = "-";
                resultAB = a - b;
                result.setText(resultFormat.format(resultAB));
                break;
            case R.id.but_gr20:
                mathSign = "X";
                resultAB = a * b;
                result.setText(resultFormat.format(resultAB));
                handShake.setVisibility(View.VISIBLE);
                Log.d("myTag", " but_gr20=");
                break;
            case R.id.reset:
                mathSign = "C";
                number1.setText("");
                number2.setText("");
                result.setText("");

                Log.d("myTag", " but_gr20=");
                break;
        }

        chosen_sign.setText(mathSign);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        lang = Locale.getDefault().getLanguage();
        Log.d("myTag", "Calc lang=" + lang );
        super.onCreate(savedInstanceState);
        Log.d("myTag", "CalculatorActivity");
        setContentView(R.layout.calculator_activity);

        lang = Locale.getDefault().getLanguage();
        langE = Locale.getDefault().getLanguage().contentEquals(lang);
        Boolean localeTune = langE ? true : false;
        Log.d("myTag", "lang=" + lang + " , langE=" + langE.toString() + ",  localeTune=" + localeTune);

        resultFormat = new DecimalFormat("0", DecimalFormatSymbols.getInstance(Locale.ENGLISH));
        resultFormat.setMaximumFractionDigits(340);

        findInit();

        number1.setShowSoftInputOnFocus(false);
        number1.setFocusable(true);
        number1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    Log.d("myTag", "onFocusChange number1");
                    editFocus = true;
                }
            }
        });

        number2.setShowSoftInputOnFocus(false);
        number2.setFocusable(true);
        number2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    Log.d("myTag", "onFocusChange number2 ");
                    editFocus = false;
                }
            }
        });

        setListener();

    }

    private void findInit() {
        number1 = (EditText) findViewById(R.id.input_number1);
        number2 = (EditText) findViewById(R.id.input_number2);
        result = (EditText) findViewById(R.id.input_number3);
        error_message = (TextView) findViewById(R.id.error_message);
        chosen_sign = (TextView) findViewById(R.id.chosen_sign);
        handShake = (ImageView) findViewById(R.id.img_handShake);

        but_gr1 = (Button) findViewById(R.id.but_gr1);
        but_gr2 = (Button) findViewById(R.id.but_gr2);
        but_gr3 = (Button) findViewById(R.id.but_gr3);
        but_gr4 = (Button) findViewById(R.id.but_gr4);
        but_gr5 = (Button) findViewById(R.id.but_gr5);
        but_gr6 = (Button) findViewById(R.id.but_gr6);
        but_gr7 = (Button) findViewById(R.id.but_gr7);
        but_gr8 = (Button) findViewById(R.id.but_gr8);
        but_gr9 = (Button) findViewById(R.id.but_gr9);
        but_gr10 = (Button) findViewById(R.id.but_gr10);
        but_gr11 = (Button) findViewById(R.id.but_gr11);
        but_gr12 = (Button) findViewById(R.id.but_gr12);
        but_gr13 = (Button) findViewById(R.id.but_gr13);
        but_gr14 = (Button) findViewById(R.id.but_gr14);
        but_gr15 = (Button) findViewById(R.id.but_gr15);
        but_gr16 = (Button) findViewById(R.id.but_gr16);
        but_gr17 = (Button) findViewById(R.id.but_gr17);
        but_gr18 = (Button) findViewById(R.id.but_gr18);
        but_gr19 = (Button) findViewById(R.id.but_gr19);
        but_gr20 = (Button) findViewById(R.id.but_gr20);
        reset = (Button) findViewById(R.id.reset);
        back= (Button) findViewById(R.id.but_back);

    }

    public String delChar(String str) {
        if (str != null && str.length() > 0) {
            str = str.substring(0, str.length() - 1);
        }
        return str;
    }

    private void setListener() {

        but_gr1.setOnClickListener(this);
        but_gr2.setOnClickListener(this);
        but_gr3.setOnClickListener(this);
        but_gr4.setOnClickListener(this);
        but_gr5.setOnClickListener(this);
        but_gr6.setOnClickListener(this);
        but_gr7.setOnClickListener(this);
        but_gr8.setOnClickListener(this);
        but_gr9.setOnClickListener(this);
        but_gr10.setOnClickListener(this);
        but_gr11.setOnClickListener(this);
        but_gr12.setOnClickListener(this);
        but_gr13.setOnClickListener(this);
        but_gr14.setOnClickListener(this);
        but_gr15.setOnClickListener(this);
        but_gr16.setOnClickListener(this);
        but_gr17.setOnClickListener(this);
        but_gr18.setOnClickListener(this);
        but_gr19.setOnClickListener(this);
        but_gr20.setOnClickListener(this);
        back.setOnClickListener(this);
        reset.setOnClickListener(this);
    }

}
