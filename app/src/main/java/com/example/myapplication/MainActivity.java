package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.Group;

import android.app.VoiceInteractor;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private Calculator fCalc;
    private final static String keyCalculator = "Calculator";
    private TextView fTvFirst = null;
    private TextView fTvSecond = null;
    private TextView fTvRes = null;
    private HashMap<String,Button> fButtonMap = new HashMap<String,Button>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fCalc = new Calculator();
        InitView();
    }

    private void InitView() {
        fTvFirst = findViewById(R.id.tv_first_num);
        fTvSecond = findViewById(R.id.tv_second_num);
        fTvRes = findViewById(R.id.tv_res_num);
        fButtonMap.put("0", findViewById(R.id.button_0));
        fButtonMap.put("1", findViewById(R.id.button_1));
        fButtonMap.put("2", findViewById(R.id.button_2));
        fButtonMap.put("3", findViewById(R.id.button_3));
        fButtonMap.put("4", findViewById(R.id.button_4));
        fButtonMap.put("5", findViewById(R.id.button_5));
        fButtonMap.put("6", findViewById(R.id.button_6));
        fButtonMap.put("7", findViewById(R.id.button_7));
        fButtonMap.put("8", findViewById(R.id.button_8));
        fButtonMap.put("9", findViewById(R.id.button_9));
        fButtonMap.put(".", findViewById(R.id.button_point));
        fButtonMap.put("buttonEqual", findViewById(R.id.button_equals));
        fButtonMap.put("buttonPlus", findViewById(R.id.button_plus));
        fButtonMap.put("buttonMinus", findViewById(R.id.button_minus));
        fButtonMap.put("buttonMultiply", findViewById(R.id.button_multiply));
        fButtonMap.put("buttonDivide", findViewById(R.id.button_divide));
        fButtonMap.put("buttonClear", findViewById(R.id.button_clear));

        for (Button button: fButtonMap.values()) {
            button.setOnClickListener(this);
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.button_0:
                setNums("0");
                break;
            case R.id.button_1:
                setNums("1");
                break;
            case R.id.button_2:
                setNums("2");
                break;
            case R.id.button_3:
                setNums("3");
                break;
            case R.id.button_4:
                setNums("4");
                break;
            case R.id.button_5:
                setNums("5");
                break;
            case R.id.button_6:
                setNums("6");
                break;
            case R.id.button_7:
                setNums("7");
                break;
            case R.id.button_8:
                setNums("8");
                break;
            case R.id.button_9:
                setNums("9");
                break;
            case R.id.button_point:
                setNums(".");
                break;
            case R.id.button_equals:
                DoTask();
                break;
            case R.id.button_plus:
                initTask(Calculator.eTasks.plus);
                break;
            case R.id.button_minus:
                initTask(Calculator.eTasks.minus);
                break;
            case R.id.button_multiply:
                initTask(Calculator.eTasks.multiply);
                break;
            case R.id.button_divide:
                initTask(Calculator.eTasks.divide);
                break;
            case R.id.button_clear:
                fCalc = new Calculator();
                fTvFirst.setText("");
                fTvSecond.setText("");
                fTvRes.setText("");
                break;
        }
    }

    private void initTask(Calculator.eTasks pTask)  {
        if(fCalc==(null))
            fCalc = new Calculator();
        if(fCalc.getfStrFirstNum()==null)
            return;
        fCalc.setTask(pTask);
    }

    private void DoTask() {
        if(fCalc.equals(null))
            return;
        try {
            String xRes = fCalc.DoTask().toString();
            fTvRes.setText(xRes );
        } catch (Exception e) {

            Toast toast = Toast.makeText(getApplicationContext(), e.getMessage(),  Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    private void setNums(String pValue) {
        try {
            if(fCalc.getTask()==null) {
                if (fCalc.getfStrFirstNum() == (null)) {
                    if (pValue.equals("."))
                        return;
                    fCalc.setfStrFirstNum(new StringBuilder().append(pValue));
                } else {
                    if (pValue.equals(".")) {
                        if (fCalc.getfStrFirstNum().indexOf(".") == -1 && fCalc.getfStrFirstNum().length() > 0) {
                            fCalc.appendfStrFirstNum(pValue);
                        }
                    } else {
                        fCalc.appendfStrFirstNum(pValue);
                    }
                }
                fTvFirst.setText(fCalc.getfStrFirstNum().toString());
            }
            else {
                if(fCalc.getfStrSecondNum()==(null))
                {
                    if(pValue.equals("."))
                        return;
                    fCalc.setfStrSecondNum(new StringBuilder().append(pValue));
                }
                else {
                    if(pValue.equals(".")){
                        if(fCalc.getfStrSecondNum().indexOf(".")== -1 && fCalc.getfStrSecondNum().length()>0)
                        {
                            fCalc.appendfStrSecondNum(pValue);
                        }
                    }
                    else{
                        fCalc.appendfStrSecondNum(pValue);
                    }
                }
                fTvSecond.setText(fCalc.getfStrSecondNum().toString());
            }

        }
        catch (Exception e)
        {
            Toast toast = Toast.makeText(getApplicationContext(), e.getMessage(),  Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle instanceState) {
        super.onSaveInstanceState(instanceState);
        instanceState.putSerializable(keyCalculator, fCalc);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle instanceState) {

        super.onRestoreInstanceState(instanceState);
        fCalc = (Calculator) instanceState.getSerializable(keyCalculator);
        if(fCalc==null)
            return;
        setTextCounters();
    }

    private void setTextCounters() {
        if(fCalc==null)
            return;
        if(fCalc.getfStrFirstNum()!=null)
            fTvFirst.setText(fCalc.getfStrFirstNum().toString());
        if(fCalc.getfStrSecondNum()!=null)
            fTvSecond.setText(fCalc.getfStrSecondNum().toString());

    }


}