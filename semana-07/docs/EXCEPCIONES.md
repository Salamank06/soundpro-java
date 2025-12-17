# Análisis de Excepciones – SoundPro Semana 07

## 1. Excepciones Personalizadas Implementadas

### 1.1 SalarioInvalidoException

**Jerarquía**: `Exception` → `SalarioInvalidoException`

**Propósito**: Validar que los salarios cumplan con los requisitos mínimos del sistema.

**Casos de uso**:
- Salario negativo
- Salario fuera del rango permitido por la empresa

**Constructores**:
```java
public SalarioInvalidoException(String mensaje)
public SalarioInvalidoException(String mensaje, double salarioInvalido)
public SalarioInvalidoException(String mensaje, Throwable causa)
```

**Ejemplo de lanzamiento**:
```java
if (salarioBase < 0) {
    throw new SalarioInvalidoException("El salario base no puede ser negativo.", salarioBase);
}
```

---

### 1.2 PersonalNoEncontradoException

**Jerarquía**: `Exception` → `PersonalNoEncontradoException`

**Propósito**: Indicar que no existe personal con los criterios de búsqueda especificados.

**Casos de uso**:
- Búsqueda por ID inexistente
- Búsqueda con criterios que no coinciden con ningún registro

**Constructores**:
```java
public PersonalNoEncontradoException(String id)
public PersonalNoEncontradoException()
public PersonalNoEncontradoException(String mensaje, Throwable causa)
```

**Ejemplo de lanzamiento**:
```java
for (PersonalAbstract e : personal) {
    if (e.getIdentificacion().equals(id)) return e;
}
throw new PersonalNoEncontradoException(id);
```

---

### 1.3 CalificacionInvalidaException

**Jerarquía**: `Exception` → `CalificacionInvalidaException`

**Propósito**: Validar que las calificaciones estén en el rango correcto (0-100).

**Casos de uso**:
- Calificación negativa
- Calificación mayor a 100
- Formato inválido

**Constructores**:
```java
public CalificacionInvalidaException(int calificacion)
public CalificacionInvalidaException(String mensaje)
public CalificacionInvalidaException(String mensaje, Throwable causa)
```

**Ejemplo de lanzamiento**:
```java
if (calificacion < 0 || calificacion > 100) {
    throw new CalificacionInvalidaException(calificacion);
}
```

---

## 2. Estrategia de Manejo de Excepciones

### 2.1 Excepciones Checked vs Unchecked

**Decisión**: Usar excepciones **checked** (extends `Exception`)

**Justificación**:
- Son errores de negocio recuperables
- El llamador debe decidir explícitamente cómo manejarlas
- Documenta contratos de métodos mediante `throws`
- Obliga a escribir código robusto

**Comparación**:

| Aspecto | Checked (Exception) | Unchecked (RuntimeException) |
|---------|---------------------|------------------------------|
| **Compilador** | Obliga try-catch o throws | No requiere manejo |
| **Uso ideal** | Errores recuperables | Errores de programación |
| **Nuestro caso** | ✅ Usado | ❌ No usado |

### 2.2 Validaciones en Constructores

**Patrón implementado**: Fail-fast

```java
public PersonalAbstract(...) throws SalarioInvalidoException {
    if (salarioBase < 0) {
        throw new SalarioInvalidoException(...);
    }
    // ...
}
```

**Ventajas**:
- Garantiza objetos siempre en estado válido
- Detecta errores tempranamente
- Evita propagación de datos incorrectos

---

## 3. Uso de Excepciones en el Sistema

### 3.1 Métodos que Lanzan Excepciones

| Clase | Método | Excepciones |
|-------|--------|-------------|
| PersonalAbstract | constructor | SalarioInvalidoException |
| PersonalPlanta | constructor | SalarioInvalidoException |
| PersonalContrato | constructor | SalarioInvalidoException |
| Evaluable | setCalificacion() | CalificacionInvalidaException |
| SoundProHR | buscarPersonal(String) | PersonalNoEncontradoException |
| SoundProHR | evaluarPersonal() | CalificacionInvalidaException |

