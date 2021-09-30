package client;
// D:\Projects\Starcloud\src\mainD:\Projects\Starcloud\src\main\server

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class FilesOps {
    String path = "D:\\Projects\\Starcloud\\src\\main\\client";
    private List<Path> str;

    public FilesOps() throws IOException {
        this.str = Files.walk(Paths.get(path))
                .filter(Files::isRegularFile)
                .collect(Collectors.toList());
    }

    public List<Path> getStr(){
        return str;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
