package com.WalletManagement.WalletApi.security;

import com.WalletManagement.WalletApi.service.MyUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

@EnableWebSecurity
public class SecurityConfigurer extends WebSecurityConfigureAdapter{
    @Autowired
    private MyUserDetailService myUserDetailService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.UserDetailsService(myUserDetailService);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}
