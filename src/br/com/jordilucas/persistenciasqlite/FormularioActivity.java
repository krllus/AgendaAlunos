package br.com.jordilucas.persistenciasqlite;

import br.com.jordilucas.persistenciasqlite.helper.FormularioHelper;
import br.com.jordilucas.persistenciasqlite.modelo.bean.Aluno;
import br.com.jordilucas.persistenciasqlite.modelo.dao.AlunoDao;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FormularioActivity extends Activity {

    private Button botao;
    private FormularioHelper helper;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.formulario);
    
    
        helper = new FormularioHelper(this);
        botao = (Button)findViewById(R.id.btSalvar);
        botao.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Aluno aluno = helper.getAluno();
				
				AlunoDao dao = new AlunoDao(FormularioActivity.this);
				dao.cadastrar(aluno);
				
				dao.close();
				
				finish();
			}
		});
        
        
    
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
    	
    	MenuInflater inflater  = this.getMenuInflater();
    	
    	inflater.inflate(R.menu.menu_principal, menu);
    	
    	return true;
    	
    }
    

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
    	switch(item.getItemId()){
    	case R.id.menuNovo:
    		
    		startActivity(new Intent(this, ListaAlunosActivity.class));
    		
    		return true;
    	
    	default:
    		return super.onOptionsItemSelected(item);
    	}
    }
    
    
}
