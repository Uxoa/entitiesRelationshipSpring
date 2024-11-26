# Sistema de Gestión para Clínica Veterinaria

- Content

### 🏁 **Contexto General**

Margarita está a punto de abrir su clínica veterinaria y necesita un sistema para gestionar los datos de sus pacientes y sus tutores. Este sistema será esencial para mantener organizada toda la información de los animales atendidos y sus responsables.

En este primer sprint, nos enfocaremos en las funcionalidades más importantes del sistema: el **gestor de pacientes** y el **gestor de tutores**. Margarita quiere empezar con un sistema sencillo pero funcional, que permita registrar, buscar, listar, actualizar y eliminar tanto pacientes como tutores.

El sistema será implementado como una **API REST** desarrollada en **Java Spring Boot**, y los datos serán almacenados en una base de datos.

---

## 👀 **Objetivo del Primer Sprint**

En este primer sprint, se desarrollará lo siguiente:

1. **Gestor de Tutores:**
    - Registro, búsqueda, listado, actualización y eliminación de tutores.
    - Relación entre tutores y pacientes, permitiendo reutilizar los datos de los tutores para varios pacientes.
2. **Gestor de Pacientes:**
    - Registro, búsqueda, listado, actualización y eliminación de pacientes.
    - Asociación de pacientes con sus respectivos tutores.

Con esto, Margarita podrá registrar y gestionar toda la información de sus pacientes y sus tutores de manera centralizada.

---

## 🧑🏽‍🦰 **Gestor de Tutores**

**Contexto:**

Además de los pacientes, Margarita necesita poder registrar a los tutores, quienes son responsables de traer a los animales a la clínica. Este módulo permitirá gestionar la información de los tutores de manera centralizada, asegurando que varios pacientes puedan asociarse al mismo tutor.

**Requisitos Funcionales:**

1. **Registro de Tutores:**
    - Permitir registrar tutores con la siguiente información:
        - Nombre completo (nombre y apellidos).
        - Número de teléfono.
        - Identificación única del tutor (autogenerada por el sistema).
2. **Búsqueda de Tutores:**
    - Buscar tutores por su nombre o número de identificación único.
    - Ver todos los detalles del tutor, incluyendo la lista de pacientes que están bajo su cuidado.
3. **Listado de Tutores:**
    - Listar todos los tutores registrados en el sistema.
    - Mostrar información básica como nombre y teléfono.
4. **Actualización de Tutores:**
    - Permitir modificar los datos de un tutor registrado, como su nombre o teléfono.
5. **Eliminación de Tutores:**
    - Permitir eliminar un tutor del sistema si ya no tiene pacientes asociados.

---

## 😿 **Gestor de Pacientes**

**Contexto:**

Margarita necesita poder registrar y gestionar a los pacientes de su clínica. Cada paciente debe tener información básica como su nombre, edad, especie, además de estar asociado a un tutor que sea responsable de él. Este módulo permitirá mantener un registro organizado de todos los pacientes y sus datos.

**Requisitos Funcionales:**

1. **Registro de Pacientes:**
    - Permitir registrar pacientes con la siguiente información:
        - Nombre del paciente.
        - Especie (**perro** o **gato**).
        - Raza (opcional y por defecto: “desconocido”).
        - Edad.
        - Número de identificación único (autogenerado).
        - Tutor asociado (por ID).
2. **Búsqueda de Pacientes:**
    - Buscar pacientes por su número de identificación único.
    - Ver todos los detalles del paciente, incluyendo el tutor asociado.
3. **Listado de Pacientes:**
    - Listar todos los pacientes registrados en el sistema.
    - Mostrar información básica como nombre, especie, y tutor asociado.
4. **Actualización de Pacientes:**
    - Permitir modificar los datos de un paciente registrado, como su nombre, especie, edad, tutor, etc.
5. **Eliminación de Pacientes:**
    - Permitir eliminar un paciente del sistema, asegurando que ya no esté disponible en los listados o búsquedas.

---

---

## **Resumen del Alcance del Primer Sprint**

| **Módulo** | **Funcionalidades** |
| --- | --- |
| **Gestor de Pacientes** | Registrar pacientes, buscar por identificación, listar todos los pacientes, actualizar y eliminar. |
| **Gestor de Tutores** | Registrar tutores, buscar por nombre o identificación, listar todos los tutores, actualizar y eliminar. |

---

## **Resultados Esperados**

1. Margarita podrá gestionar la información de los tutores y pacientes desde un sistema centralizado.
2. Cada paciente estará asociado a un tutor existente, garantizando la consistencia de los datos.
3. El sistema estará preparado para ser extendido en el siguiente sprint, donde se incluirá la gestión de citas.

## Entrega:

- Historias de Usuario y Criterios de Aceptación
- Diagrama de clases UML
- Diagrama de base de datos Modelo E/R
- Repositorio en Github documentado.
