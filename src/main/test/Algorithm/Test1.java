package Algorithm;

import com.avengers.bruce.Algorithm.basic.DataStructure.List.code.ListNode;
import com.avengers.bruce.Algorithm.util.Power;
import com.avengers.bruce.Algorithm.util.Swap;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class Test1 {

    @Test
    public void testPower() throws Exception {

        int result = Power.power(2,10);

        System.out.println();
    }

    @Test
    public void testSqrt() throws Exception {

        int result = Power.sqrt(10);

        System.out.println();
    }

    @Test
    public void testSwap() throws Exception {

        ListNode A = new ListNode('A');
        ListNode B = new ListNode('B');
        System.out.println(A.toString());
        System.out.println(B.toString());

//        ListNode tmp = A;
//        A = B;
//        B = tmp;

        Swap.run(A,B);

        int a = 1;
        int b = 2;

        Swap.run(a,b);

        System.out.println();
    }


}
