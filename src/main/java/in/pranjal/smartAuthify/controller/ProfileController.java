package in.pranjal.smartAuthify.controller;

import in.pranjal.smartAuthify.io.ProfileRequest;
import in.pranjal.smartAuthify.io.ProfileResponse;
import in.pranjal.smartAuthify.service.ProfileService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.web.bind.annotation.*;

@RestController

@RequiredArgsConstructor
public class ProfileController {
    private final ProfileService profileService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public ProfileResponse register(@Valid @RequestBody ProfileRequest request){
        ProfileResponse response= profileService.createProfile(request);
        return  response;
    }
//    @GetMapping("/test")
//    public String test(){
//        return "Auth is working";
//    }
    @GetMapping("/profile")
    public ProfileResponse getProfile(@CurrentSecurityContext(expression = "authentication?.name") String email){
        return profileService.getProfile(email);
    }
}
