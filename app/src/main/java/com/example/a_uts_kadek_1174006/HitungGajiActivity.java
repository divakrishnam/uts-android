package com.example.a_uts_kadek_1174006;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HitungGajiActivity extends AppCompatActivity {

    TextView tvNama, tvJabatan, tvGaji, tvTunjangan, tvPotongan, tvTotal;
    Button btnHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hitung_gaji);

        tvNama = findViewById(R.id.tv_nama);
        tvJabatan = findViewById(R.id.tv_jabatan);
        tvGaji = findViewById(R.id.tv_gaji);
        tvTunjangan = findViewById(R.id.tv_tunjangan);
        tvPotongan = findViewById(R.id.tv_potongan);
        tvTotal = findViewById(R.id.tv_total);
        btnHome = findViewById(R.id.btn_home);

        SharedPref pref = new SharedPref(getApplicationContext());

        int potongan = getIntent().getIntExtra("POTONGAN", 0);
        int gaji = getIntent().getIntExtra("GAJI", 0);
        int tunjangan = getIntent().getIntExtra("TUNJANGAN", 0);

        int total = gaji + tunjangan - potongan;

        tvNama.setText(pref.getUserName());
        tvJabatan.setText(pref.getEmail());
        tvTunjangan.setText(String.valueOf(tunjangan));
        tvPotongan.setText(String.valueOf(potongan));
        tvGaji.setText(String.valueOf(gaji));

        tvTotal.setText(String.valueOf(total));


        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
            }
        });

    }
}
