package answer5to9;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class Count {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        String sql = "SELECT COUNT(*) FROM user";
        //answer 5
        Count count = context.getBean("count", Count.class);
        System.out.println(count.jdbcTemplate.queryForObject(sql, Integer.class));

        //Answer 6
        String sql1 = "SELECT NAME FROM user WHERE username = ?";
        System.out.println(count.jdbcTemplate.queryForObject(sql1, new Object[]{"rishabh"}, String.class));

        //Answer 7
        String sql2 = "INSERT INTO user (username,password,name,age,dob)VALUES(?,?,?,?,?)";
        count.jdbcTemplate.update(sql2, new Object[]{
                "rishabh42", "password", "RISHABH", 23, new Date()
        });

        //Answer8
        String sql3 = "SELECT * FROM user WHERE username = ?";
        System.out.println(count.jdbcTemplate.queryForMap(sql3,new Object[]{"rishabh"}));

        //Answer 9
        String sql4 = "SELECT * FROM user";
        System.out.println(count.jdbcTemplate.queryForList(sql4));
    }
}
