package com.example.geoquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    int test = 0;

    private Button mTrueButton;
    private Button mFalseButton;
    List<String> questionList = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTrueButton = (Button) findViewById(R.id.true_button);
        TextView textView = (TextView) findViewById(R.id.textView);
        verification(textView);
    }

    public void verification(TextView textview)
    {
        questionList.add("My name is Brahim ");
        questionList.add("The Captial of France is Nantes ");
        questionList.add("Camberra is the Capital of Australia ");
        textview.setText(questionList.get(test));
        test ++;

        if(test == 4){
            test = 1;
        }

        if (test == 1 || test == 3){
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast= Toast.makeText(MainActivity.this,
                        R.string.correct_toast, Toast.LENGTH_SHORT);
                        toast.show();
                        verification(textview);
            }
        });

        mFalseButton = (Button) findViewById(R.id.false_button);
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast= Toast.makeText(MainActivity.this,
                        R.string.incorrect_toast, Toast.LENGTH_SHORT);toast.show();
                        verification(textview);
            }
        });
        }else{
            mTrueButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast toast = Toast.makeText(MainActivity.this,
                            R.string.incorrect_toast, Toast.LENGTH_SHORT);toast.show();
                            verification(textview);
                }
            });

            mFalseButton = (Button) findViewById(R.id.false_button);
            mFalseButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast toast= Toast.makeText(MainActivity.this,
                            R.string.correct_toast, Toast.LENGTH_SHORT);toast.show();
                            verification(textview);
                }
            });
        }
    }
}

