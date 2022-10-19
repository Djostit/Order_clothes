package com.example.orderclothes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Order_check extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_check);

        Bundle arg = getIntent().getExtras();

        TextView login = findViewById(R.id.login);
        TextView password = findViewById(R.id.password);

        login.setText(arg.get("login").toString());
        password.setText(arg.get("password").toString());

        TextView ur_gender = findViewById(R.id.ur_gender);

        ur_gender.setText(arg.get("gender").toString());

        TextView size = findViewById(R.id.size);

        size.setText(arg.get("size").toString());

        TextView type_of_clothes = findViewById(R.id.type_of_clothes);

        type_of_clothes.setText(arg.get("typeCloth").toString());

        TextView clothes = findViewById(R.id.clothes);

        clothes.setText(arg.get("cloth").toString());

        TextView count = findViewById(R.id.count);

        count.setText(arg.get("count").toString());
    }
}