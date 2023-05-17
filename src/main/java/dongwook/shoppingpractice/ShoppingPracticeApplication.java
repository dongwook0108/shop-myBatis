package dongwook.shoppingpractice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Slf4j
@SpringBootApplication
public class ShoppingPracticeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShoppingPracticeApplication.class, args);
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = "123qwe";
        String encodedPassword = passwordEncoder.encode(password);
        System.out.println("encodedPassword = " + encodedPassword);

    }

}
