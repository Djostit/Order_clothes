package com.example.orderclothes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class ChoiceGender extends AppCompatActivity {

    String login;
    String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice_gender);

        Bundle arg = getIntent().getExtras();
        login = arg.get("login").toString();
        password = arg.get("password").toString();

        ListView countriesList = findViewById(R.id.countriesList);

        Intent intent = new Intent(getApplicationContext(), Ordering.class);
        intent.putExtra("login", login);
        intent.putExtra("password", password);

        countriesList.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        intent.putExtra("gender", "Male");
                        startActivity(intent);
                        break;
                    case 1:
                        intent.putExtra("gender", "Female");
                        startActivity(intent);
                        break;
                }
            }
        });
    }
}