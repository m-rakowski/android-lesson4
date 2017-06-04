package course.android.android_lesson4;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Michal on 07.05.2017.
 */

public class QuizActivity extends Activity {

    private List<RadioButton> answers = new ArrayList<>();
    private int points = 0;
    private List<RadioGroup> radioGroups = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);


        radioGroups.add((RadioGroup) findViewById(R.id.dickensRadioGroup));
        radioGroups.add((RadioGroup) findViewById(R.id.adaRadioGroup));
        radioGroups.add((RadioGroup) findViewById(R.id.zanRadioGroup));
        radioGroups.add((RadioGroup) findViewById(R.id.deGaulleRadioGroup));
        radioGroups.add((RadioGroup) findViewById(R.id.cocoRadioGroup));

        answers.add((RadioButton) findViewById(R.id.dickensButton));
        answers.add((RadioButton) findViewById(R.id.adaButton));
        answers.add((RadioButton) findViewById(R.id.zanButton));
        answers.add((RadioButton) findViewById(R.id.deGaulleButton));
        answers.add((RadioButton) findViewById(R.id.cocoButton));

        Button submitButton = (Button) findViewById(R.id.submitButton);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                points = 0;
                for (int i = 0; i < 5; i++) {
                    int checkedOption = radioGroups.get(i).getCheckedRadioButtonId();
                    RadioButton radioButton = (RadioButton) findViewById(checkedOption);

                    if (answers.get(i).equals(radioButton)) {
                        points++;
                    }
                }
                Toast.makeText(getApplicationContext(), "You got " + points + " answers right!", Toast.LENGTH_LONG).show();
            }
        });
    }
}