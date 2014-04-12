package br.com.jordilucas.persistenciasqlite;

import java.util.ArrayList;
import java.util.List;

import br.com.jordilucas.persistenciasqlite.modelo.bean.Aluno;
import br.com.jordilucas.persistenciasqlite.modelo.dao.AlunoDao;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class ListaAlunosActivity extends Activity {
	
	private ListView lvListagem;
	
	private List<Aluno> listaAlunos;
	
	private Aluno alunoSelecionado = null;
	
	private ArrayAdapter<Aluno> adapter;
	
	private int adapterlayout = android.R.layout.simple_list_item_1;
	
	private final String TAG = "CADASTRO_ALUNO";
	private final String ALUNOS_KEY = "LISTA";
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_alunos);
        
        lvListagem = (ListView)findViewById(R.id.lvListaAlunos);
        
        registerForContextMenu(lvListagem);
    
    
        lvListagem.setOnItemClickListener(new OnItemClickListener() {
		
        	
			@Override
			public void onItemClick(AdapterView<?> adapter, View view,
					int posicao, long id) {
				Toast.makeText(ListaAlunosActivity.this, 
						"Aluno: "+listaAlunos.get(posicao), Toast.LENGTH_SHORT).show();
				
				
			
			}
        	
        });
    
        
        lvListagem.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> adapter, View view,
					int posicao, long id) {
					
					alunoSelecionado = (Aluno) adapter.getItemAtPosition(posicao);
				
					Log.i(TAG, "Aluno selecionado ListView.longClick()"
							+ alunoSelecionado.getNome());
					
				return false;
			}
		});
        
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View view, 
    		ContextMenuInfo menuInfo){
    	
    		super.onCreateContextMenu(menu, view, menuInfo);
    	
    		getMenuInflater().inflate(R.menu.menu_contexto, menu);
    }
    
    @Override
    public boolean onContextItemSelected(MenuItem item){
    	switch(item.getItemId()){
    		case R.id.menuDeletar:
    			break;
    		default:
    			break;
    	}
    	return super.onContextItemSelected(item);
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        
    	MenuInflater inflater = this.getMenuInflater();
    	
    	inflater.inflate(R.menu.menu_principal, menu);
    	
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
    	switch(item.getItemId()){
    	case R.id.menuNovo:
    		
    		startActivity(new Intent(this, FormularioActivity.class));
    		
    		return true;
    	
    	default:
    		return super.onOptionsItemSelected(item);
    	}
    }
    
    
    public void carregarLista(){
    	AlunoDao dao = new AlunoDao(this);
    	
    	this.listaAlunos = dao.listar();
    	
    	dao.close();
    	
    	
    	this.adapter = new ArrayAdapter<Aluno>(this, adapterlayout, listaAlunos);
    	
    	this.lvListagem.setAdapter(adapter);
    	
    }
    
    @Override
    protected void onResume(){
    	super.onResume();
    	this.carregarLista();
    }
    
    /*private void excluirAluno(){
    	AlertDialog.Builder builder= new AlertDialog.Builder(this);
    	
    	builder.setMessage("Confirma a exclusão de: "
    			+alunoSelecionado.getNome());
    	
    	builder.setPositiveButton("Sim", new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				AlunoDao dao = new AlunoDao(ListaAlunosActivity.this);
				dao.deletar(alunoSelecionado);
				dao.close();
				carregarLista();
				alunoSelecionado = null;
				
			}
		});
    	
    	builder.setNegativeButton("Não", null);
    	AlertDialog dialog = builder.create();
    	
    	dialog.setTitle("Confirmação de operação");
    	dialog.show();
    }
    
    */
    
    /*
    @Override
    protected void onSaveInstanceState(Bundle outState){
    	outState.putStringArrayList(ALUNOS_KEY, (ArrayList<String>) listaAlunos);
    	
    	super.onSaveInstanceState(outState);
    	
    	Log.i(TAG, "OnSavedInstanceState(): "+listaAlunos);
    }
    
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState){
    	super.onRestoreInstanceState(savedInstanceState);
    	
    	listaAlunos = savedInstanceState.getStringArrayList(ALUNOS_KEY);
    	
    	Log.i(TAG, "OnSaveRestoreState(): "+listaAlunos);
    }
   
    */
}
