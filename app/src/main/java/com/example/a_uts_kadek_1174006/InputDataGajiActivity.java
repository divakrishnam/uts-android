package com.example.a_uts_kadek_1174006;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class InputDataGajiActivity extends AppCompatActivity {

    EditText etNama, etGaji, etTunjangan, etPotongan;
    RadioGroup rgJabatan;
    RadioButton rbKP, rbS, rbKB;
    Button btnHitung;

    int gaji, tunjangan, potongan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_data_gaji);

        etNama = findViewById(R.id.et_nama);
        etGaji = findViewById(R.id.et_gaji);
        etTunjangan = findViewById(R.id.et_tunjangan);
        etPotongan = findViewById(R.id.et_potongan);
        rgJabatan = findViewById(R.id.rg_jabatan);
        rbKP = findViewById(R.id.rb_kp);
        rbS = findViewById(R.id.rb_s);
        rbKB = findViewById(R.id.rb_kb);
        btnHitung = findViewById(R.id.btn_hitung);

        SharedPref pref = new SharedPref(getApplicationContext());
        etNama.setText(pref.getUserName());

        rgJabatan.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.rb_kp) {
                    gaji = 10000000;
                    tunjangan = 70 * gaji / 100;
                    etGaji.setText("Rp." + gaji);
                    etTunjangan.setText("Rp." + tunjangan);
                } else if (checkedId == R.id.rb_s) {
                    gaji = 5000000;
                    tunjangan = 30 * gaji / 100;
                    etGaji.setText("Rp." + gaji);
                    etTunjangan.setText("Rp." + tunjangan);
                } else if (checkedId == R.id.rb_kb) {
                    gaji = 4500000;
                    tunjangan = 45 * gaji / 100;
                    etGaji.setText("Rp." + gaji);
                    etTunjangan.setText("Rp." + tunjangan);
                }
            }
        });

        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((rbKB.isChecked() || rbS.isChecked() || rbKP.isChecked())) {
                    Intent result = new Intent(getApplicationContext(), HitungGajiActivity.class);
                    if (etPotongan.getText().toString().isEmpty()) {
                        potongan = 0;
                        result.putExtra("POTONGAN", potongan);
                    } else {
                        potongan = Integer.parseInt(etPotongan.getText().toString());
                        result.putExtra("POTONGAN", potongan);
                    }

                    if (rbKP.isChecked()) {
                        gaji = 10000000;
                        tunjangan = 70 * gaji / 100;
                        result.putExtra("GAJI", gaji);
                        result.putExtra("TUNJANGAN", tunjangan);
                    } else if (rbS.isChecked()) {
                        gaji = 5000000;
                        tunjangan = 30 * gaji / 100;
                        result.putExtra("GAJI", gaji);
                        result.putExtra("TUNJANGAN", tunjangan);
                    } else if (rbKB.isChecked()) {
                        gaji = 4500000;
                        tunjangan = 45 * gaji / 100;
                        result.putExtra("GAJI", gaji);
                        result.putExtra("TUNJANGAN", tunjangan);
                    }
                startActivity(result);
            }else

            {

                Toast.makeText(getApplicationContext(), "Data inputan tidak boleh kosong", Toast.LENGTH_SHORT).show();
            }
        }
    });


}
}
