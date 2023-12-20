package com.example.profilukm;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "your_database_name";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "your_table_name";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAMA = "nama";
    public static final String COLUMN_SINGKATAN = "singkatan";
    public static final String COLUMN_FOTO = "foto";
    public static final String COLUMN_AGENDA = "agenda";
    public static final String COLUMN_PENCAPAIAN = "pencapaian";
    public static final String COLUMN_VISI = "visi";
    public static final String COLUMN_MISI = "misi";
    public static final String COLUMN_IG = "ig";
    public static final String COLUMN_TELEPON = "telepon";

    // SQL query to create the table
    private static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "_id INTEGER," +
                    COLUMN_NAMA + " TEXT," +
                    COLUMN_SINGKATAN + " TEXT," +
                    COLUMN_FOTO + " INTEGER," +
                    COLUMN_AGENDA + " TEXT," +
                    COLUMN_PENCAPAIAN + " TEXT," +
                    COLUMN_VISI + " TEXT," +
                    COLUMN_MISI + " TEXT," +
                    COLUMN_IG + " TEXT," +
                    COLUMN_TELEPON+ " TEXT" +
                    ")";
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL(CREATE_TABLE);
            prepopulateData(db);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
    private boolean isTableEmpty(SQLiteDatabase db) {
        Cursor cursor = db.rawQuery("SELECT COUNT(*) FROM " + TABLE_NAME, null);
        cursor.moveToFirst();
        int count = cursor.getInt(0);
        cursor.close();
        return count == 0;
    }
    private void prepopulateData(SQLiteDatabase db) {
        if (isTableEmpty(db)) {
            insertData(db,
                    "Politeknik Pecinta Alam Lampung",
                    "POLTAPALA",
                    R.drawable.poltapala,
                    " \n * Latihan Pemantapan \n * Pelatihan Keorganisasian \n * Jambore Nasional \n * Lomba Lintas Alam Poltapala Nasional \n * Pendidikan Dasar \n * Latihan Dasar \n * Musyawarah Besar.",
                    " \n *Tahun 2016: UKM Teraktif \n *Tahun 2017: Juara III Lomba Lintas Alam Lereng Timur Gunung Tanggamus \n *Tahun 2019: Juara VII Lomba Lintas Alam Pemuda Se-Sumbagsel",
                    "Membentuk Kepribadian Mahasiswa yang Kreatif dan bertanggung jawab terhadap lingkungan masyarakat",
                    "Mewujudkan sumberdaya manusia yang peka terhadap alam dan lingkungan untuk melaksanakan fungsi sosial dan ikut serta mengatasi masalah alam, sosial dan lingkungan",
                    "@poltapala_lampung",
                    "08345678920"


                    );
            insertData(db,
                    "Seni dan Budaya",
                    "UKMBS",
                    R.drawable.ukmbs,
                    " \n * Latihan Pemantapan \n * Hari Peduli Sampah Nasional \n * Pelatihan Keorganisasian \n * Jambore Nasional \n * Lomba Lintas Alam Poltapala Nasional \n * Pendidikan Dasar \n * Latihan Dasar \n * Musyawarah Besar.",
                    "\n *Tahun 2019: Juara VII Lomba Lintas Alam Pemuda Se-Sumbagsel",
                    "Menyusun, melaksanakan dan mengvalusasi setiap program kerja yang telah disusun.\n"+
                            "Melaksanakan kegiatan yang dapat meningkatkan kreatifitas dan intergritas anggota ukmbs.\n"+
                            "membentuk anggota yang beretika",
                    "Menciptakan generasi muda yang berjiwa seni dan berkreatifitas tinggi dengan berlandaskan moral dan etika",
                    "@ukm_bspolinela",
                    "08345678920"

                    );
            insertData(db,
                    "Persatuan Suara",
                    "Per SUKMA",
                    R.drawable.sukma,
                    " \n * Sukma Fair 2023 ",
                    " \n *Tahun 2016: UKM Teraktif \n *Tahun 2017: Juara III Lomba Lintas Alam Lereng Timur Gunung Tanggamus ",
                    "Sebagai motor, dinamisator, stabilisator, mediator dan inspirator dalam dinamika pers kampus di Indonesia.",
                    "Mewujudkan masyarakat kampus yang kreatif, disiplin, komunikatif, bermoral, intelektual, menjunjung supremasi hukum, serta berwawasan luas.\n" +
                            "Sebagai wadah aktivitas, komunikasi, informasi dan media belajar antara anggota UKM Pers SUKMA dan civitas akademika lainnya.\n" +
                            "Wadah yang menampung dan menyalurkan aspirasi mahasiswa dan sivitas akademika lainnya.\n" +
                            "Melakukan kontrol sosial secara kritis, analisis, ilmiah dan bersifat membangun serta tidak memihak dalam memberi kontribusi untuk kemajuan Politeknik Negeri Lampung.",
                    "@perssukmapolinela",
                    "08345678920"


                    );
            insertData(db,
                    "Studi Mahasiswa Riset Terapan",
                    "SMART",
                    R.drawable.smart,
                    " \n 1. Kelas Karya Tulis Ilmiah \n 2. Training Anggota \n 3. Nyepeak Kampus Polinela",

                    "\n *Tahun 2016: UKM Teraktif \n *Tahun 2017: Juara III Lomba Lintas Alam Lereng Timur Gunung Tanggamus",
                    "Menjadi organisasi yang mencetak ilmuwan muda cerdas, kompetitif, profesional, dan berkarakter, dengan berlandaskan ilmu terapam",
                    "Meningkatkan SDM Smart Polinela yang memiliki daya saing guna meningkatkan mutu Smart Polinela,Menjadi wadah bagi mahasiswa Polinela untuk berinovasi dan berkreasi dalam lingkup keilmiahan, Menciptakan rasa kekeluargaan dan keakraban anatr anggota Smart Polinela",
                    "@kbm_smartpolinela",
                    "08345678920"
                    );
            insertData(db,
                    "Koperasi Mahasiswa",
                    "KOPMA",
                    R.drawable.kopma,
                    " \n 1. Diksar 2023 \n 2. Seminar Kewirausahaan \n 3. Bazzar LatDis 2023 \n 4. Pelatihan Manajemen Keuangan",
                    " \n *Tahun 2017: Juara III Lomba Lintas Alam Lereng Timur Gunung Tanggamus \n *Tahun 2019: Juara VII Lomba Lintas Alam Pemuda Se-Sumbagsel \n *Tahun 2019: Juara VI Lomba Lintas Alam Pemuda Se-Sumbagsel 2019 ",
                    "Membentuk Kepribadian Mahasiswa yang Kreatif dan bertanggung jawab terhadap lingkungan masyarakat",
                    "Mewujudkan sumberdaya manusia yang peka terhadap alam dan lingkungan untuk melaksanakan fungsi sosial dan ikut serta mengatasi masalah alam, sosial dan lingkungan",
                    "@kopma_polinela",
                    "08345678920"

                    );
            insertData(db,
                    "Olahraga",
                    "UKMO",
                    R.drawable.ukmo,
                    " \n 1. Polinela Sport Championship 2023 \n 2. Kongres Internal Olahraga \n 3. Pekan Olahraga ",
                    " \n *Tahun 2019: Juara VII Lomba Lintas Alam Pemuda Se-Sumbagsel \n *Tahun 2019: Juara VI Lomba Lintas Alam Pemuda Se-Sumbagsel 2019 ",
                    "Menciptakan generasi muda yang berjiwa kreatif dan menjujung tinggi semngat portifitas serta menghasilkan atlet-atlet berbakat dan berkualitas yang nantinya berguna bagi abngsa dan negara Indonesia",
                    "Mengembangkan bakat dan kreatifitas olahraga dari setiap mahasiswa agar memiliki jiwa yang sehat dan selalu menjunjung tinggi atas sportifitas dalam aspek kehidupanna",
                    "@ukmolahragapolinela",
                    "08345678920"

            );
            insertData(db,
                    "Al Banna",
                    "AL BANNA",
                    R.drawable.albana,
                    " \n Tabligh Akbar \n 2. Latihan Kepemimpinan Manajemen Islam \n 3. Polinela Mengaji \n 3. Islamic Euphoria Competition \n 4. Tabligh Akbar Spesial Polinela Islamic Festival 2023",
                    " \n *Tahun 2019: Juara VII Lomba Lintas Alam Pemuda Se-Sumbagsel \n *Tahun 2019: Juara VI Lomba Lintas Alam Pemuda Se-Sumbagsel 2019 ",
                    "Membentuk Kepribadian Mahasiswa yang Kreatif dan bertanggung jawab terhadap lingkungan masyarakat",
                    "Mewujudkan sumberdaya manusia yang peka terhadap alam dan lingkungan untuk melaksanakan fungsi sosial dan ikut serta mengatasi masalah alam, sosial dan lingkungan",
                    "@ldkalbannapolinela",
                    "08345678920"

                    );
            insertData(db,
                    "Garda Kedisplinan",
                    "GARDA",
                    R.drawable.garda,
                    " \n * Latihan Pemantapan \n * Hari Peduli Sampah Nasional \n * Pelatihan Keorganisasian \n * Jambore Nasional \n * Lomba Lintas Alam Poltapala Nasional \n * Pendidikan Dasar \n * Latihan Dasar \n * Musyawarah Besar.",
                    " \n *Tahun 2019: Juara VII Lomba Lintas Alam Pemuda Se-Sumbagsel \n *Tahun 2019: Juara VI Lomba Lintas Alam Pemuda Se-Sumbagsel 2019 ",
                    "Membentuk Kepribadian Mahasiswa yang Kreatif dan bertanggung jawab terhadap lingkungan masyarakat",
                    "Mewujudkan sumberdaya manusia yang peka terhadap alam dan lingkungan untuk melaksanakan fungsi sosial dan ikut serta mengatasi masalah alam, sosial dan lingkungan",
                    "@ukmgarda.kedisiplinan_polinela",
                    "08345678920"

                    );
            insertData(db,
                    "English Club",
                    "EC",
                    R.drawable.ec,
                    " \n * Latihan Pemantapan \n * Hari Peduli Sampah Nasional \n * Pelatihan Keorganisasian \n * Jambore Nasional \n * Lomba Lintas Alam Poltapala Nasional \n * Pendidikan Dasar \n * Latihan Dasar \n * Musyawarah Besar.",
                    " \n *Tahun 2017: Juara III Lomba Lintas Alam Lereng Timur Gunung Tanggamus \n *Tahun 2019: Juara VII Lomba Lintas Alam Pemuda Se-Sumbagsel \n *Tahun 2019: Juara VI Lomba Lintas Alam Pemuda Se-Sumbagsel 2019 ",
                    "Membentuk Kepribadian Mahasiswa yang Kreatif dan bertanggung jawab terhadap lingkungan masyarakat",
                    "Mewujudkan sumberdaya manusia yang peka terhadap alam dan lingkungan untuk melaksanakan fungsi sosial dan ikut serta mengatasi masalah alam, sosial dan lingkungan",
                    "@ecpolinela",
                    "08345678920"

                    );
        }
    }
    private void insertData(SQLiteDatabase db, String nama, String singkatan, int foto, String agenda, String pencapaian, String visi, String misi, String ig, String telepon){
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAMA, nama);
        values.put(COLUMN_SINGKATAN, singkatan);
        values.put(COLUMN_FOTO, foto);
        values.put(COLUMN_AGENDA, agenda);
        values.put(COLUMN_PENCAPAIAN, pencapaian);
        values.put(COLUMN_VISI, visi);
        values.put(COLUMN_MISI, misi);
        values.put(COLUMN_IG, ig);
        values.put(COLUMN_TELEPON, telepon);
        db.insert(TABLE_NAME, null, values);
    }
    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.query(TABLE_NAME, null, null, null, null, null, null);
    }

    public Cursor getDataById(long id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.query(TABLE_NAME, null, COLUMN_ID + " = ?",
                new String[]{String.valueOf(id)}, null, null, null);
    }

}
