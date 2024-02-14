package exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class App {
    public static List<String> buildApartmentsList(List<Home> apartments, int count) {
        List<String> result = new ArrayList<>();
        List<Home> sortedApartments = apartments.stream()
                .sorted((apartment1, apartment2) -> apartment1.compareTo(apartment2))
                .collect(Collectors.toCollection(ArrayList::new));
        for (Home apartment : sortedApartments) {
            result.add(apartment.toString());
            if (result.size() == count) {
                break;
            }
        }
        return result;
    }
}
// END
