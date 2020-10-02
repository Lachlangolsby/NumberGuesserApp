package au.edu.unsw.infs3634.numberguesser;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class InitialPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial_page);
        // Setting background layout from XML file, using Animation drawable to animate the colour
        // changes
        ConstraintLayout background = findViewById(R.id.layout);
        AnimationDrawable animationDrawable = (AnimationDrawable) background.getBackground();
        animationDrawable.setEnterFadeDuration(1000);
        animationDrawable.setExitFadeDuration(3000);
        animationDrawable.start();

        // 1. Creating Randomly generated number to be guessed between 1 - 100
        Random r = new Random();
        int low = 0;
        int high = 100;
        final int randomResult = r.nextInt(high - low) + 1;

        // 2. identifying button and text view from XML file to be changed
        final Button Button = findViewById(R.id.GuessButton);
        final TextView tv3 = findViewById(R.id.Error);

        Button.setOnClickListener(new View.OnClickListener() {
            // 4. Declaring variable to count the amount of attempts
            int i = 0;

            // 5. Series of actions to be carried out if button is clicked, as well as assessing
            //    Validity of user input
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                EditText editText = findViewById(R.id.GuessField);
                String temp = editText.getText().toString();

                if ((!temp.equals("") && Integer.parseInt(temp)!=0 && Integer.parseInt(temp) <101) ) {
                    i++;
                    assessGuess(randomResult, temp, i);
                    attemptsRemaining(i, randomResult);
                    tv3.setText("");
                } else {
                    tv3.setText("Please enter a valid number");
                }
            }
        });

    }

    // AssessGuess gives feedback to users based on their guess
    @SuppressLint("SetTextI18n")
    public void assessGuess(int randomNumber, String numberGuessed, int count) {

        // 1. Declaring text views from XML file to be changed
        TextView tv = findViewById(R.id.highLowText);
        TextView tv2 = findViewById(R.id.Attempts);

        // 2. Parsing user feedback and assessing proximity to the random number
        int value = Integer.parseInt(numberGuessed);
        int difference = value - randomNumber;

        // 3. Based on proximity to number telling user to guess higher or lower by changing TextViews
        if (difference < 0) {
            tv.setText("The number is higher than your previous guess !!");
            tv2.setText("You Have " + (5 - count) + " Attempts Remaining");

        } else if (difference > 0) {
            tv.setText("The number is Lower than your previous guess !!");
            tv2.setText("You Have " + (5 - count) + " Attempts Remaining");

        } else {
            // 4. If guess is correct redirecting to CorrectGuess class
            Intent activityChangeIntent = new Intent(InitialPage.this, CorrectGuess.class);
            InitialPage.this.startActivity(activityChangeIntent);
            // 5. Using Intents to pass random number through to Correct Guess for UI
            Intent passNumber = new Intent(InitialPage.this, CorrectGuess.class);
            passNumber.putExtra("randomNumber", randomNumber);
            startActivity(passNumber);


        }


    }

    // Attempts remaining assess whether 5 attempts is over an directs them to the
    // Exhausted Attempts  Class
    public void attemptsRemaining(int i, int randomNumber) {
        // 1. Retrieving Guessed number
        EditText editText = findViewById(R.id.GuessField);
        String temp = editText.getText().toString();
        int value = Integer.parseInt(temp);

        // 2. Assessing if 5th guess is incorrect, if so  using intent to change page and pass the
        // random number through to ExhaustedAttempts class for the UI.
        if (i == 5 & value != randomNumber) {
            Intent activityChangeIntent = new Intent(InitialPage.this, ExhaustedAttempts.class);
            InitialPage.this.startActivity(activityChangeIntent);
            Intent passNumber = new Intent(InitialPage.this, ExhaustedAttempts.class);
            passNumber.putExtra("randomNumber", randomNumber);
            startActivity(passNumber);


        }


    }
}
