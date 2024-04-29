import java.io.IOException;
public interface Modify {
    void create() throws IOException, InterruptedException;
    void update() throws NumberFormatException, IOException, InterruptedException;
    void delete() throws NumberFormatException, IOException, InterruptedException;
}
