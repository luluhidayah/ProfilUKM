package com.example.profilukm;

import static com.example.profilukm.DatabaseHelper.COLUMN_AGENDA;
import static com.example.profilukm.DatabaseHelper.COLUMN_IG;
import static com.example.profilukm.DatabaseHelper.COLUMN_MISI;
import static com.example.profilukm.DatabaseHelper.COLUMN_NAMA;
import static com.example.profilukm.DatabaseHelper.COLUMN_PENCAPAIAN;
import static com.example.profilukm.DatabaseHelper.COLUMN_SINGKATAN;
import static com.example.profilukm.DatabaseHelper.COLUMN_TELEPON;
import static com.example.profilukm.DatabaseHelper.COLUMN_VISI;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {
    private DatabaseHelper databaseHelper;
    private TextView tvNama, tvVisi, tvMisi, tvAgenda, tvPencapaian, tvIg, tvTelepon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        int id = getIntent().getExtras().getInt("id");
        databaseHelper = new DatabaseHelper(this);
        tvNama = findViewById(R.id.tv_nama);
        tvVisi = findViewById(R.id.visi);
        tvMisi = findViewById(R.id.misi);
        tvAgenda = findViewById(R.id.tv_agenda);
        tvPencapaian = findViewById(R.id.tv_pencapaian);
        tvIg = findViewById(R.id.tv_ig);
        tvTelepon = findViewById(R.id.tv_telepon);
        Cursor cursor = databaseHelper.getDataById(id);

        if (cursor.moveToFirst()) {
            String nama = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_NAMA));
            String singkatan = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_SINGKATAN));
            String agenda = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_AGENDA));
            String pencapaian = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_PENCAPAIAN));
            String visi = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_VISI));
            String misi = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_MISI));
            String ig = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_IG));
            String telepon = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TELEPON));
            tvNama.setText(nama);
            tvVisi.setText("VISI : "+visi);
            tvMisi.setText("MISI : "+misi);
            tvAgenda.setText("Agenda UKM "+singkatan+":"+agenda);
            tvPencapaian.setText("Pencapaian UKM "+singkatan+":"+pencapaian);
            tvIg.setText(ig);
            tvTelepon.setText(telepon);
        }

        cursor.close();
    }

}
