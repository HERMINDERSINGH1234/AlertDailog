package com.example.sunshine.alertdailog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.preference.DialogPreference;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnSimple = findViewById(R.id.btnSimple);
        Button btnComplex = findViewById(R.id.btnComplex);


        final AlertDialog alertDialog = new AlertDialog.Builder(this).setTitle("Hello from Alert Dialog")
                .setCancelable(false)
                .setMessage("Hi I'm a sample message!")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "Positive button clicked", Toast.LENGTH_SHORT).show();

                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "Negative button clicked", Toast.LENGTH_SHORT).show();
                    }
                })
                .create();

        btnSimple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.show();
            }
        });



        final View dialogView=LayoutInflater.from(this).inflate(R.layout.dialog_view,null,true);



        final AlertDialog customDialog =new AlertDialog.Builder(this).setTitle("Complex Alert Dialog")
                .setView(dialogView)
                .setPositiveButton("Post", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                EditText emailEt= dialogView.findViewById(R.id.etEmail);
                EditText passwordEt=dialogView.findViewById(R.id.etPassword);

                String email=emailEt.getText().toString();
                String password=passwordEt.getText().toString();
                //Toast.makeText(MainActivity.this,"wrong info",Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this,email+ "   " +password, Toast.LENGTH_SHORT).show();

                //Create a new User
                //Send a new broadcast
            }

        }).create();

        btnComplex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customDialog.show();
            }
        });

    }
}
