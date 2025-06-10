package com.medicos.api.domain.model.usuario;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

// Classe reponsável por chamar o método da interface que irá buscar o usuário no banco de dados.
// Precisamos explicitar para o Spring Security que ele irá precisar o método da interface para validar o usuário no banco de dados.
public class UsuarioService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    // Construtor da classe com o usuárioRepository realizando a injeção de
    // dependência
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    // Método que vamos ter a logica para buscar o usuário no banco de dados
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return usuarioRepository.findByEmailIgnoreCase(username)
                .orElseThrow(UsernameNotFoundException);
    }

}
