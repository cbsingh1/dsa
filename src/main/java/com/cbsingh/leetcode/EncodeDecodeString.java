package com.cbsingh.leetcode;

import java.util.ArrayList;
import java.util.List;

public class EncodeDecodeString {
    void main() {
        var cut = new EncodeDecodeString();
        var input = List.of("we", "say", ":", "yes", "!@#$%^&*()");
        String encodedOutput = cut.encode(input);
        List<String> output = cut.decode(encodedOutput);

        System.out.println(output);
    }

    public String encode(List<String> strs) {
        var sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length()).append("#").append(str);
        }
        return sb.toString().trim();
    }

    public List<String> decode(String str) {
        var res = new ArrayList<String>();
        if (str.isBlank()) return res;

        int i = 0;
        while (i < str.length()) {
            int hashIndex = str.indexOf('#', i);
            if (hashIndex == -1) break;

            int wordLength = Integer.parseInt(str.substring(i, hashIndex));
            String word = str.substring(hashIndex + 1, hashIndex + 1 + wordLength);
            res.add(word);
            i = hashIndex + 1 + wordLength;
        }
        return res;
    }
}
