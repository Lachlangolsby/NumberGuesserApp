package au.edu.unsw.infs3634.numberguesser;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class OpeningPage<mediaPlayer> extends AppCompatActivity {

    // declaring media player as null as to be accessed in other java classes
    public static MediaPlayer mediaPlayer = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opening_page);

        // Setting background layout from XML file, using Animation drawable to animate the colour
        // changes
        ConstraintLayout background = findViewById(R.id.layout);
        AnimationDrawable animationDrawable = (AnimationDrawable) background.getBackground();
        animationDrawable.setEnterFadeDuration(1000);
        animationDrawable.setExitFadeDuration(3000);
        animationDrawable.start();
        // assigning music to media player for background music and starting music
        mediaPlayer = MediaPlayer.create(this, R.raw.wiimusic);
        mediaPlayer.start();


        Button Button = findViewById(R.id.Play);
        Button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent activityChangeIntent = new Intent(OpeningPage.this, InitialPage.class);
                OpeningPage.this.startActivity(activityChangeIntent);
            }
        });
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


    }


}

