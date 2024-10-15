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

   
    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)

    @Test
    public void equals_covers_all_cases() {
        Team newTeam = new Team("test-team-2");
        newTeam.addMember("a");

        Team sameTeam = new Team("test-team-2");
        sameTeam.addMember("a");

        Team diffTeam = new Team("test-team-2");
        diffTeam.addMember("b");

        assertEquals(true, team.equals(team));
        assertEquals(false, team.equals(newTeam));
        assertEquals(false, team.equals(0));
        assertEquals(true, newTeam.equals(sameTeam));
        assertEquals(false, newTeam.equals(diffTeam));
    }

    @Test
    public void hashCode_covers_all_cases() {
        Team team1 = new Team("test-team");
        team1.addMember("a");
        Team team2 = new Team("test-team");
        team2.addMember("a");
        assertEquals(team1.hashCode(), team2.hashCode());
        Team t = new Team();
        int result = t.hashCode();
        int expectedResult = 1;
        assertEquals(expectedResult, result);
    }

}
