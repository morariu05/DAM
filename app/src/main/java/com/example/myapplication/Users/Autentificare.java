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

public class Autentificare extends AppCompatActivity {

    EditText mEmail, mParola;
    Button mLogin, mRegister;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autentificare);

        mEmail = findViewById(R.id.Email);
        mParola = findViewById(R.id.Parola);
        mLogin = findViewById(R.id.Loginbutton);
        mRegister = findViewById(R.id.RegisterButton);

        firebaseAuth = FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser() != null) {  // daca user-ul este deja conectat
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }

        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mEmail.getText().toString().trim();
                String parola = mParola.getText().toString().trim();

                firebaseAuth = FirebaseAuth.getInstance();

                if (TextUtils.isEmpty(email)) {
                    mEmail.setError("Completarea acestui câmp este obligatorie!");
                    return;
                }

                if (TextUtils.isEmpty(parola)) {
                    mParola.setError("Completarea acestui câmp este obligatorie!");
                    return;
                }

                firebaseAuth.signInWithEmailAndPassword(email, parola).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(Autentificare.this, " Autentificare realizata cu succes! ", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        }
                        else
                        {
                            Toast.makeText(Autentificare.this, " Eroare de autentificare! " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

        mRegister.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), CreareCont.class));
            }
        });

    }
}