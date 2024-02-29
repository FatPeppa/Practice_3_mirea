package com.example.practice_3_mirea;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class Second_activity extends AppCompatActivity {
    //Реализация через фрагменты
    public Second_activity() {
        super(R.layout.activity_second);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.fragment_container_view2,
                            SecondFragment.class, null)
                    .commit();
        }
    }
}