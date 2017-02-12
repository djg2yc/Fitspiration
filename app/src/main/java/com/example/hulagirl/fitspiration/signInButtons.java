package com.example.hulagirl.fitspiration;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class signInButtons extends AppCompatActivity {
    Button login;
    Button signIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_buttons);

        login = (Button) findViewById(R.id.button3);

        signIn = (Button) findViewById(R.id.button4) ;
        // Capture button clicks
        login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent myIntent = new Intent(signInButtons.this,
                        HomeScreen.class);
                startActivity(myIntent);
            }

        });

        signIn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent myIntent = new Intent(signInButtons.this,
                        HomeScreen.class);
                startActivity(myIntent);
            }

        });



    }
}
