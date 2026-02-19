package br.com.eniac.gestaoativosti.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "ativos_db";
    public static final String TABLE_ATIVOS = "ativos";
    public static final String KEY_ID = "id";
    public static final String KEY_NOME = "nome";
    public static final String KEY_TIPO = "tipo";
    public static final String KEY_DATA = "data_aquisicao";
    public static final String KEY_VALOR = "valor";
    public static final String KEY_STATUS = "status";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_ATIVOS_TABLE = "CREATE TABLE " + TABLE_ATIVOS + "("
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + KEY_NOME + " TEXT,"
                + KEY_TIPO + " TEXT,"
                + KEY_DATA + " TEXT,"
                + KEY_VALOR + " REAL,"
                + KEY_STATUS + " TEXT" + ")";
        db.execSQL(CREATE_ATIVOS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ATIVOS);
        onCreate(db);
    }
}