import java.io.*;
import java.util.*;
// import java.util.concurrent.TimeUnit;

public class App {
    private static InputStreamReader p = new InputStreamReader(System.in);
    private static BufferedReader input = new BufferedReader(p);
    // private static ArrayList<Komik> DataKomik = new ArrayList<>();
    private static ArrayList<Member> DataMember = new ArrayList<>();
    private static ArrayList<Komik> DataKomik = new ArrayList<>();
    
    public static void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void main(String[] args) throws NumberFormatException, IOException, InterruptedException {
        Admin Admin = new Admin("admin", "123123", "admin", DataMember, DataKomik);
        // Member mem1 = new Member("member", "123123", "rizka", "Member");
        while (true) {
            clear();
            System.out.println("> 1. Registrasi");
            System.out.println("> 2. Login");
            System.out.println("> 3. Exit");
            // System.out.println("> 1. Tambah Data");
            // System.out.println("> 2. Tampilkan Data");
            // System.out.println("> 3. Edit Data");
            // System.out.println("> 4. Hapus Data");
            // System.out.println("> 5. Exit");
            System.out.print("Masukkan pilihan: ");
            String pil_menu_String = input.readLine();
            if (isNum(pil_menu_String)) {
                int pilih = Integer.parseInt(pil_menu_String);
                switch (pilih) {
                    case 1:
                        clear();
                        System.out.println("=== REGISTRASI ===");
                        System.out.print("Username: "); String usn = input.readLine();
                        System.out.print("Password: "); String pw = input.readLine();
                        System.out.print("Nama: "); String name = input.readLine();
                        Member new_mem = new Member(usn, pw, name, "Member", DataKomik);
                        DataMember.add(new_mem);
                        System.out.println("Berhasil registrasi\nSilakan Login!");
                        Thread.sleep(1000);
                        // tambah_data();
                        break;
                    case 2:
                        clear();
                        System.out.println("=== LOGIN ===");
                        System.out.print("Username: "); String username = input.readLine();
                        System.out.print("Password: "); String password = input.readLine();
                        if (username.equals(Admin.getUsn()) && (password.equals(Admin.getPw()))) {
                            Admin.menu();
                        }
                        for (Member mem: DataMember) {
                            if (username.equals(mem.getUsn()) && password.equals(mem.getPw())) {
                                mem.menu();
                            }
                        }
                        break;
                    case 3:
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