package in.pranjal.smartAuthify.service.implementation;

import in.pranjal.smartAuthify.entity.UserEntity;
import in.pranjal.smartAuthify.io.ProfileRequest;
import in.pranjal.smartAuthify.io.ProfileResponse;
import in.pranjal.smartAuthify.mapper.UserEntityMapper;
import in.pranjal.smartAuthify.repository.UserRepository;
import in.pranjal.smartAuthify.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {
    private final UserRepository userRepository;
    private final UserEntityMapper userEntityMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public ProfileResponse createProfile(ProfileRequest request) {
        UserEntity newProfile = userEntityMapper.convertToUserEntity(request);
        if(!userRepository.existsByEmail(newProfile.getEmail())){
            newProfile=userRepository.save(newProfile);

            return userEntityMapper.covertToProfileResponse(newProfile);
        }
     throw new ResponseStatusException(HttpStatus.CONFLICT,"Email already exists");
    }

    @Override
    public ProfileResponse getProfile(String email) {
        UserEntity existingUser = userRepository.findByEmail(email)
                .orElseThrow(()->new UsernameNotFoundException("User not found: "+email));
        return userEntityMapper.covertToProfileResponse(existingUser);
    }
}
