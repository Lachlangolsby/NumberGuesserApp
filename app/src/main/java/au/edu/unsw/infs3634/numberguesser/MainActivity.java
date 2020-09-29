package au.edu.unsw.infs3634.numberguesser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.InputMismatchException;
import java.util.Random;

public class MainActivity<difference> extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Random r = new Random();
        int low = 0;
        int high = 10;
        final int randomResult = r.nextInt(high - low) + low;


        final Button Button = (Button) findViewById(R.id.GuessButton);

        final TextView tv3 = (TextView) findViewById(R.id.Error);

        Button.setOnClickListener(new View.OnClickListener() {

            int i = 0;

            @Override
            public void onClick(View view) {
                EditText editText = findViewById(R.id.GuessField);
                String temp = editText.getText().toString();
                if (!temp.equals("")) {
                    i++;
                    assessGuess(randomResult,temp, i);
                    attemptsRemaining(i, randomResult, Button);
                    tv3.setText("");
                }else {
                    tv3.setText("Please enter a valid number");
                }
            }
        });

    }

    public void assessGuess(int randomNumber, String numberGuessed, int count) {
        TextView tv = (TextView) findViewById(R.id.highLowText);
        TextView tv2 = (TextView) findViewById(R.id.Attempts);





        int value = Integer.parseInt(numberGuessed);
        int difference = value - randomNumber;




        if (difference < 0) {
                tv.setText("The number is higher than your previous guess !!");
                tv2.setText("You Have " + (5 - count) + " Attempts Remaining");

            } else if (difference > 0) {
                tv.setText("The number is Lower than your previous guess !!");
                tv2.setText("You Have " + (5 - count) + " Attempts Remaining");

            } else if (difference == 0) {
                Intent activityChangeIntent = new Intent(MainActivity.this, CorrectGuess.class);
                MainActivity.this.startActivity(activityChangeIntent);
                Intent passNumber = new Intent(MainActivity.this, CorrectGuess.class);
                passNumber.putExtra("randomNumber", randomNumber);
                startActivity(passNumber);



            }


    }



    public void attemptsRemaining(int i, int randomNumber, Button Button) {
        EditText editText = findViewById(R.id.GuessField);
        String temp = editText.getText().toString();
        int value = Integer.parseInt(temp);
        if (i == 5 & value != randomNumber) {
            Intent activityChangeIntent = new Intent(MainActivity.this, ExaughstedAttempts.class);
            MainActivity.this.startActivity(activityChangeIntent);
            Intent passNumber = new Intent(MainActivity.this, ExaughstedAttempts.class);
            passNumber.putExtra("randomNumber", randomNumber);
            startActivity(passNumber);


        }


    }
}