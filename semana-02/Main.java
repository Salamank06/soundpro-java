public class Main {
    public static void main(String[] args) {
        System.out.println("=== SEMANA 02: SOUNDPRO - RELACIONES Y ARRAYLIST ===\n");

        // --- 1. CREAR OBJETOS Y CLASE GESTORA ---

        SoundProManager manager = new SoundProManager("SoundPro S.A.S.");

        // Cabinas (Clase Nueva 1)
        StudioBooth boothA = new StudioBooth("CAB-001", "Cabina Principal", 4);
        StudioBooth boothB = new StudioBooth("CAB-002", "Cabina Voces", 2);
        manager.addBooth(boothA);
        manager.addBooth(boothB);

        // Clientes (Base + ArrayList)
        Client client1 = new Client("ART-001", "Banda Zenith", "zenith@mail.com", "Rock");
        Client client2 = new Client("ART-002", "Maria G.", "maria@mail.com", "Pop");
        manager.addClient(client1);
        manager.addClient(client2);

        // --- 2. CREAR RELACIONES (Sesiones) ---

        // Sesión 1: Cliente 1 reserva Cabina A
        RecordingSession session1 = new RecordingSession("REC-001", "Grabación Álbum", 8, 50000.0, "Banda Zenith", boothA, client1);

        // Sesión 2: Cliente 2 reserva Cabina B
        RecordingSession session2 = new RecordingSession("REC-002", "Mezcla", 4, 65000.0, "Maria G.", boothB, client2);

        // --- 3. USAR ARRAYLISTS Y LÓGICA ---

        // Añadir sesiones al historial de los clientes (ArrayList en Client)
        client1.addSession(session1);
        client2.addSession(session2);

        // Crear Facturas (Clase Nueva 2)
        Invoice invoice1 = new Invoice("INV-1001", session1, client1);
        Invoice invoice2 = new Invoice("INV-1002", session2, client2);

        System.out.println("--- RESULTADOS DE SESIONES ---");
        session1.showInfo();
        System.out.println("Costo Final INV-1001: $" + String.format("%.2f", invoice1.getFinalAmount()));

        session2.showInfo();
        System.out.println("Costo Final INV-1002: $" + String.format("%.2f", invoice2.getFinalAmount()));

        // Usar ArrayList de la Clase Gestora
        manager.listClientsWithHistory();

        System.out.println("\nTotal de cabinas gestionadas: " + manager.countActiveBooths());
        System.out.println("¿Cabina A disponible ahora? " + (boothA.isAvailable() ? "Sí" : "No"));
    }
}