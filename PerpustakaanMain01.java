import java.util.Scanner;
public class PerpustakaanMain01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;

        Mahasiswa01[] mhs = {
            new Mahasiswa01("22001", "Andi", "Teknik Informatika"),
            new Mahasiswa01("22002", "Budi", "Teknik Informatika"),
            new Mahasiswa01("22003", "Citra", "Sistem Informasi Bisnis")
        };

        Buku01[] buku = {
            new Buku01("B001", "Algoritma", 2020),
            new Buku01("B002", "Basis Data", 2019),
            new Buku01("B003", "Pemrograman", 2021),
            new Buku01("B004", "Fisika", 2024)
        };

        Peminjaman01[] pjm = {
            new Peminjaman01(mhs[0], buku[0], 7),
            new Peminjaman01(mhs[1], buku[1], 3),
            new Peminjaman01(mhs[2], buku[2], 10),
            new Peminjaman01(mhs[2], buku[3], 6),
            new Peminjaman01(mhs[0], buku[1], 4)
        };

        do{
            System.out.println("=== SISTEM PEMINJAMAN RUANG BACA JTI");
            System.out.println("1. Tampilkan Mahasiswa");
            System.out.println("2. Tampilkan Buku");
            System.out.println("3. Tampilkan Peminjaman");
            System.out.println("4. Urutkan Berdasarkan Denda");
            System.out.println("5. Cari Berdasarkan NIM");
            System.out.println("6. Tambah Data Peminjaman");
            System.out.println("7. Tampilkan Statistik");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");
            n = sc.nextInt();
            sc.nextLine();

            switch (n) {
                case 1:
                    System.out.println("Daftar Mahasiswa: ");
                    SistemPeminjaman01.tampilMahasiswa(mhs);
                    break;
                case 2:
                    System.out.println("Daftar Buku: ");
                    SistemPeminjaman01.tampilBuku(buku);
                    break;
                case 3:
                    System.out.println("Data Peminjaman: ");
                    SistemPeminjaman01.tampilPeminjaman(pjm);
                    break;
                case 4:
                    SistemPeminjaman01.PengurutanDenda(pjm);
                    System.out.println("Setelah diurutkan (Denda terbesar): ");
                    SistemPeminjaman01.tampilPeminjaman(pjm);
                    break;
                case 5:
                    SistemPeminjaman01.PengurutanNim(pjm);
                    System.out.print("Masukkan NIM: ");
                    String nim = sc.nextLine();
                    SistemPeminjaman01.cariNim(pjm, nim);
                    break;
                case 6:
                    pjm = SistemPeminjaman01.tambahPeminjaman(pjm, mhs, buku, sc);
                    break;
                case 7:
                    SistemPeminjaman01.tampilStatistik(pjm);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Input tidak valid.");
            }
        } while (n != 0);
    }
}
