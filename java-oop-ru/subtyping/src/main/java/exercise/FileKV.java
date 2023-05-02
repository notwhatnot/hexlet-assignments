package exercise;

import java.util.Map;
import java.util.HashMap;

// BEGIN
class FileKV implements KeyValueStorage {
    private String pathToFile;
    private Map<String, String> initial;

    FileKV(String pathToFile, Map<String, String> initial) {
        this.pathToFile = pathToFile;
        this.initial = initial;

        String initialMapToJson = Utils.serialize(initial);
        Utils.writeFile(pathToFile, initialMapToJson);


    }

    @Override
    public void set(String key, String value) {
        String storageAsString = Utils.readFile(pathToFile);
        Map<String, String> storageAsMap = Utils.unserialize(storageAsString);
        storageAsMap.put(key, value);
        String storageMapToJson = Utils.serialize(storageAsMap);
        Utils.writeFile(pathToFile, storageMapToJson);

    }

    @Override
    public void unset(String key) {
        String storageAsString = Utils.readFile(pathToFile);
        Map<String, String> storageAsMap = Utils.unserialize(storageAsString);
        storageAsMap.remove(key);
        String storageMapToJson = Utils.serialize(storageAsMap);
        Utils.writeFile(pathToFile, storageMapToJson);
    }



    @Override
    public String get(String key, String defaultValue) {
        String storageAsString = Utils.readFile(pathToFile);
        Map<String, String> storageAsMap = Utils.unserialize(storageAsString);
        return storageAsMap.getOrDefault(key, defaultValue);
    }


    @Override
    public Map<String, String> toMap() {
        String storageAsString = Utils.readFile(pathToFile);
        return Utils.unserialize(storageAsString);

    }


}
// END
