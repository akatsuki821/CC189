package OtherProblems;

import java.util.*;

public class AllAnagrams {
    public List<Integer> allAnagrams(String s, String l) {
        List<Integer> res = new ArrayList<>();
        if (l.length() == 0) {
            return res;
        }
        if (s.length() > l.length()) {
            return res;
        }
        Map<Character, Integer> map = countMap(s);

        int match = 0;
        for (int i = 0; i < l.length(); i++) {
            char temp = l.charAt(i);
            Integer count = map.get(temp);
            if (count != null) {
                map.put(temp, count - 1);
                if (count == 1) {
                    match++;
                }
            }
            if (i >= s.length()) {
                temp = l.charAt(i - s.length());
                count = map.get(temp);
                if (count != null) {
                    map.put(temp, count + 1);
                    if (count == 0) {
                        match--;
                    }
                }
            }
            if (match == map.size()) {
                res.add(i - s.length() + 1);
            }
        }
        return res;
    }

    private Map<Character, Integer> countMap(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            Integer count = map.get(ch);
            if (count == null) {
                map.put(ch, 1);
            } else {
                map.put(ch, count + 1);
            }
        }
        return map;
    }
}
