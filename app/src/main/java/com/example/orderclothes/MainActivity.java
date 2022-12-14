package com.example.orderclothes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void GoToOrder(View view) {
        TextView text_log = findViewById(R.id.login);
        TextView text_pass = findViewById(R.id.password);

        //String login = ;
        //String password = ;

        if(text_log.getText().toString().isEmpty() ||
                text_pass.getText().toString().isEmpty()){
            Toast toast = Toast.makeText(this, "Empty", Toast.LENGTH_SHORT);
            toast.show();
            return;
        }

        Intent intent = new Intent(this, ChoiceGender.class);

        intent.putExtra("login", text_log.getText().toString());
        intent.putExtra("password", text_pass.getText().toString());

        startActivity(intent);
    }
}