package Tools;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FieldUtilsExt {
    public FieldUtilsExt(){}
    public static List<Field> getDeclaredFieldsWithInheritance(Class clazz){
        ArrayList fields = new ArrayList();
        fields.addAll(Arrays.asList(clazz.getDeclaredFields()));

        for(Class supp = clazz.getSuperclass();supp!=Object.class;supp = supp.getSuperclass()){
            fields.addAll(Arrays.asList(supp.getDeclaredFields()));
        }

        return fields;
    }
    public static List<Field> getDeclaredFieldsWithInheritance(Object object){
        return getDeclaredFieldsWithInheritance(object.getClass());
    }
}
