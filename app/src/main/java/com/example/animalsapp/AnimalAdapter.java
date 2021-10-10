package com.example.animalsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class AnimalAdapter extends RecyclerView.Adapter<AnimalAdapter.AnimalHolder> {

    ArrayList<Animal> animalData;
    Context context;
    MyClickInterface myClickInterface;

    public AnimalAdapter(ArrayList<Animal> animalData, Context context, MyClickInterface myClickInterface) {
        this.animalData = animalData;
        this.context = context;
        this.myClickInterface = myClickInterface;
    }

    @NonNull
    @Override
    public AnimalHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.animal_card,parent,false);

        return new AnimalHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimalHolder holder, int position) {
        holder.txtAnimalName.setText(animalData.get(position).getName());
        holder.imgAnimal.setImageResource(animalData.get(position).getImage());
    }

    @Override
    public int getItemCount() {

        return animalData.size();
    }

    class AnimalHolder extends RecyclerView.ViewHolder{

        TextView txtAnimalName;
        ImageView imgAnimal;

        public AnimalHolder(@NonNull View itemView) {
            super(itemView);

            txtAnimalName = itemView.findViewById(R.id.txt_animal_name);
            imgAnimal = itemView.findViewById(R.id.img_animal);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    myClickInterface.onItemClick(getAdapterPosition());
                }
            });
        }
    }

    interface MyClickInterface{
        void onItemClick(int positionOfTheAnimal);
    }
}