### 3.2 Manejo en Main

**Técnicas utilizadas**:

1. **Try-catch simple**:
```java
try {
    PersonalPlanta p = new PersonalPlanta(...);
} catch (SalarioInvalidoException e) {
    System.err.println("Error: " + e.getMessage());
}
```

2. **Multi-catch**:
```java
try {
    hr.evaluarPersonal(ana, 92);
} catch (PersonalNoEncontradoException | CalificacionInvalidaException e) {
    System.err.println("Error: " + e.getMessage());
}
```

3. **Finally**:
```java
try {
    // Operación
} catch (Exception e) {
    // Manejo
} finally {
    // SIEMPRE se ejecuta (limpieza, reportes, etc.)
    hr.mostrarNomina();
}
```

---

## 4. Beneficios Observados

### 4.1 Robustez
- Sistema no puede crear objetos en estado inválido
- Errores detectados inmediatamente
- Mensajes descriptivos facilitan debugging

### 4.2 Mantenibilidad
- Excepciones agrupadas en paquete dedicado
- Fácil agregar nuevas excepciones
- Documentación clara de errores posibles

### 4.3 Experiencia de Usuario
- Mensajes de error contextuales
- Diferenciación clara entre tipos de error
- Sistema continúa funcionando después de errores

---

## 5. Evolución desde Semana 06

| Aspecto | Semana 06 | Semana 07 |
|---------|-----------|-----------|
| **Validaciones** | Simples (if/print) | Excepciones checked |
| **Organización** | Archivos sueltos | Paquetes estructurados |
| **Errores** | Ignorados o prints | Manejo explícito |
| **Documentación** | Básica | Javadoc completo |
| **Robustez** | Media | Alta |

---

## 6. Principios SOLID Aplicados

### Single Responsibility Principle (SRP)
- Cada excepción representa UN tipo específico de error
- Clases de modelo no manejan excepciones (solo las lanzan)
- SoundProHR gestiona lógica de negocio

### Open/Closed Principle (OCP)
- Nuevas excepciones pueden agregarse sin modificar código existente
- Nuevos tipos de personal heredan manejo de excepciones

### Liskov Substitution Principle (LSP)
- PersonalPlanta y PersonalContrato pueden usarse polimórficamente
- Mismas excepciones declaradas en interfaz Evaluable

---

## 7. Mejores Prácticas Aplicadas

✅ **Nombres descriptivos**: `SalarioInvalidoException` vs `ErrorException`  
✅ **Constructores múltiples**: mensaje, mensaje+valor, mensaje+causa  
✅ **Javadoc completo**: En todas las excepciones y métodos  
✅ **Mensajes contextuales**: Incluyen valores inválidos  
✅ **No catch genérico**: Catch específico para cada tipo  
✅ **Finally para limpieza**: Garantiza ejecución de código crítico  

---

## 8. Casos de Prueba Implementados

| # | Descripción | Tipo | Resultado Esperado |
|---|-------------|------|-------------------|
| 1 | Crear personal válido | ✅ Éxito | Personal creado |
| 2 | Salario negativo | ❌ Error | SalarioInvalidoException |
| 3 | Buscar ID existente | ✅ Éxito | Personal encontrado |
| 4 | Buscar ID inexistente | ❌ Error | PersonalNoEncontradoException |
| 5 | Evaluaciones válidas | ✅ Éxito | Calificaciones asignadas |
| 6 | Calificación > 100 | ❌ Error | CalificacionInvalidaException |
| 7 | Calificación < 0 | ❌ Error | CalificacionInvalidaException |
| 8 | Finally | ✅ Siempre | Nómina mostrada |

---

## Conclusión

La implementación de excepciones personalizadas y paquetes estructurados transforma el sistema SoundPro en una aplicación empresarial robusta, mantenible y profesional. El manejo explícito de errores garantiza que el sistema se comporte predeciblemente incluso en situaciones excepcionales.

