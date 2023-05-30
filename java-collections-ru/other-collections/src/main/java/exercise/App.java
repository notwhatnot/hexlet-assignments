package exercise;

import java.util.*;

// BEGIN
public class App {

    public static Map<String, String> genDiff(Map<String, Object> data1, Map<String, Object> data2) {
        Set<String> data1Keys= data1.keySet();
        Set<String> data2Keys = data2.keySet();
        Set<String> union = new HashSet<>();
        union.addAll(data1Keys);
        union.addAll(data2Keys);

        Map<String, String> result = new LinkedHashMap<>();


        for (String keyEntry: union) {
            Object data1Object = data1.get(keyEntry);
            Object data2Object = data2.get(keyEntry);

            String differenceDescription = App.findDifference(data1Object, data2Object);

            result.put(keyEntry, differenceDescription);
        }

        return result;
    }

    private static String findDifference(Object data1Object, Object data2Object) {
        if (null != data1Object && data1Object.equals(data2Object)) {
            return "unchanged";
        }

        if (null != data1Object && null != data2Object && !data1Object.equals(data2Object)) {
            return "changed";
        }

        if (null == data1Object && null != data2Object) {
            return "added";
        }

        if (null != data1Object && null == data2Object) {
            return "deleted";
        }
        return null;
    }
}
//END
