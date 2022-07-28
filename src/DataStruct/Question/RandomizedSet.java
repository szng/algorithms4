package DataStruct.Question;

import java.util.*;

/**
 * leetcode 380
 */
public class RandomizedSet {
    private final Map<Integer, Integer> map;
    private final List<Integer> list;

    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    public boolean insert(int val) {
        if (map.get(val) != null) {
            return false;
        }
        list.add(val);
        map.put(val, list.indexOf(val));
        return true;
    }

    public boolean remove(int val) {
        if (map.get(val) == null) {
            return false;
        }
        Integer index = map.get(val);
        Integer last = list.get(list.size() - 1);
        list.set(index, last);
        map.put(last, index);
        list.remove(list.size() - 1);
        map.remove(val);
        return true;
    }

    public int getRandom() {
        int size = list.size();
        Random random = new Random();
        return list.get(random.nextInt(size));
    }

    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        randomizedSet.insert(-1);
        randomizedSet.remove(-1);
        randomizedSet.insert(-2);
        randomizedSet.getRandom();
        randomizedSet.remove(-2);
        randomizedSet.insert(-2);
        System.out.println(randomizedSet.getRandom());
    }
}
