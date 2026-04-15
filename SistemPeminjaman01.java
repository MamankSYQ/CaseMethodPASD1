import java.util.Scanner;
public class SistemPeminjaman01 {
    static void tampilMahasiswa(Mahasiswa01[] mhs){
        for (Mahasiswa01 m : mhs){
            m.tampilMahasiswa();
        }
    }
    static void tampilBuku(Buku01[] buku){
        for (Buku01 b : buku){
            b.tampilBuku();
        }
    }
    static void tampilPeminjaman(Peminjaman01[] pjm){
        for (Peminjaman01 p : pjm){
            p.tampilPeminjaman();
        }
    }

    static void PengurutanDenda(Peminjaman01[] pjm){
        for (int i = 1; i < pjm.length; i++){
            Peminjaman01 temp = pjm[i];
            int posisi = i;
            for (int j = i - 1; j >= 0; j--){
                if (pjm[j].denda < temp.denda){
                    pjm[j+1] = pjm[j];
                    posisi = j;
                }
                else{
                    break;
                }
            }
            pjm[posisi] = temp;
        }
    }
    static void PengurutanNim(Peminjaman01[] pjm){
        for (int i = 1; i < pjm.length; i++){
            Peminjaman01 temp = pjm[i];
            int posisi = i;
            for (int j = i-1; j >= 0; j--){
                if (pjm[j].mhs.nim.compareTo(temp.mhs.nim) > 0){
                    pjm[j+1] = pjm[j];
                    posisi = j;
                }
                else {
                    break;
                }
            }
            pjm[posisi] = temp;
        }
    }
    static void cariNim(Peminjaman01[] pjm, String nim){
        int kiri = 0;
        int kanan = pjm.length - 1;
        boolean ditemukan = false;

        while (kiri <= kanan){
            int mid = (kiri + kanan) / 2;

            int banding = pjm[mid].mhs.nim.compareTo(nim);
            if (banding == 0){
                int i = mid;

                while (i >= 0 && pjm[i].mhs.nim.equals(nim)){
                    pjm[i].tampilPeminjaman();
                    i--;
                }
                i = mid + 1;
                while (i < pjm.length && pjm[i].mhs.nim.equals(nim)) {
                    pjm[i].tampilPeminjaman();
                    i++;
                }
                ditemukan = true;
                break;
            }
            else if (banding < 0){
                kiri = mid + 1;
            }
            else {
                kanan = mid - 1;
            }
        }
        if (!ditemukan){
            System.out.println("Data tidak ditemukan");
        }
    }
    static Peminjaman01[] tambahPeminjaman(Peminjaman01[] pjm, Mahasiswa01[] mhs, Buku01[] buku, Scanner sc){
        System.out.print("Masukkan NIM Mahasiswa: ");
        String nim = sc.nextLine();

        Mahasiswa01 mhsDitemukan = null;
        for (Mahasiswa01 m : mhs){
            if (m.nim.equals(nim)){
                mhsDitemukan = m;
                break;
            }
        }
        if (mhsDitemukan == null){
            System.out.println("NIM tidak ditemukan");
            return pjm;
        }

        System.out.print("Masukkan kode buku: ");
        String kode = sc.nextLine();

        Buku01 bukuDitemukan = null;
        for (Buku01 b : buku){
            if (b.kodeBuku.equals(kode)){
                bukuDitemukan = b;
                break;
            }
        }
        if (bukuDitemukan == null){
            System.out.println("Kode buku tidak ditemukan");
            return pjm;
        }

        System.out.println("Masukkan lama pinjam(hari):");
        int lama = Integer.parseInt(sc.nextLine());

        Peminjaman01 baru = new Peminjaman01(mhsDitemukan, bukuDitemukan, lama);
        Peminjaman01[] pjmBaru = new Peminjaman01[pjm.length + 1];
        for (int i = 0; i < pjm.length; i++){
            pjmBaru[i] = pjm[i];
        }

        pjmBaru[pjm.length] = baru;

        System.out.println("Data peminjaman berhasil ditambahkan!");
        return pjmBaru;
    }
    static void tampilStatistik(Peminjaman01[] pjm) {
        int totalDenda = 0;
        int jumlahTerlambat = 0;
        int jumlahTepat = 0;

        for (Peminjaman01 p : pjm) {
            totalDenda += p.denda;          

            if (p.terlambat > 0) {
                jumlahTerlambat++;         
            } else {
                jumlahTepat++;             
            }
        }

        System.out.println("========== STATISTIK PEMINJAMAN ==========");
        System.out.println("Total seluruh denda    : Rp" + totalDenda);
        System.out.println("Jumlah terlambat       : " + jumlahTerlambat + " peminjaman");
        System.out.println("Jumlah tepat waktu     : " + jumlahTepat    + " peminjaman");
        System.out.println("==========================================");
}
}
