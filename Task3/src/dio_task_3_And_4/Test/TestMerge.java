//local code review (vtegza): there are package issues all over project. Use domain names for packages - ex: com.dio.training @ 2/15/2015
//local code review (vtegza): add project files @ 2/15/2015
package dio_task_3_And_4.Test;

import dio_task_3_And_4.Main;
import dio_task_3_And_4.Pojo;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

//local code review (vtegza): if this class is test class : it should be in test package: add test package @ 2/15/2015
public class TestMerge {

    //local code review (vtegza): create test values for in test methods @ 2/15/2015
    final Pojo[] p1 = {new Pojo("Slava", 44), new Pojo("Olga", 32),new Pojo("Genk", 17)
            ,new Pojo("Kosta", 22), new Pojo("Igor", 14),new Pojo("Andrey", 18)};
    final Pojo [] p2 = {new Pojo("Silva", 28), new Pojo("Sasha", 39),
            new Pojo("Slava", 44),new Pojo("Andrey", 18)};
    final Pojo [] pEmpty = new Pojo[0];
    final Pojo [] pNull = new Pojo[4];
    Main m = new Main();

    @Test
    public void test_NormalValues() throws Exception {
        Pojo []result = {new Pojo("Andrey", 18), new Pojo("Genk", 17), new Pojo("Igor", 14),
                new Pojo("Kosta", 22), new Pojo("Olga", 32), new Pojo("Sasha", 39),
                new Pojo("Slava", 44), new Pojo("Silva", 28)};
        Pojo [] test = m.merge(p1, p2);
        Arrays.sort(test);
        Arrays.sort(result);

        assertArrayEquals(test, result);
    }

    @Test
    public void test_FirstMasEmpty() throws Exception {
        Pojo [] result = p1.clone();
        Pojo [] test = m.merge(pEmpty, p1);
        Arrays.sort(result);
        Arrays.sort(test);

        assertArrayEquals(test, result);
    }

    @Test
    public void test_SecoundtMasEmpty() throws Exception {
        Pojo [] result = p1.clone();
        Pojo [] test = m.merge(p1, pEmpty);
        Arrays.sort(result);
        Arrays.sort(test);

        assertArrayEquals(test, result);
    }

    @Test
    public void test_FirstMasNull() throws Exception {
        //local code review (vtegza): create new array instead of clone @ 2/15/2015
        Pojo [] result = p1.clone();
        Pojo [] test = m.merge(pNull, p1);
        Arrays.sort(result);
        Arrays.sort(test);

        assertArrayEquals(test, result);
    }

    @Test
    public void test_SecoundMasNull() throws Exception {
        Pojo [] result = p1.clone();
        Pojo [] test = m.merge(p1, pNull);
        Arrays.sort(result);
        Arrays.sort(test);

        assertArrayEquals(test, result);
    }

}