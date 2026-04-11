public class Peminjaman {
    Mahasiswa mhs;
    Buku buku;
    int lamaPinjam;
    int terlambat;
    int denda;

    public Peminjaman(Mahasiswa mhs, Buku buku, int lamaPinjam) {
        this.mhs = mhs;
        this.buku = buku;
        this.lamaPinjam = lamaPinjam;
        this.terlambat = 0;
        this.denda = 0;
    }

    public void hitungDenda() {
        if (lamaPinjam > 5) {
            terlambat = lamaPinjam - 5;
            denda = terlambat * 2000;
        } else {
            terlambat = 0;
            denda = 0;
        }
    }

    public void tampil() {
        System.out.println(mhs.nama + " | " + buku.judul +
                " | Lama: " + lamaPinjam +
                " | Terlambat: " + terlambat +
                " | Denda: " + denda);
    }
}
