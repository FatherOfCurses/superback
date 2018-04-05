package com.lmig.ci.superhero.superherosightings.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.lmig.ci.superhero.superherosightings.domain.Power;

import java.util.List;

@Repository
public interface PowerRepository extends JpaRepository<Power, Integer>{


}
