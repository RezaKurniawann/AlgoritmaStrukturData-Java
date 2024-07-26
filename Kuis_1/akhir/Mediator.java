public class Mediator {
    
    Item[] barang = new Item[7];
    Destination[] tujuan = new Destination[5]; 

    //input daftar item
    void inputItem(Item... items) {
        for (int i = 0; i < items.length; i++) {
            barang[i] = items[i];
        }
    }

    //input daftar destination
    void inputDestination(Destination... destinations) {
        for (int j = 0; j < destinations.length; j++) {
            tujuan[j] = destinations[j];
        }
    }

    //tampil daftar item
    void tampilInputItem () {

        System.out.println("----------------------------------------------------------");
        System.out.println("|  ID  |    Varietas Beras    |    Harga    |    Stok    |");
        System.out.println("----------------------------------------------------------");
        for(Item item : barang){
            item.tampil();
        }
        System.out.println("----------------------------------------------------------");
        
    }

    // tampil daftar destination
    void tampilInputDestination () {
        if (tujuan != null) {
            System.out.println("--------------------------------------------------");
            System.out.println("|   ID   |     Tujuan     |   Ongkos Pengiriman  |");
            System.out.println("--------------------------------------------------");
            for (Destination destination : tujuan) {      
                destination.tampil();
            }
            System.out.println("--------------------------------------------------");
        }
    }

    //mencari index item
    int mencariItem(Item[] barang, String idBarang) { 
        for (int i = 0; i < barang.length; i++) {
            if (barang[i].id.equalsIgnoreCase(idBarang)) {            
                return i;
            }
        }
        return -1;
    }     

    //mencari index destination
    int mencariDestination(Destination[] tujuan, String idTujuan) { 
        for (int i = 0; i < tujuan.length; i++) {
            if (tujuan[i].id.equalsIgnoreCase(idTujuan)) {
                return i;
            }
        }
        return -1;
    } 
    
}