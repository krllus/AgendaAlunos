package br.com.jordilucas.persistenciasqlite.modelo.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.jordilucas.persistenciasqlite.modelo.bean.Aluno;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class AlunoDao extends SQLiteOpenHelper{
	
	private static final int VERSAO = 1;
	private static final String TABELA = "Aluno";
	private static final String DATABASE = "MPAlunos";
	
	private static final String TAG = "CADASTRO_ALUNO";
	
	
	public AlunoDao(Context context){
		super(context, DATABASE, null, VERSAO);
	}
	
	public void onCreate(SQLiteDatabase database){
		String ddl = "CREATE TABLE " +TABELA+ "("
				+"id INTEGER PRIMARY KEY, "
				+"nome TEXT, telefone TEXT, endereco TEXT, site TEXT, email TEXT,"
				+"foto TEXT,nota REAL)";
		database.execSQL(ddl);
					
	}
	
	public void onUpgrade(SQLiteDatabase database, int versaoAntiga, int versaoNova){
		String sql = "DROP TABLE IF EXISTS "+TABELA;
		database.execSQL(sql);
		onCreate(database);
	}
	
	public void cadastrar(Aluno aluno){
		ContentValues values = new ContentValues();
		
		values.put("nome", aluno.getNome());
		values.put("telefone", aluno.getTelefone());
        values.put("endereco", aluno.getEndereco());
        values.put("site", aluno.getSite());
		values.put("email", aluno.getEmail());
        values.put("foto", aluno.getFoto());
		values.put("nota", aluno.getNota());
		
		getWritableDatabase().insert(TABELA, null, values);
		
		Log.i(TAG, "Aluno cadastro "+aluno.getNome());
	}
	
	public List<Aluno> listar(){
		List<Aluno> lista = new ArrayList<Aluno>();
		
		String sql = "Select * from Aluno order by nome";
		
		Cursor cursor = getReadableDatabase().rawQuery(sql, null);
		
		try{
			while(cursor.moveToNext()){
				Aluno aluno = new Aluno();
				
				aluno.setId(cursor.getInt(0));
				aluno.setNome(cursor.getString(1));
				aluno.setTelefone(cursor.getString(2));
                aluno.setEndereco(cursor.getString(3));
                aluno.setSite(cursor.getString(4));
				aluno.setEmail(cursor.getString(5));
				aluno.setFoto(cursor.getString(6));
				aluno.setNota(cursor.getDouble(7));
				
				lista.add(aluno);
				
			}
		}
		catch(SQLException e){
			Log.e(TAG, e.getMessage());
		}
		finally{
			cursor.close();
		}
		return lista;
	}





/*
	
	public void deletar(Aluno aluno){
		
		String[] args ={ aluno.getId().toString() };
		
		getWritableDatabase().delete(TABELA, "id=?", args);
		
		Log.i(TAG, "Aluno deletado: "+aluno.getNome());
		
	}

*/
	
	
}
