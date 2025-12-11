# Análisis de Abstracción e Interfaces – SoundPro

## Justificación de Abstracciones
- `EmpleadoAbstract` captura estado común (nombre, identificación, salario) y comportamiento compartido (`mostrarInfo`).
- Obliga a subclases a definir `calcularSalario` y `obtenerDescripcion`.

## Interfaces
- `Evaluable`: contrato de calificación (set/get, nivel).
- `Bonificable`: contrato de bonificación (porcentaje, monto fijo).
- Permiten capacidades transversales, no jerárquicas, y múltiple implementación.

## Jerarquía
EmpleadoAbstract
   |
----+----+
|         |
EmpleadoPlanta    EmpleadoContrato

## Principios SOLID
- SRP: Cada clase tiene una responsabilidad clara (cálculo salario, evaluación, bonos).
- OCP: Nuevos tipos de empleados e interfaces pueden añadirse sin modificar los existentes.
- ISP: Interfaces pequeñas y enfocadas (`Evaluable`, `Bonificable`).

## Mejoras vs Semana 05
- Separación más clara entre estado compartido (abstracta) y capacidades (interfaces).
- Polimorfismo enriquecido vía tipos de interfaz y clase abstracta.
