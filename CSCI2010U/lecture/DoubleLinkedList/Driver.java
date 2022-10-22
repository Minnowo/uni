import java.util.LinkedList;


public class Driver 
{

    public static int convert(LinkedList<Integer> list)
    {
        int result = list.getFirst();

        for(int i = 0; i < list.size(); i++)
        {
            result = result * 2 + list.get(i);
        }

        return result;
    }


    public static void main(String[] args) 
    {
        LinkedList_ ll = new LinkedList_();

        ll.insertElement(1);
        ll.insertElement(2);
        ll.insertElement(3);
        ll.insertElement(4);

        System.out.println(ll.toString());
        ll.removeAt(1);
        ll.removeAt(1);
        ll.removeAt(1);
        ll.removeAt(0);
        System.out.println(ll.toString());
        ll.insertElement(3);
        ll.insertElement(2);
        ll.removeAt(1);
        System.out.println(ll.toString());


        // LinkedList<Integer> list = new LinkedList();

        // list.add(1);
        // list.add(0);
        // list.add(1);
        // list.add(0);

        // System.out.println(list);

        // System.out.println(convert(list));
    }
}
