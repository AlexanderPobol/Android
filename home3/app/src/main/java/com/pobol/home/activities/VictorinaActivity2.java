package com.pobol.home.activities;


import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.pobol.home.R;
import com.pobol.home.UserDataVictory;
import com.pobol.home.VictorCategory;

import java.util.HashMap;
import java.util.Map;


public class VictorinaActivity2 extends AppCompatActivity implements View.OnClickListener {

    private Button butMoveLeft;
    private Button butMoveRight;
    private Button butMoveDown;
    private Button butMoveUp;
    private Button butYes;
    private Button butNo;
    private Button butBack;
    private TextView tvChosenCat;
    private TextView tvNumQues;
    private TextView tvNques;
    private TextView tvCorrect;
    private TextView tvWrong;
    private TextView tvAns;
    private TextView tvAnsResult;
    private TextView tvNQ;
    private EditText etQuestion;
    private SeekBar sbTotal;
    private Switch swPult1;
    private Switch swResult;
    private ImageView imgCategory;
    private int a = 0;
    private int number = 1;
    private int correctA = 0;
    private int wrongA = 0;
    private int length = 0;
    private VictorCategory victorCategory;
    private String[] catQuestions;
    private String[] catAnswer;
    private Map<Integer, UserDataVictory> userdata;

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.but_back:
                Log.d("myTag", "back");
                startActivity(new Intent(VictorinaActivity2.this, VictorinaActivity.class));
                break;
            case R.id.but_move_right:
                Log.d("myTag", "right" + "  number=" + number + "catQuestions.length= " + catQuestions[number - 1]);
                if (number < catQuestions.length) {
                    number++;
                } else {
                    number = 1;
                }
                break;
            case R.id.but_move_left:
                Log.d("myTag", "left" + "  number=" + number + "catQuestions.length= " + catQuestions[number - 1]);
                if (number > 1) {
                    number--;
                } else {
                    number = catQuestions.length;
                }
                break;
            case R.id.but_yes:
                Log.d("myTag", " but_gr21=yes");
                userdata.get(number).setAnswer(UserDataVictory.Answer.YES);
                break;
            case R.id.but_no:
                Log.d("myTag", " but_gr22=no");
                userdata.get(number).setAnswer(UserDataVictory.Answer.NO);
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

        tvNQ.setText("№" + number);
        etQuestion.setText(catQuestions[number - 1]);
        correctWrongAnsTotal();
        tvCorrect.setText("правильно " + String.valueOf(correctA));
        tvWrong.setText("ошибок " + String.valueOf(wrongA));
        sbTotal.setProgress(number);
        UserDataVictory.Answer compareAnswer = correctWrongAns(userdata.get(number).getAnswer(), number);
        Log.d("myTag", "compareAnswer=" + compareAnswer);
        tvAns.setTextSize(24);
        tvAns.setText(userdata.get(number).getAnswer().toString());

