import java.io.File;
import java.io.FilenameFilter;

public class Colar implements FilenameFilter {
    String extension;

    @Override
    public boolean accept(File dir, String name){
        return name.endsWith(extension);
    }
}
