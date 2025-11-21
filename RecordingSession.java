public class RecordingSession {
    // Atributos (más de 3, lo cual es mejor práctica)
    String sessionCode;
    String sessionType;
    int durationHours;
    double pricePerHour;
    String artistName;

    // Constructor
    public RecordingSession(String sessionCode, String sessionType, int durationHours, double pricePerHour, String artistName) {
        this.sessionCode = sessionCode;
        this.sessionType = sessionType;
        this.durationHours = durationHours;
        this.pricePerHour = pricePerHour;
        this.artistName = artistName;
    }

    // Método 1: Muestra la información y el costo total estimado
    public void showInfo() {
        System.out.println("------------------------------------");
        System.out.println("Código: " + sessionCode);
        System.out.println("Artista: " + artistName);
        System.out.println("Tipo: " + sessionType);
        System.out.println("Duración: " + durationHours + " horas");
        // Llama al método que retorna un valor calculado
        System.out.printf("Costo Total Estimado: $%.2f%n", calculateTotalCost());
    }

    // Método 2 (Retorna un valor calculado)
    public double calculateTotalCost() {
        return durationHours * pricePerHour;
    }
}