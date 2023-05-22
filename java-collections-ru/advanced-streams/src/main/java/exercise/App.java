package exercise;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

// BEGIN
class App {

    public static void main(String[] args) {
        System.out.println(getForwardedVariables("[program:options]\n" +
                "environment=\"X_FORWARDED_variable=value,  \"\n" +
                "\n" +
                "key=value"));
    }

    public static String getForwardedVariables(String config) {
        List<String> configList = List.of(config.split("\n"));
        return configList.stream()
                .filter(row -> row.startsWith("environment"))
                .map(row -> row.replace("environment=", "").replace("\"", ""))
                .flatMap(row ->
                            Stream.of(row.split(",")))
                                    .filter(element -> element.startsWith("X_FORWARDED"))
                                    .map(element -> element.replace("X_FORWARDED_", ""))
                .collect(Collectors.joining(","));
    }
}
//END
