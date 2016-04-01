package mobile.fin.financial;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);

        final EditText txtNome = (EditText) findViewById(R.id.txtNomeUsuario);
        final EditText txtSenha = (EditText) findViewById(R.id.txtSenha);
        Button btnLogar = (Button) findViewById(R.id.btnLogar);

        btnLogar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String nome = String.valueOf(txtNome.getText());
                String senha = String.valueOf(txtSenha.getText());

                if(nome.equals("Guilherme")) {

                    if(senha.equals("123")) {

                        Intent irParaLista = new Intent(LoginActivity.this, ListaActivity.class);
                        startActivity(irParaLista);
                        finish();

                    } else {
                        chamarAlertDialog();
                    }

                } else {
                    chamarAlertDialog();
                }

            }

        });

    }

    private void chamarAlertDialog() {

        AlertDialog.Builder dlgAlert = new AlertDialog.Builder(this);
        dlgAlert.setTitle(R.string.app_name);
        dlgAlert.setMessage(R.string.invalid);
        dlgAlert.setNeutralButton("OK", null);
        dlgAlert.show();

    }

}
