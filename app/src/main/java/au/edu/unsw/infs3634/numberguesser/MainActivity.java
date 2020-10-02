package au.edu.unsw.infs3634.numberguesser;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
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
        setContentView(R.layout.activity_opening_page);

        Intent activityChangeIntent = new Intent(MainActivity.this, OpeningPage.class);
        MainActivity.this.startActivity(activityChangeIntent);

    }
}
