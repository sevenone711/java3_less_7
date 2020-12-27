package java3_less7;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;

public class StartTest {
    int countBf = 0; //счетчик BeforeSuite
    int countAf = 0; //счетчик AfterSuite
    Method before = null;
    Method after = null;
    public static void start(Class o) throws Exception {
        StartTest startTest = new StartTest();
        Method[] methods = o.getDeclaredMethods();
        ArrayList<Method> arrMethods = new ArrayList<>();
        for (Method m:methods) {
            if (m.isAnnotationPresent(Test.class)) arrMethods.add(m);
            if (m.isAnnotationPresent(BeforeSuite.class)) {
                startTest.countBf++;
                startTest.before = m;

            };
            if (m.isAnnotationPresent(AfterSuite.class)) {
                startTest.countAf++;
                startTest.after = m;
            };
            if(startTest.countBf > 1 || startTest.countAf > 1) throw new RuntimeException("Превышено количество BeforeSuite или  AfterSuite");
                    }
        arrMethods.sort(new Comparator<Method>() {  //сортируем
            @Override
            public int compare (Method o1, Method o2) {
               return o1.getAnnotation(Test.class).priority() - o2.getAnnotation(Test.class).priority(); // в данном случае больший приоретет у меньшего числа тоесть 1 самый высокий приоретет
            }
        });

        if (startTest.before != null) startTest.before.invoke(null);
        for(Method mt:arrMethods) mt.invoke(null);
        if (startTest.after != null) startTest.after.invoke(null);



    }
}
