public class RecordingSession {
    private String sessionCode;
    private String sessionType;
    private int durationHours;
    private double pricePerHour;
    private String artistName;
    private StudioBooth booth;
    private Client bookingClient;

    public RecordingSession(String sessionCode, String sessionType, int durationHours, double pricePerHour, String artistName, StudioBooth booth, Client client) {
        setSessionCode(sessionCode);
        setSessionType(sessionType);
        setDurationHours(durationHours);
        setPricePerHour(pricePerHour);
        setArtistName(artistName);
        setBooth(booth);
        setBookingClient(client);
        if (this.booth != null) this.booth.reserve();
    }

    public RecordingSession(String sessionCode, int durationHours, double pricePerHour) {
        this(sessionCode, "General", durationHours, pricePerHour, "Artista", null, null);
    }

    public RecordingSession(String sessionCode) {
        this(sessionCode, 1, 10000.0);
    }

    public double calculateTotalCost() { return durationHours * pricePerHour; }

    public void showInfo() {
        String clientName = bookingClient != null ? bookingClient.getClientName() : "N/A";
        String boothId = booth != null ? booth.getBoothId() : "N/A";
        String boothName = booth != null ? booth.getName() : "N/A";
        System.out.println("Sesión: " + sessionCode + " | Cliente: " + clientName + " | Cabina: " + boothId + " (" + boothName + ")");
    }

    public int getDurationHours() { return durationHours; }
    public String getSessionCode() { return sessionCode; }
    public double getPricePerHour() { return pricePerHour; }
    public String getSessionType() { return sessionType; }
    public String getArtistName() { return artistName; }
    public StudioBooth getBooth() { return booth; }
    public Client getBookingClient() { return bookingClient; }

    public void setSessionCode(String sessionCode) { if (!validString(sessionCode)) throw new IllegalArgumentException("Código inválido"); this.sessionCode = sessionCode; }
    public void setSessionType(String sessionType) { if (!validString(sessionType)) throw new IllegalArgumentException("Tipo inválido"); this.sessionType = sessionType; }
    public void setDurationHours(int durationHours) { if (durationHours <= 0) throw new IllegalArgumentException("Duración inválida"); this.durationHours = durationHours; }
    public void setPricePerHour(double pricePerHour) { if (pricePerHour <= 0) throw new IllegalArgumentException("Precio inválido"); this.pricePerHour = pricePerHour; }
    public void setArtistName(String artistName) { if (!validString(artistName)) throw new IllegalArgumentException("Artista inválido"); this.artistName = artistName; }
    public void setBooth(StudioBooth booth) { this.booth = booth; }
    public void setBookingClient(Client bookingClient) { this.bookingClient = bookingClient; }

    private static boolean validString(String s) { return s != null && !s.trim().isEmpty(); }
}
