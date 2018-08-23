//package cn.liuyiyou.springboot.admin.config;
//
//import de.codecentric.boot.admin.server.config.AdminServerProperties;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
//import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
//
///***
// *
// * @see <a href="http://codecentric.github.io/spring-boot-admin/2.0.2/#_securing_spring_boot_admin_server"></a>
// * @author: liuyiyou.cn
// * @date: 2018/8/20
// * @Copyright 2018 liuyiyou.cn Inc. All rights reserved
// */
//@Configuration
//public class SecuritySecureConfig extends WebSecurityConfigurerAdapter {
//
//    private final String adminContextPath;
//
//    public SecuritySecureConfig(AdminServerProperties adminServerProperties) {
//        this.adminContextPath = adminServerProperties.getContextPath();
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        // @formatter:off
//        SavedRequestAwareAuthenticationSuccessHandler successHandler = new SavedRequestAwareAuthenticationSuccessHandler();
//        successHandler.setTargetUrlParameter("redirectTo");
//        successHandler.setDefaultTargetUrl(adminContextPath + "/");
//
//        http.authorizeRequests()
//                //	Grants public access to all static assets and the login page.
//                .antMatchers(adminContextPath + "/assets/**").permitAll()
//                .antMatchers(adminContextPath + "/login").permitAll()
//                //Every other request must be authenticated.
//                .anyRequest().authenticated()
//                .and()
//                //	Configures login and logout.
//                .formLogin().loginPage(adminContextPath + "/login").successHandler(successHandler).and()
//                .logout().logoutUrl(adminContextPath + "/logout").and()
//                .httpBasic().and()
//                .csrf()
//                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
//                .ignoringAntMatchers(
//                        "/instances",
//                        "/actuator/**"
//                );
//        // @formatter:on
//    }
//}
