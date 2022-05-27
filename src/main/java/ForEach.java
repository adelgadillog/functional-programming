import java.util.*;
import java.lang.*;
public class ForEach {
    private static Long minTmp = Long.MAX_VALUE;
    private static Integer response = new Integer(0);
    public static void main(String args[]) {
        Integer x[]={1,2,3,1,2,1,10};
        Map<Integer,Long> count = new HashMap<Integer,Long>();
        List<Integer> lista = new ArrayList<Integer>();
        Collections.addAll(lista,x);


        lista.forEach((a)->{

            if(count.containsKey(a)){
                Long tmp = count.get(a);
                count.put(a,tmp++);
            }
            else {
                count.put(a,1L);
            }

        });
        count.forEach((a,b)->{
            if(b < minTmp) minTmp =  b; response = a;
        });

        System.out.println(response);
        System.out.println(lista.stream().min(Integer::compare).get());
    }
}