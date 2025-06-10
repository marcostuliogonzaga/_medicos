package com.medicos.api.domain.infra;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Classe de configuração de segurança.
 * Define dois usuários em memória para autenticação básica via Spring Security.
 */
@Configuration
@EnableWebSecurity
public class ConfiguracoesSeguranca {

  // Bean responsável por configurar os filtros de segurança do Spring Security
  @Bean
  public SecurityFilterChain filtrosSeguranca(HttpSecurity http) throws Exception {

    return http
        // Define regras de autorização para requisições HTTP
        .authorizeHttpRequests(req -> {
          // Libera o acesso público a recursos estáticos como CSS, JS e imagens
          req.requestMatchers("/css/**", "/js/**", "/assets/**", "/").permitAll();

          // Qualquer outra requisição exige autenticação (login)
          req.anyRequest().authenticated();
        })

        // Configuração da autenticação via formulário (form login)
        .formLogin(form -> form
            // Define a URL da página de login personalizada
            .loginPage("/login")

            // Define a URL de redirecionamento após login bem-sucedido
            .defaultSuccessUrl("/", true)

            // Libera acesso à página de login para todos (mesmo não autenticados)
            .permitAll())

        // Configuração do logout
        .logout(logout -> logout
            // Redireciona para a página de login com parâmetro de logout após sair
            .logoutSuccessUrl("/login?logout")

            // Permite que qualquer um acesse a URL de logout
            .permitAll())

        // Constrói e retorna o objeto SecurityFilterChain
        .rememberMe(rememberMe -> rememberMe.key("chave-segura")
            .alwaysRemember(true))
        .csrf(Customizer.withDefaults())
        .build();
  }
}

// Bean responsável por configurar os filtros de segurança do Spring Security
// @Bean public SecurityFilterChain filtrosSeguranca(HttpSecurity http)throws
// Exception{

// return http
// // Define regras de autorização para requisições HTTP
// .authorizeHttpRequests(req->{
// // Libera o acesso público a recursos estáticos como CSS, JS e imagens
// req.requestMatchers("/css/**","/js/**","/assets/**").permitAll();

// // Qualquer outra requisição exige autenticação (login)
// req.anyRequest().authenticated();})

// // Configuração da autenticação via formulário (form login)
// .formLogin(form->form
// // Define a URL da página de login personalizada
// .loginPage("/login")

// // Define a URL de redirecionamento após login bem-sucedido
// .defaultSuccessUrl("/")

// // Libera acesso à página de login para todos (mesmo não autenticados)
// .permitAll())

// // Configuração do logout
// .logout(logout->logout
// // Redireciona para a página de login com parâmetro de logout após sair
// .logoutSuccessUrl("/login?logout")

// // Permite que qualquer um acesse a URL de logout
// .permitAll())

// // Constrói e retorna o objeto SecurityFilterChain
// .build();}
