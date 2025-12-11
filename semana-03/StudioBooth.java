public class StudioBooth {
    private String boothId;
    private String name;
    private int maxCapacity;
    private boolean available;

    public StudioBooth(String boothId, String name, int maxCapacity) {
        setBoothId(boothId);
        setName(name);
        setMaxCapacity(maxCapacity);
        this.available = true;
    }

    public StudioBooth(String boothId, String name) {
        this(boothId, name, 1);
    }

    public StudioBooth(String boothId) {
        this(boothId, "Cabina", 1);
    }

    public boolean reserve() {
        if (available) { available = false; return true; }
        return false;
    }

    public String getBoothId() { return boothId; }
    public String getName() { return name; }
    public int getMaxCapacity() { return maxCapacity; }
    public boolean isAvailable() { return available; }

    public void setBoothId(String boothId) {
        if (!validString(boothId)) throw new IllegalArgumentException("Id inválido");
        this.boothId = boothId;
    }

    public void setName(String name) {
        if (!validString(name)) throw new IllegalArgumentException("Nombre inválido");
        this.name = name;
    }

    public void setMaxCapacity(int maxCapacity) {
        if (maxCapacity <= 0) throw new IllegalArgumentException("Capacidad inválida");
        this.maxCapacity = maxCapacity;
    }

    public void setAvailable(boolean available) { this.available = available; }

    private static boolean validString(String s) { return s != null && !s.trim().isEmpty(); }
}
