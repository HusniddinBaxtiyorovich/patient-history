package com.example.historydiseases.config;

import com.example.historydiseases.core.entity.profileEntity.ProfileEntity;
import com.example.historydiseases.core.repository.profilerepository.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;


import java.util.Optional;

@RequiredArgsConstructor
@Component
public class CustomUserDetailService implements UserDetailsService {

    private ProfileRepository profileRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
//        System.out.println("Keldi: loadUserByUsername.");
        Optional<ProfileEntity> usersOptional = this.profileRepository.findByEmail(s);
        usersOptional.orElseThrow(() -> new UsernameNotFoundException("Username not found"));
        ProfileEntity profile = usersOptional.get();
        return new CustomUserDetails(profile);
    }
}
