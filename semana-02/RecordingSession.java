public class RecordingSession {
    // Atributos existentes
    private String sessionCode;
    private String sessionType;
    private int durationHours;
    private double pricePerHour;
    private String artistName;

    // Nuevas Relaciones
    private StudioBooth booth; // Relación con StudioBooth
    private Client bookingClient; // Relación con Client

    // Constructor MODIFICADO para recibir las relaciones
    public RecordingSession(String sessionCode, String sessionType, int durationHours, double pricePerHour, String artistName, StudioBooth booth, Client client) {
        this.sessionCode = sessionCode;
        this.sessionType = sessionType;
        this.durationHours = durationHours;
        this.pricePerHour = pricePerHour;
        this.artistName = artistName;
        this.booth = booth;
        this.bookingClient = client;

        // Simular la reserva del booth al crear la sesión
        booth.reserve();
    }

    // Método de Negocio de la Semana 01
    public double calculateTotalCost() {
        return durationHours * pricePerHour;
    }

    // Método para mostrar info
    public void showInfo() {
        System.out.println("Sesión: " + sessionCode +
                " | Cliente: " + bookingClient.getClientName() +
                " | Cabina: " + booth.getBoothId() +
                " (" + booth.getName() + ")");
    }

    // Getters necesarios para la Semana 02
    public int getDurationHours() { return durationHours; }
    public String getSessionCode() { return sessionCode; }
    public double getPricePerHour() { return pricePerHour; }
    public Client getBookingClient() { return bookingClient; }
}