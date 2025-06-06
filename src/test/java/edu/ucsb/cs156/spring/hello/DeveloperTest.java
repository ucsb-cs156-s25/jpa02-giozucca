package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;

public class DeveloperTest {

    @Test
    public void testPrivateConstructor() throws Exception {
        // this hack is from https://www.timomeinen.de/2013/10/test-for-private-constructor-to-get-full-code-coverage/
        Constructor<Developer> constructor = Developer.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()),"Constructor is not private");

        constructor.setAccessible(true);
        constructor.newInstance();
    }

    @Test
    public void getName_returns_correct_name() {
        assertEquals("Giovanni L.", Developer.getName());
    }

    @Test
    public void getGithubId_returns_correct_githubId() {
        assertEquals("giozucca", Developer.getGithubId());
    }

    @Test
    public void getTeam_returns_team_with_correct_members() {
        Team  t = Developer.getTeam();
        assertTrue(t.getMembers().contains("Giovanni"),"Team should contain Giovanni");
        assertTrue(t.getMembers().contains("Nathan"),"Team should contain Nathan");
        assertTrue(t.getMembers().contains("Hannah"),"Team should contain Hannah");
        assertTrue(t.getMembers().contains("Rishik"),"Team should contain Rishik");
        assertTrue(t.getMembers().contains("Selena"),"Team should contain Selena");
        assertTrue(t.getMembers().contains("Tiffany"),"Team should contain Tiffany");
        
    }


    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)

}
