🏥 Sistema de Gestión Hospitalaria – Spring Boot API

API REST desarrollada con Spring Boot para la gestión integral de un sistema hospitalario. Permite administrar pacientes, doctores, especialidades, turnos médicos, camas y análisis clínicos, incorporando seguridad con JWT y arquitectura en capas.
🚀 Tecnologías Utilizadas

Java 17+

Spring Boot

Spring Web

Spring Data JPA

Spring Security + JWT

Hibernate

Swagger / OpenAPI

Lombok

H2 / MySQL (configurable)

Maven

📐 Arquitectura del Proyecto

El proyecto sigue una arquitectura en capas: Controller: expone endpoints REST

Service: lógica de negocio

Repository: acceso a datos (JPA)

DTOs: separación entre API y modelo

Mappers: conversión Entity ↔ DTO

Security: autenticación con JWT

🧩 Módulos del Sistema 👤 Pacientes

Crear, actualizar y eliminar pacientes

Búsqueda por DNI, nombre, teléfono, email

Contraseñas encriptadas con BCrypt

👨‍⚕️ Doctores

Alta, baja y modificación de doctores

Asociación con especialidades

Consulta por especialidad

🧠 Especialidades

CRUD completo

Relación uno a muchos con doctores

📅 Turnos

Crear, actualizar y cancelar turnos

Estados: RESERVADO, CANCELADO, COMPLETADO

Filtros dinámicos por paciente, doctor, fecha y estado

🛏️ Camas

Administración de camas hospitalarias

Estados: DISPONIBLE, OCUPADA, MANTENIMIENTO

Asignación y liberación de camas

🧪 Análisis Clínicos

Registro de análisis por paciente

Eliminación y consulta por paciente

📌 Próximas Mejoras

Roles (ADMIN, DOCTOR, PACIENTE)

Tests unitarios e integración

Manejo global de excepciones

Auditoría (createdAt, updatedAt)

Paginación y ordenamiento

Dockerización
