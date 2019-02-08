package com.cegeka.switchfully.security;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = ArmyResource.ARMY_RESOURCE_PATH)
public class ArmyResource {

    public static final String ARMY_RESOURCE_PATH = "/armies";
    public static final String ARMY_TANKS_RESOURCE_PATH = "/tanks";

    @RequestMapping(method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE ,path = "/{country}")
    @PreAuthorize("hasRole('ROLE_PRIVATE') or hasRole('ROLE_GENERAL')")
    public ArmyInfoDto getDeployedArmyInfo(@PathVariable(value = "country") String country){
        return ArmyInfoDto.armyInfoDto()
                .withCountry(country)
                .withNumberOfTroops(2000)
                .withxCoordinateOfBase(15)
                .withyCoordinateOfBase(20);
    }

    @RequestMapping(method = RequestMethod.POST)
    @PreAuthorize("hasRole('ROLE_CIVILIAN')")
    public void joinArmy(){
        //TODO
    }

    @RequestMapping(method = RequestMethod.POST, path = "/promote/{name}")
    @PreAuthorize("hasRole('ROLE_HUMAN_RELATIONSHIPS')")
    public void promotePrivate(@PathVariable(value = "name") String name){
        //TODO
    }

    @RequestMapping(method = RequestMethod.POST, path = "/discharge/{name}")
    @PreAuthorize("hasRole('ROLE_HUMAN_RELATIONSHIPS')")
    public void dischargeSoldier(@PathVariable(value = "name") String name){
        //TODO
    }

    @RequestMapping(method = RequestMethod.GET, path = "/nuke")
    @PreAuthorize("hasRole('ROLE_GENERAL')")
    public String launchNukes(){
        return "The world ends. Not with a bang but a whimper";
    }

    // TANKS MAN

    @RequestMapping(method = RequestMethod.POST, path = ARMY_TANKS_RESOURCE_PATH + "/{name}")
//    @PreAuthorize("hasRole('ROLE_PRIVATE')")
    public void createTanks(@PathVariable(value = "name") String name){
        //TODO
    }

    @RequestMapping(method = RequestMethod.GET, path = ARMY_TANKS_RESOURCE_PATH + "/{name}")
//    @PreAuthorize("hasRole('ROLE_PRIVATE') or hasRole('ROLE_GENERAL') or hasRole('CIVILIAN')")
    public void getTanks(@PathVariable(value = "name") String name){
        //TODO
    }

    @RequestMapping(method = RequestMethod.DELETE, path = ARMY_TANKS_RESOURCE_PATH + "/{name}")
//    @PreAuthorize("hasRole('ROLE_GENERAL')")
    public void deleteTanks(@PathVariable(value = "name") String name){
        //TODO
    }

    @RequestMapping(method = RequestMethod.PUT, path = ARMY_TANKS_RESOURCE_PATH + "/{name}")
//    @PreAuthorize("hasRole('ROLE_PRIVATE') or hasRole('ROLE_GENERAL')")
    public void updateTanks(@PathVariable(value = "name") String name){
        //TODO
    }
}
