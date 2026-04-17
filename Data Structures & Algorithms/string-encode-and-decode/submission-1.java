class Solution {

    public String encode(List<String> strs) {
        StringBuilder result = new StringBuilder("");
        for (String s : strs) {
            result.append(s.length() + "#" + s);
        }
        return result.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int index = str.indexOf("#", i);
            String amountStr = str.substring(i, index);
            index++; //Index now stands at the start of the string
            result.add(str.substring(index, index + Integer.parseInt(amountStr)));
            i = index + Integer.parseInt(amountStr);
        }
        return result;
    }
}
