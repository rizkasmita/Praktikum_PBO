import java.util.ArrayList;
// import java.io.BufferedReader;
import java.io.IOException;
// import java.io.InputStreamReader;

public class Admin extends User {
    private ArrayList<Komik> DataKomik;
    private ArrayList<Member> DataMember;
    private String lvl;
    // protected InputStreamReader p = new InputStreamReader(System.in);
    // protected BufferedReader input = new BufferedReader(p);

    public Admin(String usn, String pw, String name, String lvl, ArrayList<Member> data, ArrayList<Komik> datkom) {
        super(usn, pw, name);
        this.lvl = lvl;
        this.DataMember = data;
        this.DataKomik = datkom;
        // super.DataKomik = new ArrayList<>();
    }

    public ArrayList<Komik> getKomik() {
        return DataKomik;
    }

    @Override
    protected void greeting() {
        super.greeting();
        System.out.println("Level: " + this.lvl);
    }

    @Override
    protected void displayData() throws IOException {
        if (this.DataKomik.isEmpty()) {
            System.out.println("There is no data yet");
        } else {
            for(int i = 0; i < this.DataKomik.size(); i++) {
                System.out.println("[" + (i+1) + "]");
                System.out.println("Judul: " + this.DataKomik.get(i).getJdl());
                System.out.println("Genre: " + this.DataKomik.get(i).getGenre());
                System.out.println("Tahun Terbit: " + this.DataKomik.get(i).getThn());
                System.out.println("Jumlah Halaman: " + this.DataKomik.get(i).getJml());
                System.out.println("Stok: " + this.DataKomik.get(i).getStok());
                System.out.println("\n");
            }
        }
    }

    @Override
    protected void menu() throws IOException, InterruptedException {
        while(true) {
            greeting();
            System.out.println("[1] Add Comic");
            System.out.println("[2] Display Comic");
            System.out.println("[3] Update Comic");
            System.out.println("[4] Delete Comic");
            System.out.println("[5] Log Out");
            System.out.print("Input here: ");
            String pil = input.readLine();
            if (super.isNum(pil)) {
                int pilInt = Integer.parseInt(pil);
                switch (pilInt) {
                    case 1:
                        create();
                        break;
                    case 2:
                        displayData();
                        break;
                    case 3:
                        update();
                        break;
                    case 4:
                        delete();
                        break;
                    case 5:
                        return;
                    default:
                        System.out.println("Pilihan tidak ada");
                        Thread.sleep(1000);
                }
            }
        }
    }

    public void create() throws IOException, InterruptedException {
        super.clear();
        System.out.println("=== Add Comic ===");
        System.out.print("Masukkan judul: ");
        String jdl = input.readLine();
        System.out.print("Masukkan genre: ");
        String gen = input.readLine();
        while (true) {
            System.out.print("Masukkan Tahun Terbit: ");
            String thn_String = input.readLine();
            if (isNum(thn_String)) {
                int thn = Integer.parseInt(thn_String);
                while (true) {
                    System.out.print("Masukkan Jumlah Halaman: ");
                    String jml_String = input.readLine();
                    if (isNum(jml_String)) {
                        int jml = Integer.parseInt(jml_String);
                        while (true) {
                            System.out.print("Masukkan Stok: ");
                            String stokStr = input.readLine();
                            if (isNum(stokStr)) {
                                int stok = Integer.parseInt(stokStr);
                                Komik kom = new Komik(jdl, gen, thn, jml, stok);
                                this.DataKomik.add(kom);
                                break;
                            } else {
                                System.out.println("\n=== Stok Harus Berupa Angka ===");
                            }
                        }
                        break;
                    } else {
                        System.out.println("\n=== Jumlah Halaman Harus Berupa Angka ===");
                    }
                }
                break;
            } else {
                System.out.println("\n=== Tahun Terbit Harus Berupa Angka ===");
            }
        }
        System.out.println("\n=== Data Berhasil Ditambah ===");
        Thread.sleep(1000);
    }

