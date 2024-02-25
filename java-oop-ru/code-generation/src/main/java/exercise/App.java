package exercise;


import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;


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
