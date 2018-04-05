package com.lmig.ci.superhero.superherosightings.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.lmig.ci.superhero.superherosightings.domain.Org;

@Repository
public interface OrgRepository extends JpaRepository<Org, Integer>{

}
