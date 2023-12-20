package com.example.profilukm;
import static com.example.profilukm.DatabaseHelper.COLUMN_ID;
import static com.example.profilukm.DatabaseHelper.COLUMN_FOTO;
import static com.example.profilukm.DatabaseHelper.COLUMN_NAMA;
import static com.example.profilukm.DatabaseHelper.COLUMN_SINGKATAN;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class CustomCursorAdapter extends CursorAdapter {

    public CustomCursorAdapter(Context context, Cursor cursor) {
        super(context, cursor, 0);
    }
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.item_ukm, parent, false);
    }
    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView namaTextView = view.findViewById(R.id.nama_ukm);
        TextView singkatanTextView = view.findViewById(R.id.nama_singkat_ukm);
        ImageView fotoImageView = view.findViewById(R.id.logo_ukm);
        int idPr = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_ID));
        long id = cursor.getLong(cursor.getColumnIndexOrThrow("_id"));
        String nama = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_NAMA));
        String singkatan = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_SINGKATAN));
        int foto = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_FOTO));

        namaTextView.setText(nama);
        singkatanTextView.setText(singkatan);
        Glide.with(context).load(foto).into(fotoImageView);
        view.setOnClickListener(view1 -> {
            context.startActivity(new Intent(context,DetailActivity.class).putExtra("id",idPr));
        });

    }
}
