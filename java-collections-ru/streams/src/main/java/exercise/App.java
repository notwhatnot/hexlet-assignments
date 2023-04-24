package exercise;

import java.util.List;
import java.util.Arrays;

// BEGIN
class App {
    public static long getCountOfFreeEmails(List<String> emails) {
        String[] freeDomains = {"gmail.com", "yandex.ru", "hotmail.com"};
        List<String> freeDomainsList = Arrays.asList(freeDomains);
        return emails.stream()
                .filter(email -> freeDomainsList.contains(email.split("@")[1]))
                .count();
    }
}
// END
