# Semana 07: Paquetes y Excepciones - SoundPro

## 📝 Descripción del Proyecto

Sistema de gestión de recursos humanos para **SoundPro**, un estudio de grabación profesional. El sistema permite administrar personal de planta y contrato, procesar nóminas, realizar evaluaciones de desempeño y aplicar bonificaciones, con validaciones robustas mediante excepciones personalizadas.

## 📦 Estructura de Paquetes

```
com.soundpro/
├── modelo/              - Clases del dominio (Personal, Interfaces)
│   ├── PersonalAbstract.java
│   ├── PersonalPlanta.java
│   ├── PersonalContrato.java
│   ├── Evaluable.java
│   └── Bonificable.java
├── servicio/            - Lógica de negocio (Gestión de RRHH)
│   └── SoundProHR.java
├── excepciones/         - Excepciones personalizadas
│   ├── SalarioInvalidoException.java
│   ├── PersonalNoEncontradoException.java
│   └── CalificacionInvalidaException.java
└── Main.java            - Punto de entrada con casos de prueba
```

## ⚠️ Excepciones Personalizadas

### 1. SalarioInvalidoException
- **Tipo**: Checked (extends Exception)
- **Cuándo se lanza**: Cuando se intenta crear personal con salario negativo o inválido
- **Ejemplo**: `new PersonalPlanta("Ana", "E001", -500000, 5)` → Excepción

### 2. PersonalNoEncontradoException
- **Tipo**: Checked (extends Exception)
- **Cuándo se lanza**: Cuando se busca personal por ID y no existe en el sistema
- **Ejemplo**: `hr.buscarPersonal("E999")` → Excepción si E999 no existe

### 3. CalificacionInvalidaException
- **Tipo**: Checked (extends Exception)
- **Cuándo se lanza**: Cuando se asigna una calificación fuera del rango 0-100
- **Ejemplo**: `personal.setCalificacion(150)` → Excepción

## 🚀 Cómo Ejecutar

### Desde terminal (Windows - Git Bash):
```bash
cd semana-07
javac -encoding UTF-8 -d bin src/com/soundpro/*/*.java src/com/soundpro/*.java
java -cp bin com.soundpro.Main
```

### Desde terminal (Linux/Mac):
```bash
cd semana-07
javac -d bin src/com/soundpro/*/*.java src/com/soundpro/*.java
java -cp bin com.soundpro.Main
```

### Desde IntelliJ IDEA:
1. Abrir proyecto en IntelliJ
2. Marcar carpeta `src` como "Sources Root"
3. Clic derecho en `Main.java`
4. Run 'Main.main()'

## ✅ Funcionalidades Implementadas

- [x] Organización en paquetes (com.soundpro.*)
- [x] 3 excepciones personalizadas (checked)
- [x] Validaciones con excepciones en constructores
- [x] Try-catch en Main con 8 casos de prueba
- [x] Finally para operaciones de limpieza
- [x] Documentación Javadoc en todas las clases
- [x] Mensajes descriptivos en excepciones
- [x] Multi-catch para manejo eficiente

## 📊 Salida Esperada

```
=== SOUNDPRO - SEMANA 07: PAQUETES Y EXCEPCIONES ===

--- Caso 1: Crear Personal Válido ---
✓ Agregado: Planta, años: 5
✓ Agregado: Contrato, meses: 6
✓ Agregado: Planta, años: 3
✅ Personal creado exitosamente

--- Caso 2: Salario Negativo (Debe Fallar) ---
❌ Excepción capturada correctamente: El salario base no puede ser negativo. Valor recibido: $-500000.00

--- Caso 3: Buscar Personal Existente ---
✓ Encontrado: Luis Martínez
  Salario: $1500000.00

--- Caso 4: Buscar Personal Inexistente (Debe Fallar) ---
❌ Excepción capturada correctamente: No se encontró personal con ID: E999

--- Caso 5: Evaluaciones Válidas ---
✓ Evaluación registrada: 92 → Excelente
✓ Evaluación registrada: 80 → Bueno
✓ Evaluación registrada: 75 → Bueno

--- Caso 6: Calificación Inválida (Debe Fallar) ---
❌ Excepción capturada correctamente: Calificación inválida: 150. Debe estar entre 0 y 100.

--- Caso 7: Calificación Negativa (Debe Fallar) ---
❌ Excepción capturada correctamente: Calificación inválida: -10. Debe estar entre 0 y 100.

--- Caso 8: Nómina Final (con Finally) ---
✓ Agregado: Planta, años: 1
✓ Personal temporal agregado

🔒 Bloque finally ejecutado: Generando reporte...

=== NÓMINA COMPLETA ===
Ana García (E001): $2500000.00
Luis Martínez (E002): $1500000.00
María López (E003): $2875000.00
Temporal (E099): $1890000.00
TOTAL: $8765000.00

✅ Programa finalizado correctamente.
📊 Total de personal registrado: 4
```

## 🔧 Cambios Aplicados desde Semana 06

1. **Reorganización en Paquetes**: Código movido de raíz a estructura `com.soundpro.*`
2. **Excepciones Personalizadas**: Creadas 3 excepciones checked específicas del dominio
3. **Validaciones Robustas**: Agregadas en constructores con `throw`
4. **Manejo de Errores**: Try-catch con multi-catch en operaciones críticas
5. **Finally**: Demostración de limpieza garantizada
6. **Documentación**: Javadoc completo en todas las clases públicas

## 💡 Decisiones de Diseño

- **Checked vs Unchecked**: Se usaron excepciones checked (`extends Exception`) porque son errores de negocio recuperables que el llamador debe manejar explícitamente.
- **Paquete excepciones**: Separado para facilitar mantenimiento y permitir reutilización.
- **Validaciones en constructores**: Garantiza que nunca existan objetos en estado inválido (fail-fast).
- **Multi-catch**: Usado para manejar diferentes excepciones de forma elegante sin duplicar código.
- **Mensajes contextuales**: Las excepciones incluyen el valor inválido para facilitar debugging.

## 📚 Referencias

- Oracle Java Documentation - Exceptions
- Effective Java (Joshua Bloch) - Item 69-77
- Material del bootcamp - Semanas 04-06 (base del diseño)

---

**Versión**: 1.0  
**Semana**: 07  
**Estado**: ✅ Completo
