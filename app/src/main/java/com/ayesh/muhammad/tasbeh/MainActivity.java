package com.ayesh.muhammad.tasbeh;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int counter = 0;
    TextView counterText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        RelativeLayout layout = (RelativeLayout) findViewById(R.id.main_activity);
        layout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, counter++ +"", Toast.LENGTH_SHORT).show();
                counterText = (TextView) findViewById(R.id.counter);
                counterText.setText(++counter + "");
            }
        });

        Button reset = (Button) findViewById(R.id.button);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter = 0;
                counterText.setText("0");
            }
        });
    }


}

