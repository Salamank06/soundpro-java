# Semana 06: Clases Abstractas e Interfaces - SoundPro

## 📝 Descripción del Proyecto

Sistema de gestión de recursos humanos para **SoundPro** con clases abstractas e interfaces transversales.

**Esta semana**: Evolución de la jerarquía de herencia a clase abstracta `PersonalAbstract` e implementación de interfaces `Evaluable` y `Bonificable` para capacidades transversales.

## 📦 Estructura del Código

```
semana-06/
├── README.md
├── src/
│   ├── PersonalAbstract.java (clase abstracta)
│   ├── PersonalPlanta.java (implementa Evaluable, Bonificable)
│   ├── PersonalContrato.java (implementa Evaluable, Bonificable)
│   ├── Evaluable.java (interfaz)
│   ├── Bonificable.java (interfaz)
│   └── Main.java
└── docs/
    └── ANALISIS.md
```

## 🎯 Conceptos Implementados

### Clase Abstracta
- `PersonalAbstract`: Clase base abstracta con:
  - Atributos comunes (`nombre`, `identificacion`, `salarioBase`)
  - Método concreto: `mostrarInfo()`
  - Métodos abstractos: `calcularSalario()`, `obtenerDescripcion()`

### Interfaces
- `Evaluable`: Contrato para calificación y evaluación
  - `setCalificacion(int)`
  - `getCalificacion()`
  - `nivel()` (retorna nivel según calificación)
  
- `Bonificable`: Contrato para bonificaciones
  - `aplicarBono(double porcentaje)`
  - `aplicarBonoFijo(double monto)`

## 🚀 Cómo Ejecutar

### Desde terminal:
```bash
cd semana-06
javac -encoding UTF-8 -d bin src/*.java
java -cp bin Main
```

### Desde IntelliJ IDEA:
1. Abrir proyecto en IntelliJ
2. Clic derecho en `Main.java`
3. Run 'Main.main()'

## ✅ Funcionalidades Implementadas

- [x] Clase abstracta `PersonalAbstract` con métodos abstractos
- [x] Interfaces `Evaluable` y `Bonificable`
- [x] `PersonalPlanta` implementa ambas interfaces
- [x] `PersonalContrato` implementa ambas interfaces
- [x] Polimorfismo vía tipos de interfaz
- [x] Evaluación con calificación y nivel
- [x] Sistema de bonificaciones porcentual y fijo

## 📊 Salida Esperada

```
Personal: Ana | ID: E001
Planta, años: 5
Salario: $2500000.00
---
Personal: Luis | ID: E002
Contrato, meses: 6
Salario: $1500000.00
---
Ana nivel: Excelente
Luis nivel: Mejorable
Ana bono 10%: $2750000.00
Luis bono fijo 100k: $1600000.00
```

## 🔧 Cambios Aplicados desde Semana 05

1. **Clase abstracta**: `Personal` → `PersonalAbstract` (abstract)
2. **Interfaces**: Agregadas `Evaluable` y `Bonificable`
3. **Separación de responsabilidades**: Estado común (abstracta) vs capacidades (interfaces)
4. **Polimorfismo enriquecido**: Referencias por tipo de interfaz

## 💡 Decisiones de Diseño

- **Clase abstracta vs concreta**: Usamos abstracta porque nunca instanciaremos un "personal genérico"
- **Interfaces transversales**: Permiten capacidades que no son jerárquicas
- **Múltiple implementación**: Java permite implementar múltiples interfaces
- **SRP**: Cada interfaz tiene una responsabilidad clara

## 📚 Referencias

- Material del bootcamp - Semanas 04-05 (base de herencia y polimorfismo)
- docs/ANALISIS.md (análisis detallado de abstracción e interfaces)

---

**Versión**: 1.0  
**Semana**: 06  
**Estado**: ✅ Completo

