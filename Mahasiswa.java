public class Mahasiswa {
    // properti Mahasiswa: NIM, nama, dan program studi
    String nim;
    String nama;
    String prodi;

    // konstruktor untuk membuat objek Mahasiswa
    public Mahasiswa(String nim, String nama, String prodi) {
        this.nim = nim;
        this.nama = nama;
        this.prodi = prodi;
    }

    // tampilkan data mahasiswa dalam format yang jelas
    public void tampil() {
        System.out.println("NIM: " + nim + " | Nama: " + nama + " | Prodi: " + prodi);
    }
}
