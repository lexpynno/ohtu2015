/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import ohtuesimerkki.Player;
import ohtuesimerkki.Statistics;
import ohtuesimerkki.Reader;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Leo
 */
public class StatisticsTest {

    Statistics stats;
    Reader readerStub = new Reader() {

        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<Player>();

            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri", "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));

            return players;
        }

    };

    @Before
    public void setUp() {
        stats = new Statistics(readerStub);
    }

    @Test
    public void searchReturnsCorrectPlayerIfPlayerExists() {
        Player p = stats.search("Gretzky"); 
        assertTrue(p.getName().equals("Gretzky") && p.getTeam().equals("EDM") && p.getGoals() == 35);
    }

    @Test
    public void searchReturnNullIfNoPlayerFound() {
        Player p = stats.search("asd");
        assertTrue(p == null);
    }

    @Test
    public void teamReturnsCorrectTeam() {
        List<Player> team = stats.team("EDM");
        assertTrue(team.size() == 3);
        List<String> players = new ArrayList();
        players.add("Semenko");
        players.add("Kurri");
        players.add("Gretzky");
        for (Player p : team) {
            if (!players.contains(p.getName())) {
                fail();
            }
        }
    }

    @Test
    public void testTopScorers() {
        List<Player> top = stats.topScorers(2);
        assertTrue(top.get(0).getName().equals("Gretzky") && 
                top.get(1).getName().equals("Lemieux") && top.get(2).getName().equals("Yzerman"));
    }

    @Test
    public void testTopScorersWithNegative() {
        List<Player> t = stats.topScorers(-1);
        assertTrue(t.isEmpty());
    }
}
