package com.example.a_uts_kadek_1174006;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    TextView tvFullname, tvEmail, tvPassword, tvCPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        SharedPref pref = new SharedPref(getApplicationContext());

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if(!pref.isLogin()){
            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
            finish();
        }

        tvFullname = findViewById(R.id.tv_fullname);
        tvEmail = findViewById(R.id.tv_email);
        tvPassword = findViewById(R.id.tv_password);
        tvCPassword = findViewById(R.id.tv_cpassword);

        tvFullname.setText(pref.getUserName());
        tvEmail.setText(pref.getEmail());
        tvPassword.setText(pref.getPass());
        tvCPassword.setText(pref.getCPass());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.profile){
            startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
        }else if (item.getItemId() == R.id.perusahaan){
            startActivity(new Intent(getApplicationContext(), ProfilePerusahaanActivity.class));
        }else if (item.getItemId() == R.id.hitung_gaji){
            startActivity(new Intent(getApplicationContext(), InputDataGajiActivity.class));
        }else if (item.getItemId() == R.id.logout){
            SharedPref pref = new SharedPref(getApplicationContext());
            pref.logout();
            finish();
            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
        }
        return true;
    }
}
