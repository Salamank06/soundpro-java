import java.util.ArrayList;

public class SoundProManager {
    private String name;
    private ArrayList<Client> clientPortfolio;
    private ArrayList<StudioBooth> boothList;

    public SoundProManager(String name) {
        setName(name);
        this.clientPortfolio = new ArrayList<>();
        this.boothList = new ArrayList<>();
    }

    public SoundProManager() {
        this("SoundPro");
    }

    public void addClient(Client client) { if (client == null) throw new IllegalArgumentException("Cliente inválido"); clientPortfolio.add(client); }
    public void addBooth(StudioBooth booth) { if (booth == null) throw new IllegalArgumentException("Cabina inválida"); boothList.add(booth); }

    public void listClientsWithHistory() {
        System.out.println("--- Clientes con historial de sesiones ---");
        for (Client client : clientPortfolio) {
            if (client.getHistory().size() > 0) {
                System.out.println("- " + client.getClientName() + " | Total Horas: " + client.calculateTotalHours() + "h");
            }
        }
    }

    public int countActiveBooths() { return boothList.size(); }

    public String getName() { return name; }
    public ArrayList<Client> getClientPortfolio() { return clientPortfolio; }
    public ArrayList<StudioBooth> getBoothList() { return boothList; }

    public void setName(String name) { if (!validString(name)) throw new IllegalArgumentException("Nombre inválido"); this.name = name; }
    public void setClientPortfolio(ArrayList<Client> clientPortfolio) { if (clientPortfolio == null) throw new IllegalArgumentException("Lista inválida"); this.clientPortfolio = clientPortfolio; }
    public void setBoothList(ArrayList<StudioBooth> boothList) { if (boothList == null) throw new IllegalArgumentException("Lista inválida"); this.boothList = boothList; }

    private static boolean validString(String s) { return s != null && !s.trim().isEmpty(); }
}
