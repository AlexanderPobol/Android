package com.pobol.home.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.pobol.home.R;
import com.pobol.home.VictorCategory;
import java.util.Locale;

public class VictorinaActivity extends AppCompatActivity implements View.OnClickListener {

    private Button butGr1;
    private Button butGr2;
    private Button butGr3;
    private Button butGr4;
    private Button butGr5;
    private Button butGr6;
    private Button butGr7;
    private Button butGr8;
    private Button butGr9;
    private Button butGr10;
    private Button butGr11;
    private Button butGr12;
    private Button butGr13;
    private Button butGr14;
    private Button butGr15;
    private Button butGr16;
    private Button butMoveLeft;
    private Button butMoveRight;
    private Button butMoveDown;
    private Button butMoveUp;
    private Button butYes;
    private Button butNo;
    private Button butBack;
    private TextView chosenCategory;
    private SeekBar sbTotal;
    private Switch swPult1;
    private Switch swResult;
    private VictorCategory victorCategory;
    private int a;
    private Boolean yourAnswer = true;


    @Override
    public void onClick(View v) {
        Log.d("myTag", "onClick");
        a = victorCategory.getCategory().ordinal();
        switch (v.getId()) {

            case R.id.but_back:
                Log.d("myTag", "back");
                startActivity(new Intent(VictorinaActivity.this, StartActivity.class));
            case R.id.but_gr1:
                Log.d("myTag", " but_gr1=1");
                victorCategory.setCategory(VictorCategory.Categories.FRUIT);
                break;
            case R.id.but_gr2:
                Log.d("myTag", " but_gr2=2");
                victorCategory.setCategory(VictorCategory.Categories.FASHION);
                break;
            case R.id.but_gr3:
                Log.d("myTag", " but_gr3=3");
                victorCategory.setCategory(VictorCategory.Categories.FOOTBALL);
                break;
            case R.id.but_gr4:
                Log.d("myTag", " but_gr4=4");
                victorCategory.setCategory(VictorCategory.Categories.GEOGRAPHY);
                break;
            case R.id.but_gr5:
                Log.d("myTag", " but_gr5=5");
                victorCategory.setCategory(VictorCategory.Categories.ANIMAL);
                break;
            case R.id.but_gr6:
                Log.d("myTag", " but_gr6=6");
                victorCategory.setCategory(VictorCategory.Categories.MATH);
                break;
            case R.id.but_gr7:
                Log.d("myTag", " but_gr7=7");
                victorCategory.setCategory(VictorCategory.Categories.SPORT);
                break;
            case R.id.but_gr8:
                Log.d("myTag", " but_gr8=8");
                victorCategory.setCategory(VictorCategory.Categories.ANATOMY);
                break;
            case R.id.but_gr9:
                Log.d("myTag", " but_gr9=9");
                victorCategory.setCategory(VictorCategory.Categories.MONEY);
                break;
            case R.id.but_gr10:
                Log.d("myTag", " but_gr10=10");
                victorCategory.setCategory(VictorCategory.Categories.AUTO);
                break;
            case R.id.but_gr11:
                Log.d("myTag", " but_gr11=11");
                victorCategory.setCategory(VictorCategory.Categories.CITY);
                break;
            case R.id.but_gr12:
                Log.d("myTag", " but_gr12=12");
                victorCategory.setCategory(VictorCategory.Categories.SWEETS);
                break;
            case R.id.but_gr13:
                Log.d("myTag", " but_gr13=13");
                victorCategory.setCategory(VictorCategory.Categories.HISTORY);
                break;
            case R.id.but_gr14:
                Log.d("myTag", " but_gr14=14");
                victorCategory.setCategory(VictorCategory.Categories.ASTRONOMY);
                break;
            case R.id.but_gr15:
                Log.d("myTag", " but_gr15= 15");
                victorCategory.setCategory(VictorCategory.Categories.PHYSICS);
                break;
            case R.id.but_gr16:
                Log.d("myTag", " but_gr16=16");
                victorCategory.setCategory(VictorCategory.Categories.TECHNOLOGY);
                break;
            case R.id.but_move_right:
                Log.d("myTag", " but_gr18=left" + "  a=" + a);
                victorCategory.setCategory(VictorCategory.Categories.values()[a < 15 ? a + 1 : 1]);
                break;
            case R.id.but_move_left:
                Log.d("myTag", " but_gr18=left" + "  a=" + a);
                victorCategory.setCategory(VictorCategory.Categories.values()[a > 0 ? a - 1 : 15]);
                break;
            case R.id.but_move_up:
                Log.d("myTag", " but_gr19=up");
                victorCategory.setCategory(VictorCategory.Categories.values()[a < 4 ? a + 12 : a - 4]);
                break;
            case R.id.but_move_down:
                Log.d("myTag", " but_gr20=down");
                victorCategory.setCategory(VictorCategory.Categories.values()[a > 12 ? a - 12 : a + 4]);
                break;
            case R.id.but_yes:
                Log.d("myTag", " but_gr21=yes");
                Intent victCategory = new Intent(VictorinaActivity.this, VictorinaActivity2.class);
                victCategory.putExtra("category", victorCategory.getCategory().toString());
                startActivity(victCategory);
                break;
            case R.id.but_no:
                Log.d("myTag", " but_gr22=no");
                yourAnswer = false;
                break;
            case R.id.sb_total:
                Log.d("myTag", " but_gr23=quest № ");
                break;
            case R.id.sw_pult1:
                Log.d("myTag", " but_gr23=pult1");
                break;
            case R.id.sw_result:
                Log.d("myTag", " but_gr24=result");
                break;
        }
        chosenCategory.setText("выбрана категория " + victorCategory.getCategory().toString());
        Log.d("myTag", " onClick category= " + victorCategory.toString());


    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("myTag", "VictorinaActivity");
        setContentView(R.layout.victorina_activity);
        String lang = Locale.getDefault().getLanguage();
        Log.d("myTag", "lang=" + lang);
        findInit();
        setListener();
        victorCategory = new VictorCategory(VictorCategory.Categories.FRUIT);
        Log.d("myTag", "victorCategory onCrerate= " + victorCategory.getCategory());
    }

