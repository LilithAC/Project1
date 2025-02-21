import java.util.ArrayList;
import java.util.Arrays;

public class SetOperations {

    public static final String[] UNIVERSE = {
            "Twilight Sparkle",
            "Applejack",
            "Fluttershy",
            "Rarity",
            "Pinkie Pie",
            "Rainbow Dash"
    };

    //method creates new arrayList containing ALL
    //the elements from arrayLists a and b but excludes duplicates
    public static void union(ArrayList a, ArrayList b) {
        ArrayList<String> union = new ArrayList<>();
        union.addAll(a);
        for (int i = 0; i < b.size(); i++) {
            if (union.contains(b.get(i))) { //checks if element is already listed
                continue;
            }
            union.add(b.get(i).toString());
        }
        System.out.println(union);
    }

    //method creates a new arrayList containing only
    //the elements that arrayLists a and b SHARE
    public static void intersect(ArrayList a, ArrayList b) {
        ArrayList<String> intersect = new ArrayList<>();
        for (int i = 0; i < a.size(); i++) {
            if (b.contains(a.get(i))) { //checks if element is in arrayList b before adding
                intersect.add(a.get(i).toString());
            }
        }
        System.out.println(intersect);
    }

    //method creates a new arrayList containing
    //all the elements OUTSIDE the subset
    public static void complement(ArrayList a) {
        ArrayList<String> universe = new ArrayList<>();
        universe.addAll(Arrays.asList(UNIVERSE));
        SetOperations.complement(universe, a);
    }

    //Write a method that accepts 2 parameters:
    //an ArrayList of all values in your sample.
    //And one that accepts A, your subset. Use that to solve for complement.
    public static void complement(ArrayList<String> universe, ArrayList<String> subset) {
        ArrayList<String> complement = new ArrayList<>();
        for (String e : universe) {
            if (!subset.contains(e)) { //checks if element isnt in subset
                complement.add(e);
            }
        }
        System.out.println(complement);
    }
}
