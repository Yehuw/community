package life.yehuw.wochat;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//@MapperScan(basePackages = "life.yehuw.wochat.mapper")
@SpringBootApplication
public class WochatApplication {

    public static void main(String[] args) {
        SpringApplication.run(WochatApplication.class, args);
    }

}
