# Bootcamp Java POO - SoundPro

## 👤 Información del Estudiante
- **Nombre**: Luis Fernando Sanchez Loaiza
- **Ficha**: 3228973A
- **Dominio**: Estudio de Grabación "SoundPro"

## 📝 Descripción del Proyecto

**SoundPro** es un sistema integral de gestión para un estudio de grabación profesional que incluye:
- Gestión de sesiones de grabación
- Administración de cabinas y equipamiento
- Sistema de facturación
- Gestión de recursos humanos (RRHH)

Este proyecto fue desarrollado progresivamente durante 8 semanas de un bootcamp de Programación Orientada a Objetos en Java, demostrando la evolución desde conceptos básicos hasta técnicas avanzadas.

## 🗂️ Estructura del Proyecto

```
soundpro-java/
├── README.md                    ← Este archivo
├── .gitignore
├── semana-02/                   ← Modelado OO + ArrayList
│   ├── README.md
│   ├── src/
│   └── docs/
├── semana-03/                   ← Encapsulación + Validaciones
│   ├── README.md
│   ├── src/
│   └── docs/
├── semana-04/                   ← Herencia
│   ├── README.md
│   ├── src/
│   └── docs/
├── semana-05/                   ← Polimorfismo
│   ├── README.md
│   ├── src/
│   └── docs/
├── semana-06/                   ← Clases Abstractas + Interfaces
│   ├── README.md
│   ├── src/
│   └── docs/
├── semana-07/                   ← Paquetes + Excepciones
│   ├── README.md
│   ├── src/
│   └── docs/
└── semana-08/                   ← Colecciones Avanzadas
    ├── README.md
    ├── src/
    └── docs/
```

## 📚 Evolución por Semana

### Semana 02: Modelado Orientado a Objetos
- **Conceptos**: Clases, objetos, relaciones, ArrayList
- **Clases**: Client, StudioBooth, RecordingSession, Invoice, SoundProManager
- **Enfoque**: Dominio del estudio de grabación

### Semana 03: Encapsulación
- **Conceptos**: Modificadores de acceso, getters/setters, validaciones
- **Evolución**: Mismas clases con encapsulación completa
- **Documentación**: MEJORAS.md

### Semana 04: Herencia
- **Conceptos**: Extends, super(), jerarquías
- **Clases**: PersonalSoundPro (padre) → PersonalPlanta, PersonalContrato (hijos)
- **Enfoque**: Dominio de RRHH
- **Documentación**: JERARQUIA.md

### Semana 05: Polimorfismo
- **Conceptos**: Sobrescritura (@Override), sobrecarga, dynamic binding
- **Evolución**: Gestor polimórfico (SoundProHR)
- **Documentación**: POLIMORFISMO.md

### Semana 06: Clases Abstractas e Interfaces
- **Conceptos**: abstract, implements, contratos
- **Evolución**: PersonalSoundPro → PersonalAbstract
- **Interfaces**: Evaluable, Bonificable
- **Documentación**: ANALISIS.md

### Semana 07: Paquetes y Excepciones
- **Conceptos**: package, import, excepciones personalizadas
- **Estructura**: com.soundpro.{modelo, servicio, excepciones}
- **Excepciones**: SalarioInvalidoException, PersonalNoEncontradoException, CalificacionInvalidaException
- **Documentación**: EXCEPCIONES.md

### Semana 08: Colecciones Avanzadas
- **Conceptos**: HashMap, TreeSet, LinkedHashMap, Comparable, Comparator
- **Mejoras**: Búsquedas O(1), ordenamiento automático, comparadores
- **Funcionalidades**: Filtrado, estadísticas, menú interactivo
- **Documentación**: COLECCIONES.md

## 🚀 Cómo Ejecutar

### Requisitos
- Java JDK 8 o superior
- Terminal con soporte UTF-8

### Compilación y Ejecución (ejemplo Semana 08)

```bash
# Navegar a la semana deseada
cd semana-08

# Compilar
javac -encoding UTF-8 -d bin src/com/soundpro/*/*.java src/com/soundpro/*.java

# Ejecutar (versión con demostración automática)
java -cp bin com.soundpro.Main

# O ejecutar (versión con menú interactivo)
java -cp bin com.soundpro.MainInteractivo
```

### Compilación de Semanas 02-06 (sin paquetes)

```bash
# Ejemplo: Semana 05
cd semana-05
javac -encoding UTF-8 -d bin src/*.java
java -cp bin Main
```

## 🎯 Principios Aplicados

### SOLID
- **S**ingle Responsibility: Cada clase tiene una responsabilidad clara
- **O**pen/Closed: Extensible sin modificar código existente
- **L**iskov Substitution: Subclases son intercambiables con el padre
- **I**nterface Segregation: Interfaces pequeñas y específicas
- **D**ependency Inversion: Dependencia de abstracciones

### Patrones de Diseño
- **Gestores**: SoundProManager, SoundProHR
- **Estrategia**: Comparadores personalizados
- **Template Method**: Métodos abstractos en PersonalAbstract

## 📊 Métricas del Proyecto

- **Semanas completadas**: 8/8
- **Clases implementadas**: 20+
- **Interfaces**: 3
- **Excepciones personalizadas**: 4
- **Líneas de código**: ~2000
- **Documentación**: 10+ archivos .md

## 🔧 Tecnologías

- **Lenguaje**: Java 8+
- **Colecciones**: ArrayList, HashMap, TreeSet, LinkedHashMap
- **Paradigma**: Programación Orientada a Objetos
- **Control de versiones**: Git

## 📖 Documentación Adicional

Cada semana contiene:
- `README.md`: Descripción, estructura, instrucciones de ejecución
- `docs/`: Archivos .md con análisis conceptual específico de la semana

## 👨‍💻 Autor

**Santiago Salamanca**  
Estudiante de Bootcamp Java POO  
Email: Santicosalamanca@gmail.com

---

**Estado del proyecto**: ✅ Completo (Semanas 02-08)  
**Última actualización**: Diciembre 2024

