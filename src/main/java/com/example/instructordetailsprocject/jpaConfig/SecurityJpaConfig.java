package com.example.instructordetailsprocject.jpaConfig;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpMethod;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
public class SecurityJpaConfig {
    @Bean(name="orderProperties")
    @ConfigurationProperties("spring.datasource.order")
    public DataSourceProperties dataSourceProperties() {

        return new DataSourceProperties();
    }

    @Bean(name="orderDatasource")
    @ConfigurationProperties(prefix = "spring.datasource.order")
    public DataSource datasource(@Qualifier("orderProperties") DataSourceProperties properties){

        return properties.initializeDataSourceBuilder().build();
    }

    @Bean
    public UserDetailsManager userDetailsManager(@Qualifier("orderDatasource")DataSource dataSource) {

        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        return jdbcUserDetailsManager;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity)throws Exception{

        httpSecurity.authorizeHttpRequests(configurer ->
                        configurer
                                .requestMatchers(HttpMethod.GET,"/api").hasRole("EMPLOYEE")
                                .requestMatchers(HttpMethod.GET,"/api/data/**").hasRole("MANAGER")
                                .requestMatchers(HttpMethod.GET,"/api/systems/**").hasRole("ADMIN")
                                .anyRequest().authenticated()
                );

        // use HTTP Basic authentication
        httpSecurity.httpBasic(Customizer.withDefaults());

        // disable Cross Site Request Forgery (CSRF)
        // in general, not required for stateless REST APIs that use POST, PUT, DELETE and/or PATCH
        httpSecurity.csrf(csrf -> csrf.disable());

        return httpSecurity.build();
    }

}
