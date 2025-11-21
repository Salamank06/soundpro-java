import java.time.LocalDate;

public class Invoice {
    private String invoiceNumber;
    private RecordingSession session; // Relación con RecordingSession
    private Client client;           // Relación con Client
    private LocalDate issueDate;
    private double finalAmount;

    public Invoice(String invoiceNumber, RecordingSession session, Client client) {
        this.invoiceNumber = invoiceNumber;
        this.session = session;
        this.client = client;
        this.issueDate = LocalDate.now();
        // Usa el método de la sesión para calcular el monto inicial
        this.finalAmount = session.calculateTotalCost() * 1.19; // Ejemplo: 19% IVA
    }

    // Método de Negocio: Verifica si la factura debe ser pagada hoy (ej. emitida hace menos de 7 días)
    public boolean requiresImmediatePayment() {
        return LocalDate.now().isBefore(issueDate.plusDays(7));
    }

    public String getSummary() {
        return "Factura: " + invoiceNumber +
                " | Cliente: " + client.getClientName() +
                " | Sesión: " + session.getSessionCode() +
                " | Monto Final: $" + String.format("%.2f", finalAmount);
    }

    // Getters
    public double getFinalAmount() { return finalAmount; }
}