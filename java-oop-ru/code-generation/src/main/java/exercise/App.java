package exercise;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Map;


// BEGIN
class App {
    public static void save(Path path, Car car) {
        try {
            System.out.println(Files.write(path, car.serialize().getBytes()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Car extract(Path path) {
        String read = "";
        try {
            read = Files.readString(path.toAbsolutePath().normalize());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return Car.unserialize(read);
    }
}
// END
