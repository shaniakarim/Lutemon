package com.example.lutemon.ui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.lutemon.R;
import com.example.lutemon.battle.Battle;
import com.example.lutemon.model.*;
import com.example.lutemon.storage.Storage;

public class MainActivity extends AppCompatActivity {

    Storage storage = new Storage();
    int pinkId, blackId;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnCreate = findViewById(R.id.btnCreate);
        Button btnBattle = findViewById(R.id.btnBattle);
        TextView textLog = findViewById(R.id.textLog);

        btnCreate.setOnClickListener(v -> {
            Lutemon pink = new Pink("Pinky");
            Lutemon black = new Black("Shadow");
            pinkId = storage.addLutemon(pink);
            blackId = storage.addLutemon(black);
            textLog.setText("Created Pinky and Shadow!");
        });

        btnBattle.setOnClickListener(v -> {
            Lutemon pink = storage.getLutemon(pinkId);
            Lutemon black = storage.getLutemon(blackId);
            String result = Battle.startBattle(pink, black);
            textLog.setText(result);
        });
    }
}
