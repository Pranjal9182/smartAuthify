package in.pranjal.smartAuthify.mapper;

import in.pranjal.smartAuthify.entity.UserEntity;
import in.pranjal.smartAuthify.io.ProfileRequest;
import in.pranjal.smartAuthify.io.ProfileResponse;
import lombok.Builder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.UUID;
@Component
@Builder
public class UserEntityMapper {
    private final PasswordEncoder passwordEncoder;
 public UserEntity convertToUserEntity(ProfileRequest request){

    return UserEntity.builder()
            .email(request.getEmail())
            .userId(UUID.randomUUID().toString())
            .name(request.getName())

            .password(passwordEncoder.encode(request.getPassword()))
            .isAccountVerified(false)
            .resetOtpExpiredAt(0L)
            .verifyOtp(null)
            .verifyOtpExpiredAt(0l)
            .resetOtp(null)
            .build();
}

public ProfileResponse covertToProfileResponse(UserEntity userEntity){
     return ProfileResponse.builder()
             .name(userEntity.getName())
             .email(userEntity.getEmail())
             .userId(userEntity.getUserId())
             .isAccountVerified(userEntity.getIsAccountVerified())
             .build();
}
}
