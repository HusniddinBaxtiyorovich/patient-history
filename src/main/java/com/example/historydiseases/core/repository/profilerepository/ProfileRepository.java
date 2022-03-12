package com.example.historydiseases.core.repository.profilerepository;

import com.example.historydiseases.core.entity.profileEntity.ProfileEntity;
import com.example.historydiseases.core.entity.profileEntity.util.ProfileStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface ProfileRepository extends JpaRepository<ProfileEntity, Long> {


    @Query(
            value = "SELECT * FROM profile p WHERE p.user_id = ?1",
            nativeQuery = true)
    List<ProfileEntity> findFirstByUserId(Long userId);

    @Query(
            value = "SELECT * from profile p where " +
                    "upper(p.firstname || p.lastname || p.patronymic) like %?1%",
            nativeQuery = true)
    List<ProfileEntity> findByName(String firstname);

    boolean existsByUserId(Long userId);



    Optional<ProfileEntity> getByEmail(String email);

    @Transactional
    @Modifying
    @Query("update ProfileEntity set status=:status  where id=:id")
    void updateStatus(@Param("status") ProfileStatus status, @Param("id") Long id);

    Optional<ProfileEntity> findByEmailAndPassword(String email, String password);

    Optional<ProfileEntity> findByEmail(String email);
;
}
