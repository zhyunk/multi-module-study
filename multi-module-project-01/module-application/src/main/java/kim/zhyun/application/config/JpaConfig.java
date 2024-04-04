package kim.zhyun.application.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "kim.zhyun.library.repository")
@EntityScan(basePackages = "kim.zhyun.library.entity")
@Configuration
public class JpaConfig { }
