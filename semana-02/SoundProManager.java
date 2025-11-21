import java.util.ArrayList;

public class SoundProManager { // Clase Gestora
    private String name;
    private ArrayList<Client> clientPortfolio; // ArrayList de Clientes
    private ArrayList<StudioBooth> boothList; // ArrayList de Cabinas

    public SoundProManager(String name) {
        this.name = name;
        this.clientPortfolio = new ArrayList<>();
        this.boothList = new ArrayList<>();
    }

    public void addClient(Client client) {
        clientPortfolio.add(client);
    }

    public void addBooth(StudioBooth booth) {
        boothList.add(booth);
    }

    // Método de Negocio que usa el ArrayList: Buscar clientes con historial
    public void listClientsWithHistory() {
        System.out.println("\n--- Clientes con historial de sesiones ---");
        for (Client client : clientPortfolio) {
            if (client.getHistory().size() > 0) {
                System.out.println("- " + client.getClientName() +
                        " | Total Horas: " + client.calculateTotalHours() + "h");
            }
        }
    }

    public int countActiveBooths() {
        return boothList.size();
    }
}