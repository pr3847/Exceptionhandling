import java.lang.annotation.*;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Custom annotations @interface Annotation name

// 1st type Marker Annotation -no method values inside

@interface Myannotation{

}

// 2nd type Single valued annotation -one method value or we can set deafult to it

@interface SingleAnno{
    int value() default 0;
}

// 3rd type Multi value annotation -more than one method inside
@Documented//Marks the annotation for inclusion in the documentation
@Inherited// if the custom annotation consist then it will inhertied to sub class also
@Retention(RetentionPolicy.RUNTIME)// specify until what level the annotaion should be source, class(compile), runtime
@Target(ElementType.METHOD)//specify for what type we can use annota TYPE-class  ,Method-method
@interface MultiAnno{
    int value1() default 10;
    String value2() default "Hi";
}

class Animals{
    @MultiAnno(value1 = 25,value2 = "manu")
    public void eatSomething(){System.out.println("eating something");}
    @Deprecated // used if we change ar update the method
    void walk(){System.out.println("walking");}
}

class Dog extends Animals{
//    @Override // override the parent class method
    void eatsomething(){System.out.println("eating foods");}//should be eatSomething
}


public class Annotations {
    @SuppressWarnings("unchecked") //used to supress the warnings at compile time
    public static void main(String[] args) throws Exception {
        ArrayList list=new ArrayList();
        list.add("sonoo");
        list.add("vimal");
        list.add("ratan");
        for(Object obj:list){
            System.out.println(obj);
        }
        Animals a=new Animals();
        a.walk();
        Method m=a.getClass().getMethod("eatSomething");

        MultiAnno s=m.getAnnotation(MultiAnno.class);
        System.out.println(s.value1()+" "+s.value2());
    }
}
