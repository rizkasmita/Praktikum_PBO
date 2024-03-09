public class Komik {
    String judul;
    String genre;
    int thn_terbit;
    int jml_halaman;

    Komik(String judul, String genre, int thn_terbit, int jml_halaman) {
        this.judul = judul;
        this.genre = genre;
        this.thn_terbit = thn_terbit;
        this.jml_halaman = jml_halaman;
    }

    void display() {
        System.out.println("Judul: " + this.judul);
        System.out.println("Genre: " + this.genre);
        System.out.println("Tahun Terbit: " + this.thn_terbit);
        System.out.println("Jumlah Halaman: " + this.jml_halaman);
    }

    void setJudul(String jdl) {
        this.judul = jdl;
    }

    void setGenre(String gen) {
        this.genre = gen;
    }

    void setThn(int thn) {
        this.thn_terbit = thn;
    }

    void setJml(int jml) {
        this.jml_halaman = jml;
    }
}
