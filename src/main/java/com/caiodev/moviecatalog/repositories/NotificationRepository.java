package com.caiodev.moviecatalog.repositories;

import com.caiodev.moviecatalog.entities.Notification;
import com.caiodev.moviecatalog.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {

    @Query("SELECT obj FROM Notification obj WHERE "
            + "(obj.profile.user = :user)"
            + "ORDER BY obj.moment DESC")
    Page<Notification> find(User user, Pageable pageable);

}
