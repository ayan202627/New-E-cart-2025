package com.jwt.auth_service;

import com.jwt.auth_service.jwtfilter.JwtFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
public class AuthServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthServiceApplication.class, args);
	}

//	@Bean
//	public RestTemplate getRestTemplate(RestTemplateBuilder rtb){
//		return rtb.build();
//	}

//	@Bean
//	public FilterRegistrationBean filterBean(){
//		FilterRegistrationBean frb = new FilterRegistrationBean();
//		frb.setFilter(new JwtFilter());
//		frb.addUrlPatterns("/product-app/addProduct","/product-app/deleteProduct","/product-app/updateProduct");
//		return frb;
//	}

	@Bean
	public FilterRegistrationBean<CorsFilter> corsFilterRegistrationBean() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();
		// ⚠️ WARNING: Using "*" for allowed origins, methods, and headers
		// is INSECURE for production environments. Use specific values!
		config.addAllowedOrigin("*");
		config.addAllowedMethod("*");
		config.addAllowedHeader("*");
		source.registerCorsConfiguration("/**", config);
		FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<>(new CorsFilter(source));
		bean.setOrder(Ordered.HIGHEST_PRECEDENCE); // Ensure this CORS filter runs first
		return bean;
	}

}
