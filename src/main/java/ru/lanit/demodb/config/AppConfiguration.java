package ru.lanit.demodb.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(value={"ru.lanit.demodb"})
public class AppConfiguration {
	
	
}
