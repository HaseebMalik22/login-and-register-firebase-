package com.example.loginandregisterfirebase;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class signup extends AppCompatActivity {

    TextInputLayout fullname_var, username_var, email_var, phonenumber_var, password_var;
    Button register_btn,login_btn;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);


        fullname_var = findViewById(R.id.user_fullname_input);
        username_var = findViewById(R.id.username_input);
        email_var = findViewById(R.id.email_input);
        phonenumber_var = findViewById(R.id.number_input);
        password_var = findViewById(R.id.passwrod_signup);


    }



    public void loginbuttonclick(View view) {
        Intent intent = new Intent(getApplicationContext(), login.class);
        startActivity(intent);
        finish();


    }

    public void registerbuttonclick(View view) {

        String fullname_ = fullname_var.getEditText().getText().toString();
        String username_ = username_var.getEditText().getText().toString();
        String email_ = email_var.getEditText().getText().toString();
        String phonenumber_ = phonenumber_var.getEditText().getText().toString();
        String password_ = password_var.getEditText().getText().toString();

        if (!fullname_.isEmpty()) {
            fullname_var.setError(null);
            fullname_var.setErrorEnabled(false);
            if (!username_.isEmpty()) {
                username_var.setError(null);
                username_var.setErrorEnabled(false);
                if (!email_.isEmpty()) {
                    email_var.setError(null);
                    email_var.setErrorEnabled(false);
                    if (!phonenumber_.isEmpty()) {
                        phonenumber_var.setError(null);
                        phonenumber_var.setErrorEnabled(false);
                        if (!password_.isEmpty()) {
                            password_var.setError(null);
                            password_var.setErrorEnabled(false);
                            if (email_.matches("^[a-zA-Z0-9]+(?:\\.[a-zA-Z0-9]+)*@[a-zA-Z0-9]+(?:\\.[a-zA-Z0-9]+)*$\n")){



                                firebaseDatabase = firebaseDatabase.getInstance();
                                reference = firebaseDatabase.getReference("datauser");

                                String fullname_s = fullname_var.getEditText().getText().toString();
                                String username_s = username_var.getEditText().getText().toString();
                                String email_s = email_var.getEditText().getText().toString();
                                String phonenumber_s = phonenumber_var.getEditText().getText().toString();
                                String password_s = password_var.getEditText().getText().toString();

                                storingdata storingdatass = new storingdata(fullname_s,username_s,email_s,phonenumber_s,password_s);

                                reference.child(username_s).setValue(storingdatass);

                                Toast.makeText(getApplicationContext(), "successfully", Toast.LENGTH_SHORT).show();

                                Intent intent = new Intent(getApplicationContext(),dashboard.class);

                                startActivity(intent);
                                finish();



                            }else{
                                email_var.setError("invalid email");
                            }

                        } else {
                            password_var.setError("please enter your password");
                        }

                    } else {
                        phonenumber_var.setError("please enter your phone number");
                    }

                } else {
                    email_var.setError("please enter your email");
                }
            } else {
                username_var.setError("please enter the username");
            }
        } else {
            fullname_var.setError("please enter the fullname");
        }


    }
}
