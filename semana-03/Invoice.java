import java.time.LocalDate;

public class Invoice {
    private String invoiceNumber;
    private RecordingSession session;
    private Client client;
    private LocalDate issueDate;
    private double finalAmount;

    public Invoice(String invoiceNumber, RecordingSession session, Client client) {
        setInvoiceNumber(invoiceNumber);
        setSession(session);
        if (client == null) throw new IllegalArgumentException("Cliente inválido");
        this.client = client;
        this.issueDate = LocalDate.now();
        this.finalAmount = session.calculateTotalCost() * 1.19;
    }

    public Invoice(String invoiceNumber, RecordingSession session) {
        this(invoiceNumber, session, session.getBookingClient());
    }

    public Invoice(RecordingSession session) {
        this("INV-" + session.getSessionCode(), session);
    }

    public boolean requiresImmediatePayment() { return LocalDate.now().isBefore(issueDate.plusDays(7)); }

    public String getSummary() {
        return "Factura: " + invoiceNumber + " | Cliente: " + client.getClientName() + " | Sesión: " + session.getSessionCode() + " | Monto Final: $" + String.format("%.2f", finalAmount);
    }

    public String getInvoiceNumber() { return invoiceNumber; }
    public RecordingSession getSession() { return session; }
    public Client getClient() { return client; }
    public LocalDate getIssueDate() { return issueDate; }
    public double getFinalAmount() { return finalAmount; }

    public void setInvoiceNumber(String invoiceNumber) { if (!validString(invoiceNumber)) throw new IllegalArgumentException("Número inválido"); this.invoiceNumber = invoiceNumber; }
    public void setSession(RecordingSession session) { if (session == null) throw new IllegalArgumentException("Sesión inválida"); this.session = session; }
    public void setClient(Client client) { if (client == null) throw new IllegalArgumentException("Cliente inválido"); this.client = client; }
    public void setFinalAmount(double finalAmount) { if (finalAmount <= 0) throw new IllegalArgumentException("Monto inválido"); this.finalAmount = finalAmount; }

    private static boolean validString(String s) { return s != null && !s.trim().isEmpty(); }
}
