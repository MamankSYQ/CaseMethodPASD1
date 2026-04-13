public class Mahasiswa01 {
    String nim;
    String nama;
    String prodi;

    Mahasiswa01(String nm, String name, String prd){
        nim = nm;
        nama = name;
        prodi = prd;
    }
    void tampilMahasiswa(){
        System.out.println("Daftar Mahasiswa: ");
        System.out.println("NIM: "+nim+" | Nama: "+nama+" | Prodi: "+prodi);
    }
}