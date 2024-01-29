package com.example.solidbank2.conrtollers;

import com.example.solidbank2.domain.AuthenticationRequest;
import com.example.solidbank2.domain.AuthenticationResponse;
import com.example.solidbank2.domain.RegisterRequest;
import com.example.solidbank2.service.AuthenticationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "AuthenticationController")
@RestController
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    @Operation(summary = "Register")
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse>register(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(authenticationService.register(request));
    }
    @Operation(summary = "Authenticate")
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse>register(@RequestBody AuthenticationRequest request ){
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }


}
