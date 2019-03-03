import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapFactory {
    public Map creadorMap(int n){
        if (n==1){
            return new HashMap();
        }else if (n==2){
            return new TreeMap();
        }else{
            return new LinkedHashMap();
        }

    }
}
