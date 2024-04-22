import java.util.ArrayList;

public class Komik {
    private String judul;
    private String genre;
    private int thn_terbit;
    private int jml_halaman;
    private int stok;
    private static ArrayList<Komik> DataKomik = new ArrayList<>();

    Komik(String judul, String genre, int thn_terbit, int jml_halaman, int stok) {
        this.judul = judul;
        this.genre = genre;
        this.thn_terbit = thn_terbit;
        this.jml_halaman = jml_halaman;
        this.stok = stok;
        DataKomik.add(this);
    }

    void display() {
        System.out.println("Judul: " + this.judul);
        System.out.println("Genre: " + this.genre);
        System.out.println("Tahun Terbit: " + this.thn_terbit);
        System.out.println("Jumlah Halaman: " + this.jml_halaman);
    }

    public String pinjamKomik (String judul, String username) {
        String ret = "Buku dengan judul " + judul + " berhasil dipinjam oleh " + username;
        return ret;
    }

    public int pinjamKomik (String judul, int stok) {
        int stokNow = stok - 1;
        setStok(stokNow);
        return stokNow;
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

    public void setStok(int stok) {
        this.stok = stok;
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
    
    public int getStok() {
        return stok;
    }
}
