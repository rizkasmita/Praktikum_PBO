import java.util.ArrayList;

// import java.io.BufferedReader;
import java.io.IOException;
// import java.io.InputStreamReader;

public class Member extends User {
    private ArrayList<Komik> DataKomik;
    private String lvl;
    // protected InputStreamReader p = new InputStreamReader(System.in);
    // protected BufferedReader input = new BufferedReader(p);

    public Member(String usn, String pw, String name, String lvl, ArrayList<Komik> datkom) {
        super(usn, pw, name);
        this.lvl = lvl;
        this.DataKomik = datkom;
        // super.DataKomik = new ArrayList<>();
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
                System.out.println("\n");
            }
        }
    }

    @Override
    protected void menu() throws IOException, InterruptedException {
        while(true) {
            greeting();
            System.out.println("[1] Search Comic");
            System.out.println("[2] Display Comic");
            System.out.println("[3] Log Out");
            System.out.print("Input here: ");
            String pil = input.readLine();
            if (super.isNum(pil)) {
                int pilInt = Integer.parseInt(pil);
                switch (pilInt) {
                    case 1:
                        search();
                        break;
                    case 2:
                        displayData();
                        Thread.sleep(1000);
                        break;
                    case 3:
                        return;
                    default:
                        System.out.println("Pilihan tidak ada");
                        Thread.sleep(1000);
                }
            }
        }
    }

    public void search() throws IOException, InterruptedException {
        clear();
        System.out.println("=== SEARCH COMIC ===");
        System.out.print("Masukkan judul komik: "); String jdlKom = input.readLine();
        for (Komik kom: DataKomik) {
            if (jdlKom.equals(kom.getJdl())) {
            // if (kom.getJdl().equals(jdlKom)) {
                System.out.println("=== Comic Found ===");
                System.out.println(kom.getJdl());
                System.out.println(kom.getGenre());
                System.out.println(kom.getThn());
                System.out.println(kom.getJml());
            } else {
                System.out.println("=== Comic Not Found ===");
            }
        }
        Thread.sleep(1000);
    }
}
