package cv.yyh.com.mycrollviewdemo;


import android.provider.Settings;
import android.util.Log;

import org.junit.Test;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * 值引用和对象引用的实现
 */
public class ExampleUnitTest {
    private final String TAG = "yuyahao";
    @Test
    public void addition_isCorrect() throws Exception {
        int i = 3;
        int j = 5;
        System.out.print("i = "+i+"\n");
        System.out.print("j = "+j+"\n");
        changedValue(3,5);
        System.out.print("再次输出看是否改变..."+"\n");
        System.out.print("i = "+i+"\n");
        System.out.print("j = "+j+"\n");
    }

    /**
     * 传值改变
     * @param i
     * @param j
     */
    private void changedValue(int i, int j) {
        System.out.print("传值进行交换..."+"\n");
        int temp = i;
        i =  j;
        j = temp;
        System.out.print("i = "+i+"\n");
        System.out.print("j = "+j+"\n");
    }
}