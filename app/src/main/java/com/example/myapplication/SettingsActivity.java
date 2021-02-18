package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.radiobutton.MaterialRadioButton;

public class SettingsActivity extends AppCompatActivity {

    private String fStateSettings;
    private RadioButton fRbCat;
    private RadioButton fRbDog;
    private MaterialRadioButton fRb;
    private RadioGroup fRbGroup;
    private Button fBtBack;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        initView();
    }

    private void initView() {
        fStateSettings = (String) getIntent().getStringExtra(MainActivity.BACKGROUND_PIC);
        fBtBack =  findViewById(R.id.bt_back);
        fRbCat =  findViewById(R.id.rb_backCat);
        fRbGroup = findViewById(R.id.rb_gr);
        fRbDog =  findViewById(R.id.rb_backDog);

        try {
            if (fStateSettings.equals("CAT"))
                fRbCat.setChecked(true);
            else if (fStateSettings.equals("DOG"))
                fRbDog.setChecked(true);

            fBtBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    exitWithResult();
                }
            });
        }
        catch (Exception e) {
            Toast toast = Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT);
            toast.show();
        }
    }


    private void exitWithResult() {
        makeAnswer();
        Intent xIntent = new Intent();
        xIntent.putExtra("answ", fStateSettings);
        setResult(Activity.RESULT_OK, xIntent);
        finish();
    }

    private void makeAnswer() {
        Integer xId = fRbGroup.getCheckedRadioButtonId();
        switch (xId) {
            case -1: {
                Toast toast = Toast.makeText(this, "Выберите фон!", Toast.LENGTH_SHORT);
                toast.show();
            }
            break;
            case R.id.rb_backCat: {
                fStateSettings = "CAT";
            }
            break;
            case R.id.rb_backDog: {
                fStateSettings = "DOG";
            }
            break;
        }
    }
}

