package com.example.buscarlibro.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.buscarlibro.model.Libro;
import com.example.buscarlibro.repository.LibroRepository;

public class LibroViewModel extends ViewModel {
    private LibroRepository libroRepository;
    private MutableLiveData<Libro> libroEncontrado;
    private MutableLiveData<Boolean> libroNoEncontrado;

    public LibroViewModel() {
        libroRepository = LibroRepository.getInstance();
        libroEncontrado = new MutableLiveData<>();
        libroNoEncontrado = new MutableLiveData<>();
    }

    public LiveData<Libro> getLibroEncontrado() {
        return libroEncontrado;
    }

    public LiveData<Boolean> getLibroNoEncontrado() {
        return libroNoEncontrado;
    }

    public void buscarLibro(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            libroNoEncontrado.setValue(true);
            return;
        }

        Libro libro = libroRepository.buscarLibroPorNombre(nombre.trim());
        if (libro != null) {
            libroEncontrado.setValue(libro);
            libroNoEncontrado.setValue(false);
        } else {
            libroEncontrado.setValue(null);
            libroNoEncontrado.setValue(true);
        }
    }
}
