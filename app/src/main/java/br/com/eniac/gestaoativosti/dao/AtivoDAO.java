package br.com.eniac.gestaoativosti.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import br.com.eniac.gestaoativosti.database.DBHelper;
import br.com.eniac.gestaoativosti.model.Ativo;
import android.database.Cursor;
import java.util.ArrayList;
import java.util.List;

public class AtivoDAO {
    private DBHelper dbHelper;

    public AtivoDAO(Context context) {
        dbHelper = new DBHelper(context);
    }

    public List<Ativo> listarTodos() {
        List<Ativo> ativos = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String sql = "SELECT * FROM " + DBHelper.TABLE_ATIVOS + " ORDER BY id DESC";
        Cursor cursor = db.rawQuery(sql, null);

        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
            String nome = cursor.getString(cursor.getColumnIndexOrThrow("nome"));
            String tipo = cursor.getString(cursor.getColumnIndexOrThrow("tipo"));
            String data = cursor.getString(cursor.getColumnIndexOrThrow("data_aquisicao"));
            double valor = cursor.getDouble(cursor.getColumnIndexOrThrow("valor"));
            String status = cursor.getString(cursor.getColumnIndexOrThrow("status"));

            Ativo ativo = new Ativo(id, nome, tipo, data, valor, status);
            ativos.add(ativo);
        }

        cursor.close();
        db.close();
        return ativos;
    }

    public void salvar(Ativo ativo) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DBHelper.KEY_NOME, ativo.getNome());
        values.put(DBHelper.KEY_TIPO, ativo.getTipo());
        values.put(DBHelper.KEY_DATA, ativo.getDataAquisicao());
        values.put(DBHelper.KEY_VALOR, ativo.getValor());
        values.put(DBHelper.KEY_STATUS, ativo.getStatus());

        db.insert(DBHelper.TABLE_ATIVOS, null, values);
        db.close();
    }
}