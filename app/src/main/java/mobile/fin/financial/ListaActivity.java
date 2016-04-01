package mobile.fin.financial;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by guilh on 17/03/2016.
 */
public class ListaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_layout);

        ListView listTarefas = (ListView) findViewById(R.id.listTarefas);

        registerForContextMenu(listTarefas);

        final String[] tarefas = new String[] {"Receber receita x", "Pagar despesa y", "etc"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, tarefas);

        listTarefas.setAdapter(adapter);

        listTarefas.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(ListaActivity.this, "Tarefa: " + (position + 1), Toast.LENGTH_SHORT).show();

            }

        });

        listTarefas.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListaActivity.this, "Fazer", Toast.LENGTH_LONG);
                return false;
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_principal, menu);

        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.cadastro:
                Intent irParaCadastro = new Intent(this, CadastroTarefaActivity.class);
                startActivity(irParaCadastro);
                break;

            case R.id.sair:
                finish();
                break;

        }

        return super.onOptionsItemSelected(item);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.add(R.string.edit);
        menu.add(R.string.delete);
        super.onCreateContextMenu(menu, v, menuInfo);
    }
}
