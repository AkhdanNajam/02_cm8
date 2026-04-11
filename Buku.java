public class Buku {
    // properti Buku: kode buku, judul buku, dan tahun terbit
    String kodeBuku;
    String judul;
    int tahunTerbit;

    // konstruktor untuk membuat objek Buku
    public Buku(String kodeBuku, String judul, int tahunTerbit) {
        this.kodeBuku = kodeBuku;
        this.judul = judul;
        this.tahunTerbit = tahunTerbit;
    }

    // tampilkan data buku dalam format yang mudah dibaca
    public void tampil() {
        System.out.println("Kode Buku: " + kodeBuku + " | Judul: " + judul + " | Tahun Terbit: " + tahunTerbit);
    }
}