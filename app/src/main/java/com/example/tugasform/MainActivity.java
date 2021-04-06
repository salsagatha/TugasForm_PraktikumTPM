package com.example.tugasform;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.view.View;
import android.text.TextUtils;

public class MainActivity extends AppCompatActivity {
    private EditText eNama,eNIM,eNilai;
    private TextView tNama,tNIM,tNilai;
    private Button bSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eNama   = findViewById(R.id.etNama);
        eNIM    = findViewById(R.id.etNIM);
        eNilai  = findViewById(R.id.etNilai);

        bSubmit = findViewById(R.id.btnSubmit);
        bSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sNama  = eNama.getText().toString().trim();
                String sNIM   = eNIM.getText().toString().trim();
                String sNilai = eNilai.getText().toString().trim();

                if(TextUtils.isEmpty(sNama)){
                    eNama.setError("Masukkan Nama Anda!");
                }
                else if(TextUtils.isEmpty(sNIM)){
                    eNIM.setError("Masukkan NIM Anda!");
                }
                else if(TextUtils.isEmpty(sNilai)){
                    eNilai.setError("Masukkan Nilai Anda!");
                }
                else {
                    double nilai = Double.parseDouble(sNilai);
                    sNilai = convertnilai(nilai);
                    setContentView(R.layout.output);

                    tNama = findViewById(R.id.tvNama);
                    tNIM = findViewById(R.id.tvNIM);
                    tNilai = findViewById(R.id.tvNilai);

                    tNama.setText("Nama : " + sNama);
                    tNIM.setText("NIM    : " + sNIM);
                    tNilai.setText("Nilai    : " + sNilai);
                }
            }
        });
    }

    protected String convertnilai(double nilai){
        if (nilai > 3.66 && nilai <= 4 ){
            return "A";
        }
        else if(nilai > 3.33 && nilai <= 3.66 ){
            return "A-";
        }
        else if(nilai > 3 && nilai <= 3.33 ){
            return "B+";
        }
        else if(nilai > 2.66 && nilai <= 3 ){
            return "B";
        }
        else if(nilai > 2.33 && nilai <= 2.66 ){
            return "B-";
        }
        else if(nilai > 2 && nilai <= 2.33 ){
            return "C+";
        }
        else if(nilai > 1.66 && nilai <= 2 ){
            return "C";
        }
        else if(nilai > 1.33 && nilai <= 1.66 ){
            return "C-";
        }
        else if(nilai > 1 && nilai <= 1.33 ){
            return "D+";
        }
        else if(nilai >= 0 && nilai <= 1 ){
            return "D";
        }
        else{
            return "Masukkan nilai dengan tepat!";
        }
    }
}