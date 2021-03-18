package com.example.myapplication.Users;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class CreareCont extends AppCompatActivity {

   // TextView mtextView, mtextView2, mtextView3, mtextView5, mtextView6, mtextView8, mtextView9, mUsername_obligatoriu, mparola_obligatorie;
    EditText mNume, mPrenume, mEmail, mTelefon, mParola;
    Button mbuttonCreareCont, mLogin;
    FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creare_cont);

        mNume = findViewById(R.id.Nume);
        mPrenume = findViewById(R.id.Prenume);
        mEmail = findViewById(R.id.Email);
        mTelefon = findViewById(R.id.Telefon);
        mParola = findViewById(R.id.Parola);
        mbuttonCreareCont = findViewById(R.id.buttonCreareCont);
        mLogin = findViewById(R.id.Loginbutton);

        firebaseAuth = FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser() != null) {  // daca user-ul este deja conectat
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }

        mbuttonCreareCont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nume = mNume.getText().toString().trim();
                String prenume = mPrenume.getText().toString().trim();
                String email = mEmail.getText().toString().trim();
                String parola = mParola.getText().toString().trim();

                firebaseAuth = FirebaseAuth.getInstance();

                if(TextUtils.isEmpty(nume)){
                    mNume.setError("Completarea acestui câmp este obligatorie!");
                    return;
                }

                if(TextUtils.isEmpty(prenume)){
                    mPrenume.setError("Completarea acestui câmp este obligatorie!");
                    return;
                }

                if(TextUtils.isEmpty(email)){
                    mEmail.setError("Completarea acestui câmp este obligatorie!");
                    return;
                }

                if(TextUtils.isEmpty(parola)){
                    mParola.setError("Completarea acestui câmp este obligatorie!");
                    return;
                }

                firebaseAuth.createUserWithEmailAndPassword(email, parola).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(CreareCont.this, " Cont creat cu succes! ", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));

                        } else {
                            Toast.makeText(CreareCont.this, " Eroare! " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

        mLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Autentificare.class));
            }
        });

    }
}