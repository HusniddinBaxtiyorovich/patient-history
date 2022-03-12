package com.example.historydiseases.core.security;


import com.example.historydiseases.core.dto.profile.ProfileDetailDTO;
import com.example.historydiseases.core.entity.Profile;
import com.example.historydiseases.core.exp.ItemNotFoundException;
import com.example.historydiseases.core.exp.ProfileNotFoundException;
import com.example.historydiseases.core.exp.ServerBadRequestException;
import com.example.historydiseases.core.repository.ProfileRepository;
import com.example.historydiseases.core.util.JwtTokenUtil;
import com.example.historydiseases.dto.AuthorizationDTO;
import com.example.historydiseases.dto.RegistrationDTO;
import com.example.historydiseases.feature_profile.ProfileRole;
import com.example.historydiseases.feature_profile.ProfileStatus;
import lombok.RequiredArgsConstructor;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.Locale;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AuthService {

    private ProfileRepository profileRepository;

    private MailSenderService mailSenderService;

    private ResourceBundleMessageSource messageSource;

    private JwtTokenUtil jwtTokenUtil;
    @Value("${server.url}")
    private String serverUrl;

    public ProfileDetailDTO auth(AuthorizationDTO dto, String lang) {
        String email = dto.getEmail(); // ali@mail.ru
        String pswd = DigestUtils.md5Hex(dto.getPassword()); // abcd123
        Optional<Profile> optional = this.profileRepository.findByEmailAndPassword(email, pswd);

        if (!optional.isPresent()) {
            throw new ProfileNotFoundException(messageSource.getMessage("email.paswd.incorrect", null, new Locale(lang)));
        }

        Profile profileEntity = optional.get();
        if (!profileEntity.getStatus().equals(ProfileStatus.ACTIVE)) {
            throw new ProfileNotFoundException(messageSource.getMessage("not.active", null, new Locale(lang)));
        }

        String jwt = jwtTokenUtil.generateAccessToken(profileEntity.getId(), profileEntity.getEmail());

        ProfileDetailDTO responseDTO = new ProfileDetailDTO();
        responseDTO.setToken(jwt);
        responseDTO.setName(profileEntity.getName());
        responseDTO.setSurname(profileEntity.getSurname());
        responseDTO.setContact(profileEntity.getContact());

        return responseDTO;
    }

    public String registration(RegistrationDTO dto) {
        Optional<Profile> optional = profileRepository.getByEmail(dto.getEmail());
        if (optional.isPresent()) {
            throw new ServerBadRequestException("Email already exists.");
        }

        Profile entity = new Profile();
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        entity.setEmail(dto.getEmail());
        entity.setContact(dto.getContact());
        entity.setRole(ProfileRole.ROLE_USER);
        entity.setStatus(ProfileStatus.INACTIVE);
        entity.setCreatedDate(LocalDateTime.now());
        entity.setPassword(DigestUtils.md5Hex(dto.getPassword()));

        this.profileRepository.save(entity);
        String jwt = jwtTokenUtil.generateAccessToken(entity.getId(), entity.getEmail());
        String link = serverUrl + "/auth/verification/" + jwt;
        try {
            mailSenderService.sendEmail(dto.getEmail(),
                    "TestKun uz verification",
                    "Salom shu linkni bosing." + link);
        } catch (Exception e) {
            this.profileRepository.delete(entity);
        }

        return "Sizning emailingizga verificatsiyadan o'tish linki yuborildi, link orqali verifikatsiyadan o'ting";
    }

    public String verification(String jwt) {
        Long profileId = Long.parseLong(jwtTokenUtil.getUserId(jwt));

        Optional<Profile> optional = this.profileRepository.findById(profileId);
        if (!optional.isPresent()) {
            throw new ItemNotFoundException("Wrong key");
        }
        Profile profileEntity = optional.get();
        if (!profileEntity.getStatus().equals(ProfileStatus.INACTIVE)) {
            throw new ServerBadRequestException("You are in wrong status");
        }

        profileEntity.setStatus(ProfileStatus.ACTIVE);
        this.profileRepository.save(profileEntity);
        return "Successfully verified";
    }
}
