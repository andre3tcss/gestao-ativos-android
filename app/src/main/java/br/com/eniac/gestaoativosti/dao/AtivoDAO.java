package br.com.eniac.gestaoativosti.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import br.com.eniac.gestaoativosti.database.DBHelper;
import br.com.eniac.gestaoativosti.model.Ativo;

public class AtivoDAO {
    private DBHelper dbHelper;

    public AtivoDAO(Context context) {
        dbHelper = new DBHelper(context);
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