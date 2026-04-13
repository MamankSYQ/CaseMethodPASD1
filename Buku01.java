public class Buku01 {
    String kodeBuku;
    String judul;
    int tahunTerbit;

    Buku01(String kd, String jdl, int thn){
        kodeBuku = kd;
        judul = jdl;
        tahunTerbit = thn;
    }
    void tampilBuku(){
        System.out.println("Daftar Buku: ");
        System.out.println("Kode: "+kodeBuku+" | Judul: "+judul+" | Tahun: "+tahunTerbit);
    }
}
