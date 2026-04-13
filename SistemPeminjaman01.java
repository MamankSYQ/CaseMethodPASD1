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
}
