package com.douhu.douhudemojdbcstarter;

import com.douhu.douhudemojdbcstarter.prop.SpringBootPropertiesConfiguration;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(SpringBootPropertiesConfiguration.class)
@ConditionalOnProperty(prefix = "douhu.jdbc", name = "enable", havingValue = "true", matchIfMissing = true)
@RequiredArgsConstructor
public class DouhuDemoJdbcStarterApplication {

	@Autowired
	private SpringBootPropertiesConfiguration props;

	public static void main(String[] args) {
		SpringApplication.run(DouhuDemoJdbcStarterApplication.class, args);
	}

	@Bean
	public SpringBootPropertiesConfiguration getDouhuJdbcConfig()
	{
		System.out.println("props:::" + props != null ? props.toString() : "is null");
		return props;
	}

}
