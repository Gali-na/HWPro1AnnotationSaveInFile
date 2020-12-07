import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class SaveInFile {
    public static void write(Book book) {
        Class<?> c = Saver.class;Method[] methods = c.getMethods();
        for (Method m : methods) {
            if (m.isAnnotationPresent(AnnotationForMethod.class)) {
                try {
                    m.invoke(null,   recordingInformation(book), fileName(book));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static String fileName(Book book) {
        Class<?> clasBook = book.getClass();
        Field[] filds = clasBook.getDeclaredFields();
        String fileName = "";

        for (Field f : filds) {
            if (f.isAnnotationPresent(AnnotationForString.class)) {
                AnnotationForString annotationForString = f.getAnnotation(AnnotationForString.class);
                fileName = annotationForString.fileName();
            }

        }
        return fileName;
    }

    private static String recordingInformation(Book book) {
        Class<?> clasBook = book.getClass();
        Field[] filds = clasBook.getDeclaredFields();

        String textForWrite = "";
        for (Field f : filds) {
            if (f.isAnnotationPresent(AnnotationForString.class)) {
                AnnotationForString annotationForString = f.getAnnotation(AnnotationForString.class);
                f.setAccessible(true);
                try {
                    textForWrite = (String) f.get(book);

                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return textForWrite;
    }
}
