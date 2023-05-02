package com.example.firstaidmobileapp;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class QuizActivity extends AppCompatActivity {


    private TextView questionTextView;
    private RadioButton optionARadioButton;
    private RadioButton optionBRadioButton;
    private RadioButton optionCRadioButton;
    private RadioButton optionDRadioButton;
    private RadioGroup optionsRadioGroup;
    private Button submitButton;

    private int currentQuestionIndex;
    private int score;

    private String[] questions = {
            "What should you do if someone is choking?",
            "What should you do if someone has a nosebleed?",
            "What should you do if someone has a seizure?",
            "What should you do if someone has a burn?",
            "What is the first thing you should do when a person is heavily bleeding?",
            "How do you treat a burn that has blisters?",
            "What is the proper way to perform the Heimlich maneuver on a choking adult?",
            "What is the first step in treating a snake bite?",
            "How do you treat someone experiencing an asthma attack?",
            "What is the proper way to perform CPR on an adult?",
            "How do you treat a minor cut or scrape?",
            "How do you treat someone who is experiencing a heart attack?",
            "What is the first step in treating someone who is experiencing a stroke?",
            "How do you treat someone who is having a severe allergic reaction?",
            "What is the proper way to apply the tourniquet?",
            "How do you treat a sprained ankle?",
            "How do you treat a bee sting?"
    };

    private String[][] options = {
            {"Give them a glass of water", "Pat them on the back", "Perform the Heimlich maneuver", "Ask them to cough"},
            {"Tilt their head back", "Tilt their head forward", "Hold their nose and lean them forward", "Hold their nose and lean them backward"},
            {"Put a spoon in their mouth", "Hold them down", "Call an ambulance", "Take their temperature"},
            {"Apply ice to the affected area", "Apply butter to the affected area", "Apply toothpaste to the affected area", "Run the affected area under cool water"},
            {"Apply Pressure to the  wound","Elevate the Wound","Apply a tourniquet","clean the wound"},
            {"Pop the blisters","Cover the burn with a dry, sterile bandage","Apply cold water fro 20 minutes","Apply warm water for 20 minutes"},
            {"Strike them on the back of your hand","Perform Abdominal Thrusts","Give them a glass of water","Turn them upside down"},
            {"Apply a Tourniquet","Cut the wound and suck out venom","Wash the wound with soap and water","Keep the affected limb immobilized"},
            {"Give them water to drink","Encourage them to take deep breaths","Use a rescue inhaler if they have one","Take them outside for fresh air"},
            {"Perform 10 chest compressions followed by 2 breaths","Perform 15 chest compressions followed by 2 breaths","Perform 30 chest compressions followed by 2 breaths","Perform 50 chest compressions followed by 2 breaths"},
            {"Wash the wound with soap and water and cover with a bandage","Apply Rubbing alcohol to the wound","Apply hydrogen peroxide to the wound","Cover the wound with a wt cloth"},
            {"Give them aspirin to chew","Give them water to drink","Encourage them to take deep breaths","Have them lie down on their stomach"},
            {"Have them lie down","Give them water to Drink","Call emergency services immediately","Encourage them to take deep breaths"},
            {"Give them water to drink","Encourage them to take deep breaths","Give them their EpiPen if they have one","Have them lie on their stomach"},
            {"Tie it tightly around the affected limb","tie it loosely around the affected limb","tie it above the affected area and tighten until bleeding stops","Tie it below the affected area and tighten until bleeding stops"},
            {"Apply heat on affected area","Elevate the affected area and apply a cold compress","Massage the affected area","Walk it off"},
            {"Cover the affected area with a warm compress","Apply a tourniquet to the affected area","Remove the stinger and apply a cold compress","Apply an antibiotic ointment to the affected area"}


    };

    private int[] answers = {2, 1, 2, 0,0,1,1,3,2,2,0,0,2,2,2,1,2};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        questionTextView = findViewById(R.id.question_text_view);
        optionARadioButton = findViewById(R.id.option_a_radio_button);
        optionBRadioButton = findViewById(R.id.option_b_radio_button);
        optionCRadioButton = findViewById(R.id.option_c_radio_button);
        optionDRadioButton = findViewById(R.id.option_d_radio_button);
        optionsRadioGroup = findViewById(R.id.options_radio_group);
        submitButton = findViewById(R.id.submit_button);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedOptionIndex = optionsRadioGroup.getCheckedRadioButtonId();
                if (selectedOptionIndex != -1) {
                    RadioButton selectedOptionRadioButton = findViewById(selectedOptionIndex);
                    int selectedOption = optionsRadioGroup.indexOfChild(selectedOptionRadioButton);
                    if (selectedOption == answers[currentQuestionIndex]) {
                        score++;
                    }
                    currentQuestionIndex++;
                    if (currentQuestionIndex < questions.length) {
                        updateQuestion();
                    } else {
                        showScore();
                    }
                }
            }
        });

        currentQuestionIndex = 0;
        score = 0;
        updateQuestion();
    }

    private void updateQuestion() {
        questionTextView.setText(questions[currentQuestionIndex]);
        optionARadioButton.setText(options[currentQuestionIndex][0]);
        optionBRadioButton.setText(options[currentQuestionIndex][1]);
        optionCRadioButton.setText(options[currentQuestionIndex][2]);
        optionDRadioButton.setText(options[currentQuestionIndex][3]);
        optionsRadioGroup.clearCheck();
    }

    private void showScore() {
        String message = "You scored " + score + " out of " + questions.length + "!";
        questionTextView.setText(message);
        optionARadioButton.setVisibility(View.GONE);
        optionBRadioButton.setVisibility(View.GONE);
        optionCRadioButton.setVisibility(View.GONE);
        optionDRadioButton.setVisibility(View.GONE);
        submitButton.setVisibility(View.GONE);
    }

}