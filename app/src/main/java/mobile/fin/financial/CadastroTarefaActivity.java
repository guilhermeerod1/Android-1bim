package mobile.fin.financial;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by guilh on 17/03/2016.
 */
public class CadastroTarefaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edicao_layout);

        final EditText txtData = (EditText) findViewById(R.id.txtData);
        final EditText txtHorario = (EditText) findViewById(R.id.txtHorario);
        final EditText txtDataHorario = (EditText) findViewById(R.id.txtDataHorario);

        Button btnCadastrar = (Button) findViewById(R.id.btnCadastrar);

        btnCadastrar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String data = String.valueOf(txtData.getText());
                String horario = String.valueOf(txtHorario.getText());
                String dataHorario = data + horario;

                txtDataHorario.setText(dataHorario);

            }

        });

    }

}
