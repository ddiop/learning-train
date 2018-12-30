package com.diop.learning.train.exposition;

import java.net.UnknownHostException;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.diop.learning.config.LearningProperties;
import com.diop.learning.web.rest.support.AbstractSpringBootLauncher;

@SpringBootApplication(scanBasePackages = "com.diop.learning",exclude = {MongoAutoConfiguration.class, MongoDataAutoConfiguration.class})
//@EnableRetry
@EnableConfigurationProperties(LearningProperties.class)
//@EnableDiscoveryClient
@EnableMongoRepositories(basePackages = "com.diop.interfaces")

public class LearningTrainExpositionApplication extends AbstractSpringBootLauncher {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(LearningTrainExpositionApplication.class);
	}

	public static void main(String[] args) throws UnknownHostException {
		AbstractSpringBootLauncher.launch(LearningTrainExpositionApplication.class, args);
	}

	@Bean
	public CorsFilter corsFilter() {
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		final CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		config.addAllowedOrigin("*");
		config.addAllowedHeader("*");
		config.addAllowedMethod("OPTIONS");
		config.addAllowedMethod("HEAD");
		config.addAllowedMethod("GET");
		config.addAllowedMethod("PUT");
		config.addAllowedMethod("POST");
		config.addAllowedMethod("DELETE");
		config.addAllowedMethod("PATCH");
		source.registerCorsConfiguration("/**", config);
		return new CorsFilter(source);
	}

}