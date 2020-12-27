package java3_less7;

public class MyTests {
    @BeforeSuite
    public static void bedoreSuite(){
        System.out.println("BeforeSuite");
    }
    @AfterSuite
    public static void afterSuite(){
        System.out.println("afterSuite");
    }
    @Test(priority = 7)
    public static void test1(){
        System.out.println("test1");
    }
    @Test(priority = 3)
    public static void test2(){
        System.out.println("test2");
    }
    @Test(priority = 1)
    public static void test3(){
        System.out.println("test3");
    }
    @Test(priority = 2)
    public static void test4(){
        System.out.println("test4");
    }
    @Test(priority = 3)
    public static void test5(){
        System.out.println("test5");
    }
//    @AfterSuite
//    public static void afterSuite2(){
//        System.out.println("AfterSuite2");
//    }
//@BeforeSuite
//public static void bedoreSuite2(){
//    System.out.println("BeforeSuite2);
//}

}
