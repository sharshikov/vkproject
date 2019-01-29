package Help;

import org.openqa.selenium.WebElement;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Iterator;

public class Page {


    public WebElement getElementByTitle(String title) {
        Iterator var2;
        Field field;
        var2 = FieldUtilsExt.getDeclaredFieldsWithInheritance(this.getClass()).iterator();

        while (var2.hasNext()) {
            field = (Field) var2.next();
            if (isRequiredElement(field,title)){
                return (WebElement)getElementByField(this,field);
            }
        }
        return null;
    }

    public String getTitle() {
        return ((PageEntry) this.getClass().getAnnotation(PageEntry.class)).title();
    }

    public static <T> T getElementByField(Object parentObject, Field field){
        field.setAccessible(true);
        try{
            Object element = field.get(parentObject);
            return (T) element;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static boolean isRequiredElement(Field field, String title) {
        return getFieldTitle(field).equals(title);
    }

    private static String getFieldTitle(Field field) {
        Annotation[] var1 = field.getAnnotations();
        int var2 = var1.length;

        for (int var3 = 0; var3 < var2;++var3){
            Annotation a = var1[var3];
            if(a instanceof ElementTitle){
                return ((ElementTitle)a).value();
            }
        }
        return null;
    }
}
