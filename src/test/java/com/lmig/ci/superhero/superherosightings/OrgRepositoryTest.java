package com.lmig.ci.superhero.superherosightings;

import com.lmig.ci.superhero.superherosightings.domain.Org;
import com.lmig.ci.superhero.superherosightings.repository.OrgRepository;
import com.lmig.ci.superhero.superherosightings.helpers.TestHelper;
import com.lmig.ci.superhero.superherosightings.repository.PowerRepository;
import org.aspectj.weaver.ast.Or;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("unit-test")
@Rollback()

public class OrgRepositoryTest {

    @Autowired
    private OrgRepository orgRepository;

    @Before
    public void setUp() {
        List<Org> orgs = orgRepository.findAll();
        orgRepository.deleteAll();
    }

    @Test
    @Transactional
    public void ICanAddAnOrgToTheDatabase () {
        Org org = TestHelper.createOrg(1);
        Org expectedOrg = orgRepository.save(org);
        Assert.assertTrue(expectedOrg == orgRepository.getOne(expectedOrg.getOrgId()));
    }

    @Test
    @Transactional
    public void ICanSeeOneOrgByItsId() {

    }

    @Test
    @Transactional
    public void ICanSeeAllTheOrgsInTheDatabase() {

    }

    @Test
    @Transactional
    public void ICanUpdateAnOrgInTheDatabase() {

    }

    @Test
    @Transactional
    public void ICanDeleteAnOrgFromTheDatabase() {

    }

}
