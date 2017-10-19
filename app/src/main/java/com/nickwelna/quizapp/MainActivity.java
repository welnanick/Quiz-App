package com.nickwelna.quizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String RESULTS_MESSAGE = "results message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void gradeQuiz(View view) {

        int numberOfQuestionsCorrect = 0;

        EditText answer1 = findViewById(R.id.answer_1_edit_text);

        if (answer1.getText().toString().equals(getString(R.string.answer_1))) {

            numberOfQuestionsCorrect++;

        }

        RadioButton answer2 = findViewById(R.id.answer_2_false);

        if (answer2.isChecked()) {

            numberOfQuestionsCorrect++;

        }

        CheckBox saintPaul = findViewById(R.id.saint_paul);
        CheckBox minneapolis = findViewById(R.id.minneapolis);
        CheckBox crookston = findViewById(R.id.crookston);
        CheckBox rochester = findViewById(R.id.rochester);
        CheckBox duluth = findViewById(R.id.duluth);
        CheckBox morris = findViewById(R.id.morris);
        CheckBox waseca = findViewById(R.id.waseca);
        CheckBox mankato = findViewById(R.id.mankato);

        boolean correctAnswersChecked = saintPaul.isChecked() && minneapolis.isChecked() &&
                crookston.isChecked() && rochester.isChecked() && duluth.isChecked() &&
                morris.isChecked();
        boolean wrongAnswersChecked = waseca.isChecked() || mankato.isChecked();

        if (correctAnswersChecked && !wrongAnswersChecked) {

            numberOfQuestionsCorrect++;

        }

        EditText answer4 = findViewById(R.id.answer_4_edit_text);

        if (answer4.getText().toString().equals(getString(R.string.answer_4))) {

            numberOfQuestionsCorrect++;

        }

        Toast.makeText(this, String.format(getString(R.string.score_text_format), numberOfQuestionsCorrect), Toast.LENGTH_SHORT).show();

        TextView resultMessage = findViewById(R.id.result_message);

        switch (numberOfQuestionsCorrect) {

            case 4:
                resultMessage.setText(R.string.four_correct);
                break;

            case 3:
                resultMessage.setText(getString(R.string.three_correct));
                break;

            default:
                resultMessage.setText(getString(R.string.two_or_less_correct));
                break;

        }

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {

        super.onSaveInstanceState(outState);

        TextView resultMessage = findViewById(R.id.result_message);

        outState.putCharSequence(RESULTS_MESSAGE, resultMessage.getText());

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {

        super.onRestoreInstanceState(savedInstanceState);

        TextView resultMessage = findViewById(R.id.result_message);

        resultMessage.setText(savedInstanceState.getCharSequence(RESULTS_MESSAGE));

    }

}