    public void update() throws NumberFormatException, IOException, InterruptedException {
        while (true) {
            super.clear();
            System.out.println("=== UPDATE DATA ===");
            displayData();
            if (this.DataKomik.size() == 0) {
                Thread.sleep(1000);
                break;
            } else {
                System.out.print("Pilih Nomor Data yang Mau Diubah: ");
                String pil_ubah_String = input.readLine();
                if (isNum(pil_ubah_String)) {
                    int pil_ubah = Integer.parseInt(pil_ubah_String);
                    if (pil_ubah <= 0 || pil_ubah > this.DataKomik.size()) {
                        System.out.println("\n=== Data Tidak Tersedia ===");
                        Thread.sleep(1000);
                    } else {
                        // this.DataKomik.get(pil_ubah-1).display();
                        System.out.println(this.DataKomik.get(pil_ubah-1).getJdl());
                        System.out.println(this.DataKomik.get(pil_ubah-1).getGenre());
                        System.out.println(this.DataKomik.get(pil_ubah-1).getThn());
                        System.out.println(this.DataKomik.get(pil_ubah-1).getJml());
                        System.out.println(this.DataKomik.get(pil_ubah-1).getStok());
                        boolean back = true;
                        while (back) {
                            System.out.println("> 1. Ubah Judul");
                            System.out.println("> 2. Ubah Genre");
                            System.out.println("> 3. Ubah Tahun Terbit");
                            System.out.println("> 4. Ubah Jumlah Halaman");
                            System.out.println("> 5. Ubah Stok");
                            System.out.println("> 5. Kembali ke Menu");
                            System.out.print("Masukkan pilihan: ");
                            String pil_ubah_menu_String = input.readLine();
                            if (isNum(pil_ubah_menu_String)) {
                                int pil_ubah_menu = Integer.parseInt(pil_ubah_menu_String);
                                switch (pil_ubah_menu) {
                                    case 1:
                                        System.out.print("Masukkan judul baru: ");
                                        this.DataKomik.get(pil_ubah-1).setJudul(input.readLine());
                                        break;
                                    case 2:
                                        System.out.print("Masukkan genre baru: ");
                                        this.DataKomik.get(pil_ubah-1).setGenre(input.readLine());
                                        break;
                                    case 3:
                                        while (true) {
                                            System.out.print("Masukkan tahun terbit baru: ");
                                            String thn_String = input.readLine();
                                            if (isNum(thn_String)) {
                                                this.DataKomik.get(pil_ubah-1).setThn(Integer.parseInt(thn_String));
                                                break;
                                            } else {
                                                System.out.println("\n=== Tahun Terbit Harus Berupa Angka ===");
                                                Thread.sleep(1000);
                                            }
                                        }
                                        break;
                                    case 4:
                                        while (true) {
                                            System.out.print("Masukkan jumlah halaman baru: ");
                                            String jml_String = input.readLine();
                                            if (isNum(jml_String)) {
                                                this.DataKomik.get(pil_ubah-1).setJml(Integer.parseInt(jml_String));
                                                break;
                                            } else {
                                                System.out.println("\n=== Jumlah Halaman Harus Berupa Angka ===");
                                                Thread.sleep(1000);
                                            }
                                        }
                                        break;
                                    case 5:
                                        while (true) {
                                            System.out.print("Masukkan stok baru: ");
                                            String jml_String = input.readLine();
                                            if (isNum(jml_String)) {
                                                this.DataKomik.get(pil_ubah-1).setStok(Integer.parseInt(jml_String));
                                                break;
                                            } else {
                                                System.out.println("\n=== Stok Harus Berupa Angka ===");
                                                Thread.sleep(1000);
                                            }
                                        }
                                        break;
                                    case 6:
                                        back = false;
                                        break;
                                    default:
                                        System.out.println("\n=== Pilihan Tidak Tersedia ===");
                                        Thread.sleep(1000);
                                        break;
                                }
                                if (pil_ubah_menu >= 1 && pil_ubah_menu <= 4) {
                                    System.out.println("\n=== Data Berhasil Diubah ===");
                                    Thread.sleep(1000);
                                }
                            } else {
                                System.out.println("\n=== Input Harus Berupa Angka ===");
                                Thread.sleep(1000);
                            }
                        }
                        if (!back) {
                            break;
                        }
                    }
                } else {
                    System.out.println("\n=== Input Harus Berupa Angka ===");
                    Thread.sleep(1000);
                }
            }
        }
    }

    public void delete() throws NumberFormatException, IOException, InterruptedException{
        while (true) {
            super.clear();
            System.out.println("=== HAPUS DATA ===");
            displayData();
            if (this.DataKomik.size() == 0) {
                Thread.sleep(1000);
                break;
            } else {
                System.out.print("Pilih Nomor Data yang Mau Diubah: ");
                String pil_hapus_String = input.readLine();
                if (isNum(pil_hapus_String)) {
                    int pil_hapus = Integer.parseInt(pil_hapus_String);
                    if (pil_hapus <= 0 || pil_hapus > this.DataKomik.size()) {
                        System.out.println("\n=== Data Tidak Tersedia ===");
                        Thread.sleep(1000);
                    } else {
                        // this.DataKomik.get(pil_hapus-1).display();
                        System.out.println(this.DataKomik.get(pil_hapus-1).getJdl());
                        System.out.println(this.DataKomik.get(pil_hapus-1).getGenre());
                        System.out.println(this.DataKomik.get(pil_hapus-1).getThn());
                        System.out.println(this.DataKomik.get(pil_hapus-1).getJml());
                        System.out.println(this.DataKomik.get(pil_hapus-1).getStok());
                        boolean loop = true;
                        while (loop) {
                            System.out.print("Apakah Anda Yakin untuk Menghapus Data Ini? (y/n): ");
                            String confirm = input.readLine();
                            if (confirm.equals("Y") || confirm.equals("y")) {
                                this.DataKomik.remove(pil_hapus-1);
                                System.out.println("\n=== Data Berhasil Dihapus ===");
                                Thread.sleep(1000);
                                loop = false;
                            } else if (confirm.equals("N") || confirm.equals("n")) {
                                System.out.println("\n=== Data Tidak Dihapus ===\n=== Kembali ke Menu ===");
                                Thread.sleep(1000);
                                loop = false;
                            } else {
                                System.out.println("\n=== Keyword yang Anda Masukkan Tidak Sesuai ===");
                                Thread.sleep(1000);
                            }
                        }
                        if (!loop) {
                            break;
                        }
                    }
                } else {
                    System.out.println("\n=== Input Harus Berupa Angka ===");
                    Thread.sleep(1000);
                }
            }
        }
    }
}
