package de.phl.programmingproject.dnd;

import de.phl.programmingproject.TestBase;
import de.phl.programmingproject.TestUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockedConstruction;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class DungeonsAndDragonsTest extends TestBase {

    @Spy
    Monster spyMonster = new Monster("Spy", 100, 15);


    @Test
    void task_1_attack_method_implemented() {
        Monster m1 = new Monster("Orc1", 100, 0);
        Player warrior = new Player("War", CharacterClass.WARRIOR, 100);
        String desc1 = warrior.attack(m1);
        assertEquals("Schwertstreich", desc1, "Angriffsbeschreibung für Krieger ist falsch");

        Monster m2 = new Monster("Orc2", 100, 0);
        Player mage = new Player("Mage", CharacterClass.MAGE, 100);
        String desc2 = mage.attack(m2);
        assertEquals("Feuerball", desc2, "Angriffsbeschreibung für Magier ist falsch");

        Monster m3 = spyMonster;
        Player paladin = new Player("Pal", CharacterClass.PALADIN, 100);
        String desc3 = paladin.attack(m3);
        assertEquals("Gerechte Rache", desc3, "Angriffsbeschreibung für Paladin ist falsch");

        try {
            verify(m3).takeDamage(10);
        } catch (AssertionError e) {
            fail("die Methode `takeDamage` wurde gar nicht oder mit falschen Werten aufgerufen");
        }
    }

    @Test
    void task_2_take_damage_for_player_implemented() {
        Player ch = new Player("Tester", CharacterClass.PALADIN, 100);
        ch.takeDamage(5);
        assertEquals(Status.ALIVE, ch.getStatus());
        assertEquals(95, ch.getHitPoints(), "Die Methode takeDamage der Player-Klasse is noch nicht richtig implementiert.");
        ch.takeDamage(95);
        assertEquals(Status.STUNNED, ch.getStatus());
        ch.takeDamage(10);
        assertEquals(Status.DEAD, ch.getStatus());

        // Verify that takeDamage uses if-else statements
        String filePath = "src/main/java/de/phl/programmingproject/dnd/Player.java";
        String content = TestUtils.getFileContentForFileInRootOrSrcDirectory(filePath);
        String[] parts = content.split("void takeDamage\\(int damage\\) \\{", 2);
        if (parts.length < 2) throw new IllegalStateException("takeDamage signature not found");
        String methodContent = parts[1]; // contains the rest of the file starting after the opening brace
        assertTrue(methodContent.contains("if") && methodContent.contains("else"),
                "Die Methode `takeDamage` muss If-Else-Anweisungen verwenden, um den Status des Charakters zu aktualisieren.");
    }

    @Test
    void task_2_take_damage_for_monster_implemented() {
        Monster mo = new Monster("Beast", 10, 1);
        mo.takeDamage(5);
        assertEquals(Status.ALIVE, mo.getStatus());
        assertEquals(5, mo.getHitPoints(), "Die Methode takeDamage der Monster-Klasse is noch nicht richtig implementiert.");
        mo.takeDamage(5);
        assertEquals(Status.STUNNED, mo.getStatus());
        mo.takeDamage(1);
        assertEquals(Status.DEAD, mo.getStatus());
    }

    @Test
    void task_3_fight_implemented() {

        Player leeroy = new Player("Leeroy Jenkins", CharacterClass.PALADIN, 100);
        Monster goblin = new Monster("Goblin", 80, 10);

        Player spyLeeroy = Mockito.spy(leeroy);
        Monster spyGoblin = Mockito.spy(goblin);

        DungeonsAndDragons.fight(spyLeeroy, spyGoblin);

        try {
            verify(spyLeeroy, Mockito.times(8)).attack(spyGoblin);
        } catch (AssertionError e) {
            fail("In der fight-Methode muss der Player so oft angreifen, bis er oder das Monster nicht mehr ALIVE ist.\n" + e);
        }
        verify(spyGoblin, Mockito.atLeastOnce()).attack(spyLeeroy);

        assertEquals(spyGoblin.getStatus(), Status.STUNNED,
                "Nach dem Kampf muss der Goblin den Status STUNNED haben.");

        assertEquals(spyLeeroy.getHitPoints(), 30,
                "Nach dem Kampf muss Leeroy Jenkins noch 30 Lebenspunkte haben.");

    }

    @Test
    void task_4_fight_simulated() {
        List<List<Object>> recordedPlayerArgs = new java.util.ArrayList<>();
        List<List<Object>> recordedMonsterArgs = new java.util.ArrayList<>();

        try (MockedConstruction<Player> mockedPlayer = org.mockito.Mockito.mockConstruction(
                Player.class,
                (mock, context) ->
                        recordedPlayerArgs.add(new java.util.ArrayList<>(context.arguments())))) {
            MockedConstruction<Monster> mockedMonster = org.mockito.Mockito.mockConstruction(
                    Monster.class,
                    (mock, context) ->
                            recordedMonsterArgs.add(new java.util.ArrayList<>(context.arguments()))
            );

            // verify that the fight method was called from the main class
            MockedStatic<DungeonsAndDragons> mockedDnD = Mockito.mockStatic(
                    DungeonsAndDragons.class, org.mockito.Mockito.CALLS_REAL_METHODS);

            DungeonsAndDragons.main(new String[]{});


            assertTrue(mockedPlayer.constructed().size() > 0,
                    "Es wurde kein Player erzeugt.");

            Player leeroy = mockedPlayer.constructed().get(0);
            assertEquals("Leeroy Jenkins", recordedPlayerArgs.get(0).get(0),
                    "Der Name von Leeroy Jenkins ist falsch.");
            assertEquals(CharacterClass.PALADIN, recordedPlayerArgs.get(0).get(1),
                    "Die CharacterClass von Leeroy Jenkins ist falsch.");
            assertEquals(100, recordedPlayerArgs.get(0).get(2),
                    "Die Lebenspunkte von Leeroy Jenkins sind falsch.");

            assertTrue(mockedMonster.constructed().size() > 0,
                    "Es wurden keine Monster erzeugt.");
            assertEquals("Goblin", recordedMonsterArgs.get(0).get(0),
                    "Der Name des Monsters ist falsch.");
            assertEquals(80, recordedMonsterArgs.get(0).get(1),
                    "Die Lebenspunkte des Monsters sind falsch.");
            assertEquals(10, recordedMonsterArgs.get(0).get(2),
                    "Die Stärke des Monsters ist falsch.");

            Monster goblin = mockedMonster.constructed().get(0);

            try {
                mockedDnD.verify(() -> DungeonsAndDragons.fight(leeroy, goblin));
            } catch (AssertionError e) {
                fail("Die statische Methode `fight` wurde nicht mit den erwarteten Argumenten aufgerufen.\n " + e);
            }
        }
    }

    @Test
    void testCreateMonstersProducesTwentyWithExpectedStats() {

        String content = TestUtils.getFileContentForFileInRootOrSrcDirectory("src/main/java/de/phl/programmingproject/dnd/DungeonsAndDragons.java");
        // Ensure that a loop is used to create the monsters
        String[] parts = content.split("createMonsters", 2);
        if (parts.length < 2) throw new IllegalStateException("createMonsters signature not found");
        String methodContent = parts[1]; // contains the rest of the file starting after the opening brace

        assertTrue(methodContent.contains("for"),
                "Die Methode `createMonsters` muss eine for-Schleife verwenden, um die Monster zu erstellen.");

        List<Monster> monsters = DungeonsAndDragons.createMonsters();
        assertNotNull(monsters);
        assertEquals(20, monsters.size());

        for (int i = 0; i < 20; i++) {
            Monster m = monsters.get(i);
            int expectedHp = 50 + i * 5;
            int expectedStrength = 5 + i * 2;
            assertEquals(expectedHp, m.getHitPoints(), "HP mismatch at index " + i);
            assertEquals(expectedStrength, m.getStrength(), "Strength mismatch at index " + i);
            assertEquals(DungeonsAndDragons.names[i % DungeonsAndDragons.names.length], m.getName(), String.format("Der Name des Monsters mit Index %d stimmt nicht ", i));
        }
    }
}
