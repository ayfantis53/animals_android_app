package com.example.animalsapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AnimalAdapter.MyClickInterface {

    RecyclerView recyclerView;
    ArrayList<Animal> animals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_AnimalsApp);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        animals = new ArrayList<>();

        animals.add(new Animal("Dolphin", R.drawable.dolphin));
        animals.add(new Animal("Turtle", R.drawable.turtle));
        animals.add(new Animal("Parrot", R.drawable.parrot));
        animals.add(new Animal("Rabbit", R.drawable.rabbit));
        animals.add(new Animal("Tiger", R.drawable.tiger));
        animals.add(new Animal("Owl", R.drawable.owl));
        animals.add(new Animal("Lion", R.drawable.lion));
        animals.add(new Animal("Wolf", R.drawable.wolf));

        
        AnimalAdapter animalAdapter = new AnimalAdapter(animals, this , this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(animalAdapter);

    }

    @Override
    public void onItemClick(int positionOfTheAnimal) {
        Toast.makeText(this,"Clicked " + animals.get(positionOfTheAnimal).getName(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, AnimalInfo.class);
        intent.putExtra("image", animals.get(positionOfTheAnimal).getImage());
        intent.putExtra("name", animals.get(positionOfTheAnimal).getName());
        startActivity(intent);
    }
}