# 📄 Documentación Swagger/OpenAPI - Spring Boot

## ✅ Cambios Realizados

Se ha configurado **SpringDoc OpenAPI** en el proyecto Spring Boot para generar documentación Swagger automáticamente.

### 1️⃣ Dependencia Agregada (pom.xml)

```xml
<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
    <version>2.3.0</version>
</dependency>
```

### 2️⃣ Configuración (application.properties)

```properties
# Configuración de Swagger/OpenAPI
springdoc.api-docs.path=/api-docs
springdoc.swagger-ui.path=/swagger-ui.html
springdoc.swagger-ui.operationsSorter=method
springdoc.swagger-ui.tagsSorter=alpha
```

### 3️⃣ Clase de Configuración

Se creó `OpenAPIConfig.java` con información personalizada de la API y servidores disponibles.

### 4️⃣ Anotaciones en Controladores

Se agregaron anotaciones de documentación en:
- `UsuarioService.java` - @Tag y @Operation
- `ProyectoService.java` - @Tag y @Operation

---

## 🌐 URLs de Acceso

### **Producción (Railway)**
- 📄 **Swagger UI**: https://backspring-production-72c6.up.railway.app/swagger-ui.html
- 📄 **OpenAPI JSON**: https://backspring-production-72c6.up.railway.app/api-docs

### **Local**
- 📄 **Swagger UI**: http://localhost:8081/swagger-ui.html
- 📄 **OpenAPI JSON**: http://localhost:8081/api-docs

---

## 🚀 Próximos Pasos

1. **Hacer commit y push** al repositorio
2. **Railway desplegará automáticamente** los cambios
3. **Verificar** que la documentación esté disponible en la URL de producción

---

## 📝 Comandos Git

```bash
cd c:\Users\jordy\Desktop\backspring
git add .
git commit -m "feat: Agregar documentación Swagger/OpenAPI"
git push
```

---

## 🎯 Endpoints Documentados

### **Usuarios** (`/api/usuarios`)
- `GET /api/usuarios` - Listar todos los usuarios
- `GET /api/usuarios/programadores` - Listar programadores
- `GET /api/usuarios/{uid}` - Buscar usuario por ID
- `POST /api/usuarios` - Crear usuario
- `PUT /api/usuarios/{uid}` - Actualizar usuario

### **Proyectos** (`/api/proyectos`)
- `GET /api/proyectos` - Listar todos los proyectos
- `GET /api/proyectos/{id}` - Buscar proyecto por ID
- `GET /api/proyectos/programador/{idProgramador}` - Proyectos por programador
- `GET /api/proyectos/tipo/{tipo}` - Proyectos por tipo
- `POST /api/proyectos` - Crear proyecto
- `PUT /api/proyectos/{id}` - Actualizar proyecto
