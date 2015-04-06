import java.util.*;
public class ListMethods
{
    public static ArrayList<Integer> deepClone(ArrayList<Integer> tList)
    {
        ArrayList<Integer> list = new ArrayList<Integer>(); 
        for (Integer i : tList)
        {
            list.add(new Integer(i));
        }
        return list;
    }

    public static ArrayList<Integer> makeList(int n)
    {
        ArrayList<Integer> tempList = null;
        if (n <= 0)  // The smallest list we can make
        {
            tempList = new ArrayList<Integer>(0);
        }
        else        // All other size lists are created here
        {            
            tempList = makeList(n-1);
            tempList.add(new Integer(n));     
        }
        return tempList;
    }

    public static ArrayList<Integer> reverseList(ArrayList<Integer> tList)
    {
        ArrayList<Integer> list = ListMethods.deepClone(tList); 
        if (list.size() <=1)
        {
            return list;
        }
        else
        {
            Integer firstElement = list.remove(0);            
            list = reverseList(list);
            list.add(firstElement);
        }
        return list;
    }
}
