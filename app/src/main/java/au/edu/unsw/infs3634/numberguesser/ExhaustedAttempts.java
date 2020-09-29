package au.edu.unsw.infs3634.numberguesser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ExhaustedAttempts extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exhausted_attempts);

        // 1. Getting Random number value from main activity using getIntExtra() method and setting text
        // to the random number that was suppose to be guessed.
        Intent intent = getIntent();
        int randomNumber = intent.getIntExtra("randomNumber", 0);
        TextView correctNumber = findViewById(R.id.number);
        correctNumber.setText((Integer.toString(randomNumber)));

        // 2. Declaring button and creating an onclick listener which launches the main activity once
        // the play again button is clicked.
        Button Button = findViewById(R.id.button);
        Button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent activityChangeIntent = new Intent(ExhaustedAttempts.this, MainActivity.class);
                ExhaustedAttempts.this.startActivity(activityChangeIntent);


            }

        });
    }
}
