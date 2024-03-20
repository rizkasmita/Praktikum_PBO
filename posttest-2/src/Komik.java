public class Komik {
    private String judul;
    private String genre;
    private int thn_terbit;
    private int jml_halaman;

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

    public void setJudul(String jdl) {
        this.judul = jdl;
    }

    public void setGenre(String gen) {
        this.genre = gen;
    }

    public void setThn(int thn) {
        this.thn_terbit = thn;
    }

    public void setJml(int jml) {
        this.jml_halaman = jml;
    }

    public String getJdl() {
        return judul;
    }

    public String getGenre() {
        return genre;
    }

    public int getThn() {
        return thn_terbit;
    }

    public int getJml() {
        return jml_halaman;
    }
}
