package Tools;

import com.google.common.collect.UnmodifiableIterator;
import com.google.common.reflect.ClassPath;
import interfaces.PageEntry;
import org.apache.commons.lang3.reflect.FieldUtils;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.HashSet;
import java.util.Iterator;

public class PageWrapper {
    private String currentPageTitle;
    private Page currentPage;
    public Page getPage(String title, String packageName) {
        return bootstrapPage(getPageClass(packageName, title));
    }

    public Page getCurrentPage(){
        return this.currentPage;
    }

    private Class<?> getPageClass(String packagName, String title) {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        HashSet allClasses = new HashSet();

        try {
            UnmodifiableIterator ex = ClassPath.from(loader).getAllClasses().iterator();

            while (ex.hasNext()) {
                ClassPath.ClassInfo page = (ClassPath.ClassInfo) ex.next();
                if (page.getName().startsWith(packagName + ".")) {
                    allClasses.add(page.load());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Iterator ex1 = allClasses.iterator();

        String pageTitle;
        Class page1;
        do {
            if (!ex1.hasNext()) {
                return null;
            }

            page1 = (Class) ex1.next();
            pageTitle = null;
            if (null != page1.getAnnotation(PageEntry.class)) {
                pageTitle = ((PageEntry) page1.getAnnotation(PageEntry.class)).title();
            } else {
                try {
                    pageTitle = (String) FieldUtils.readStaticField(page1, "title", true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } while (pageTitle == null || !pageTitle.equals(title));
        return page1;
    }



    private Page bootstrapPage(Class<?> page) {
        if (page != null) {
            try {
                Constructor e = page.getConstructor(new Class[0]);
                e.setAccessible(true);
                this.currentPage = (Page) e.newInstance(new Object[0]);
                this.currentPageTitle = this.currentPage.getTitle();
                return this.currentPage;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
