# Análisis de Colecciones y Comparadores – SoundPro Semana 08

## 1. Colecciones Implementadas

### 1.1 HashMap<String, PersonalAbstract>

**Declaración**:
```java
private final HashMap<String, PersonalAbstract> personalPorID = new HashMap<>();
```

**Características**:
- **Estructura**: Tabla hash
- **Complejidad**:
  - Búsqueda: O(1) promedio
  - Inserción: O(1) promedio
  - Eliminación: O(1) promedio
- **Orden**: No garantiza orden
- **Duplicados**: Claves únicas (ID único)

**Uso en el sistema**:
```java
// Agregar
personalPorID.put(p.getIdentificacion(), p);

// Buscar (muy rápido)
PersonalAbstract p = personalPorID.get(id);

// Verificar duplicado
if (personalPorID.containsKey(id)) {
    throw new DuplicadoException(id);
}
```

**Ventajas**:
✅ Búsqueda instantánea por ID  
✅ Escalable a miles de registros  
✅ API simple y directa  

**Desventajas**:
❌ Sin orden natural  
❌ Mayor uso de memoria que ArrayList  

---

### 1.2 TreeSet<PersonalAbstract>

**Declaración**:
```java
private final TreeSet<PersonalAbstract> personalOrdenado = new TreeSet<>();
```

**Características**:
- **Estructura**: Árbol Rojo-Negro balanceado
- **Complejidad**:
  - Búsqueda: O(log n)
  - Inserción: O(log n)
  - Eliminación: O(log n)
- **Orden**: Automático según Comparable
- **Duplicados**: No permite (según equals/hashCode)

**Uso en el sistema**:
```java
// Agregar (se ordena automáticamente)
personalOrdenado.add(p);

// Obtener ordenado (ya está ordenado!)
TreeSet<PersonalAbstract> ordenado = new TreeSet<>(personalOrdenado);

// Iterar en orden
for (PersonalAbstract p : personalOrdenado) {
    // Siempre en orden de mayor a menor salario
}
```

**Ventajas**:
✅ Siempre ordenado automáticamente  
✅ No necesita llamar sort()  
✅ Eficiente para conjuntos que cambian frecuentemente  

**Desventajas**:
❌ Más lento que HashMap para búsqueda  
❌ Requiere implementar Comparable o Comparator  

---

### 1.3 LinkedHashMap<String, Integer>

**Declaración**:
```java
private final LinkedHashMap<String, Integer> evaluaciones = new LinkedHashMap<>();
```

**Características**:
- **Estructura**: HashMap + Lista doblemente enlazada
- **Complejidad**: Similar a HashMap (O(1) promedio)
- **Orden**: Mantiene orden de inserción
- **Duplicados**: Claves únicas

**Uso en el sistema**:
```java
// Agregar evaluación
evaluaciones.put(p.getIdentificacion(), calificacion);

// Iterar en orden de registro
for (Map.Entry<String, Integer> entry : evaluaciones.entrySet()) {
    // Se recorre en orden cronológico
}
```

**Ventajas**:
✅ Rendimiento de HashMap  
✅ Mantiene orden de inserción  
✅ Ideal para historial cronológico  

**Desventajas**:
❌ Ligeramente más memoria que HashMap  

---

### 1.4 ArrayList<PersonalAbstract>

**Uso**:
```java
List<PersonalAbstract> lista = new ArrayList<>(personalPorID.values());
lista.sort(new ComparadorPorNombre());
```

**Características**:
- **Estructura**: Array dinámico
- **Complejidad**:
  - Acceso por índice: O(1)
  - Búsqueda: O(n)
  - Inserción al final: O(1) amortizado
- **Orden**: Orden de inserción o personalizado con sort()
- **Duplicados**: Permite duplicados

**Ventajas**:
✅ Rápido acceso por índice  
✅ Flexible para ordenamiento personalizado  
✅ Compatible con Collections.sort()  

---

## 2. Comparadores Implementados

### 2.1 Comparable<PersonalAbstract> (Orden Natural)

**Implementación**:
```java
public abstract class PersonalAbstract implements Comparable<PersonalAbstract> {
    @Override
    public int compareTo(PersonalAbstract otro) {
        // Orden: Mayor salario primero
        return Double.compare(otro.calcularSalario(), this.calcularSalario());
    }
}
```

**Características**:
- Define el orden "natural" de los objetos
- Usado por TreeSet, Collections.sort(), Arrays.sort()
- Solo puede haber UNA implementación por clase

**Resultado**:
```
Diana Silva [E005] - $3500000.00  ← Mayor salario
María López [E003] - $2875000.00
Ana García [E001] - $2500000.00
Carlos Ruiz [E004] - $1800000.00
Luis Martínez [E002] - $1500000.00  ← Menor salario
```

---

### 2.2 ComparadorPorNombre (Comparator)

**Implementación**:
```java
public class ComparadorPorNombre implements Comparator<PersonalAbstract> {
    @Override
    public int compare(PersonalAbstract p1, PersonalAbstract p2) {
        return p1.getNombre().compareToIgnoreCase(p2.getNombre());
    }
}
```

**Uso**:
```java
lista.sort(new ComparadorPorNombre());
```

**Resultado**:
```
Ana García
Carlos Ruiz
Diana Silva
Luis Martínez
María López
```

---

### 2.3 ComparadorPorID (Comparator)

