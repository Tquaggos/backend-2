package com.biolab.musicsystem.repositories;

import com.biolab.musicsystem.entities.Musica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicaRepository extends JpaRepository<Musica, Long> {
    Musica findByNome(String nome);
}
