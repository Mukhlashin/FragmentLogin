package com.example.fragmentlogin;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.fragmentlogin.login.LoginFragment;

public class MainActivity extends AppCompatActivity {

    public static FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fm = getSupportFragmentManager();
        fm.beginTransaction()
                .add(R.id.login_main_container, new LoginFragment())
                .addToBackStack("")
                .commit();
    }
}
