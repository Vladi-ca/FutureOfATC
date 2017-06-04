package com.example.android.futureofatc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;
import static android.widget.Toast.makeText;

public class MainActivity extends AppCompatActivity {
    String airport;
    int score;
    EditText busiestAirport;
    RadioButton exerciseThird;
    RadioButton drugsNo;
    RadioButton excellentStress;
    RadioButton suicideNo;
    RadioButton focus;
    RadioButton languages;
    CheckBox mathCheckbox;
    CheckBox physicsCheckbox;
    CheckBox historyCheckbox;
    CheckBox chemistryCheckbox;
    RadioButton greatIq;
    View scoreButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // EditText Question WITH IMPLEMENTED POINT SYSTEM
        busiestAirport = (EditText) findViewById(R.id.airport);

        exerciseThird = (RadioButton) findViewById(R.id.exercise_three);
        drugsNo = (RadioButton) findViewById(R.id.second_drugs);
        excellentStress = (RadioButton) findViewById(R.id.excellent_stress);
        suicideNo = (RadioButton) findViewById(R.id.no_suicide);
        focus = (RadioButton) findViewById(R.id.focus_three_more);
        languages = (RadioButton) findViewById(R.id.languages_two);

        mathCheckbox = (CheckBox) findViewById(R.id.math_checkbox);
        physicsCheckbox = (CheckBox) findViewById(R.id.physics_checkbox);
        historyCheckbox = (CheckBox) findViewById(R.id.history_checkbox);
        chemistryCheckbox = (CheckBox) findViewById(R.id.chemistry_checkbox);
        greatIq = (RadioButton) findViewById(R.id.iq_great);

        scoreButton = findViewById(R.id.score_button);
    }

    public void showScore(View view) {

        // EditText Question WITH IMPLEMENTED POINT SYSTEM
        airport = String.valueOf(busiestAirport.getText());
        String zeroAnswer = busiestAirport.getEditableText().toString();

        //Question 1 - Exercise
        boolean firstAnswer = exerciseThird.isChecked();

        //Question 2 - Drugs
        boolean secondAnswer = drugsNo.isChecked();

        //Question 3 - Stress
        boolean thirdAnswer = excellentStress.isChecked();

        //Question 4 - Suicide
        boolean fourthAnswer = suicideNo.isChecked();

        //Question 5 - Focus/ Performance
        boolean fifthAnswer = focus.isChecked();

        //Question 6 - Focus/ Performance
        boolean sixthAnswer = languages.isChecked();

        //Question 7 - Subjects/ Math, IT, Statistics, Physics
        boolean seventhAnswer1 = mathCheckbox.isChecked();
        boolean seventhAnswer2 = physicsCheckbox.isChecked();
        boolean seventhAnswer3 = historyCheckbox.isChecked();
        boolean seventhAnswer4 = chemistryCheckbox.isChecked();

        //Question 8 - Subjects/ Math, IT, Statistics, Physics
        boolean eightAnswer = greatIq.isChecked();

        calculateScore(zeroAnswer, firstAnswer, secondAnswer, thirdAnswer, fourthAnswer, fifthAnswer, sixthAnswer, seventhAnswer1, seventhAnswer2, seventhAnswer3, seventhAnswer4, eightAnswer);
        displayScore(score);
    }

    // Adding one point to the score if the designated answer is chosen
    private int calculateScore(String zeroAnswer, boolean firstAnswer, boolean secondAnswer, boolean thirdAnswer, boolean fourthAnswer, boolean fifthAnswer, boolean sixthAnswer, boolean seventhAnswer1, boolean seventhAnswer2, boolean seventhAnswer3, boolean seventhAnswer4, boolean eightAnswer) {
        // EditText Question WITH IMPLEMENTED POINT SYSTEM
        if (zeroAnswer.equals(busiestAirport)) {
            score = score + 1;
        }

        if (firstAnswer) {
            score = score + 1;
        }

        if (secondAnswer) {
            score = score + 1;
        }

        if (thirdAnswer) {
            score = score + 1;
        }

        if (fourthAnswer) {
            score = score + 1;
        }

        if (fifthAnswer) {
            score = score + 1;
        }

        if (sixthAnswer) {
            score = score + 1;
        }

        if (seventhAnswer1 && seventhAnswer2 && !seventhAnswer3 && !seventhAnswer4) {  //if first and second answer is chosen, point will be added to the score
            score = score + 1;
        }

        if (eightAnswer) {
            score = score + 1;
        }

        return score;
    }

    // Toasts appears after pressing the submit button and designated score with description will appear.
    public void displayScore(int scoreTotal) {

            if (scoreTotal == 0) {
                makeText(this, getString(com.example.android.futureofatc.R.string.toast_score_zero), Toast.LENGTH_LONG).show();
            } else if (scoreTotal < 8) {
                makeText(this, getString(com.example.android.futureofatc.R.string.toast_low_score) + score + getString(R.string.toast_score_outOfNine), Toast.LENGTH_LONG).show();
            } else if (scoreTotal == 8) {
                makeText(this, getString(com.example.android.futureofatc.R.string.toast_slight_chance) + score + getString(com.example.android.futureofatc.R.string.toast_slight_chance_score), Toast.LENGTH_LONG).show();
            } else if (scoreTotal == 9) {
                makeText(this, getString(com.example.android.futureofatc.R.string.toast_some_abilities) + score + getString(com.example.android.futureofatc.R.string.toast_score_outOfNine), Toast.LENGTH_LONG).show();
            }

            score = 0;
    }

}