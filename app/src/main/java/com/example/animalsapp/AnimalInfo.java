package com.example.animalsapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class AnimalInfo extends AppCompatActivity {

    ImageView img, backButton;
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_info);

        img = findViewById(R.id.imgCircled);
        backButton=findViewById(R.id.backButton);
        txt = findViewById(R.id.animal);

        Intent intent = getIntent();

        img.setImageResource(intent.getIntExtra("image", R.drawable.ic_launcher_foreground));
        txt.setText(intent.getStringExtra("name"));
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(AnimalInfo.this, MainActivity.class);
                startActivity(intent1);
            }
        });


    }
}
