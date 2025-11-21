public class StudioBooth {
    private String boothId;
    private String name;
    private int maxCapacity;
    private boolean isAvailable;

    public StudioBooth(String boothId, String name, int maxCapacity) {
        this.boothId = boothId;
        this.name = name;
        this.maxCapacity = maxCapacity;
        this.isAvailable = true;
    }

    // Método de Negocio: Simula la reserva del espacio
    public boolean reserve() {
        if (isAvailable) {
            this.isAvailable = false;
            return true;
        }
        return false;
    }

    // Getters y Setters
    public String getBoothId() { return boothId; }
    public String getName() { return name; }
    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean available) { isAvailable = available; }
}