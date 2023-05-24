package com.example.wagecalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextHours;
    private EditText editTextWage;
    private Button buttonCalculate;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextHours = findViewById(R.id.editTextHours);
        editTextWage = findViewById(R.id.editTextWage);
        buttonCalculate = findViewById(R.id.buttonCalculate);
        textViewResult = findViewById(R.id.textViewResult);

        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateWage();
            }
        });
    }

    private void calculateWage() {
        String hoursString = editTextHours.getText().toString();
        String wageString = editTextWage.getText().toString();

        if (!hoursString.isEmpty() && !wageString.isEmpty()) {
            double hours = Double.parseDouble(hoursString);
            double wage = Double.parseDouble(wageString);
            double totalWage = hours * wage;

            textViewResult.setText(String.format("Total wage: $%.2f", totalWage));
        } else {
            textViewResult.setText("Please enter valid values");
        }
    }
}
