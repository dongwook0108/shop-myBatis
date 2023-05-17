package dongwook.shoppingpractice.common.security;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final AuthenticationFailureHandler customAuthenticationFailureHandler;


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers("/", "/login", "/login**", "/member/sign-up", "/products/**",
                        "/api/**", "/h2-console/**")
                .permitAll()
                .antMatchers("/admin/**").hasAnyAuthority("ADMIN")
                .anyRequest().authenticated()
                .and()
                .headers(headers -> headers.frameOptions().sameOrigin())
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/")
                .failureHandler(customAuthenticationFailureHandler)
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/");
        return http.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return web -> {
            web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());
//            web.ignoring().antMatchers(HttpMethod.OPTIONS);
            web.ignoring().antMatchers("/fonts/**", "/error");
        };
    }
}
