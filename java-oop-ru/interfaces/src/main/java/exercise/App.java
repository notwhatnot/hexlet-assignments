package exercise;

import java.util.List;
import java.util.stream.Collectors;
import java.util.*;


// BEGIN
class App {
    public static List<String> buildApartmentsList(List<Home> realEstateObjects, int n) {

       if (realEstateObjects.isEmpty()) {
           return Collections.emptyList();
       }

        Collections.sort(realEstateObjects, (a, b) -> a.compareTo(b));

        List<String> realEstateObjectsString = realEstateObjects.stream()
                        .map(realEstateObject -> realEstateObject.toString())
                        .collect(Collectors.toList());
        System.out.println(realEstateObjectsString);

        return realEstateObjectsString.subList(0, n);
    }
}
// END
