public class RecordingSession {
    private String sessionCode;
    private String sessionType;
    private int durationHours;
    private double pricePerHour;
    private String artistName;

    private StudioBooth booth;
    private Client bookingClient;

    public RecordingSession(String sessionCode, String sessionType, int durationHours, double pricePerHour, String artistName, StudioBooth booth, Client client) {
        this.sessionCode = sessionCode;
        this.sessionType = sessionType;
        this.durationHours = durationHours;
        this.pricePerHour = pricePerHour;
        this.artistName = artistName;
        this.booth = booth;
        this.bookingClient = client;

        booth.reserve();
    }

    public double calculateTotalCost() {
        return durationHours * pricePerHour;
    }

    public void showInfo() {
        System.out.println("Sesión: " + sessionCode +
                " | Cliente: " + bookingClient.getClientName() +
                " | Cabina: " + booth.getBoothId() +
                " (" + booth.getName() + ")");
    }

    public int getDurationHours() { return durationHours; }
    public String getSessionCode() { return sessionCode; }
    public double getPricePerHour() { return pricePerHour; }
    public Client getBookingClient() { return bookingClient; }
}
