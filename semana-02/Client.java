import java.util.ArrayList;

public class Client {
    // Atributos base (asumidos)
    private String clientId;
    private String clientName;
    private String email;
    private String genre;
    private ArrayList<RecordingSession> history; // USO DE ARRAYLIST (Relación 1:N)

    // Constructor (adaptado)
    public Client(String clientId, String clientName, String email, String genre) {
        this.clientId = clientId;
        this.clientName = clientName;
        this.email = email;
        this.genre = genre;
        this.history = new ArrayList<>(); // Inicialización del ArrayList
    }

    // Método para usar el ArrayList
    public void addSession(RecordingSession session) {
        history.add(session);
    }

    // Método de Negocio: Calcula la duración total de sesiones del cliente
    public int calculateTotalHours() {
        int total = 0;
        for (RecordingSession session : history) {
            total += session.getDurationHours(); // Asume que el getter existe
        }
        return total;
    }

    // Getters
    public String getClientName() { return clientName; }
    public String getClientId() { return clientId; }
    public ArrayList<RecordingSession> getHistory() { return history; }
}