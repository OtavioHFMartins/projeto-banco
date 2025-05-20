package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static java.lang.String.format;
import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.WRITE;

public class IOUtil {

    public static void addLinha(String caminho, String linha) {
        try {
            Path path = Path.of(caminho);
            Files.writeString(path, linha, WRITE, APPEND);
        } catch (IOException e) {
            throw new IllegalArgumentException(format("Caminho do arquivo %s invalido", caminho));
        }
    }

    public static List<String> getLinhas(String caminho) {
        try {
            Path path = Path.of(caminho);
            return Files.readAllLines(path);

        } catch (IOException e) {
            throw new IllegalArgumentException(format("Caminho do arquivo %s invalido", caminho));
        }
    }

}
