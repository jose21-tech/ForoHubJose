README.md
🔐 Foro Hub
Descripción del Proyecto
Una API REST para una plataforma de foro, desarrollada en Spring Boot. El proyecto implementa un sistema de autenticación seguro con JWT y permite a los usuarios gestionar los tópicos del foro a través de diferentes endpoints.

Funcionalidades Clave
Autenticación y Autorización: Implementa Spring Security para proteger los endpoints. Los usuarios deben autenticarse para obtener un token JWT, que luego es usado para acceder a los recursos.

Gestión de Tópicos: Ofrece una gestión completa de tópicos (CRUD - Crear, Leer, Actualizar, Borrar).

Tecnologías Utilizadas
Java 17

Spring Boot 3

Spring Security

JSON Web Tokens (JWT)

Spring Data JPA

PostgreSQL

Maven

Configuración y Pruebas del Proyecto
1. Configuración de la Base de Datos
El archivo de configuración (src/main/resources/application.properties) no está incluido por motivos de seguridad. Para ejecutar el proyecto, debes crear este archivo y añadir tus propias credenciales de PostgreSQL:

Properties

spring.datasource.url=jdbc:postgresql://localhost:5432/foro_hub_db
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
api.security.secret=123456789
2. Insertar Usuario de Prueba
Para poder probar la autenticación, debes insertar un usuario en la base de datos. Puedes hacerlo ejecutando el siguiente comando SQL:

SQL

INSERT INTO usuarios (login, clave) VALUES ('usuario_prueba', '$2a$10$tJtA1yLz1tSjN.t0oJ3lO.VqgMv.t6U.W1y.K9Q0Q4S.1j8u4L0v0');
Luego, utiliza las siguientes credenciales en el endpoint de login:

Usuario: usuario_prueba

Contraseña: 123456

3. Endpoints de la API
Una vez que la aplicación esté corriendo, utiliza una herramienta como Insomnia o Postman para interactuar con los endpoints.

POST /login - Obtiene el token JWT.

POST /topics - Crea un nuevo tópico.

GET /topics - Lista todos los tópicos.

GET /topics/{id} - Muestra los detalles de un tópico.

PUT /topics/{id} - Actualiza un tópico.

DELETE /topics/{id} - Elimina un tópico.
