package com.douhu.douhudemojdbcstarter.prop;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Properties;

/**
  * 功能描述: 
  * @Author: 窦虎
  * @Date: 2020/11/22$ 21:50$
  */
@ConfigurationProperties(prefix = "douhu.jdbc")
@Data
public final class SpringBootPropertiesConfiguration {

    private String driverClass;
    private String url;
    private String username;
    private String password;
}