    private void findInit() {
        chosenCategory = (TextView) findViewById(R.id.chosen_category);
        butBack = (Button) findViewById(R.id.but_back);
        butGr1 = (Button) findViewById(R.id.but_gr1);
        butGr2 = (Button) findViewById(R.id.but_gr2);
        butGr3 = (Button) findViewById(R.id.but_gr3);
        butGr4 = (Button) findViewById(R.id.but_gr4);
        butGr5 = (Button) findViewById(R.id.but_gr5);
        butGr6 = (Button) findViewById(R.id.but_gr6);
        butGr7 = (Button) findViewById(R.id.but_gr7);
        butGr8 = (Button) findViewById(R.id.but_gr8);
        butGr9 = (Button) findViewById(R.id.but_gr9);
        butGr10 = (Button) findViewById(R.id.but_gr10);
        butGr11 = (Button) findViewById(R.id.but_gr11);
        butGr12 = (Button) findViewById(R.id.but_gr12);
        butGr13 = (Button) findViewById(R.id.but_gr13);
        butGr14 = (Button) findViewById(R.id.but_gr14);
        butGr15 = (Button) findViewById(R.id.but_gr15);
        butGr16 = (Button) findViewById(R.id.but_gr16);
        butMoveUp = (Button) findViewById(R.id.but_move_up);
        butMoveDown = (Button) findViewById(R.id.but_move_down);
        butMoveLeft = (Button) findViewById(R.id.but_move_left);
        butMoveRight = (Button) findViewById(R.id.but_move_right);
        butYes = (Button) findViewById(R.id.but_yes);
        butNo = (Button) findViewById(R.id.but_no);
        sbTotal = (SeekBar) findViewById(R.id.sb_total);
        swPult1 = (Switch) findViewById(R.id.sw_pult1);
        swResult = (Switch) findViewById(R.id.sw_result);
    }

    private void setListener() {
        butGr1.setOnClickListener(this);
        butGr2.setOnClickListener(this);
        butGr3.setOnClickListener(this);
        butGr4.setOnClickListener(this);
        butGr5.setOnClickListener(this);
        butGr6.setOnClickListener(this);
        butGr7.setOnClickListener(this);
        butGr8.setOnClickListener(this);
        butGr9.setOnClickListener(this);
        butGr10.setOnClickListener(this);
        butGr11.setOnClickListener(this);
        butGr12.setOnClickListener(this);
        butGr13.setOnClickListener(this);
        butGr14.setOnClickListener(this);
        butGr15.setOnClickListener(this);
        butGr16.setOnClickListener(this);
        butMoveUp.setOnClickListener(this);
        butMoveDown.setOnClickListener(this);
        butMoveLeft.setOnClickListener(this);
        butMoveRight.setOnClickListener(this);
        butBack.setOnClickListener(this);
        butYes.setOnClickListener(this);
        butNo.setOnClickListener(this);
        sbTotal.setOnClickListener(this);
        swPult1.setOnClickListener(this);
        swResult.setOnClickListener(this);
    }

}
