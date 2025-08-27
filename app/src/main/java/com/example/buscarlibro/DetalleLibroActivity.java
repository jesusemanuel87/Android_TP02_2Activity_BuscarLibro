package com.example.buscarlibro;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.button.MaterialButton;

public class DetalleLibroActivity extends AppCompatActivity {
    private ImageView ivLibroImagen;
    private TextView tvLibroNombre;
    private TextView tvLibroAutor;
    private TextView tvLibroAno;
    private TextView tvLibroResena;
    private MaterialButton btnVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_libro);

        initializeViews();
        loadBookData();
        setupListeners();
    }

    private void initializeViews() {
        ivLibroImagen = findViewById(R.id.ivLibroImagen);
        tvLibroNombre = findViewById(R.id.tvLibroNombre);
        tvLibroAutor = findViewById(R.id.tvLibroAutor);
        tvLibroAno = findViewById(R.id.tvLibroAno);
        tvLibroResena = findViewById(R.id.tvLibroResena);
        btnVolver = findViewById(R.id.btnVolver);
    }

    private void loadBookData() {
        // Obtener los datos del libro desde el Intent
        String nombre = getIntent().getStringExtra("libro_nombre");
        String autor = getIntent().getStringExtra("libro_autor");
        int ano = getIntent().getIntExtra("libro_ano", 0);
        String resena = getIntent().getStringExtra("libro_resena");
        int imagenResourceId = getIntent().getIntExtra("libro_imagen", 0);

        // Establecer los datos en las vistas
        tvLibroNombre.setText(nombre);
        tvLibroAutor.setText(autor);
        tvLibroAno.setText(String.valueOf(ano));
        tvLibroResena.setText(resena);
        
        if (imagenResourceId != 0) {
            ivLibroImagen.setImageResource(imagenResourceId);
        }
    }

    private void setupListeners() {
        btnVolver.setOnClickListener(v -> {
            // Volver a la actividad anterior
            finish();
        });
    }
}
