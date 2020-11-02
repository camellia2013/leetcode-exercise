package com.example.demo.lengthOfLongestSubstring;


import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;


@Slf4j
public class LengthOfLongestSubstring {

    public static void main(String[] args) {

        // Assert.isTrue(new LengthOfLongestSubstring().lengthOfLongestSubstring("") == 0, "");
        Assert.isTrue(new LengthOfLongestSubstring().lengthOfLongestSubstring(" ") == 1, "");
        Assert.isTrue(new LengthOfLongestSubstring().lengthOfLongestSubstring("abcabcbb") == 3, "");
        Assert.isTrue(new LengthOfLongestSubstring().lengthOfLongestSubstring("bbbbb") == 1, "");
        Assert.isTrue(new LengthOfLongestSubstring().lengthOfLongestSubstring("pwwkew") == 3, "");
    }


    public int lengthOfLongestSubstring(String s) {

        HashSet<String> r = new HashSet<>();
        HashSet<String> h = new LinkedHashSet<>();

        String[] array = s.split("");
        for (int i = 0; i < array.length; i++) {
            h.clear();
            for (int j = i; j < array.length; j++) {
                int a = h.size();
                h.add(array[j]);
                if (h.size() == a) {
                    r.add(join(h));
                    break;
                }
            }
            r.add(join(h));
        }

        Iterator<String> i = r.iterator();
        int max = 0;
        while (i.hasNext()) {
            max = Math.max(i.next().length(), max);
        }
        return max;
    }


    private String join(final HashSet<String> hs) {

        StringBuilder s = new StringBuilder();
        for (final String h : hs) {
            s.append(h);
        }
        return s.toString();
    }
}
