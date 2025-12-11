# Análisis de Polimorfismo – SoundPro

## 1. Sobrecarga (Overloading)
### Métodos Sobrecargados
- `buscarEmpleado(String id)`
- `buscarEmpleado(Empleado prototipo)`
- `buscarEmpleado(double minSalario, double maxSalario)`
- `aplicarBono(double monto)` / `aplicarBono(double monto, double porcentaje)`

### Justificación
Permiten búsquedas flexibles por diferentes criterios y aplicar bonos de forma fija o porcentual.

---

## 2. Sobrescritura (Overriding)
### Tabla Comparativa
| Método | Clase Padre | EmpleadoPlanta | EmpleadoContrato |
|--------|-------------|----------------|------------------|
| `calcularSalario()` | salario base | salario + bono por antigüedad | salario base |
| `obtenerDescripcion()` | "Empleado general" | "Planta, años: X" | "Contrato, meses: Y" |

### Código Ejemplo
Se usa `@Override` en subclases para redefinir comportamiento según tipo de empleado.

---

## 3. Polimorfismo Dinámico
### Ejemplo de Dynamic Binding
- `SistemaRH.procesarNomina(Empleado empleado)` recibe la clase padre.
- Al llamar `empleado.calcularSalario()`, se ejecuta la versión específica de la subclase.

### Explicación
El enlace dinámico invoca métodos según el tipo real del objeto, habilitando extensibilidad sin modificar el sistema gestor.

---

## 4. Beneficios
- Flexibilidad: procesamiento de nómina para cualquier tipo de empleado.
- Extensibilidad: nuevas subclases pueden integrarse sin cambiar `SistemaRH`.
- Mantenibilidad: lógica localizada en subclases y métodos específicos.
