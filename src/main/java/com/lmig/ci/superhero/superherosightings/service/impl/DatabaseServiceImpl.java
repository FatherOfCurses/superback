package com.lmig.ci.superhero.superherosightings.service.impl;

import com.lmig.ci.superhero.superherosightings.domain.Org;
import com.lmig.ci.superhero.superherosightings.domain.Power;
import com.lmig.ci.superhero.superherosightings.repository.PowerRepository;
import com.lmig.ci.superhero.superherosightings.repository.OrgRepository;
import com.lmig.ci.superhero.superherosightings.service.DatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DatabaseServiceImpl implements DatabaseService{

    @Autowired
    PowerRepository powerRepository;
    OrgRepository orgRepository;

    @Override
    public Power addPower(Power power) { return powerRepository.save(power); }

    @Override
    public Power getPower(int powerId) {
        return powerRepository.findOne(powerId);
    }

    @Override
    public List<Power> listAllPowers(){
        return powerRepository.findAll();
    }

    @Override
    public Power updatePower(Power power) {
        return powerRepository.save(power);
    }

    @Override
    public void deletePower(int powerId) {
        powerRepository.delete(powerId);
    }

    @Override
    public Org addOrg(Org org) { return orgRepository.save(org); }

    @Override
    public Org getOrg(int orgId) {return orgRepository.findOne(orgId); }

    @Override
    public List<Org> listAllOrgs() {return orgRepository.findAll(); }

    @Override
    public Org updateOrg(Org org) {return orgRepository.save(org); }

    @Override
    public void deleteOrg(int orgId) {powerRepository.delete(orgId); }


}
