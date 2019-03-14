package answer10and11;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service("main10")
public class Main {
    @Autowired
    JdbcTemplate jdbcTemplate;

    User getUser() {
        String sql = "SELECT * FROM user WHERE username = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{"rishabh"}, new UserMapper());
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        Main main = context.getBean("main10",Main.class);
        User user =  main.getUser();
        System.out.println(user);

        //Using hql


    }


}
