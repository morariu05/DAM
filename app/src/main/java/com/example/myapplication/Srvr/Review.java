package com.example.myapplication.Srvr;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.Srvr.MessageSender;
import com.example.myapplication.Users.Autentificare;

public class Review extends AppCompatActivity {
    
    EditText e1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        e1 = findViewById(R.id.editText);
        final RatingBar ratingRatingBar = findViewById(R.id.ratingBar);
        Button button_rating = findViewById(R.id.button2);
        final TextView textView = findViewById(R.id.textView_rating);

        button_rating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                textView.setText("Your rating is: " + ratingRatingBar.getRating());
            }
        });

    }

    public void send(View v)
    {
        MessageSender messageSender = new MessageSender();
        messageSender.execute(e1.getText().toString());
        Toast.makeText(Review.this, " Review trimis cu succes! Îți mulțumim!", Toast.LENGTH_SHORT).show();
    }
}