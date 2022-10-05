package com.example.orderclothes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class ChoiceOfClothingType extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice_of_clothing_type);

        Bundle arg = getIntent().getExtras();

        ListView countriesList = findViewById(R.id.countriesList);

        Intent intent = new Intent(getApplicationContext(), Ordering.class);
        intent.putExtra("login", arg.get("login").toString());
        intent.putExtra("password", arg.get("password").toString());
        intent.putExtra("gender", arg.get("gender").toString());

        countriesList.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        intent.putExtra("typeCloth", "Headgear");
                        startActivity(intent);
                        break;
                    case 1:
                        intent.putExtra("typeCloth", "Outerwear");
                        startActivity(intent);
                        break;
                    case 2:
                        intent.putExtra("typeCloth", "Underwear");
                        startActivity(intent);
                        break;
                    case 3:
                        intent.putExtra("typeCloth", "Shoes");
                        startActivity(intent);
                        break;
                }
            }
        });
    }
}