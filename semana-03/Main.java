public class Main {
    public static void main(String[] args) {
        SoundProManager manager = new SoundProManager("SoundPro S.A.S.");

        StudioBooth boothA = new StudioBooth("CAB-101", "Cabina Principal", 4);
        StudioBooth boothB = new StudioBooth("CAB-102");
        manager.addBooth(boothA);
        manager.addBooth(boothB);

        Client client1 = new Client("ART-101", "Banda Zenith", "zenith@mail.com", "Rock");
        Client client2 = new Client("Maria G.");
        manager.addClient(client1);
        manager.addClient(client2);

        RecordingSession session1 = new RecordingSession("REC-101", "Álbum", 8, 50000.0, "Banda Zenith", boothA, client1);
        RecordingSession session2 = new RecordingSession("REC-102", 4, 65000.0);
        session2.setBookingClient(client2);
        client1.addSession(session1);
        client2.addSession(session2);

        Invoice invoice1 = new Invoice("INV-2001", session1, client1);
        Invoice invoice2 = new Invoice(session2);

        System.out.println("=== SEMANA 03: ENCAPSULACIÓN Y CONSTRUCTORES ===\n");
        session1.showInfo();
        System.out.println(invoice1.getSummary());
        session2.showInfo();
        System.out.println(invoice2.getSummary());
        manager.listClientsWithHistory();
    }
}
