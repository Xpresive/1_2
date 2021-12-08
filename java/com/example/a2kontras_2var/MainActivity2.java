package com.example.a2kontras_2var;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        String tekstas =getIntent().getStringExtra("reiksme");
        TextView tv = findViewById(R.id.textView);

        String[] ivestis =tekstas.split("\\s+");

        Handler handler = new Handler();

        for (int i = 0; i < ivestis.length; i++){
            handler.postDelayed(new TextChanger(tv, ivestis[i]), 1000 * (i + 1));
        }
        handler.postDelayed(new TextChanger(tv, tekstas), 1000 * (ivestis.length + 1));

        Button button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishAffinity();
            }
        });
    }

    public class TextChanger implements Runnable{
        TextView textView;
        String text;

        public TextChanger(TextView tv, String text){
            this.textView = tv;
            this.text = text;
        }
        @Override
        public void run() {
            textView.setText(text + " (" + text.length() + ")");
        }
    }
}