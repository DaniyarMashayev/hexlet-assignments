package exercise;

import java.util.stream.Collectors;
import java.util.Arrays;

// BEGIN
class App {
    public static String getForwardedVariables(String data) {
        return Arrays.stream(data.split("\n"))
                .filter(u -> u.startsWith("environment="))
                        .map(u -> u.replaceAll("environment=", ""))
                        .map(u -> u.replaceAll("\"", ""))
                        .map(u -> u.split(","))
                        .flatMap(u -> Arrays.stream(u))
                        .filter(u -> u.startsWith("X_FORWARDED_"))
                        .map(u -> u.replaceAll("X_FORWARDED_", ""))
                .collect(Collectors.joining(","));

    }
}
//END
