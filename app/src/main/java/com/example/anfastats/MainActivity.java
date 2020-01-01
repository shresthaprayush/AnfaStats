package com.example.anfastats;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.anfastats.ModelData.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    private EditText edittextpassword;
    Button button;
    private EditText editTextphonenumber;
    private String key;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.buttonLogin);
        imageView = findViewById(R.id.logoapp);
        editTextphonenumber = findViewById(R.id.TextboxUserName);
        edittextpassword = findViewById(R.id.TextViewPassword);

        imageView.setBackgroundResource(R.drawable.yeti);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checklogin();

            }
        });

    }

    private void checklogin() {

        String userphone = editTextphonenumber.getText().toString();
        String userpassword = edittextpassword.getText().toString();

        if (userpassword.isEmpty()){

            edittextpassword.setError("Please enter the password");
            edittextpassword.requestFocus();

        }

        if (userphone.isEmpty()){

            editTextphonenumber.setError("Please enter the username");
            edittextpassword.requestFocus();

        }

        Call<User> call = RetrofitClient.getmInstance().getretrofit(getApplicationContext()).verifylogin(userphone,userpassword);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User loginresponse = response.body();

                if (loginresponse.getError()==1){



                    Toast.makeText(MainActivity.this, "Invalid Username and Password ", Toast.LENGTH_SHORT).show();

                }

                else{
                    SharedPreferencemanager.getmInstance(MainActivity.this).saveUser(loginresponse);
                    Intent intent = new Intent(MainActivity.this,Activity2.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);


                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

                Toast.makeText(MainActivity.this, "Error"+t, Toast.LENGTH_SHORT).show();

            }
        });




    }
    @Override
    protected void onStart(){

        super.onStart();

        if (SharedPreferencemanager.getmInstance(this).isLoggedIn()) {

            Intent intent = new Intent(MainActivity.this, Activity2.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);

        }


    }

}
