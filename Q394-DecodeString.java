package medium;

public class DecodeString {
    public class StringWithLength {
        public String str;
        public int length;
        
        public StringWithLength(String str, int length) {
            this.str = str;
            this.length = length;
        }
    }
    
    public static void main(String[] args) {
        DecodeString ds = new DecodeString();
        System.out.println(ds.decodeString("100[leetcode]"));
    }
    
    public String decodeString(String s) {
        if (s == null || s.length() <= 0) {
            return s;
        }
        StringWithLength result = decodeSubString("1[" + s + "]");
        return result.str;
    }
    
    private StringWithLength decodeSubString(String s) {
        StringBuilder ssb = new StringBuilder();
        StringBuilder csb = new StringBuilder();
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                csb.append(c);
            } else if (c == '[') {
                StringWithLength swl = decodeSubString(s.substring(i + 1));
                int count = csb.toString().length() > 0 ? Integer.parseInt(csb.toString()) : 1;
                for (int j=0; j<count; j++) ssb.append(swl.str);
                csb = new StringBuilder();
                i += swl.length;
            } else if (c == ']') {
                String result = ssb.toString();
                return new StringWithLength(result, i + 1);
            } else {
                ssb.append(c);
            }
        }
        return new StringWithLength(ssb.toString(), 1);
    }

}
