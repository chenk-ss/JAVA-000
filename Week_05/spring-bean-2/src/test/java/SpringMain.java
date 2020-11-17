import com.chenk.springbean2.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @Author chenk
 * @create 2020/11/17 14:41
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:spring.xml"})
public class SpringMain {
    @Resource
    private UserService userService;
    @Test
    public void test() {
        String name = "xxx";
        String res = userService.get(name);
        System.out.println(res);
    }

}