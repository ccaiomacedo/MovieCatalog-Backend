package com.caiodev.moviecatalog.repositories;

import com.caiodev.moviecatalog.entities.Trailer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrailerRepository extends JpaRepository<Trailer, Long> {
}
