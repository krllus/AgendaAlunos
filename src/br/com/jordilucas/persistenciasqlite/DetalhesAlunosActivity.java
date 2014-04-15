package br.com.jordilucas.persistenciasqlite;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import br.com.jordilucas.persistenciasqlite.R;

/**
 * Created by jordi on 14/04/14.
 */
public class DetalhesAlunosActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalhes_alunos);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = this.getMenuInflater();

        inflater.inflate(R.menu.menu_principal, menu);

        return true;

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuNovo:

                startActivity(new Intent(this, ListaAlunosActivity.class));

                return true;

            default:
                return super.onOptionsItemSelected(item);
        }


    }
}