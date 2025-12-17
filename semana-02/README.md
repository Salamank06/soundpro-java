# Entrega: Semana 02 - Estudio de Grabación "SoundPro"

**Dominio:** Estudio de Grabación SoundPro

---

## Objetivos Cumplidos

El objetivo de esta entrega fue expandir el modelado del estudio de grabación SoundPro, implementando **relaciones de agregación/asociación** entre objetos y el uso de **colecciones dinámicas (`ArrayList`)** para la gestión de datos.

## Checklist de Entrega

| Criterio | Estado | Detalle de la Implementación |
| :--- | :--- | :--- |
| **Mínimo 2 nuevas clases** | [X] Cumplido | **`StudioBooth.java`** (Cabina) y **`Invoice.java`** (Factura). |
| **ArrayList implementado** | [X] Cumplido | Usado en **`Client.java`** (historial de sesiones) y en la clase gestora **`SoundProManager.java`** (gestión de clientes y cabinas). |
| **Relaciones entre objetos** | [X] Cumplido | `RecordingSession` se relaciona con `Client` y `StudioBooth`. `Invoice` se relaciona con `RecordingSession` y `Client`. |
| **Main.java funcional** | [X] Cumplido | El programa demuestra la creación de todas las relaciones, el uso de `ArrayList`, la reserva de cabinas y el cálculo de facturas. |
| **README.md completo** | [X] Cumplido | Este documento. |
| **Código compila sin errores** | [X] Cumplido | Verificado en terminal. |

---

## Estructura y Componentes de la Solución

### Clases y Roles Implementados

| Archivo | Rol en el Proyecto | Implementación Clave |
| :--- | :--- | :--- |
| **`StudioBooth.java`** | Clase Nueva 1 | Modelado del espacio físico (cabina). |
| **`Invoice.java`** | Clase Nueva 2 | Registro de facturación (relación 1:1 con la sesión). |
| **`SoundProManager.java`** | Clase Gestora | Contiene `ArrayList<Client>` y `ArrayList<StudioBooth>`. |
| **`Client.java`** | Base (Modificada) | Contiene `ArrayList<RecordingSession>` (Historial). |
| **`RecordingSession.java`** | Base (Modificada) | Contiene relaciones con `Client` y `StudioBooth`. |
| **`Main.java`** | Driver | Prueba las funcionalidades. |

### Estructura del Repositorio

semana-02/ ├── README.md ├── StudioBooth.java ├── Invoice.java ├── SoundProManager.java ├── RecordingSession.java ├── Client.java └── Main.java


---

## Comandos de Compilación

```bash
cd semana-02
javac -encoding UTF-8 -d bin src/*.java
java -cp bin Main
```

---

## Proceso de Entrega

El código se implementó siguiendo la nomenclatura **`PascalCase`** para clases y **`camelCase`** para variables, y se subió con el siguiente proceso:

```bash
# Agregar cambios
git add semana-02/

# Commit
git commit -m "feat(semana-02): Implementar clases de dominio (StudioBooth, Invoice), relaciones y ArrayList para SoundPro."

# Push
git push origin main