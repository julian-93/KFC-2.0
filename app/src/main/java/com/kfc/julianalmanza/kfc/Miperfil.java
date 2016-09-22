package com.kfc.julianalmanza.kfc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class Miperfil extends AppCompatActivity {
    TextView datos;
    String nombre,contraseña,correo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_miperfil);
        Bundle extra =getIntent().getExtras();
        nombre=extra.getString("nombre");
        contraseña=extra.getString("contraseña");
        correo=extra.getString("correo");
        datos=(TextView) findViewById(R.id.datos);
        String texto=getString(R.string.user)+"\n"+nombre+"\n"+getString(R.string.correo)+"\n"+correo;
        datos.setText(texto);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        switch (id){

            case(R.id.MainActivity):
                finish();
                break;
            case(R.id.Productos):
                Intent intent= new Intent(this,Productos.class);
                intent.putExtra("nombre",nombre);
                intent.putExtra("contraseña",contraseña);
                intent.putExtra("correo",correo);
                finish();
                startActivity(intent);
            break;
        }
        return super.onOptionsItemSelected(item);
    }
}