        if (userdata.get(number).getAnswer() != UserDataVictory.Answer.NO_ANSWER) {
            tvAnsResult.setVisibility(View.VISIBLE);
            if (compareAnswer == UserDataVictory.Answer.YES) {
                tvAnsResult.setText("ПРАВИЛЬНО");
            } else if (compareAnswer == UserDataVictory.Answer.NO) {
                tvAnsResult.setText("ОШИБКА");
            }
        } else {
            tvAnsResult.setVisibility(View.INVISIBLE);
        }
    }


    private void correctWrongAnsTotal() {
        int i = 1;
        correctA = 0;
        wrongA = 0;

        for (Map.Entry<Integer, UserDataVictory> entry : userdata.entrySet()) {
            UserDataVictory.Answer uAnswer = entry.getValue().getAnswer();
            UserDataVictory.Answer rAnswer = correctWrongAns(uAnswer, i);
            if (rAnswer == UserDataVictory.Answer.YES) {
                correctA++;
            } else if (rAnswer == UserDataVictory.Answer.NO) {
                wrongA++;
            }
            i++;
        }
    }

    private UserDataVictory.Answer correctWrongAns(UserDataVictory.Answer uAnswer, int n) {

        UserDataVictory.Answer an = UserDataVictory.Answer.NO_ANSWER;
        if (uAnswer != an) {
            String catAn = catAnswer[n - 1];

            if (catAn.equalsIgnoreCase("yes") | (catAn.equalsIgnoreCase("да"))) {
                an = UserDataVictory.Answer.YES;
            } else if (catAn.equalsIgnoreCase("no") | (catAn.equalsIgnoreCase("нет"))) {
                an = UserDataVictory.Answer.NO;
            }

            if (uAnswer.equals(an)) {
                an = UserDataVictory.Answer.YES;
                ;
            } else {
                an = UserDataVictory.Answer.NO;
            }
        }
        return an;
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        Log.d("myTag", "VictorinaActivity2");
        setContentView(R.layout.victorina_activity2);

        Intent receiveVictIntent = getIntent();
        String category = receiveVictIntent.getStringExtra("category");
        victorCategory = new VictorCategory(VictorCategory.Categories.valueOf(category));
        findInit();
        setListener();
        int question = victorCategory.category.questionsXML;
        int answer = victorCategory.category.answerXML;
        int img = victorCategory.category.imageXML;
        Log.d("myTag", "getCategory=" + victorCategory.getCategory().toString() + "  " + question + "  " + answer);

        Resources res = getResources();
        catQuestions = res.getStringArray(question);
        catAnswer = res.getStringArray(answer);
        length = catQuestions.length;
        Log.d("myTag", "length= " + String.valueOf(length));

        imgCategory.setImageResource(img);
        tvChosenCat.setText("категория " + category);
        tvNques.setText(String.valueOf(length) + " вопросов");

        tvNQ.setText("№" + number);
        etQuestion.setText(catQuestions[number - 1]);

        tvCorrect.setText("правильно " + String.valueOf(correctA));
        tvWrong.setText("ошибок " + String.valueOf(wrongA));
        tvAns.setText("нет ответа");
        tvAnsResult.setVisibility(View.INVISIBLE);

        sbTotal.setMax(length);
        sbTotal.setProgress(0);
        sbTotal.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });

        userdata = new HashMap<>();
        for (int i = 0; i < length; i++) {
            userdata.put(i + 1, new UserDataVictory(victorCategory.category, UserDataVictory.Answer.NO_ANSWER));
        }

        for (Map.Entry<Integer, UserDataVictory> item : userdata.entrySet()) {
            Log.d("myTag", "Key:" + item.getKey() + ", Value:" + item.getValue().getAnswer());
        }

    }

    private void findInit() {

        butMoveUp = (Button) findViewById(R.id.but_move_up);
        butMoveDown = (Button) findViewById(R.id.but_move_down);
        butMoveLeft = (Button) findViewById(R.id.but_move_left);
        butMoveRight = (Button) findViewById(R.id.but_move_right);
        butYes = (Button) findViewById(R.id.but_yes);
        butNo = (Button) findViewById(R.id.but_no);
        sbTotal = (SeekBar) findViewById(R.id.sb_total);
        swPult1 = (Switch) findViewById(R.id.sw_pult1);
        swResult = (Switch) findViewById(R.id.sw_result);
        butBack = (Button) findViewById(R.id.but_back);
        etQuestion = (EditText) findViewById(R.id.et_question);
        tvChosenCat = (TextView) findViewById(R.id.tv_chosen_category);
        tvNumQues = (TextView) findViewById(R.id.tv_num_quest);
        tvNques = (TextView) findViewById(R.id.tv_num_quest);
        tvCorrect = (TextView) findViewById(R.id.tv_correct);
        tvNQ = (TextView) findViewById(R.id.tv_n_quest);
        tvWrong = (TextView) findViewById(R.id.tv_wrong);
        tvAns = (TextView) findViewById(R.id.tv_ans);
        tvAnsResult = (TextView) findViewById(R.id.tv_answer);
        imgCategory = (ImageView) findViewById(R.id.img_category);
    }

    private void setListener() {

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
