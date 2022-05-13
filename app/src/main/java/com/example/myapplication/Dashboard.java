package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.AlertDialog;
import android.app.Application;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Dashboard extends AppCompatActivity implements View.OnClickListener{

    public CardView card1,card2,card3,card4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        card1=(CardView) findViewById(R.id.c1);
        card2=(CardView) findViewById(R.id.c2);
        card3=(CardView) findViewById(R.id.c3);
        card4=(CardView) findViewById(R.id.c4);

        card1.setOnClickListener(this);
        card2.setOnClickListener(this);
        card3.setOnClickListener(this);
        card4.setOnClickListener(this);
    }
        @Override
        public void onBackPressed(){
            AlertDialog.Builder builder = new AlertDialog.Builder(Dashboard.this);
            builder.setMessage("Do you really want to exit?");
            builder.setCancelable(true);
            builder.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    finishAffinity();
                }
            });
             builder.setPositiveButton("No", new DialogInterface.OnClickListener() {
                 @Override
                 public void onClick(DialogInterface dialogInterface, int i) {
                     dialogInterface.cancel();
                 }
             });
             AlertDialog alertDialog = builder.create();
             alertDialog.show();
        }


    @Override
    public void onClick(View v) {
        Intent i;
        switch (v.getId()){
            case R.id.c1:
                i = new Intent(this,Accounts.class);
                startActivity(i);
                break;
            case R.id.c2:
                i = new Intent(this,MainActivity.class);
                startActivity(i);
                break;
            case R.id.c3:
                i = new Intent(this,Feedback.class);
                startActivity(i);
                break;
            case R.id.c4:
                i = new Intent(this,ContactUs.class);
                startActivity(i);
                break;

        }

    }
}