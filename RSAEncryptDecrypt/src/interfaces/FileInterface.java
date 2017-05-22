package interfaces;

import java.nio.file.Path;
import java.util.List;

public interface FileInterface {

    List<String> getDataFromFile(Path pathToFile);
    void putDataToFile(List<String> data, Path pathToFile);
    void showFile(Path pathToFile);

}
