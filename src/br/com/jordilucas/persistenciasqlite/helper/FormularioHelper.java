package br.com.jordilucas.persistenciasqlite.helper;

import br.com.jordilucas.persistenciasqlite.FormularioActivity;
import br.com.jordilucas.persistenciasqlite.R;
import br.com.jordilucas.persistenciasqlite.modelo.bean.Aluno;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;

public class FormularioHelper {

	private EditText nome;
	private EditText telefone;
	private EditText endereco;
	private EditText site;
	private EditText email;
	private EditText nota;
	private ImageView foto;
	
	private Aluno aluno;

	public FormularioHelper(FormularioActivity activity){
		
		nome = (EditText)activity.findViewById(R.id.edNome);
		telefone = (EditText)activity.findViewById(R.id.etFone);
		site = (EditText)activity.findViewById(R.id.etSite);
		email = (EditText)activity.findViewById(R.id.etEmail);
		endereco = (EditText)activity.findViewById(R.id.etEndereco);
		nota = (EditText)activity.findViewById(R.id.etNota);
		foto = (ImageView)activity.findViewById(R.id.ivFoto);
		
		aluno = new Aluno();
}
	
	public Aluno getAluno(){
		
		aluno.setNome(nome.getText().toString());
		aluno.setTelefone(telefone.getText().toString());
		aluno.setSite(site.getText().toString());
		aluno.setEmail(email.getText().toString());
		aluno.setEndereco(endereco.getText().toString());
		aluno.setNota(Double.valueOf(nota.getText().toString()));
		
		return aluno;
	}
}


