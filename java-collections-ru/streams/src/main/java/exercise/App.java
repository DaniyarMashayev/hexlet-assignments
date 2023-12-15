package exercise;

import java.util.List;

// BEGIN
class App {
    public static long getCountOfFreeEmails(List<String> emails) {
        List<String> freeEmails = List.of("@gmail.com", "@yandex.ru", "@hotmail.com");
        long countOfFreeEmails = 0;
        for (String freeEmail : freeEmails) {
            long countEmails = emails.stream()
                    .filter(email -> email.contains(freeEmail))
                    .count();
            countOfFreeEmails = countOfFreeEmails + countEmails;
        }
        return countOfFreeEmails;
    }
}
// END
