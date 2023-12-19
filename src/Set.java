import java.util.HashMap;
import java.util.Iterator;

public class Set<E> {
    private HashMap<E,E> map;

    public Set() {
        map = new HashMap<E,E>();
    }

    public Boolean add(E e) {
        if(!contains(e)) {
            map.put(e, e);
            return true;
        }
        return false;
    }

    public Boolean remove(E e) {
        if(contains(e)) {
            map.remove(e);
            return true;
        }
        else return false;
    }

    public void printSet() {
        System.out.println(map.values());
    }

    public void clear() {
        map.clear();
    }

    public Boolean contains(E e){
        return map.containsKey(e);
    }

    public Boolean containsAll(Set<? extends E> s) {
        return map.keySet().containsAll(s.map.keySet());
    }

    public Boolean addAll(Set<? extends E> s) {
        if(!containsAll(s)) {
            map.putAll(s.map);
            return true;
        }
        return false;
    }

    public Boolean removeAll(Set<? extends E> s) { //credit by Gear 650610751
        boolean modified = false;

        for (E element : s.map.keySet()) {
            if (map.containsKey(element)) {
                map.remove(element);
                modified = true;
            }
        }

        return modified;
    }

    public Boolean retainAll(Set<? extends E> s) { //intersection credit by CHAT GPT :D
        boolean retainSuccess = false;

        Iterator<E> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            E element = iterator.next();
            if (!s.map.containsKey(element)) {
                iterator.remove();
                retainSuccess = true;
            }
        }
        return retainSuccess;
    }

    public int size() {
        return map.size();
    }

    public Boolean isEmpty() {
        return map.isEmpty();
    }

    public Iterator<E> iterator() {
        return map.keySet().iterator();
    }


    public static void main(String[] args) {
        Set<String> FoodSet = new Set<>();
        System.out.println(FoodSet.isEmpty());
        FoodSet.add("noodle");
        FoodSet.add("sticky rice");
        FoodSet.add("hamburger");
        System.out.println(FoodSet.isEmpty());
        FoodSet.remove("hamburger");
        FoodSet.contains("hamburger");
        Set<String> otherSet = new Set<>();
        otherSet.add("sticky rice");
        otherSet.add("chicken wing");
        FoodSet.retainAll(otherSet);
        FoodSet.printSet();
        otherSet.printSet();
        FoodSet.iterator();
        FoodSet.containsAll(otherSet);
        FoodSet.clear();
        System.out.println(FoodSet.size());
        System.out.println(otherSet.size());
    }
}