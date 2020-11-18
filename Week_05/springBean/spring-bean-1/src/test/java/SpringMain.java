import com.chenk.springbean2.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author chenk
 * @create 2020/11/17 14:41
 */
public class SpringMain {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring.xml");
        UserService userService = context.getBean(UserService.class);
        String hello = userService.get("xxx");
        System.out.println(hello);
    }
}