# Semana 08: Colecciones y Generics - SoundPro

## 📝 Descripción del Proyecto

Sistema de gestión de recursos humanos para **SoundPro** (estudio de grabación profesional). 

**Esta semana**: Refactoricé el sistema para usar colecciones profesionales (HashMap, TreeSet, LinkedHashMap) en lugar de estructuras simples, agregando operaciones de búsqueda eficiente O(1), filtrado avanzado y estadísticas del personal.

## 📦 Colecciones Utilizadas

### HashMap
- `Map<String, PersonalAbstract>` - Búsqueda rápida por ID del personal
- `LinkedHashMap<String, Integer>` - Historial cronológico de evaluaciones

### TreeSet
- `TreeSet<PersonalAbstract>` - Personal ordenado automáticamente por salario

### ArrayList
- `List<PersonalAbstract>` - Listas temporales para ordenamiento personalizado

## 🔍 Operaciones Implementadas

### CRUD con Colecciones
- ✅ Agregar con validación de duplicados (DuplicadoException)
- ✅ Buscar por clave O(1) con HashMap
- ✅ Listar con diferentes criterios de ordenamiento
- ✅ Filtrado por salario mínimo

### Filtrado
- ✅ Filtrar por salario mínimo
- ✅ Listar ordenado por nombre (ComparadorPorNombre)
- ✅ Listar ordenado por ID (ComparadorPorID)
- ✅ Listar ordenado por salario (TreeSet automático)

### Estadísticas
- ✅ Total de nómina
- ✅ Antigüedad promedio
- ✅ Personal mejor pagado (TreeSet)
- ✅ Conteo por categoría (planta vs contrato)

## 🚀 Cómo Ejecutar

### Desde terminal:
```bash
cd semana-08
javac -encoding UTF-8 -d bin src/com/soundpro/*/*.java src/com/soundpro/*.java
java -cp bin com.soundpro.MainInteractivo
```

### Desde IntelliJ IDEA:
1. Abrir proyecto en IntelliJ
2. Marcar carpeta `src` como "Sources Root"
3. Clic derecho en `MainInteractivo.java`
4. Run 'MainInteractivo.main()'

## 📦 Estructura de Paquetes

```
com.soundpro/
├── modelo/              - Clases del dominio
│   ├── PersonalAbstract.java (implementa Comparable)
│   ├── PersonalPlanta.java
│   ├── PersonalContrato.java
│   ├── Evaluable.java
│   └── Bonificable.java
├── servicio/            - Lógica de negocio con colecciones
│   └── SoundProHR.java (HashMap, TreeSet, LinkedHashMap)
├── excepciones/         - Excepciones personalizadas
│   ├── SalarioInvalidoException.java
│   ├── PersonalNoEncontradoException.java
│   ├── CalificacionInvalidaException.java
│   └── DuplicadoException.java
├── util/                - Utilidades (Comparators)
│   ├── ComparadorPorNombre.java
│   └── ComparadorPorID.java
├── Main.java            - Demostración automática (12 casos)
└── MainInteractivo.java - Menú interactivo (9 opciones)
```

## ✅ Funcionalidades Implementadas

### Ejercicio 1: Migrar Arrays a ArrayList (25 pts)
- [x] ✅ NO se usan arrays (se usa HashMap + TreeSet superiores)
- [x] ✅ Uso de interfaz `List<E>`, `Map<K,V>`, `Set<E>`
- [x] ✅ Generics correctos en todas las colecciones
- [x] ✅ Sin warnings de compilación

### Ejercicio 2: Implementar HashMap (30 pts)
- [x] ✅ HashMap<String, PersonalAbstract> para búsqueda O(1) por ID
- [x] ✅ Validación de duplicados con containsKey()
- [x] ✅ Método buscarPersonal(String id) implementado
- [x] ✅ BONUS: TreeSet adicional para ordenamiento
- [x] ✅ BONUS: LinkedHashMap para evaluaciones cronológicas

### Ejercicio 3: Filtrado y Estadísticas (25 pts)
- [x] ✅ Filtrado por salario mínimo
- [x] ✅ Listar por diferentes criterios (nombre, ID, salario)
- [x] ✅ Cálculo de total de nómina
- [x] ✅ Promedio de antigüedad
- [x] ✅ Conteo por categoría (planta/contrato)
- [x] ✅ Personal mejor pagado (TreeSet)

### Ejercicio 4: Main con Demostración (20 pts)
- [x] ✅ Menú interactivo con 9 opciones (MainInteractivo.java)
- [x] ✅ Demuestra búsqueda HashMap O(1)
- [x] ✅ Demuestra iteración con for-each
- [x] ✅ Demuestra estadísticas completas
- [x] ✅ BONUS: Main.java con 12 casos automáticos

## 📊 Salida Esperada (MainInteractivo)

```
╔═══════════════════════════════════════════════╗
║   SOUNDPRO - SISTEMA DE GESTIÓN DE PERSONAL  ║
║          Semana 08: Colecciones               ║
╚═══════════════════════════════════════════════╝

✓ Datos de prueba cargados (3 personas).

┌─────────────────────────────────────────────┐
│            MENÚ PRINCIPAL                   │
├─────────────────────────────────────────────┤
│ 1. Agregar personal                         │
│ 2. Buscar por ID (HashMap O(1))             │
│ 3. Listar todos                             │
│ 4. Listar ordenado (por nombre/ID/salario)  │
│ 5. Filtrar por salario mínimo               │
│ 6. Evaluar personal                         │
│ 7. Ver estadísticas                         │
│ 8. Eliminar personal                        │
│ 0. Salir                                    │
└─────────────────────────────────────────────┘
Seleccione una opción:
```

## 🔧 Cambios Aplicados desde Semana 07

1. **HashMap**: Búsqueda O(1) por ID (antes era O(n) con ArrayList)
2. **TreeSet**: Ordenamiento automático por salario
3. **LinkedHashMap**: Historial de evaluaciones con orden de inserción
4. **Comparadores**: 3 formas de ordenar (Comparable + 2 Comparators)
5. **Filtrado**: Métodos de filtrado por criterios
6. **Estadísticas**: Análisis completo del personal
7. **Menú interactivo**: MainInteractivo.java con Scanner

## 💡 Decisiones de Diseño

- **HashMap vs ArrayList**: HashMap para búsquedas frecuentes por ID (O(1) vs O(n))
- **TreeSet adicional**: Mantiene personal ordenado automáticamente por salario
- **LinkedHashMap para evaluaciones**: Preserva orden cronológico de registro
- **Comparable en PersonalAbstract**: Define orden natural por salario
- **Comparators externos**: Permiten múltiples criterios de ordenamiento
- **DOS versiones de Main**: Automática (testing) e Interactiva (usuario)

## 📚 Referencias

- Oracle Java Collections Framework
- Effective Java (Joshua Bloch) - Item 10-14, 47-52
- Material del bootcamp - Semanas 04-07

---

**Versión**: 1.0  
**Semana**: 08  
**Estado**: ✅ Completo
