package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.Group;

import android.app.VoiceInteractor;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    enum eTasks{plus, minus, multiply, divide };

    private Calculator _fCalc;
    private Integer _firstInt = null;
    private Integer _secondInt = null;
    private eTasks _task = null;
    private TextView _fTV = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Group xGpNums = findViewById(R.id.gp_nums);
        Group xGpActions = findViewById(R.id.gp_actions);
        _fTV =  findViewById(R.id.tv_Task);

        xGpActions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {String xValue = ((Button) v).getText().toString();
                    if(xValue.equals('='))
                    {
                        if (!_firstInt.equals(null) && !_secondInt.equals(null) && !_task.equals(null) ) {
                            initCalc();
                        }
                        else
                            throw new Exception("Не введены числа, либо не выбрано действие!");
                    }else {
                        if(_firstInt.equals(null))
                            throw new Exception("Введите первое число!");
                        switch (xValue) {
                            case "+":
                                _task = eTasks.plus;
                                break;
                            case "-":
                                _task = eTasks.minus;
                                break;
                            case "*":
                                _task = eTasks.multiply;
                                break;
                            case "/":
                                _task = eTasks.divide;
                                break;
                        }

                    }
                }catch (Exception e){
                    _fTV.setTextColor(Color.RED);
                    _fTV.setTextSize(20);
                    _fTV.setText(e.getMessage());
                }
            }
        });

        xGpNums.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             try {
                 String xValue = ((Button) v).getText().toString();
                 initNums(xValue);
             }catch (Exception e){
                 _fTV.setTextColor(Color.RED);
                 _fTV.setTextSize(20);
                 _fTV.setText(e.getMessage());
             }
            }
        });
    }

    private void initCalc()throws Exception{
        try{
            _fCalc = new Calculator(_firstInt, _secondInt);
            switch(_task)
            {
                case plus:
                    _fCalc.plus();
                    break;
                case minus:
                    _fCalc.minus();
                    break;
                case multiply:
                    _fCalc.multiply();
                    break;
                case divide:
                    _fCalc.divide();
                    break;
            }
        }
        catch(Exception e){throw e;}
    }

    private void initNums (String pVal) throws NumberFormatException{

        try {
            _fTV.append(pVal);
            Integer xnum = Integer.parseInt(_fTV.getText().toString());

        if (_task.equals(null))
            _firstInt = new Integer(xnum);
        else
            _secondInt = new Integer(xnum);

        }catch (NumberFormatException e){throw e;}

    }
}