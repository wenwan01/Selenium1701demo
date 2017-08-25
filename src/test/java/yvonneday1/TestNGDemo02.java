package yvonneday1;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2017/6/4 0004.
 */
public class TestNGDemo02 {

    @Test
    public void assertEqualTest(){
        String a = "asdf";
        String b = "asdf";

        Assert.assertEquals(a,b,"a不等于b");
        System.out.println("=====");
        Assert.assertEquals(a,b);
    }
    @Test
    public  void assertNotEqualTest(){
        int a = 1;
        int b = 2;
        Assert.assertNotEquals(a,b);
    }
    @Test
    public void assertNullTest(){
        String a = null;
        Assert.assertNull(a);
    }
    @Test
    public void assertNotNullTest(){
        String a = "yvonne";
        Assert.assertNotNull(a);
    }
    @Test
    public void a(){
        Boolean a = true;
        Assert.assertTrue(a);
    }
}
