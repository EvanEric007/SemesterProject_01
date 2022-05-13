package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Feedback extends AppCompatActivity {
    private EditText username, email, phone, feedback;
    private Button fire;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        username=findViewById(R.id.username);
        phone=findViewById(R.id.phone);
        email=findViewById(R.id.email);
        feedback=findViewById(R.id.feedback);
        fire=findViewById(R.id.fire);
        fire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Map<String, String> v=new HashMap<>();
                v.put("username",username.getText().toString());
                v.put("phone",phone.getText().toString());
                v.put("email",email.getText().toString());
                v.put("feedback",feedback.getText().toString());
                FirebaseFirestore.getInstance().collection("Vendor").add(v).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {


                    @Override
                    public void onComplete(@NonNull Task<DocumentReference> task) {
                    Toast.makeText(getApplicationContext(),"Thank You for the feedback",Toast.LENGTH_SHORT).show();
                    }

                });

            }
        });

    }


}