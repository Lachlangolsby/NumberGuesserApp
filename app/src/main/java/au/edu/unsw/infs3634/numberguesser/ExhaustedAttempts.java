package au.edu.unsw.infs3634.numberguesser;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import static au.edu.unsw.infs3634.numberguesser.OpeningPage.mediaPlayer;

public class ExhaustedAttempts extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exhausted_attempts);

        // Setting background layout from XML file, using Animation drawable to animate the colour
        // changes.Implementing sound icon for background music using variable from openingPage.
        ConstraintLayout background = findViewById(R.id.layout);
        AnimationDrawable animationDrawable = (AnimationDrawable) background.getBackground();
        animationDrawable.setEnterFadeDuration(1000);
        animationDrawable.setExitFadeDuration(3000);
        animationDrawable.start();

        final ImageView sound = findViewById(R.id.sound);
        sound.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                    sound.setColorFilter(Color.argb(255, 127, 255, 0));
                } else {
                    mediaPlayer.start();
                    sound.setColorFilter(Color.argb(255, 255, 0, 0));
                }
            }
        });

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
                Intent activityChangeIntent = new Intent(ExhaustedAttempts.this, InitialPage.class);
                ExhaustedAttempts.this.startActivity(activityChangeIntent);


            }

        });
    }
}
