# ForoHub API

## Descripción

ForoHub es una API REST desarrollada con Spring Boot que permite gestionar tópicos dentro de un foro académico.
Este proyecto forma parte del **Challenge Back-End de Alura**, cuyo objetivo es replicar el funcionamiento básico del foro de la plataforma.

La API permite a los usuarios autenticados:

* Crear tópicos
* Listar todos los tópicos
* Consultar un tópico específico
* Actualizar un tópico
* Eliminar un tópico

Además, el sistema incluye autenticación basada en **JWT** para proteger los endpoints.

---

## Tecnologías utilizadas

* Java 17
* Spring Boot 3
* Spring Web
* Spring Data JPA
* Spring Security
* JWT (JSON Web Token)
* MySQL
* Maven
* Lombok

---

## Arquitectura del proyecto

El proyecto sigue una arquitectura en capas para mantener el código organizado y escalable.

```
forohub
│
├── controller
│   └── TopicoController
│   └── AuthController
│
├── service
│   └── TopicoService
│   └── TokenService
│
├── repository
│   └── TopicoRepository
│   └── UsuarioRepository
│
├── model
│   └── Topico
│   └── Usuario
│
├── dto
│   └── DatosRegistroTopico
│   └── DatosActualizarTopico
│   └── DatosLogin
│
├── security
│   └── SecurityConfigurations
│
└── ForohubApplication
```

---

## Base de datos

Crear la base de datos en MySQL:

```sql
CREATE DATABASE forohub;
```

Configuración en `application.properties`:

```
spring.datasource.url=jdbc:mysql://localhost:3306/forohub
spring.datasource.username=root
spring.datasource.password=tu_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

---

## Autenticación

La API utiliza **JWT** para autenticar a los usuarios.

### Crear usuario en la base de datos

```sql
INSERT INTO usuarios (login,password)
VALUES ('admin','123456');
```

### Login

```
POST /login
```

Body:

```json
{
 "login": "admin",
 "password": "123456"
}
```

Respuesta:

```
TOKEN_JWT
```

El token debe enviarse en los siguientes requests:

```
Authorization: Bearer TOKEN_JWT
```

---

## Endpoints de la API

### Crear tópico

```
POST /topicos
```

Body:

```json
{
 "titulo": "Error en Spring Boot",
 "mensaje": "No puedo conectar a la base de datos",
 "autor": "Jairo",
 "curso": "Spring Boot"
}
```

---

### Listar tópicos

```
GET /topicos
```

---

### Obtener tópico específico

```
GET /topicos/{id}
```

---

### Actualizar tópico

```
PUT /topicos/{id}
```

Body:

```json
{
 "titulo": "Titulo actualizado",
 "mensaje": "Mensaje actualizado"
}
```

---

### Eliminar tópico

```
DELETE /topicos/{id}
```

---

## Cómo ejecutar el proyecto

1. Clonar el repositorio

```
git clone https://github.com/tuusuario/forohub.git
```

2. Entrar al proyecto

```
cd forohub
```

3. Ejecutar la aplicación

```
mvn spring-boot:run
```

La API estará disponible en:

```
http://localhost:8080
```

---

## Mejoras futuras

* Implementar paginación en la lista de tópicos
* Manejo global de excepciones
* Validación de tópicos duplicados
* Documentación con Swagger/OpenAPI

---

## Autor

Proyecto desarrollado por **Jairo Alvarez** como parte del programa **Oracle Next Education (ONE) - Alura Latam**.
