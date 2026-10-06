import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        // ---- Phase 1 ----
        System.out.println("=== ArrayCollection ===");
        ArrayCollection<Artifact> arr = new ArrayCollection<>();
        arr.add(new Artifact("A101", "Bronze Axe", "Bronze Age"));
        arr.add(new Artifact("B205", "Mona Study", "Renaissance"));
        arr.add(new Artifact("C309", "Flint Knife", "Stone Age"));

        Artifact key = new Artifact("B205", "", "");
        System.out.println("Contains B205? " + arr.contains(key));
        System.out.println("Retrieved: " + arr.get(key));

        arr.remove(new Artifact("A101", "", ""));   // C309 should swap into slot 0
        System.out.println("Size after removal: " + arr.size());
        System.out.print(arr);

        // ---- Phase 2 ----
        System.out.println("\n=== LinkedCollection ===");
        LinkedCollection<Artifact> linked = new LinkedCollection<>();
        linked.add(new Artifact("A101", "Bronze Axe", "Bronze Age"));
        linked.add(new Artifact("B205", "Mona Study", "Renaissance"));
        linked.add(new Artifact("C309", "Flint Knife", "Stone Age"));

        System.out.println("Contains B205? " + linked.contains(key));
        linked.remove(key);
        System.out.println("Size after removal: " + linked.size());
        System.out.print(linked);

        // ---- Phase 3 ----
        System.out.println("\n=== ArrayList + Collections.sort ===");
        ArrayList<Artifact> museumList = new ArrayList<>();
        museumList.add(new Artifact("M04", "Vase", "Greek"));
        museumList.add(new Artifact("A01", "Spearhead", "Iron Age"));
        museumList.add(new Artifact("Z99", "Manuscript", "Medieval"));
        museumList.add(new Artifact("B12", "Fresco", "Renaissance"));

        System.out.println("Before sort:");
        for (Artifact a : museumList) System.out.println(a);

        Collections.sort(museumList);

        System.out.println("After sort:");
        for (Artifact a : museumList) System.out.println(a);
    }
}
