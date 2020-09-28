package au.edu.unsw.infs3634.numberguesser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CorrectGuess extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_correct_guess);

        Intent intent = getIntent();
        int randomNumber = intent.getIntExtra("randomNumber", 0);
        TextView correctNumber = (TextView) findViewById(R.id.title3);
        correctNumber.setText("The Number Was: " + Integer.toString(randomNumber));


        Button Button = (Button) findViewById(R.id.againButton);

        Button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent activityChangeIntent = new Intent(CorrectGuess.this, MainActivity.class);
                CorrectGuess.this.startActivity(activityChangeIntent);


            }

        });

    }
}

