package util.Utility;




import java.util.ArrayList;
import java.util.HashSet;

public class JUtility {
    public static String addPrefix(String prefix, String id) {
        return prefix + id;
    }

    public static int seperateID(String strID) {
        String[] part = strID.split("(?<=\\D)(?=\\d)");
        //part[0] gives Prefix, part [1] gives numeric part
        //System.out.println(part[0]);
        //System.out.println(part[1]);
        return Integer.parseInt(part[1]);
    }
   
    public static ArrayList<String> removeStringDuplicates(ArrayList<String> list) {

        // Store unique items in result.
        ArrayList<String> result = new ArrayList<String>();

        // Record encountered Strings in HashSet.
        HashSet<String> set = new HashSet<>();

        // Loop over argument list.
        for (String item : list) {

            // If String is not in set, add it to the list and the set.
            if (!set.contains(item)) {
                result.add(item);
                set.add(item);
            }
        }
        return result;
    }
    

  

}
