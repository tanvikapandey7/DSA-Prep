import java.util.Arrays;

public class Boats {
    public int boat(int[] pep, int limit) {
        Arrays.sort(pep);
        int i = 0 ,j = pep.length -1 , boat = 0;
        while(i <= j) {
            if(pep[i]+pep[j] <= limit) {
  i++;
        
            }
              
        j--;
        boat++;
}
        return boat;
    }
}
public static void main (String[] args) {
    int[] pep = {3,2,3,2,2};
    int limit = 4;
    System.out.println(new Boats().boat(pep, limit));
}
