import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        Book book = new Book("Александр","Пушкин","2020","Евгений Онегин");
        Class<?> clasBook = book.getClass();
        Field[] filds = clasBook.getDeclaredFields();
        String fileName="";
        String textForWrite="";
        for (Field f : filds) {
            if (f.isAnnotationPresent(AnnotationForString.class)) {
                  AnnotationForString annotationForString=f.getAnnotation(AnnotationForString.class);
                fileName = annotationForString.fileName();
               f.setAccessible(true);
                try {
                    textForWrite=(String)f.get(book);

                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

            }
        }
     Class<?> c= Saver.class;
       Method [] methods= c.getMethods();
       for(Method m: methods) {
         if(m.isAnnotationPresent(AnnotationForMethod.class)) {
             try {
                 m.invoke(null,textForWrite,fileName);
             } catch (IllegalAccessException e) {
                 e.printStackTrace();
             } catch (InvocationTargetException e) {
                 e.printStackTrace();
             }
         }

       }


    }
}
