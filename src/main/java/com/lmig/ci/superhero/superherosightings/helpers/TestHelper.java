package com.lmig.ci.superhero.superherosightings.helpers;

import com.lmig.ci.superhero.superherosightings.domain.Org;
import com.lmig.ci.superhero.superherosightings.domain.Power;
import com.lmig.ci.superhero.superherosightings.domain.Sighting;
import com.lmig.ci.superhero.superherosightings.service.DatabaseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TestHelper {

    @Autowired
    private DatabaseService databaseService;

/*    public static Hero createHero(int num) {
        Hero hero = new Hero();
        hero.setHeroID(num);
        hero.setHeroName("Batman" + num);
        hero.setHeroDescription("The Dark Knight");
        return hero;
    }*/

    public static Org createOrg(int num) {
        Org org = new Org();
        org.setOrgName("Avengers" + num);
        org.setOrgDescription("The fun never ends here");
        org.setOrgAddress1("100 Stark Ave");
        org.setOrgAddress2("Suite 9999");
        org.setOrgCity("New York");
        org.setOrgState("NY");
        org.setOrgPostCode("10012");
        org.setOrgCountry("United States of America");
        org.setOrgEmail("nick.fury@avengers.org");
        org.setOrgPhone("800-AVENGER");
        return org;
    }

    public static Power createPower(int num) {
        Power power = new Power();
        power.setPowerName("Laser Vision" + num);
        power.setPowerDescription("This will burn you up");
        return power;
    }

/*    public static Location createLocation(int num) {
        Location location = new Location();
        location.setLocationID(num);
        location.setLocationName("EmpireStateBuilding" + num);
        location.setLocationDescription("Iconic New York City locale, favored by King Kong");
        location.setLocationAddress("350 Fifth Avenue, Manhattan, New York 10118 USA");
        BigDecimal locLat = new BigDecimal("40.748444");
        location.setLocationLat(locLat);
        BigDecimal locLon = new BigDecimal("-73.987844");
        location.setLocationLon(locLon);
        return location;
    }*/

/*    public static Sighting createSighting(int num) {
        Sighting sighting = new Sighting();
        sighting.setSightingID(num);
        sighting.setSightingDateTime(LocalDate.now());
        ArrayList<Hero> heroList = new ArrayList<>();
        Hero hero = createHero(num);
        heroList.add(hero);
        Location location = createLocation(num);
        sighting.setHeroes(heroList);
        sighting.setLocation(location);
        return sighting;
    }*/
}
