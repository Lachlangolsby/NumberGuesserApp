package au.edu.unsw.infs3634.numberguesser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ExaughstedAttempts extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exaughsted_attempts);

        Intent intent = getIntent();
        int randomNumber = intent.getIntExtra("randomNumber", 0);
        TextView correctNumber = (TextView) findViewById(R.id.number);
        correctNumber.setText(Integer.toString(randomNumber));

        Button Button = (Button) findViewById(R.id.button);

        Button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent activityChangeIntent = new Intent(ExaughstedAttempts.this, MainActivity.class);
                ExaughstedAttempts.this.startActivity(activityChangeIntent);


            }

        });
    }
}