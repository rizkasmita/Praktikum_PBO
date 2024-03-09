import java.io.*;
import java.util.*;
// import java.util.concurrent.TimeUnit;

public class App {
    private static InputStreamReader p = new InputStreamReader(System.in);
    private static BufferedReader input = new BufferedReader(p);
    private static ArrayList<Komik> DataKomik = new ArrayList<>();

    public static void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void main(String[] args) throws NumberFormatException, IOException, InterruptedException {
        while (true) {
            clear();
            System.out.println("> 1. Tambah Data");
            System.out.println("> 2. Tampilkan Data");
            System.out.println("> 3. Edit Data");
            System.out.println("> 4. Hapus Data");
            System.out.println("> 5. Exit");
            System.out.print("Masukkan pilihan: ");
            String pil_menu_String = input.readLine();
            if (isNum(pil_menu_String)) {
                int pilih = Integer.parseInt(pil_menu_String);
                switch (pilih) {
                    case 1:
                        tambah_data();
                        break;
                    case 2:
                        clear();
                        display_data();
                        System.out.println(".");
                        Thread.sleep(1000);
                        System.out.println("..");
                        Thread.sleep(1000);
                        System.out.println("...");
                        Thread.sleep(1000);
                        break;
                    case 3:
                        update_data();
                        break;
                    case 4:
                        hapus_data();
                        break;
                    case 5:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("\n=== Pilihan Tidak Tersedia ===");
                        Thread.sleep(1000);
                        // TimeUnit.SECONDS.sleep(1);
                        break;
                }
            } else {
                System.out.println("\n=== Input Harus Berupa Angka ===");
                Thread.sleep(1000);
            }
        }
    }

    static void tambah_data() throws NumberFormatException, IOException, InterruptedException {
        clear();
        System.out.println("=== TAMBAH DATA ===");
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
                        Komik kom = new Komik(jdl, gen, thn, jml);
                        DataKomik.add(kom);
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

    static void display_data() {
        // clear();
        if (DataKomik.size() == 0) {
            System.out.println("\n=== Data Tidak Tersedia ===");
        } else {
            for(int i = 0; i < DataKomik.size(); i++) {
                System.out.println("[" + (i+1) + "]");
                DataKomik.get(i).display();
            }
        }
    }

    static void update_data() throws NumberFormatException, IOException, InterruptedException {
        while (true) {
            clear();
            System.out.println("=== UPDATE DATA ===");
            display_data();
            if (DataKomik.size() == 0) {
                Thread.sleep(1000);
                break;
            } else {
                System.out.print("Pilih Nomor Data yang Mau Diubah: ");
                String pil_ubah_String = input.readLine();
                if (isNum(pil_ubah_String)) {
                    int pil_ubah = Integer.parseInt(pil_ubah_String);
                    if (pil_ubah <= 0 || pil_ubah > DataKomik.size()) {
                        System.out.println("\n=== Data Tidak Tersedia ===");
                        Thread.sleep(1000);
                    } else {
                        DataKomik.get(pil_ubah-1).display();
                        boolean back = true;
                        while (back) {
                            System.out.println("> 1. Ubah Judul");
                            System.out.println("> 2. Ubah Genre");
                            System.out.println("> 3. Ubah Tahun Terbit");
                            System.out.println("> 4. Ubah Jumlah Halaman");
                            System.out.println("> 5. Kembali ke Menu");
                            System.out.print("Masukkan pilihan: ");
                            String pil_ubah_menu_String = input.readLine();
                            if (isNum(pil_ubah_menu_String)) {
                                int pil_ubah_menu = Integer.parseInt(pil_ubah_menu_String);
                                switch (pil_ubah_menu) {
                                    case 1:
                                        System.out.print("Masukkan judul baru: ");
                                        DataKomik.get(pil_ubah-1).setJudul(input.readLine());
                                        break;
                                    case 2:
                                        System.out.print("Masukkan genre baru: ");
                                        DataKomik.get(pil_ubah-1).setGenre(input.readLine());
                                        break;
                                    case 3:
                                        while (true) {
                                            System.out.print("Masukkan tahun terbit baru: ");
                                            String thn_String = input.readLine();
                                            if (isNum(thn_String)) {
                                                DataKomik.get(pil_ubah-1).setThn(Integer.parseInt(thn_String));
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
                                                DataKomik.get(pil_ubah-1).setJml(Integer.parseInt(jml_String));
                                                break;
                                            } else {
                                                System.out.println("\n=== Jumlah Halaman Harus Berupa Angka ===");
                                                Thread.sleep(1000);
                                            }
                                        }
                                        break;
                                    case 5:
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

    static void hapus_data() throws NumberFormatException, IOException, InterruptedException{
        while (true) {
            clear();
            System.out.println("=== HAPUS DATA ===");
            display_data();
            if (DataKomik.size() == 0) {
                Thread.sleep(1000);
                break;
            } else {
                System.out.print("Pilih Nomor Data yang Mau Diubah: ");
                String pil_hapus_String = input.readLine();
                if (isNum(pil_hapus_String)) {
                    int pil_hapus = Integer.parseInt(pil_hapus_String);
                    if (pil_hapus <= 0 || pil_hapus > DataKomik.size()) {
                        System.out.println("\n=== Data Tidak Tersedia ===");
                        Thread.sleep(1000);
                    } else {
                        DataKomik.get(pil_hapus-1).display();
                        boolean loop = true;
                        while (loop) {
                            System.out.print("Apakah Anda Yakin untuk Menghapus Data Ini? (y/n): ");
                            String confirm = input.readLine();
                            if (confirm.equals("Y") || confirm.equals("y")) {
                                DataKomik.remove(pil_hapus-1);
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

    static boolean isNum(String str) {
        if (str == null) {
            return false;
        }
        try {
            int i = Integer.parseInt(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}