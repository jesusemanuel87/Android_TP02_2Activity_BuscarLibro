package com.example.buscarlibro;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import com.example.buscarlibro.model.Libro;
import com.example.buscarlibro.viewmodel.BookViewModel;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class BuscarLibroActivity extends AppCompatActivity {
    private TextInputEditText etSearch;
    private MaterialButton btnBuscar;
    private BookViewModel bookViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_libro);

        initializeViews();
        initializeViewModel();
        setupListeners();
        observeViewModel();
    }

    private void initializeViews() {
        etSearch = findViewById(R.id.etSearch);
        btnBuscar = findViewById(R.id.btnBuscar);
    }

    private void initializeViewModel() {
        bookViewModel = new ViewModelProvider(this).get(BookViewModel.class);
    }

    private void setupListeners() {
        btnBuscar.setOnClickListener(v -> buscarLibro());
        
        etSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    buscarLibro();
                    return true;
                }
                return false;
            }
        });
    }

    private void observeViewModel() {
        bookViewModel.getLibroEncontrado().observe(this, libro -> {
            if (libro != null) {
                // Navegar a la segunda activity con los detalles del libro
                Intent intent = new Intent(BuscarLibroActivity.this, DetalleLibroActivity.class);
                intent.putExtra("libro_nombre", libro.getNombre());
                intent.putExtra("libro_autor", libro.getAutor());
                intent.putExtra("libro_ano", libro.getAnoEdicion());
                intent.putExtra("libro_resena", libro.getResena());
                intent.putExtra("libro_imagen", libro.getImagenResourceId());
                startActivity(intent);
            }
        });

        bookViewModel.getLibroNoEncontrado().observe(this, noEncontrado -> {
            if (noEncontrado != null && noEncontrado) {
                Toast.makeText(this, "Libro no encontrado", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void buscarLibro() {
        String nombreLibro = etSearch.getText().toString().trim();
        if (!nombreLibro.isEmpty()) {
            bookViewModel.buscarLibro(nombreLibro);
        } else {
            Toast.makeText(this, "Por favor ingrese el nombre de un libro", Toast.LENGTH_SHORT).show();
        }
    }
}
