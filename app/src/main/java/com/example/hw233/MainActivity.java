package com.example.hw233;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private EditText email,subject,message;
    private TextInputLayout textInputLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.send);
        email=findViewById(R.id.email_text);
        subject=findViewById(R.id.subject_text);
        message=findViewById(R.id.message_text);
        textInputLayout=findViewById(R.id.email);
        String [] recipients={email.getText().toString()};
        button.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("plain/text");
            intent.putExtra(Intent.EXTRA_EMAIL, new String[]{email.getText().toString()});
            intent.putExtra(Intent.EXTRA_SUBJECT, subject.getText().toString());
            intent.putExtra(Intent.EXTRA_TEXT, message.getText());
            startActivity(intent);
        });
        findViewById(R.id.email).setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                textInputLayout.setStartIconTintList(hasFocus ? ColorStateList.valueOf(R.color.black) : ColorStateList.valueOf(R.color.pink));
            }
        });
    }
}