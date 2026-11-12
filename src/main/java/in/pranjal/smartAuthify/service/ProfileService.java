package in.pranjal.smartAuthify.service;

import in.pranjal.smartAuthify.io.ProfileRequest;
import in.pranjal.smartAuthify.io.ProfileResponse;

public interface ProfileService {
    ProfileResponse createProfile(ProfileRequest request);
    ProfileResponse getProfile (String email);
}
