package com.lmig.ci.superhero.superherosightings.service;

import com.lmig.ci.superhero.superherosightings.domain.Org;
import com.lmig.ci.superhero.superherosightings.domain.Power;


import java.util.List;

public interface DatabaseService {

    Power addPower(Power power);
    Power getPower(int powerId);
    List<Power> listAllPowers();
    Power updatePower(Power power);
    void deletePower(int powerId);

    Org addOrg(Org org);
    Org getOrg(int orgId);
    List<Org> listAllOrgs();
    Org updateOrg(Org org);
    void deleteOrg(int orgId);

}
