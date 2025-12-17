# 📚 Gestor de Biblioteca de Hogwarts

Sistema de gestión de biblioteca desarrollado con Java Spring Boot y React, ambientado en el universo de Harry Potter.

## 🛠️ Tecnologías

### Backend

- Java 17+
- Spring Boot 3.x
- MySQL 8.0+
- Maven

### Frontend

- React 18+
- React Router DOM
- CSS3

## 📋 Requisitos Previos

- JDK 17 o superior
- MySQL 8.0 o superior
- Node.js 16+ y npm
- Maven 3.6+

## ⚙️ Configuración

### 1. Base de Datos

Crea la base de datos en MySQL:

```sql
CREATE DATABASE biblioteca_hogwarts;
```

### 2. Backend (Spring Boot)

1. Clona el repositorio
2. Configura `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/biblioteca_hogwarts
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

3. Ejecuta el proyecto:

```bash
cd backend
mvn clean install
mvn spring-boot:run
```

El servidor estará disponible en `http://localhost:8080`

### 3. Frontend (React)

1. Instala las dependencias:

```bash
cd frontend
npm install
```

2. Inicia el servidor de desarrollo:

```bash
npm start
```

La aplicación estará disponible en `http://localhost:3000`

## 🚀 Uso

1. Inicia MySQL
2. Ejecuta el backend (Puerto 8080)
3. Ejecuta el frontend (Puerto 5173)
4. Accede a `http://localhost:5173/login`

### Credenciales

- El administrador debe crear las credenciales, sea que este tenga las suyas propias o la tenga que crear en la base de datos.

## 📁 Estructura del Proyecto

```
proyecto/
├── backend/
│   ├── src/main/java/
│   │   └── com/bibliotecadehogwarts/
│   │       ├── controller/
│   │       ├── service/
│   │       ├── repository/
│   │       ├── model/
│   │       └── dto/
│   └── application.properties
└── frontend/
    ├── src/
    │   ├── components/
    │   └── styles/
    │   └── services/
    └── package.json
```

## 🎯 Funcionalidades

- ✅ Gestión de libros
- ✅ Gestión de lectores por casas de Hogwarts
- ✅ Sistema de préstamos
- ✅ Control de multas
- ✅ Dashboard con estadísticas
- ✅ Identificación de casa más lectora

## 🐛 Solución de Problemas

### Error de conexión a MySQL

- Verifica que MySQL esté corriendo
- Confirma las credenciales en `application.properties`

### CORS errors

- Asegúrate de que el backend permita peticiones desde `http://localhost:3000`

### Puerto ocupado

- Backend: Cambia el puerto en `application.properties`: `server.port=8081`
- Frontend: Usa `PORT=3001 npm start`

## 📝 Notas

- Las tablas se crean automáticamente con `ddl-auto=update`
- Los datos de ejemplo deben cargarse manualmente o mediante scripts SQL
