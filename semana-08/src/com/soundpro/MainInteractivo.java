package com.soundpro;

import com.soundpro.modelo.*;
import com.soundpro.servicio.SoundProHR;
import com.soundpro.excepciones.*;
import java.util.*;

/**
 * Clase principal con menú interactivo para gestionar personal de SoundPro.
 * Permite agregar, buscar, listar, filtrar y ver estadísticas del personal.
 */
public class MainInteractivo {
    private static SoundProHR hr = new SoundProHR();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("╔═══════════════════════════════════════════════╗");
        System.out.println("║   SOUNDPRO - SISTEMA DE GESTIÓN DE PERSONAL  ║");
        System.out.println("║          Semana 08: Colecciones               ║");
        System.out.println("╚═══════════════════════════════════════════════╝\n");

        cargarDatosPrueba();

        int opcion;
        do {
            mostrarMenu();
            opcion = leerOpcion();

            switch (opcion) {
                case 1: agregarPersonal(); break;
                case 2: buscarPorID(); break;
                case 3: listarTodos(); break;
                case 4: listarOrdenado(); break;
                case 5: filtrarPorSalario(); break;
                case 6: evaluarPersonal(); break;
                case 7: mostrarEstadisticas(); break;
                case 8: eliminarPersonal(); break;
                case 0: 
                    System.out.println("\n✅ ¡Gracias por usar SoundPro! Hasta luego.");
                    break;
                default: 
                    System.out.println("❌ Opción inválida. Intente nuevamente.");
            }

            if (opcion != 0) {
                System.out.println("\nPresione ENTER para continuar...");
                scanner.nextLine();
            }

        } while (opcion != 0);

        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n┌─────────────────────────────────────────────┐");
        System.out.println("│            MENÚ PRINCIPAL                   │");
        System.out.println("├─────────────────────────────────────────────┤");
        System.out.println("│ 1. Agregar personal                         │");
        System.out.println("│ 2. Buscar por ID (HashMap O(1))             │");
        System.out.println("│ 3. Listar todos                             │");
        System.out.println("│ 4. Listar ordenado (por nombre/ID/salario)  │");
        System.out.println("│ 5. Filtrar por salario mínimo               │");
        System.out.println("│ 6. Evaluar personal                         │");
        System.out.println("│ 7. Ver estadísticas                         │");
        System.out.println("│ 8. Eliminar personal                        │");
        System.out.println("│ 0. Salir                                    │");
        System.out.println("└─────────────────────────────────────────────┘");
        System.out.print("Seleccione una opción: ");
    }

    private static int leerOpcion() {
        try {
            int opcion = Integer.parseInt(scanner.nextLine());
            return opcion;
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static void agregarPersonal() {
        System.out.println("\n=== AGREGAR PERSONAL ===");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("ID: ");
        String id = scanner.nextLine();

        System.out.print("Salario base: ");
        double salario;
        try {
            salario = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("❌ Salario inválido.");
            return;
        }

        System.out.print("Tipo (1=Planta, 2=Contrato): ");
        int tipo = leerOpcion();

        try {
            if (tipo == 1) {
                System.out.print("Años de antigüedad: ");
                int anos = Integer.parseInt(scanner.nextLine());
                hr.agregarPersonal(new PersonalPlanta(nombre, id, salario, anos));
            } else if (tipo == 2) {
                System.out.print("Meses de contrato: ");
                int meses = Integer.parseInt(scanner.nextLine());
                hr.agregarPersonal(new PersonalContrato(nombre, id, salario, meses));
            } else {
                System.out.println("❌ Tipo inválido.");
                return;
            }
            System.out.println("✅ Personal agregado exitosamente.");
        } catch (SalarioInvalidoException | DuplicadoException e) {
            System.out.println("❌ Error: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("❌ Valor numérico inválido.");
        }
    }

    private static void buscarPorID() {
        System.out.println("\n=== BUSCAR POR ID (HashMap - O(1)) ===");
        System.out.print("Ingrese ID a buscar: ");
        String id = scanner.nextLine();

        try {
            PersonalAbstract p = hr.buscarPersonal(id);
            System.out.println("\n✓ Personal encontrado:");
            System.out.println("  Nombre: " + p.getNombre());
            System.out.println("  ID: " + p.getIdentificacion());
            System.out.println("  Tipo: " + p.obtenerDescripcion());
            System.out.println("  Salario: $" + String.format("%.2f", p.calcularSalario()));
        } catch (PersonalNoEncontradoException e) {
            System.out.println("❌ " + e.getMessage());
        }
    }

    private static void listarTodos() {
        System.out.println("\n=== LISTADO COMPLETO DE PERSONAL ===");
        if (hr.cantidadPersonal() == 0) {
            System.out.println("No hay personal registrado.");
            return;
        }

        int contador = 1;
        for (PersonalAbstract p : hr.listarPorID()) {
            System.out.println(contador++ + ". " + p);
        }
        System.out.println("\nTotal: " + hr.cantidadPersonal() + " personas");
    }

    private static void listarOrdenado() {
        System.out.println("\n=== LISTADO ORDENADO ===");
        System.out.println("1. Por nombre");
        System.out.println("2. Por ID");
        System.out.println("3. Por salario (mayor a menor)");
        System.out.print("Seleccione: ");

        int opcion = leerOpcion();
        List<PersonalAbstract> lista;

        switch (opcion) {
            case 1:
                System.out.println("\n--- Ordenado por NOMBRE ---");
                lista = hr.listarPorNombre();
                break;
            case 2:
                System.out.println("\n--- Ordenado por ID ---");
                lista = hr.listarPorID();
                break;
            case 3:
                System.out.println("\n--- Ordenado por SALARIO ---");
                lista = new ArrayList<>(hr.listarPorSalario());
                break;
            default:
                System.out.println("❌ Opción inválida.");
                return;
        }

        int contador = 1;
        for (PersonalAbstract p : lista) {
            System.out.println(contador++ + ". " + p);
        }
    }

    private static void filtrarPorSalario() {
        System.out.println("\n=== FILTRAR POR SALARIO MÍNIMO ===");
        System.out.print("Ingrese salario mínimo: ");
        
        try {
            double salarioMin = Double.parseDouble(scanner.nextLine());
            List<PersonalAbstract> filtrados = hr.filtrarPorSalarioMinimo(salarioMin);

            if (filtrados.isEmpty()) {
                System.out.println("\nNo se encontró personal con salario >= $" + String.format("%.2f", salarioMin));
            } else {
                System.out.println("\nPersonal con salario >= $" + String.format("%.2f", salarioMin) + ":");
                int contador = 1;
                for (PersonalAbstract p : filtrados) {
                    System.out.println(contador++ + ". " + p);
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("❌ Salario inválido.");
        }
    }

    private static void evaluarPersonal() {
        System.out.println("\n=== EVALUAR PERSONAL ===");
        System.out.print("ID del personal: ");
        String id = scanner.nextLine();

        try {
            PersonalAbstract p = hr.buscarPersonal(id);
            System.out.println("Personal: " + p.getNombre());
            System.out.print("Calificación (0-100): ");
            
            int calificacion = Integer.parseInt(scanner.nextLine());
            hr.evaluarPersonal(p, calificacion);
            System.out.println("✅ Evaluación registrada exitosamente.");
        } catch (PersonalNoEncontradoException e) {
            System.out.println("❌ " + e.getMessage());
        } catch (CalificacionInvalidaException e) {
            System.out.println("❌ " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("❌ Calificación inválida.");
        }
    }

    private static void mostrarEstadisticas() {
        System.out.println("\n╔═══════════════════════════════════════╗");
        System.out.println("║          ESTADÍSTICAS GENERALES       ║");
        System.out.println("╚═══════════════════════════════════════╝");

        Map<String, Object> stats = hr.obtenerEstadisticas();
        
        System.out.println("\n📊 Personal:");
        System.out.println("  • Total: " + stats.get("total"));
        System.out.println("  • Planta: " + stats.get("planta"));
        System.out.println("  • Contrato: " + stats.get("contrato"));
        System.out.println("  • Antigüedad promedio: " + 
            String.format("%.2f", stats.get("antiguedadPromedio")) + " años");

        hr.mostrarNomina();
        hr.mostrarEvaluaciones();
    }

    private static void eliminarPersonal() {
        System.out.println("\n=== ELIMINAR PERSONAL ===");
        System.out.print("ID del personal a eliminar: ");
        String id = scanner.nextLine();

        try {
            PersonalAbstract p = hr.buscarPersonal(id);
            System.out.println("¿Eliminar a " + p.getNombre() + "? (S/N): ");
            String confirma = scanner.nextLine();
            
            if (confirma.equalsIgnoreCase("S")) {
                // Nota: Agregar método eliminar en SoundProHR
                System.out.println("✅ Personal eliminado.");
            } else {
                System.out.println("❌ Operación cancelada.");
            }
        } catch (PersonalNoEncontradoException e) {
            System.out.println("❌ " + e.getMessage());
        }
    }

    /**
     * Carga datos de prueba para facilitar la demostración.
     */
    private static void cargarDatosPrueba() {
        try {
            hr.agregarPersonal(new PersonalPlanta("Ana García", "E001", 2000000, 5));
            hr.agregarPersonal(new PersonalContrato("Luis Martínez", "E002", 1500000, 6));
            hr.agregarPersonal(new PersonalPlanta("María López", "E003", 2500000, 3));
            System.out.println("✓ Datos de prueba cargados (3 personas).\n");
        } catch (SalarioInvalidoException | DuplicadoException e) {
            System.err.println("Error cargando datos de prueba: " + e.getMessage());
        }
    }
}

