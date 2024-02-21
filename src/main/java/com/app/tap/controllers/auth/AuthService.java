package com.app.tap.controllers.auth;

import com.app.tap.entitites.Uuser;
import com.app.tap.enums.Role;
import com.app.tap.repository.UuserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    @Autowired
    private final UuserRepository _userRepository;
    @Autowired
    private final JwtService _jwtService;
    @Autowired
    private final PasswordEncoder _passwordEncoder;
    @Autowired
    private final AuthenticationManager authManager;



    public AuthResponse login(LoginRequest request){
        authManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUserName(),request.getPssword()));

        UserDetails user =_userRepository.findByUserName(request.getUserName()).orElseThrow();

        String token = _jwtService.getToken(user);

        return  AuthResponse.builder().token(token).build();
    }





    public AuthResponse register(RegisterRequest request){

        Uuser uuser = new Uuser();

        uuser.setEmail(request.getEmail());
        uuser.setPssword(_passwordEncoder.encode(request.getPssword()));
        uuser.setUuserName(request.getUserName());
        uuser.setFirstName(request.getFirstName());
        uuser.setLastName(request.getLastName());
        uuser.setUserRole(Role.USER);

        _userRepository.save(uuser);

        return AuthResponse.builder()
                .token(_jwtService.getToken(uuser))
                .build();
    }

}
