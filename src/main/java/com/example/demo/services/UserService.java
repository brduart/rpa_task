package com.example.demo.services;

import com.example.demo.config.UserDetailsImpl;
import com.example.demo.config.jwt.JwtTokenService;
import com.example.demo.config.security.SecurityConfiguration;
import com.example.demo.dto.CreateUserDTO;
import com.example.demo.dto.LoginUserDTO;
import com.example.demo.dto.RecoveryJwtTokenDTO;
import com.example.demo.entities.Role;
import com.example.demo.entities.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenService jwtTokenService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SecurityConfiguration securityConfiguration;

    // Metodo responsável por autenticar um usuário e retornar um token JWT
    public RecoveryJwtTokenDTO authenticateUser(LoginUserDTO loginUserDto) {
        // Cria um objeto de autenticação com o email e a senha do usuário
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(loginUserDto.getName(), loginUserDto.getPassword());

        // Autentica o usuário com as credenciais fornecidas
        Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        // Obtém o objeto UserDetails do usuário autenticado
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        // Gera um token JWT para o usuário autenticado
        return new RecoveryJwtTokenDTO(jwtTokenService.generateToken(userDetails));
    }

    // Metodo responsável por criar um usuário
    public void createUser(CreateUserDTO createUserDto) {

        List<Role> roles = List.of(new Role(createUserDto.getRole()));


        User newUser = new User(
                createUserDto.getName(),
                securityConfiguration.passwordEncoder().encode(createUserDto.getPassword()),
                roles
        );



         userRepository.save(newUser);
    }
}