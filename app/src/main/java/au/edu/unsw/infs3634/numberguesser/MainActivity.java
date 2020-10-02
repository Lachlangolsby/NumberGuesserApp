package au.edu.unsw.infs3634.numberguesser;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;


public class MainActivity<difference> extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opening_page);

        Intent activityChangeIntent = new Intent(MainActivity.this, OpeningPage.class);
        MainActivity.this.startActivity(activityChangeIntent);

    }
}
