
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.Test;
import java.util.*;
import java.util.PriorityQueue;
import static org.junit.Assert.assertEquals;

@RunWith(value= Parameterized.class)
public class PriorityQueueTest {


    private  Integer [] InputList ;
    private  Integer [] ExceptedList;
    //private  int element_num;

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Integer[][][]{
                {{5,4,3,1,7}, {1,3,4,5,7}},
                {{17,1,1011,101,11}, {1,11,17,101,1011}},
                {{9,1,1577,99999,12345}, {1,9,1577,12345,99999}},
                {{-5,-9,-11,-200,200}, {-200,-11,-9,-5,200}},
                {{0,-194,33,-1,17}, {-194,-1,0,17,33}},
        });
    }

    public PriorityQueueTest(Integer[] inputList, Integer[] exceptedList) {
        this.InputList = inputList;
        this.ExceptedList= exceptedList;
    }



    @Test
    public void add() {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for (int i=0;i<InputList.length;i++){
            pq.add(InputList[i]);
        }
        for (int i=0;i<InputList.length;i++) {
            assertEquals(ExceptedList[i], pq.poll());
        }
        System.out.println("add");
    }

    @Test
    public void clear() {
        PriorityQueue<Integer> pq=new PriorityQueue<>();

        for (int i=0;i<InputList.length;i++){
            pq.add(InputList[i]);
        }

        pq.clear();
        assertEquals(0, pq.size());

        System.out.println("clear");
    }

    @Test
    public void contains() {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for (int i=0;i<InputList.length;i++){
            pq.add(InputList[i]);
        }
        for (int i=0;i<InputList.length;i++) {
            assertEquals(true, pq.contains(ExceptedList[i]));
        }

        System.out.println("contains");
    }

    @Test
    public void offer() {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for (int i=0;i<InputList.length;i++){
            pq.offer(InputList[i]);
        }
        for (int i=0;i<InputList.length;i++) {
            assertEquals(ExceptedList[i], pq.poll());
        }

        System.out.println("offer");

    }

    @Test
    public void peek() {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for (int i=0;i<InputList.length;i++){
            pq.add(InputList[i]);
        }

        assertEquals(ExceptedList[0], pq.peek());

        System.out.println("peek");
    }

    @Test
    public void poll() {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for (int i=0;i<InputList.length;i++){
            pq.add(InputList[i]);
        }
        for (int i=0;i<InputList.length;i++) {
            assertEquals(ExceptedList[i], pq.poll());
        }
    }

    @Test
    public void remove() {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for (int i=0;i<InputList.length;i++){
            pq.add(InputList[i]);
        }
        for (int i=0;i<InputList.length;i++) {
            assertEquals(true, pq.remove(ExceptedList[i]));
        }
    }

    @Test
    public void size() {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for (Integer element:InputList){
            pq.add(element);
        }
        assertEquals(InputList.length,pq.size());
    }

    @Test(expected =NullPointerException.class)
    public void offerException(){
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        pq.offer(null);
    }
    @Test(expected =IllegalArgumentException.class)
    public void CapacityException(){
        PriorityQueue<Integer> pq=new PriorityQueue<>(0);
    }

    @Test (expected =NullPointerException.class)
    public void InitException(){
       List<Integer> arrlist= new ArrayList<Integer>();
       arrlist.add(null);
       PriorityQueue<Integer> pq=new PriorityQueue<>(arrlist);
    }
}
