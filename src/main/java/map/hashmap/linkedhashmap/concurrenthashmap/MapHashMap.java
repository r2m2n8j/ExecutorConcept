package map.hashmap.linkedhashmap.concurrenthashmap;

import java.util.HashMap;
import java.util.Map;

public class MapHashMap {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("Anuj", 28);
        map.put("kumar", 29);
        map.put("Mishra", 27);

        if(map.containsKey("Anuj")) System.out.println("Age :: " + map.get("Anuj"));
        int size = map.size();
        System.out.println("Size of the Map :: "+ size);
        for(Map.Entry<String, Integer> m: map.entrySet()){
            System.out.println("Name :: " + m.getKey() + " Age :: "+ m.getValue());
        }

    }
}
