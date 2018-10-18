package com.rakuten.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    private TextView tvDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example of a call to a native method
        tvDisplay = (TextView) findViewById(R.id.text_counter);
        tvDisplay.setText("0");
        Button btnCounter = findViewById(R.id.btn_counter);
        btnCounter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                long counterVal = Long.parseLong(tvDisplay.getText().toString());
                counterVal = getCounter(counterVal);
                tvDisplay.setText(String.valueOf(counterVal));
            }
        });

    }

    public native long getCounter(long n);


}
