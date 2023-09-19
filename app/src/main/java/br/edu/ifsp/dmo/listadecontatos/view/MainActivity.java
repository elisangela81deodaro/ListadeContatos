package br.edu.ifsp.dmo.listadecontatos.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import br.edu.ifsp.dmo.listadecontatos.Contato;
import br.edu.ifsp.dmo.listadecontatos.ContatoAdapter;
import br.edu.ifsp.dmo.listadecontatos.ContatoDao;
import br.edu.ifsp.dmo.listadecontatos.R;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private static final String TAG = "LISTA_CONTATOS";
    private Button button;
    private ListView listView;
    private ContatoDao contatoDao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v(TAG, "Executando onCreate().");

        contatoDao = ContatoDao.getInstance();
        button = findViewById(R.id.btn_novo);
        button.setOnClickListener(v -> novoContato());

        listView = findViewById(R.id.listview_contato);
        ContatoAdapter contatoAdapter = new ContatoAdapter(this, contatoDao.getDataset());
        listView.setAdapter(contatoAdapter);
        listView.setOnItemClickListener(this);
    }
    @Override
    protected void onStart(){
        Log.v(TAG, "Executando onStart().");
        super.onStart();

    }
    @Override
    protected void onResume(){
        Log.v(TAG, "Executando onResume().");
        super.onResume();
    }
    @Override
    protected void onPause(){
        Log.v(TAG, "Executando onPause().");
        super.onPause();
    }
    @Override
    protected void onStop(){
        Log.v(TAG, "Executando onStop().");
        super.onStop();
}
    @Override
    protected void onRestart() {
        Log.v(TAG, "Executando onRestar().");
        super.onRestart();
    }
    @Override
    protected void onDestroy() {
        Log.v(TAG, "Executando onDestroy().");
        super.onDestroy();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id){
        Contato contato = ContatoDao.getInstance().getDataset().get(position);
        String uri = "tel:" + contato.getTelefone();
        Intent intent = new Intent(Intent.ACTION_DIAL);
        startActivity(intent);

    }
    private void novoContato(){
        LayoutInflater inflater = getLayoutInflater();
        View viewInfaled = inflater.inflate((R.layout.novo_contato,))
    }
}
