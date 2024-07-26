public class MainHotel {
    public static void main(String[] args) {
        HotelService hotels = new HotelService();

        Hotel h1 = new Hotel("Cozy Cabin Lodge", "Yogyakarta", 400000, 2);
        Hotel h2 = new Hotel("Grand Paradise", "Jakarta", 1500000, 5);
        Hotel h3 = new Hotel("City Lights Inn", "Surabaya", 600000, 2);
        Hotel h4 = new Hotel("Ocean View Resort", "Bali", 1200000, 4);
        Hotel h5 = new Hotel("Mountain Retreat", "Bandung", 800000, 3);

        hotels.tambah(h1);
        hotels.tambah(h2);
        hotels.tambah(h3);
        hotels.tambah(h4);
        hotels.tambah(h5);

        System.out.println("=== Data Hotel Sebelum Sorting ===");
        hotels.tampil();
        System.out.println("=== Selection Sort ===");
        hotels.selectionSort();
        hotels.tampil();
        System.out.println("=== Insertion Sort ===");
        hotels.insertionSort();
        hotels.tampil();
    }
}
