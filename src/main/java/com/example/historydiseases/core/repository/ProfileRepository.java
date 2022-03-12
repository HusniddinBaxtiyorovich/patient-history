package com.example.historydiseases.core.repository;

import com.example.historydiseases.core.entity.Profile;
import com.example.historydiseases.feature_profile.ProfileStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface ProfileRepository extends JpaRepository<Profile, Long> {


    @Query(
            value = "SELECT * FROM profile p WHERE p.user_id = ?1",
            nativeQuery = true)
    List<Profile> findFirstByUserId(Long userId);

    @Query(
            value = "SELECT * from profile p where " +
                    "upper(p.firstname || p.lastname || p.patronymic) like %?1%",
            nativeQuery = true)
    List<Profile> findByName(String firstname);

    boolean existsByUserId(Long userId);



    Optional<Profile> getByEmail(String email);

    @Transactional
    @Modifying
    @Query("update Profile set status=:status  where id=:id")
    void updateStatus(@Param("status") ProfileStatus status, @Param("id") Long id);

    Optional<Profile> findByEmailAndPassword(String email, String password);

    Optional<Profile> findByEmail(String email);
;
}
