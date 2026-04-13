public class Peminjaman01 {
    Mahasiswa01 mhs;
    Buku01 buku;
    int lamaPinjam;
    int batasPinjam = 5;
    int terlambat;
    int denda;

    Peminjaman01(Mahasiswa01 mhs, Buku01 buku, int lamaPinjam){
        this.mhs = mhs;
        this.buku = buku;
        this.lamaPinjam = lamaPinjam;
        hitungDenda();
    }
    void hitungDenda(){
        terlambat = lamaPinjam - batasPinjam;
        if (terlambat > 0){
            denda = terlambat * 2000;
        }
        else {
            terlambat = 0;
            denda = 0;
        }
    }
    void tampilPeminjaman(){
        System.out.println(mhs.nama+" | "+buku.judul+" | Lama: "+lamaPinjam+" | Terlambat: "+terlambat+" | Denda: "+denda);
    }
}
