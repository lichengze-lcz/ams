package cn.lczze.ams;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import sun.security.util.Password;

@SpringBootTest
class AmsApplicationTests {

    @Test
    void contextLoads() {
        PasswordEncoder pe =  new BCryptPasswordEncoder();
        String password = pe.encode("123456");
        System.out.println(password);

    }

}
