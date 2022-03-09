package com.example.calculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    private EditText inputNum;
    private ImageButton plusButton;
    private ImageButton minusButton;
    private ImageButton equalButton;
    private ImageButton oneButton;
    private ImageButton twoButton;
    private ImageButton threeButton;
    private ImageButton fourButton;
    private ImageButton fiveButton;
    private ImageButton sixButton;
    private ImageButton sevenButton;
    private ImageButton eightButton;
    private ImageButton nineButton;
    private ImageButton zeroButton;
    private ImageButton divideButton;
    private ImageButton multiplyButton;
    Calculator calculator = new Calculator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputNum = findViewById(R.id.et_input_num);
        int[] numberButtons = {
                R.id.oneButton,
                R.id.twoButton,
                R.id.threeButton,
                R.id.fourButton,
                R.id.fiveButton,
                R.id.sixButton,
                R.id.sevenButton,
                R.id.eightButton,
                R.id.nineButton,
                R.id.zeroButton
        };

        int[] actButtons = {
                R.id.plusButton,
                R.id.minusButton,
                R.id.divideButton,
                R.id.multiplyButton,
                R.id.equalButton
        };

        View.OnClickListener numBTN = new View.OnClickListener() {
            @Override
            public void onClick(@NonNull View view) {
                calculator.numButton(view.getId());
                inputNum.setText(calculator.getText());
            }
        };

        View.OnClickListener actBTN = new View.OnClickListener() {
            @Override
            public void onClick(@NonNull View view) {
                calculator.actionButton(view.getId());
                inputNum.setText(calculator.getText());
            }
        };

        for (int i = 0; i < numberButtons.length; i++) {
            findViewById(numberButtons[i]).setOnClickListener(numBTN);
        }
        ;

        for (int i = 0; i < actButtons.length; i++) {
            findViewById(actButtons[i]).setOnClickListener(actBTN);
        }
        ;


    }
}