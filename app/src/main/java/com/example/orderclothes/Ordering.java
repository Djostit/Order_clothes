package com.example.orderclothes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class Ordering extends AppCompatActivity {
    String login;
    String password;
    String Gender;

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

    Spinner Headgear_female;
    Spinner Outerwear_female;
    Spinner Underwear_female;
    Spinner Shoes_female;

    Button Place_an_order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ordering);

        Bundle arg = getIntent().getExtras();

        login = arg.get("login").toString();
        password = arg.get("password").toString();

        TextView text_login = findViewById(R.id.text_login);

        text_login.setText(String.format("Hi, %s. What are you interested in?", login));

        Gender = arg.get("gender").toString();

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

        Headgear_female = findViewById(R.id.Headgear_female);
        Outerwear_female = findViewById(R.id.Outerwear_female);
        Underwear_female = findViewById(R.id.Underwear_female);
        Shoes_female = findViewById(R.id.Shoes_female);

        Headgear_female.setVisibility(View.GONE);
        Outerwear_female.setVisibility(View.GONE);
        Underwear_female.setVisibility(View.GONE);
        Shoes_female.setVisibility(View.GONE);

        Place_an_order = findViewById(R.id.Place_an_order);

        Place_an_order.setVisibility(View.GONE);

        if(Gender.equals("Male")){
            if(select_size_text.getVisibility() == View.INVISIBLE){
                select_size_text.setVisibility(View.VISIBLE);
                select_size.setVisibility(View.VISIBLE);

                select_type_text.setVisibility(View.VISIBLE);
                select_type.setVisibility(View.VISIBLE);

                button_get.setVisibility(View.VISIBLE);
            }
        }
        else if(Gender.equals("Female")){
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
        switch (OutTypeCloth(select_type.getSelectedItemPosition(), 1)){
            case "Headgear":
                if(male.isChecked()){
                    Headgear_male.setVisibility(View.VISIBLE);
                    Outerwear_male.setVisibility(View.GONE);
                    Underwear_male.setVisibility(View.GONE);
                    Shoes_male.setVisibility(View.GONE);

                    Headgear_female.setVisibility(View.GONE);
                    Outerwear_female.setVisibility(View.GONE);
                    Underwear_female.setVisibility(View.GONE);
                    Shoes_female.setVisibility(View.GONE);

                }
                else if(female.isChecked()){
                    Headgear_female.setVisibility(View.VISIBLE);
                    Outerwear_female.setVisibility(View.GONE);
                    Underwear_female.setVisibility(View.GONE);
                    Shoes_female.setVisibility(View.GONE);

                    Headgear_male.setVisibility(View.GONE);
                    Outerwear_male.setVisibility(View.GONE);
                    Underwear_male.setVisibility(View.GONE);
                    Shoes_male.setVisibility(View.GONE);
                }
                break;
            case "Outerwear":
                if(male.isChecked()){
                    Headgear_male.setVisibility(View.GONE);
                    Outerwear_male.setVisibility(View.VISIBLE);
                    Underwear_male.setVisibility(View.GONE);
                    Shoes_male.setVisibility(View.GONE);

                    Headgear_female.setVisibility(View.GONE);
                    Outerwear_female.setVisibility(View.GONE);
                    Underwear_female.setVisibility(View.GONE);
                    Shoes_female.setVisibility(View.GONE);
                }
                else if(female.isChecked()){
                    Headgear_female.setVisibility(View.GONE);
                    Outerwear_female.setVisibility(View.VISIBLE);
                    Underwear_female.setVisibility(View.GONE);
                    Shoes_female.setVisibility(View.GONE);

                    Headgear_male.setVisibility(View.GONE);
                    Outerwear_male.setVisibility(View.GONE);
                    Underwear_male.setVisibility(View.GONE);
                    Shoes_male.setVisibility(View.GONE);
                }
                break;
            case "Underwear":
                if(male.isChecked()){
                    Headgear_male.setVisibility(View.GONE);
                    Outerwear_male.setVisibility(View.GONE);
                    Underwear_male.setVisibility(View.VISIBLE);
                    Shoes_male.setVisibility(View.GONE);

                    Headgear_female.setVisibility(View.GONE);
                    Outerwear_female.setVisibility(View.GONE);
                    Underwear_female.setVisibility(View.GONE);
                    Shoes_female.setVisibility(View.GONE);
                }
                else if(female.isChecked()){
                    Headgear_female.setVisibility(View.GONE);
                    Outerwear_female.setVisibility(View.GONE);
                    Underwear_female.setVisibility(View.VISIBLE);
                    Shoes_female.setVisibility(View.GONE);

                    Headgear_male.setVisibility(View.GONE);
                    Outerwear_male.setVisibility(View.GONE);
                    Underwear_male.setVisibility(View.GONE);
                    Shoes_male.setVisibility(View.GONE);
                }
                break;
            case "Shoes":
                if(male.isChecked()) {
                    Headgear_male.setVisibility(View.GONE);
                    Outerwear_male.setVisibility(View.GONE);
                    Underwear_male.setVisibility(View.GONE);
                    Shoes_male.setVisibility(View.VISIBLE);

                    Headgear_female.setVisibility(View.GONE);
                    Outerwear_female.setVisibility(View.GONE);
                    Underwear_female.setVisibility(View.GONE);
                    Shoes_female.setVisibility(View.GONE);
                }
                else if(female.isChecked()){
                    Headgear_female.setVisibility(View.GONE);
                    Outerwear_female.setVisibility(View.GONE);
                    Underwear_female.setVisibility(View.GONE);
                    Shoes_female.setVisibility(View.VISIBLE);

                    Headgear_male.setVisibility(View.GONE);
                    Outerwear_male.setVisibility(View.GONE);
                    Underwear_male.setVisibility(View.GONE);
                    Shoes_male.setVisibility(View.GONE);
                }
                break;
        }
        Place_an_order.setVisibility(View.VISIBLE);
    }
    public String OutTypeCloth(int SelectedItemPosition, int sel){
        switch (sel){
            case 1:
                String[] array_cloth = getResources().getStringArray(R.array.array_type_cloth);
                return array_cloth[SelectedItemPosition];
            case 2:
                String[] array_size = getResources().getStringArray(R.array.array_size);
                return array_size[SelectedItemPosition];

            case 3:
                String[] array_male_head = getResources().getStringArray(R.array.array_Headgear_male);
                return array_male_head[SelectedItemPosition];
            case 4:
                String[] array_male_out = getResources().getStringArray(R.array.array_Outerwear_male);
                return array_male_out[SelectedItemPosition];
            case 5:
                String[] array_male_under = getResources().getStringArray(R.array.array_Underwear_male);
                return array_male_under[SelectedItemPosition];
            case 6:
                String[] array_male_shoes = getResources().getStringArray(R.array.array_Shoes_male);
                return array_male_shoes[SelectedItemPosition];

            case 7:
                String[] array_female_head = getResources().getStringArray(R.array.array_Headgear_female);
                return array_female_head[SelectedItemPosition];
            case 8:
                String[] array_female_out = getResources().getStringArray(R.array.array_Outerwear_female);
                return array_female_out[SelectedItemPosition];
            case 9:
                String[] array_female_under = getResources().getStringArray(R.array.array_Underwear_female);
                return array_female_under[SelectedItemPosition];
            case 10:
                String[] array_female_shoes = getResources().getStringArray(R.array.array_Shoes_female);
                return array_female_shoes[SelectedItemPosition];
        }
        return "";
    }

    public void PlaceAnOrder(View view) {
        Intent intent = new Intent(this, Order_check.class);

        intent.putExtra("login", login);
        intent.putExtra("password", password);

        String gender = "";
        String cloth = "";

        if(male.isChecked()){
            gender = "Male";
            switch (OutTypeCloth(select_type.getSelectedItemPosition(), 1)){
                case "Headgear":
                    cloth = OutTypeCloth(Headgear_male.getSelectedItemPosition(), 3);
                    break;
                case "Outerwear":
                    cloth = OutTypeCloth(Outerwear_male.getSelectedItemPosition(), 4);
                    break;
                case "Underwear":
                    cloth = OutTypeCloth(Underwear_male.getSelectedItemPosition(), 5);
                    break;
                case "Shoes":
                    cloth = OutTypeCloth(Shoes_male.getSelectedItemPosition(), 6);
                    break;
            }
        }
        else if(female.isChecked()){
            gender = "Female";
            switch (OutTypeCloth(select_type.getSelectedItemPosition(), 1)){
                case "Headgear":
                    cloth = OutTypeCloth(Headgear_female.getSelectedItemPosition(), 7);
                    break;
                case "Outerwear":
                    cloth = OutTypeCloth(Outerwear_female.getSelectedItemPosition(), 8);
                    break;
                case "Underwear":
                    cloth = OutTypeCloth(Underwear_female.getSelectedItemPosition(), 9);
                    break;
                case "Shoes":
                    cloth = OutTypeCloth(Shoes_female.getSelectedItemPosition(), 10);
                    break;
            }
        }
        intent.putExtra("gender", gender);
        intent.putExtra("size", OutTypeCloth(select_size.getSelectedItemPosition(), 2));
        intent.putExtra("type_cloth", OutTypeCloth(select_type.getSelectedItemPosition(), 1));
        intent.putExtra("cloth", cloth);

        startActivity(intent);
    }
}