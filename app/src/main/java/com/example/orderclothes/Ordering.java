package com.example.orderclothes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class Ordering extends AppCompatActivity {
    String login;
    String password;

    TextView select_size_text;
    Spinner select_size;

    TextView select_type_text;
    Spinner select_type;

    RadioButton male;
    RadioButton female;

    Button button_get;

    Spinner Headgear_male;
    Spinner Outerwear_male;
    Spinner Underwear_male;
    Spinner Shoes_male;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ordering);

        Bundle arg = getIntent().getExtras();

        login = arg.get("login").toString();
        password = arg.get("password").toString();

        TextView text_login = findViewById(R.id.text_login);

        text_login.setText(String.format("Hi, %s. What are you interested in?", login));

        male = findViewById(R.id.male);
        female = findViewById(R.id.woman);

        select_size_text = findViewById(R.id.select_size_text);
        select_size = findViewById(R.id.select_size);

        select_type_text = findViewById(R.id.select_type_text);
        select_type = findViewById(R.id.select_type);

        select_size_text.setVisibility(View.INVISIBLE);
        select_size.setVisibility(View.INVISIBLE);

        select_type_text.setVisibility(View.INVISIBLE);
        select_type.setVisibility(View.INVISIBLE);

        button_get = findViewById(R.id.button_get);

        button_get.setVisibility(View.INVISIBLE);

        Headgear_male = findViewById(R.id.Headgear_male);
        Outerwear_male = findViewById(R.id.Outerwear_male);
        Underwear_male = findViewById(R.id.Underwear_male);
        Shoes_male = findViewById(R.id.Shoes_male);

        Headgear_male.setVisibility(View.GONE);
        Outerwear_male.setVisibility(View.GONE);
        Underwear_male.setVisibility(View.GONE);
        Shoes_male.setVisibility(View.GONE);

    }

    public void ShowAddition(View view) {
        if(male.isChecked()){
            if(select_size_text.getVisibility() == View.INVISIBLE){
                select_size_text.setVisibility(View.VISIBLE);
                select_size.setVisibility(View.VISIBLE);

                select_type_text.setVisibility(View.VISIBLE);
                select_type.setVisibility(View.VISIBLE);

                button_get.setVisibility(View.VISIBLE);
            }
        }
        else if(female.isChecked()){
            if(select_size_text.getVisibility() == View.INVISIBLE){
                select_size_text.setVisibility(View.VISIBLE);
                select_size.setVisibility(View.VISIBLE);

                select_type_text.setVisibility(View.VISIBLE);
                select_type.setVisibility(View.VISIBLE);

                button_get.setVisibility(View.VISIBLE);
            }
        }
    }

    public void GetTypeCloth(View view) {
        if(OutTypeCloth(select_type.getSelectedItemPosition()).contains("Headgear")){
            if(male.isChecked()){
                Headgear_male.setVisibility(View.VISIBLE);
                Outerwear_male.setVisibility(View.GONE);
                Underwear_male.setVisibility(View.GONE);
                Shoes_male.setVisibility(View.GONE);
            }
            else if(female.isChecked()){

            }
        }
        else if(OutTypeCloth(select_type.getSelectedItemPosition()).contains("Outerwear")){
            if(male.isChecked()){
                Headgear_male.setVisibility(View.GONE);
                Outerwear_male.setVisibility(View.VISIBLE);
                Underwear_male.setVisibility(View.GONE);
                Shoes_male.setVisibility(View.GONE);
            }
            else if(female.isChecked()){

            }
        }
        else if(OutTypeCloth(select_type.getSelectedItemPosition()).contains("Underwear")){
            if(male.isChecked()){
                Headgear_male.setVisibility(View.GONE);
                Outerwear_male.setVisibility(View.GONE);
                Underwear_male.setVisibility(View.VISIBLE);
                Shoes_male.setVisibility(View.GONE);
            }
            else if(female.isChecked()){

            }
        }
        else if(OutTypeCloth(select_type.getSelectedItemPosition()).contains("Shoes")){
            if(male.isChecked()) {
                Headgear_male.setVisibility(View.GONE);
                Outerwear_male.setVisibility(View.GONE);
                Underwear_male.setVisibility(View.GONE);
                Shoes_male.setVisibility(View.VISIBLE);
            }
            else if(female.isChecked()){

            }
        }
    }
    public String OutTypeCloth(int SelectedItemPosition){
        String[] array = getResources().getStringArray(R.array.array_type_cloth);
        return array[SelectedItemPosition];
    }
}