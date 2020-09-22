package au.edu.unsw.infs3634.numberguesser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity<difference> extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Random r = new Random();
        int low = 0;
        int high = 100;
        final int randomResult = r.nextInt(high - low) + low;

        final Button Button = (Button) findViewById(R.id.GuessButton);

        Button.setOnClickListener(new View.OnClickListener() {

            int i = 0;

            @Override
            public void onClick(View view) {
                i++;
                assessGuess(randomResult, i);
                attemptsRemaining(i, randomResult, Button);
            }
        });

    }

    public void assessGuess(int randomNumber, int i) {

        EditText editText = findViewById(R.id.GuessField);

        String temp = editText.getText().toString();
        int value = Integer.parseInt(temp);
        int difference = value - randomNumber;

        TextView tv = (TextView) findViewById(R.id.highLowText);
        TextView tv2 = (TextView) findViewById(R.id.Attempts);

        if (difference < 0) {
            tv.setText("The number is higher than your previous guess !!");
            tv2.setText("You Have " + (5 - i) + " Attempts Remaining");

        } else if (difference > 0) {
            tv.setText("The number is Lower than your previous guess !!");
            tv2.setText("You Have " + (5 - i) + " Attempts Remaining");

        } else if (difference == 0) {
            tv.setText("You are correct");
            tv2.setText("");
            Intent activityChangeIntent = new Intent(MainActivity.this, CorrectGuess.class);
            MainActivity.this.startActivity(activityChangeIntent);

        }

    }

    public void attemptsRemaining(int i, int Number, Button Button) {
        if (i == 5) {
            TextView tv = (TextView) findViewById(R.id.highLowText);
            tv.setText("The number is " + Number + " You lose !!");
            Button.setText("Play Again");
            Button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    // Perform action on click
                    Intent activityChangeIntent = new Intent(MainActivity.this, MainActivity.class);

                    // currentContext.startActivity(activityChangeIntent);

                    MainActivity.this.startActivity(activityChangeIntent);
                }
            });


        }


    }
}