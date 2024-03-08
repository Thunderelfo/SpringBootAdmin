import de.codecentric.boot.admin.server.config.AdminServerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration(proxyBeanMethods = false)
@EnableWebFluxSecurity
public class SecurityConfiguration {
    @Bean
    SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http,
                                                     AdminServerProperties adminServer) {
        http.authorizeExchange(spec -> spec.
                        pathMatchers(adminServer.path("/assets/**")).permitAll().
                        pathMatchers("/actuator/health/**").permitAll().
                        pathMatchers(adminServer.path("/login")).permitAll().
                        anyExchange().authenticated()).
                formLogin(formLogin -> formLogin.loginPage(adminServer.path("/login"))).
                logout(logout -> logout.logoutUrl(adminServer.path("/logout"))).
                httpBasic(Customizer.withDefaults()).
                csrf(ServerHttpSecurity.CsrfSpec::disable);
        return http.build();
    }
}