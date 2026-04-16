# UD06 - Tarea Obligatoria RA5
## Aplicación Web MVC con Spring Boot y Thymeleaf

### Descripción
Gestión de una base de datos de Cine con Spring Boot MVC, Thymeleaf y MySQL.

### Modelo de datos
- **Director**: idDirector, nombre, anyoNacimiento
- **Pelicula**: idPelicula, titulo, anyo, director (FK → Director)
- Relación: Un director puede tener muchas películas (1-N)

### Tareas a realizar (50 TODOs)

| # | Archivo | Descripción |
|---|---------|-------------|
| 1-3 | application.properties | Configurar conexión MySQL |
| 4-9 | Director.java | Añadir anotaciones JPA (@Entity, @Id, etc.) |
| 10-16 | Pelicula.java | Añadir anotaciones JPA y relación @ManyToOne |
| 17 | DirectorRepo.java | Consulta JPQL findDirectorByYear |
| 18-19 | PeliculaRepo.java | Consultas JPQL personalizadas |
| 20-21 | PeliculaService.java | Firmas de métodos |
| 22-25 | PeliculaServiceImpl.java | Implementar métodos |
| 26-32 | PeliculaController.java | Endpoints CRUD |
| 33-34 | DirectorController.java | Métodos add/update |
| 35-38 | directores.html | Thymeleaf th:each, th:text |
| 39-41 | directorForm.html | Formulario th:action, th:field |
| 42-46 | peliculas.html | Listado películas Thymeleaf |
| 47-50 | peliculaForm.html | Formulario con selector director |

### Estructura del proyecto
```
UD06_Obligatorio_RA5/
├── pom.xml
├── mysql/Cine.sql
└── src/main/
    ├── java/com/joange/
    │   ├── CineApplication.java
    │   ├── model/
    │   │   ├── Director.java (TODO 4-9)
    │   │   └── Pelicula.java (TODO 10-16)
    │   ├── repository/
    │   │   ├── DirectorRepo.java (TODO 17)
    │   │   └── PeliculaRepo.java (TODO 18-19)
    │   ├── service/
    │   │   ├── DirectorService.java
    │   │   └── PeliculaService.java (TODO 20-21)
    │   ├── serviceImpl/
    │   │   ├── DirectorServiceImpl.java
    │   │   └── PeliculaServiceImpl.java (TODO 22-25)
    │   └── controller/
    │       ├── AppController.java
    │       ├── DirectorController.java (TODO 33-34)
    │       └── PeliculaController.java (TODO 26-32)
    └── resources/
        ├── application.properties (TODO 1-3)
        ├── static/css/estilos.css
        └── templates/*.html (TODO 35-50)
```

### Ejecución
1. Crear la base de datos ejecutando `mysql/Cine.sql`
2. Configurar `application.properties` con tus credenciales MySQL
3. Abrir carpeta en VS Code
4. Ejecutar `CineApplication.java`
5. Acceder a http://localhost:8080
