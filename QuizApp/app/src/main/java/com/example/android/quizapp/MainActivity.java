package com.example.android.quizapp;

import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Question> questions = new ArrayList<>();
    private int quizScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout mainLayout = (LinearLayout) findViewById(R.id.linear_layout);

        try {

            InputStream is = getResources().openRawResource(R.raw.data);

            String json = Utils.convertStreamToString(is);

            JSONArray questionArray = new JSONArray(json);
            for (int i = 0; i < questionArray.length(); i++) {
                JSONObject questionObject = questionArray.getJSONObject(i);
                String questionName = questionObject.getString("questionName");
                JSONArray answerArray = questionObject.getJSONArray("answers");
                Question question = new Question(questionName);
                questions.add(question);
                for (int j = 0; j < answerArray.length(); j++) {
                    JSONObject answerObject = answerArray.getJSONObject(j);
                    String answerText = answerObject.getString("text");
                    boolean answerValue = answerObject.getBoolean("value");
                    Answer answer = new Answer(answerText, answerValue);

                    question.addAnswer(answer);
                }


            }


            for (int i = 0; i < questions.size(); i++) {
                Question q = questions.get(i);
                Answer answer;

                TextView textView = new TextView(this);
                // Setting textView params - this will be questions
                textView.setText(q.getName());
                textView.setBackgroundColor(getResources().getColor(R.color.colorBackgroundQuestion));
                textView.setTextColor(getResources().getColor(R.color.text_color_primary));
                textView.setPadding(5, 0, 0, 0);

                mainLayout.addView(textView);
                RadioGroup radioGroup = new RadioGroup(this);
                mainLayout.addView(radioGroup);
                for (int j = 0; j < q.getAnswers().size(); j++) {
                    answer = q.getAnswers().get(j);
                    RadioButton radioButton = new RadioButton(this);

                    // Setting radioButton params - this will be the answers
                    radioButton.setText(answer.getName());
                    //radioButton.setPadding(30,0,0,30);
                    //int padding = getResources().getDimensionPixelOffset(R.dimen.padding);
                    radioGroup.addView(radioButton);

                }
            }

            Button submitButton = new Button(this);
            submitButton.setText("Submit");
            submitButton.setBackgroundResource(R.drawable.button_style);
            ;
            //submitButton.setBackgroundColor(getResources().getColor(R.color.colorSubmitButton));
            submitButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    submit();
                }
            });
            mainLayout.addView(submitButton);

        } catch (JSONException e) {
            e.printStackTrace();
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
    }

    public void submit() {
        quizScore = 0;
        LinearLayout mainLayout = (LinearLayout) findViewById(R.id.linear_layout);

        Question question = null;
        Answer answer = null;

        for (int i = 0; i < mainLayout.getChildCount(); i++) {

            View child = mainLayout.getChildAt(i);
            if (child instanceof TextView && child instanceof Button == false) {
                question = questions.get(i / 2);
            }

            if (child instanceof RadioGroup) {
                RadioGroup radioGroup = (RadioGroup) child;

                for (int j = 0; j < radioGroup.getChildCount(); j++) {
                    RadioButton radioButton = (RadioButton) radioGroup.getChildAt(j);
                    answer = question.getAnswers().get(j);
                    if (radioButton.isChecked() && answer.isCorrect()) {
                        quizScore = quizScore + 1;
                    }
                    ;
                }
            }
        }

        Toast.makeText(this, "You have " + quizScore + " correct answers in total.", Toast.LENGTH_SHORT).show();
    }

}
