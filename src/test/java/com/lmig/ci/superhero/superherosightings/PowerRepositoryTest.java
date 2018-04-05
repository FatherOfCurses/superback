package com.lmig.ci.superhero.superherosightings;

import com.lmig.ci.superhero.superherosightings.domain.Power;
import com.lmig.ci.superhero.superherosightings.repository.PowerRepository;
import com.lmig.ci.superhero.superherosightings.helpers.TestHelper;
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


public class PowerRepositoryTest {

    @Autowired
    private PowerRepository powerRepository;

    @Before
    public void setUp() {
        List<Power> powers = powerRepository.findAll();
            powerRepository.deleteAll();
    }

    @Test
    @Transactional
    public void ICanAddAPowerToTheDatabase() {
        Power power = TestHelper.createPower(1);
        Power expectedPower = powerRepository.save(power);
        Assert.assertTrue(expectedPower == powerRepository.getOne(expectedPower.getPowerId()));
    }

    @Test
    @Transactional
    public void ICanSeeOnePowerByItsId() {
        Power power = TestHelper.createPower(1);

        Power expectedPower = powerRepository.save(power);
        Assert.assertTrue(expectedPower == powerRepository.getOne(expectedPower.getPowerId()));
    }

    @Test
    @Transactional
    public void ICanSeeAllThePowersInTheDatabase() {
        List<Power> expectedPowerList = new ArrayList<>();
        for (int i = 1; i < 15; i++) {
            expectedPowerList.add(powerRepository.save(TestHelper.createPower(i)));
        }
        List<Power> actualPowerList = powerRepository.findAll();
        Assert.assertTrue(expectedPowerList.equals(actualPowerList));
    }

    @Test
    public void ICanEditDataForOnePowerInTheDatabase() {
        Power power = TestHelper.createPower(1);
        Power editPower = powerRepository.save(power);
        editPower.setPowerName("Heat vision");
        Power expectedPower = powerRepository.save(editPower);
        Assert.assertEquals(expectedPower, powerRepository.findOne(expectedPower.getPowerId()));
    }

    @Test
    public void ICanDeleteAPowerFromTheDatabase() {
        List<Power> expectedPowerList = new ArrayList<>();
        Power power = TestHelper.createPower(1);
        Power expectedPower = powerRepository.save(power);
        expectedPowerList.add(expectedPower);

        Power power2 = TestHelper.createPower(2);
        Power expectedPower2 = powerRepository.save(power2);
        powerRepository.delete(expectedPower2.getPowerId());
        List<Power> actualPowerList = powerRepository.findAll();
        Assert.assertEquals(expectedPowerList, actualPowerList);

    }

}
