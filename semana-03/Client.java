import java.util.ArrayList;
import java.util.regex.Pattern;

public class Client {
    private String clientId;
    private String clientName;
    private String email;
    private String genre;
    private ArrayList<RecordingSession> history;

    public Client(String clientId, String clientName, String email, String genre) {
        setClientId(clientId);
        setClientName(clientName);
        setEmail(email);
        setGenre(genre);
        this.history = new ArrayList<>();
    }

    public Client(String clientName, String email) {
        this(generateId(clientName), clientName, email, "General");
    }

    public Client(String clientName) {
        this(generateId(clientName), clientName, defaultEmail(clientName), "General");
    }

    public void addSession(RecordingSession session) {
        if (session == null) throw new IllegalArgumentException("Sesión inválida");
        history.add(session);
    }

    public int calculateTotalHours() {
        int total = 0;
        for (RecordingSession session : history) total += session.getDurationHours();
        return total;
    }

    public String getClientId() { return clientId; }
    public String getClientName() { return clientName; }
    public String getEmail() { return email; }
    public String getGenre() { return genre; }
    public ArrayList<RecordingSession> getHistory() { return history; }

    public void setClientId(String clientId) {
        if (!validString(clientId)) throw new IllegalArgumentException("Id inválido");
        this.clientId = clientId;
    }

    public void setClientName(String clientName) {
        if (!validString(clientName)) throw new IllegalArgumentException("Nombre inválido");
        this.clientName = clientName;
    }

    public void setEmail(String email) {
        if (!validEmail(email)) throw new IllegalArgumentException("Email inválido");
        this.email = email;
    }

    public void setGenre(String genre) {
        if (!validString(genre)) throw new IllegalArgumentException("Género inválido");
        this.genre = genre;
    }

    public void setHistory(ArrayList<RecordingSession> history) {
        if (history == null) throw new IllegalArgumentException("Historial inválido");
        this.history = history;
    }

    private static boolean validString(String s) { return s != null && !s.trim().isEmpty(); }
    private static boolean validEmail(String email) {
        if (!validString(email)) return false;
        return Pattern.compile("^[^@\\n]+@[^@\\n]+\\.[^@\\n]+$").matcher(email).matches();
    }
    private static String generateId(String name) { return "CL-" + name.trim().toUpperCase().replaceAll("\\s+", "-"); }
    private static String defaultEmail(String name) { return name.trim().toLowerCase().replaceAll("\\s+", ".") + "@example.com"; }
}
