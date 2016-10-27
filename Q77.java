public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> empty = new ArrayList<>();
        if (k > n || n<=0 || k<=0) {
            return empty;
        }
        
        List<List<Integer>>[][] result = new List[n+1][k+1];
        List<List<Integer>> one = new ArrayList<>();
        List<Integer> o = new ArrayList<>();
        o.add(1);
        one.add(o);
        result[1][1] = one; 
        
        for (int i=2; i<=k; i++) {
            result[1][i] = empty;
        }
        
        for (int j=1; j<=n; j++) {
            List<List<Integer>> onen = new ArrayList<>();
            for (int i=1; i<=j; i++) {
                List<Integer> on = new ArrayList<>();
                
                on.add(i);
                onen.add(on);
            }
            result[j][1] = onen;
        }
        
        for (int i=2; i<=n; i++) {
            for (int j=2; j<=k; j++) {
                if (j > i) {
                     result[i][j] = empty;
                    continue;
                }
                List<List<Integer>> no_n = result[i-1][j];
                List<List<Integer>> with_n = result[i-1][j-1];
                List<List<Integer>> rr = new ArrayList<>();
                for (List<Integer> ll : with_n) {
                    ll.add(i);
                    rr.add(ll);
                }
                
                for (List<Integer> kk : no_n) {
                    List<Integer> newList = new ArrayList<>(kk);
                    
                    rr.add(newList);
                }
                result[i][j] = rr;
            }
        }
        
        return result[n][k];
    }
}
