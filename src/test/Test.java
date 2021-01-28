package test;

import com.liujianwen.annotation.CustomAutoware;
import com.liujianwen.bean.User;
import com.liujianwen.controller.UserController;
import com.liujianwen.service.IUserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;

public class Test {
    public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException, InstantiationException, NoSuchMethodException, InvocationTargetException {
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//        User user = (User) applicationContext.getBean("User");
//        System.out.println("user = " + user);
        UserController userController = new UserController();
        Class<? extends UserController> clazz = userController.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            CustomAutoware annotation = field.getAnnotation(CustomAutoware.class);
            if(annotation!=null){
                Class<?> bean = field.getType();
                Constructor<?> constructor = bean.getConstructor();
                Object instance = constructor.newInstance();
                field.set(bean,clazz.getDeclaredField(field.getName()));
            }
        }
        userController.test();
    }
}
