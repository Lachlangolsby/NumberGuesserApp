package au.edu.unsw.infs3634.numberguesser;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OpeningPage extends AppCompatActivity {

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

        Button Button = findViewById(R.id.Play);
        Button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent activityChangeIntent = new Intent(OpeningPage.this, InitialPage.class);
                OpeningPage.this.startActivity(activityChangeIntent);
            }
        });
    }
}