**Implementación**:
```java
public class ComparadorPorID implements Comparator<PersonalAbstract> {
    @Override
    public int compare(PersonalAbstract p1, PersonalAbstract p2) {
        return p1.getIdentificacion().compareTo(p2.getIdentificacion());
    }
}
```

**Resultado**:
```
E001 - Ana García
E002 - Luis Martínez
E003 - María López
E004 - Carlos Ruiz
E005 - Diana Silva
```

---

### 2.4 Lambda Comparator (Java 8+)

**Implementación inline**:
```java
// Ordenar por salario base (menor a mayor)
lista.sort((p1, p2) -> Double.compare(p1.getSalarioBase(), p2.getSalarioBase()));

// Ordenar por nombre (con referencia a método)
lista.sort(Comparator.comparing(PersonalAbstract::getNombre));
```

**Ventajas**:
✅ Sintaxis concisa  
✅ No requiere clase separada  
✅ Ideal para ordenamientos únicos  

---

## 3. Comparación de Enfoques

### Comparable vs Comparator

| Aspecto | Comparable | Comparator |
|---------|-----------|------------|
| **Definición** | Dentro de la clase | Clase externa |
| **Cantidad** | Solo UNO | Múltiples posibles |
| **Modificación** | Requiere acceso al código | No requiere modificar clase |
| **Uso** | `Collections.sort(lista)` | `lista.sort(comparador)` |
| **Cuándo usar** | Orden "natural" obvio | Ordenes alternativos |

### HashMap vs TreeSet

| Operación | HashMap | TreeSet | Ganador |
|-----------|---------|---------|---------|
| Búsqueda por clave | O(1) | O(log n) | HashMap |
| Inserción | O(1) | O(log n) | HashMap |
| Orden automático | ❌ No | ✅ Sí | TreeSet |
| Iterar ordenado | O(n log n) | O(n) | TreeSet |
| Memoria | Media | Alta | HashMap |

**Decisión**: Usar AMBOS para diferentes propósitos
- HashMap: Búsqueda rápida
- TreeSet: Mantener orden

---

## 4. Implementación de equals() y hashCode()

**Necesario para HashMap y TreeSet**:

```java
@Override
public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    PersonalAbstract that = (PersonalAbstract) obj;
    return identificacion.equals(that.identificacion);
}

@Override
public int hashCode() {
    return identificacion.hashCode();
}
```

**Reglas importantes**:
1. Si `a.equals(b)` → `a.hashCode() == b.hashCode()`
2. Usar mismos campos en equals y hashCode
3. Objetos iguales deben tener mismo hash

---

## 5. Casos de Uso por Colección

### Caso 1: Búsqueda Frecuente por ID
**Solución**: HashMap
```java
PersonalAbstract p = personalPorID.get("E001"); // O(1)
```

### Caso 2: Mostrar Top 10 Salarios
**Solución**: TreeSet
```java
int count = 0;
for (PersonalAbstract p : personalOrdenado) {
    if (count++ >= 10) break;
    System.out.println(p);
}
```

### Caso 3: Historial de Cambios
**Solución**: LinkedHashMap
```java
// Mantiene orden cronológico automáticamente
for (Map.Entry<String, Integer> entry : evaluaciones.entrySet()) {
    System.out.println(entry.getKey() + ": " + entry.getValue());
}
```

### Caso 4: Ordenamiento Personalizado
**Solución**: ArrayList + Comparator
```java
List<PersonalAbstract> lista = new ArrayList<>(personalPorID.values());
lista.sort(new ComparadorPorNombre());
```

---

## 6. Evolución del Sistema

### Semana 06: ArrayList Simple
```java
ArrayList<PersonalAbstract> personal = new ArrayList<>();
// Búsqueda: O(n)
for (PersonalAbstract p : personal) {
    if (p.getIdentificacion().equals(id)) return p;
}
```

### Semana 08: HashMap + TreeSet
```java
HashMap<String, PersonalAbstract> personalPorID = new HashMap<>();
TreeSet<PersonalAbstract> personalOrdenado = new TreeSet<>();
// Búsqueda: O(1)
return personalPorID.get(id);
```

**Mejora**: De O(n) a O(1) en búsquedas → **Mejora significativa**

---

## 7. Mejores Prácticas Aplicadas

✅ **Usar interfaz como tipo**:
```java
Map<String, PersonalAbstract> map = new HashMap<>();  // ✅ Bueno
HashMap<String, PersonalAbstract> map = new HashMap<>();  // ❌ Menos flexible
```

✅ **Elegir colección según operación más frecuente**:
- Búsqueda por clave → HashMap
- Orden automático → TreeSet
- Orden de inserción → LinkedHashMap
- Acceso por índice → ArrayList

✅ **Implementar equals/hashCode cuando se use HashMap/HashSet**

✅ **Implementar Comparable para orden natural obvio**

✅ **Usar Comparator para ordenes alternativos**

---

## Conclusión

La implementación de colecciones avanzadas y comparadores transforma SoundPro en un sistema de alto rendimiento capaz de manejar grandes volúmenes de datos eficientemente. La combinación de HashMap (acceso rápido), TreeSet (orden automático) y LinkedHashMap (historial) proporciona una solución completa y profesional.

**Mejora cuantificable**: Búsqueda de O(n) a O(1) = **Hasta 1000x más rápido con 1000 registros**.

