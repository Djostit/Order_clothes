package com.example.orderclothes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

public class Ordering extends AppCompatActivity {
    String gender;
    ArrayAdapter<String> adapter;
    ListView countriesList;
    Spinner select_size;
    TextView Count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ordering);

        Bundle arg = getIntent().getExtras();

        gender = arg.get("gender").toString();

        countriesList = findViewById(R.id.countriesList);

        select_size = findViewById(R.id.select_size);

        Count = findViewById(R.id.Count);

        SeekBar seekBar = findViewById(R.id.seekBar);
        Count.setText(String.format("Count: %s", String.valueOf(seekBar.getProgress())));

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                // textView.setText(String.valueOf(progress));
                Count.setText(String.format("Count: %s", String.valueOf(progress)));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        switch (arg.get("typeCloth").toString()){
            case "Headgear":
                if(gender.equals("Male")){
                    adapter = new ArrayAdapter(this,
                            android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.array_Headgear_male));
                }
                else{
                    adapter = new ArrayAdapter(this,
                            android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.array_Headgear_female));
                }
                break;
            case "Outerwear":
                if(gender.equals("Male")){
                    adapter = new ArrayAdapter(this,
                            android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.array_Outerwear_male));
                }
                else{
                    adapter = new ArrayAdapter(this,
                            android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.array_Outerwear_female));
                }
                break;
            case "Underwear":
                if(gender.equals("Male")){
                    adapter = new ArrayAdapter(this,
                            android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.array_Underwear_male));
                }
                else{
                    adapter = new ArrayAdapter(this,
                            android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.array_Underwear_female));
                }
                break;
            case "Shoes":
                if(gender.equals("Male")){
                    adapter = new ArrayAdapter(this,
                            android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.array_Shoes_male));
                }
                else{
                    adapter = new ArrayAdapter(this,
                            android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.array_Shoes_female));
                }
                break;
        }

        countriesList.setAdapter(adapter);
        Intent intent = new Intent(getApplicationContext(), Order_check.class);

        intent.putExtra("login", arg.get("login").toString());
        intent.putExtra("password", arg.get("password").toString());
        intent.putExtra("gender", gender);
        intent.putExtra("typeCloth", arg.get("typeCloth").toString());
        countriesList.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id)
            {
                intent.putExtra("cloth", countriesList.getItemAtPosition(position).toString());
                intent.putExtra("size", select_size.getSelectedItem().toString());

                intent.putExtra("count", String.valueOf(seekBar.getProgress()));

                startActivity(intent);
            }
        });
    }

}