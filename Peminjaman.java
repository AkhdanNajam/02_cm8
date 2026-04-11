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
        // jika durasi pinjam lebih dari 5 hari, hitung hari terlambat
        // lalu kalikan dengan besaran denda per hari
        if (lamaPinjam > 5) {
            terlambat = lamaPinjam - 5;
            denda = terlambat * 2000;
        } else {
            terlambat = 0;
            denda = 0;
        }
    }

    public void tampil() {
        // tampilkan data peminjaman dalam format yang mudah dibaca
        System.out.println(mhs.nama + " | " + buku.judul +
                " | Lama: " + lamaPinjam +
                " | Terlambat: " + terlambat +
                " | Denda: " + denda);
    }
}
