# Buscar Libro - Android App

Una aplicación Android para buscar libros desarrollada en Java con arquitectura MVVM.

## Características

- **Búsqueda de libros**: Interfaz principal con título "Búsqueda de Libro" e icono de libro
- **Campo de búsqueda**: EditText con icono de lupa para escribir el nombre del libro
- **Botón de búsqueda**: Busca el libro en la lista predefinida
- **Vista de detalles**: Segunda actividad que muestra imagen, nombre, autor, año de edición y reseña
- **Toast de error**: Muestra "Libro no encontrado" cuando no se encuentra el libro

## Arquitectura MVVM

- **Model**: `Libro.java` - Clase de datos con atributos del libro
- **View**: Activities (`BuscarLibroActivity`, `DetalleLibroActivity`) y layouts XML
- **ViewModel**: `LibroViewModel.java` - Lógica de negocio y manejo de estados
- **Repository**: `LibroRepository.java` - Fuente de datos con lista hardcodeada de libros

## Libros Incluidos

1. **Cien años de soledad** - Gabriel García Márquez (1967)
2. **Don Quijote de la Mancha** - Miguel de Cervantes (1605)
3. **1984** - George Orwell (1949)
4. **El Principito** - Antoine de Saint-Exupéry (1943)
5. **Orgullo y prejuicio** - Jane Austen (1813)
6. **Harry Potter y la piedra filosofal** - J.K. Rowling (1997)

## Especificaciones Técnicas

- **Minimum SDK**: API 34 (Android 14.0 "UpsideDownCake")
- **Target SDK**: API 34
- **Lenguaje**: Java
- **Build System**: Kotlin DSL (build.gradle.kts)
- **Package**: com.example.buscarlibro

## Estructura del Proyecto

```
app/
├── src/main/
│   ├── java/com/example/buscarlibro/
│   │   ├── model/Libro.java
│   │   ├── repository/LibroRepository.java
│   │   ├── viewmodel/LibroViewModel.java
│   │   ├── BuscarLibroActivity.java
│   │   └── DetalleLibroActivity.java
│   ├── res/
│   │   ├── layout/
│   │   │   ├── activity_buscar_libro.xml
│   │   │   └── activity_detalle_libro.xml
│   │   ├── drawable/ (iconos y imágenes de libros)
│   │   ├── values/
│   │   │   ├── strings.xml
│   │   │   ├── colors.xml
│   │   │   └── themes.xml
│   │   └── xml/ (backup y data extraction rules)
│   └── AndroidManifest.xml
└── build.gradle.kts
```

## Cómo usar

1. Abrir la aplicación
2. Escribir el nombre del libro en el campo de búsqueda
3. Presionar "Buscar" o la tecla de búsqueda
4. Si se encuentra el libro, se abre la vista de detalles
5. Si no se encuentra, aparece un toast "Libro no encontrado"
