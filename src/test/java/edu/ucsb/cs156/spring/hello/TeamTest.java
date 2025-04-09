package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void hashCode_returns_same_for_same_objects() {
        Team t1 = new Team();
        t1.setName("foo");
        t1.addMember("bar");
        Team t2 = new Team();
        t2.setName("foo");
        t2.addMember("bar");
        assertEquals(t1.hashCode(), t2.hashCode());
     
    }

    @Test
    public void empty_hash() {
        // instantiate t as a Team object
        Team t = new Team();
        int result = t.hashCode();
        int expectedResult = 1;
        assertEquals(expectedResult, result);
    }

    @Test
    public void same_object_Test() {
        Team t1 = new Team();
        t1.setName("foo");

        assertEquals(t1.equals(t1), true);
    }

    // @Test
    // public void same_object_Test() {
    //     Team t1 = new Team();
    //     t1.setName("foo");

    //     Team t2 = t1;

    //     // assertEquals(t1.getName(), t2.getName());

    //     assertEquals(t1.equals(t2), true);
    // }


    @Test
    public void not_even_instance() {
        Team t1 = new Team();
        int t2 = 6;

        assertEquals(t1.equals(t2), false);
    }

    @Test
    public void same_name_same_team() {
        Team t1 = new Team();
        t1.setName("foo");
        t1.addMember("gio");
        t1.addMember("john");

        Team t2 = new Team();
        t2.setName("foo");
        t2.addMember("gio");
        t2.addMember("john");

        assertEquals(t1.equals(t2), true);
    }

    @Test
    public void same_name_diff_team() {
        Team t1 = new Team();
        t1.setName("foo");
        t1.addMember("gio");
        t1.addMember("john");

        Team t2 = new Team();
        t2.setName("foo");
        t2.addMember("gio");
        t2.addMember("paul");

        assertEquals(t1.equals(t2), false);
    }

    @Test
    public void diff_name_same_team() {
        Team t1 = new Team();
        t1.setName("foo");
        t1.addMember("gio");
        t1.addMember("john");

        Team t2 = new Team();
        t2.setName("bar");
        t2.addMember("gio");
        t2.addMember("john");

        assertEquals(t1.equals(t2), false);
    }

    @Test
    public void diff_name_diff_team() {
        Team t1 = new Team();
        t1.setName("foo");
        t1.addMember("gio");
        t1.addMember("john");

        Team t2 = new Team();
        t2.setName("bar");
        t2.addMember("george");
        t2.addMember("john");

        assertEquals(t1.equals(t2), false);
    }
   
    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)

}
