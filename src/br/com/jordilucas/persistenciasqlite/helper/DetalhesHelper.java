package br.com.jordilucas.persistenciasqlite.helper;

import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.jordilucas.persistenciasqlite.DetalhesAlunosActivity;
import br.com.jordilucas.persistenciasqlite.R;
import br.com.jordilucas.persistenciasqlite.modelo.bean.Aluno;

//nome, telefone, endereco, site, email, nota, foto

/**
 * Created by jordi on 14/04/14.
 */
public class DetalhesHelper {

    private TextView nome;
    private TextView telefone;
    private TextView endereco;
    private TextView site;
    private TextView email;
    private TextView nota;
    private ImageView foto;

    private Aluno aluno;

    public DetalhesHelper(DetalhesAlunosActivity activity){
        nome = (TextView)activity.findViewById(R.id.tv_detalhe_nome);
        telefone = (TextView)activity.findViewById(R.id.tv_detalhe_telefone);
        endereco = (TextView)activity.findViewById(R.id.tv_detalhe_endereco);
        site = (TextView)activity.findViewById(R.id.tv_detalhe_site);
        email = (TextView)activity.findViewById(R.id.tv_detalhe_email);
        nota = (TextView)activity.findViewById(R.id.tv_detalhe_nota);
        foto = (ImageView)activity.findViewById(R.id.iv_detalhe_foto);

    }

    public Aluno getAluno(){
        aluno.setNome(nome.getText().toString());
        aluno.setTelefone(telefone.getText().toString());
        aluno.setEndereco(endereco.getText().toString());
        aluno.setSite(site.getText().toString());
        aluno.setEmail(site.getText().toString());
        aluno.setNota(Double.valueOf(nota.getText().toString()));

        return aluno;

    }


}
