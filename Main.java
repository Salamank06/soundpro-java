public class Main {
    public static void main(String[] args) {
        System.out.println("=== SOUNDPRO - REGISTRO SEMANA 01 ===\n");

        // Instanciar 5 objetos diferentes de RecordingSession (Actividad 4)

        // 1. Grabación de Álbum
        RecordingSession session1 = new RecordingSession("REC-001", "Grabación de Álbum", 8, 50000.0, "Banda Zenith");

        // 2. Producción de Podcast
        RecordingSession session2 = new RecordingSession("REC-002", "Producción de Podcast", 2, 35000.0, "Podcast de Tecnología");

        // 3. Mezcla y Masterización
        RecordingSession session3 = new RecordingSession("REC-003", "Mezcla y Masterización", 4, 65000.0, "Cantante Solista Maria G.");

        // 4. Grabación de Jingle
        RecordingSession session4 = new RecordingSession("REC-004", "Grabación de Jingle", 3, 40000.0, "Empresa de Publicidad ABC");

        // 5. Demo Musical
        RecordingSession session5 = new RecordingSession("REC-005", "Demo Musical", 5, 45000.0, "Nuevo Artista Rock N.");

        // Mostrar la información de las 5 sesiones
        session1.showInfo();
        session2.showInfo();
        session3.showInfo();
        session4.showInfo();
        session5.showInfo();

        System.out.println("\nTotal de objetos instanciados y probados: 5");
    }
}