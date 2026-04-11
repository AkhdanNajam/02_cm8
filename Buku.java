public class Buku {
    String kodeBuku;
    String judul;
    int tahunTerbit;

    public Buku(String kodeBuku, String judul, int tahunTerbit) {
        this.kodeBuku = kodeBuku;
        this.judul = judul;
        this.tahunTerbit = tahunTerbit;
    }
    public void tampil() {
        System.out.println("Buku: " + kodeBuku + " | Judul: " + judul + " | Tahun: " + tahunTerbit);
    }
}