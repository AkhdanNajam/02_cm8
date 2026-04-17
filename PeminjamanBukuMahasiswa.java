import java.util.Scanner;
public class PeminjamanBukuMahasiswa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // inisialisasi scanner untuk membaca input pilihan menu

        // Data Mahasiswa
        // array mahasiswa menyimpan objek Mahasiswa dengan NIM, nama, dan prodi
        Mahasiswa[] mhs = {
            new Mahasiswa("22001", "Andi", "Teknik Informatika"),
            new Mahasiswa("22002", "Budi", "Teknik Informatika"),
            new Mahasiswa("22003", "Citra", "Sistem Informasi Bisnis")
        };

        // Data Buku
        Buku[] buku = {
            new Buku("B001", "Algoritma", 2020),
            new Buku("B002", "Basis Data", 2019),
            new Buku("B003", "Pemrograman", 2021),
            new Buku("B004", "Fisika", 2024)
        };

        // Data Peminjaman
        Peminjaman[] pinjam = {
            new Peminjaman(mhs[0], buku[0], 7),
            new Peminjaman(mhs[1], buku[1], 3),
            new Peminjaman(mhs[2], buku[2], 10),
            new Peminjaman(mhs[2], buku[3], 6),
            new Peminjaman(mhs[0], buku[1], 4)
        };

        int pilih;
        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Tampilkan Mahasiswa");
            System.out.println("2. Tampilkan Buku");
            System.out.println("3. Tampilkan Peminjaman");
            System.out.println("4. Urutkan berdasarkan Denda");
            System.out.println("5. Cari berdasarkan NIM");
            System.out.println("6. Cari Buku berdasarkan Kode Buku");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");
            pilih = sc.nextInt();
            sc.nextLine();

            switch (pilih) {
                case 1:
                    System.out.println("\nDaftar Mahasiswa:");
                    for (Mahasiswa m : mhs) m.tampil();
                    break;

                case 2:
                    System.out.println("\nData Buku:");
                    for (Buku b : buku) b.tampil();
                    break;

                case 3:
                    System.out.println("\nData Peminjaman:");
                    // hitung denda terlebih dahulu agar keterlambatan dan denda 
                    for (Peminjaman p : pinjam) {
                        p.hitungDenda();
                    }
                    for (Peminjaman p : pinjam) p.tampil();
                    break;

                case 4:
                    // 1) Hitung denda untuk semua peminjaman terlebih dahulu
                    for (Peminjaman p : pinjam) {
                        p.hitungDenda();
                    }
                    // 2) Urutkan array peminjaman berdasarkan nilai denda terbesar ke terkecil
                    //    menggunakan algoritma insertion sort
                    for (int i = 1; i < pinjam.length; i++) {
                        Peminjaman temp = pinjam[i];
                        int j = i - 1;

                        while (j >= 0 && pinjam[j].denda < temp.denda) {
                            pinjam[j + 1] = pinjam[j];
                            j--;
                        }
                        pinjam[j + 1] = temp;
                    }

                    System.out.println("\nSetelah diurutkan (denda terbesar):");
                    for (Peminjaman p : pinjam) p.tampil();
                    break;

                case 5:
                    System.out.print("Masukkan NIM: ");
                    String cari = sc.nextLine();

                    // 1) Urutkan data peminjaman berdasarkan NIM mahasiswa secara ascending
                    //    agar binary search dapat digunakan pada array yang terurut
                    for (int i = 0; i < pinjam.length - 1; i++) {
                        for (int j = i + 1; j < pinjam.length; j++) {
                            if (pinjam[i].mhs.nim.compareTo(pinjam[j].mhs.nim) > 0) {
                                Peminjaman temp = pinjam[i];
                                pinjam[i] = pinjam[j];
                                pinjam[j] = temp;
                            }
                        }
                    }

                    // 2) Cari NIM menggunakan binary search
                    int left = 0, right = pinjam.length - 1;
                    boolean ditemukan = false;

                    while (left <= right) {
                        int mid = (left + right) / 2;

                        if (pinjam[mid].mhs.nim.equals(cari)) {
                            System.out.println("Data ditemukan:");
                            pinjam[mid].tampil();
                            ditemukan = true;
                            break;
                        } else if (pinjam[mid].mhs.nim.compareTo(cari) < 0) {
                            left = mid + 1;
                        } else {
                            right = mid - 1;
                        }
                    }

                    if (!ditemukan) {
                        System.out.println("Data tidak ditemukan!");
                    }
                    break;
                    //mencari buku sesuai kode buku
                case 6:
                    System.out.print("Masukkan Kode Buku: ");
                    String kodeCari = sc.nextLine();
                    boolean bukuDitemukan = false;

                    for (Buku b : buku) {
                        if (b.kodeBuku.equalsIgnoreCase(kodeCari)) {
                            System.out.println("Buku ditemukan:");
                            b.tampil();
                            bukuDitemukan = true;
                            break;
                        }
                    }

                    if (!bukuDitemukan) {
                        System.out.println("Buku tidak ditemukan!");
                    }
                    break;

                case 0:
                    System.out.println("Keluar...");
                    break;

                default:
                    System.out.println("Pilihan tidak valid!");
            }

        } while (pilih != 0);
    }
}