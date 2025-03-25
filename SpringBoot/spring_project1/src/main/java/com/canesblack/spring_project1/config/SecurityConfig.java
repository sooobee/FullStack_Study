package com.canesblack.spring_project1.config;

import java.io.IOException;
import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.cors.CorsConfiguration;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		// 스프링 시큐리티 기능을 사용하고자 할 때 이 메소드 안에 작성
		
		//csrf 해킹 보호조치 코드 
		http.csrf(csrf -> csrf.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()))
		.cors(cors -> cors.configurationSource(corsCorsfigurationSource()))
		// cors 는 특정서버로만 데이터를 넘길 수 있도록 설정할 수 있음
		.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED))
		.authorizeHttpRequests(authz->authz.requestMatchers("/", "/loginPage","/logout", "/noticeCheckPage", "/register", "/menu/all")
		.permitAll()
		.requestMatchers(HttpMethod.POST,"/login").permitAll()
		.requestMatchers("/resource/**","/WEB-INF/**").permitAll()
		.requestMatchers("/noticeAdd","noticeModifyPage").hasAnyAuthority("ADMIN","MANAGER")
		.anyRequest().authenticated()
		)
		
		
		.formLogin(
				// 로그인 페이지로 이동할 때
				login->login.loginPage("/loginPage")
				// login으로 username, password 보낼 때
				.loginProcessingUrl("/login")
				// 실패했을 때
				.failureUrl("/loginPage?error=true")
				.usernameParameter("username")
				.passwordParameter("password")
				.successHandler(authenticationSuccessHandler())
				.permitAll()
				);
		
		return http.build();
	}
	
	@Bean
	public AuthenticationSuccessHandler authenticationSuccessHandler() {
		return new SimpleUrlAuthenticationSuccessHandler() {
			
			@Override
			public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
					Authentication authentication) throws IOException, ServletException {
				// 로그인 성공했을 때 세션, 권한 기능 추가 가능
				HttpSession session = request.getSession(); // 세션기능가져옴(로그아웃 할 때까지 로그인 상태 유지)
				boolean isManager = authentication.getAuthorities().stream()
						.anyMatch(grantedAuthoirity ->
						grantedAuthoirity.getAuthority().equals("ADMIN") ||
						grantedAuthoirity.getAuthority().equals("MANAGER"));
				
				// 운영진일 때 세션에 메니저추가
				if(isManager) {
					session.setAttribute("Manager", true);
				}
				
				session.setAttribute("username", authentication.getName());
				session.setAttribute("isAuthenticatied", true);
				response.sendRedirect(request.getContextPath()+"/");
				
				super.onAuthenticationSuccess(request, response, authentication);
				
			}
		};
		
	}
	
	@Bean
	public org.springframework.web.cors.CorsConfigurationSource corsCorsfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowedOrigins(Arrays.asList("http://localhost:8080", "http://localhost:8080"));
		configuration.setAllowedMethods(Arrays.asList("Get", "POST", "PUT", "DELETE"));
		configuration.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type"));
		org.springframework.web.cors.UrlBasedCorsConfigurationSource source = new org.springframework.web.cors.UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		
		return source;
	}
}
