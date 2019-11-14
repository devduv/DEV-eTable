package etable;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class AppConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
	}

    @Bean("jdbcTemplate")
    JdbcTemplate JdbcTemplate(DataSource centralDataSource) {
        return new JdbcTemplate(centralDataSource);
    }
    

}
