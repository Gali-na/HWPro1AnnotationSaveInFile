import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        Book book = new Book("Александр","Пушкин","2020","Евгений Онегин");
        SaveInFile.write(book);
    }
}
