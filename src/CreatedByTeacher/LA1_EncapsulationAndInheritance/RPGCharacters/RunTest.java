package CreatedByTeacher.LA1_EncapsulationAndInheritance.RPGCharacters;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import static org.junit.jupiter.api.Assertions.*;

/**
 * ACTIVITY: LA1 — RPG Characters
 * File:     TestRPGCharacter.java
 *
 * Place alongside Character.java, Swordsman.java, Paladin.java.
 */
public class RunTest {

    // helper: capture stdout
    private String capture(Runnable r) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream old = System.out;
        System.setOut(new PrintStream(out));
        try { r.run(); } finally { System.setOut(old); }
        return out.toString();
    }

    // ── Sample Output 1: All fields of Character are private ─────────────
    @Test
    void testCharacterFieldsArePrivate() {
        for (Field f : Character.class.getDeclaredFields()) {
            assertTrue(Modifier.isPrivate(f.getModifiers()),
                    "Field '" + f.getName() + "' must be private");
        }
    }

    // ── Sample Output 2: Character(150, 20, 5) getters ───────────────────
    @Test
    void testCharacterGetters() {
        Character c = new Character(150, 20, 5);
        assertEquals(150, c.getHealth());
        assertEquals(20,  c.getDamage());
        assertEquals(5,   c.getShield());
    }

    // ── Sample Output 3: Swordsman is a child of Character ───────────────
    @Test
    void testSwordsmanIsChildOfCharacter() {
        Swordsman s = new Swordsman();
        assertInstanceOf(Character.class, s,
                "Swordsman should be an instance of Character");
    }

    // ── Swordsman default values: 100 hp, 10 dmg, 10 shield ─────────────
    @Test
    void testSwordsmanDefaults() {
        Swordsman s = new Swordsman();
        assertEquals(100, s.getHealth());
        assertEquals(10,  s.getDamage());
        assertEquals(10,  s.getShield());
    }

    // ── receiveDamage reduces health by (damage - shield) ────────────────
    @Test
    void testCharacterReceiveDamageReducesHealth() {
        Character c = new Character(100, 10, 5);
        c.receiveDamage(15); // net = 10
        assertEquals(90, c.getHealth());
    }

    // ── receiveDamage: damage <= shield → no damage taken ────────────────
    @Test
    void testCharacterReceiveDamageNotBelowZeroReduction() {
        Character c = new Character(100, 10, 5);
        c.receiveDamage(3); // net = -2 → clamped to 0
        assertEquals(100, c.getHealth());
    }

    // ── "Character has died" printed when health drops to 0 ──────────────
    @Test
    void testCharacterHasDiedPrinted() {
        Character c = new Character(10, 10, 0);
        String out = capture(() -> c.receiveDamage(20));
        assertTrue(out.contains("Character has died"));
    }

    // ── Paladin is a child of Swordsman ──────────────────────────────────
    @Test
    void testPaladinIsChildOfSwordsman() {
        Paladin p = new Paladin();
        assertInstanceOf(Swordsman.class, p);
    }

    // ── Paladin even damage is halved before applying shield ─────────────
    @Test
    void testPaladinEvenDamageHalved() {
        Paladin p = new Paladin();
        // damage=20 → halved=10 → 10-10(shield)=0 → health stays 100
        capture(() -> p.receiveDamage(20));
        assertEquals(100, p.getHealth());
    }

    // ── Paladin odd damage is NOT halved ─────────────────────────────────
    @Test
    void testPaladinOddDamageNotHalved() {
        Paladin p = new Paladin();
        // damage=21 (odd) → 21-10=11 → health=89
        capture(() -> p.receiveDamage(21));
        assertEquals(89, p.getHealth());
    }

    // ── Paladin resurrects once: health restored to 100 ──────────────────
    @Test
    void testPaladinResurrectsOnce() {
        Paladin p = new Paladin();
        capture(() -> p.receiveDamage(300)); // lethal → should resurrect
        assertEquals(100, p.getHealth(), "After first kill, Paladin should resurrect to 100 HP");
    }

    // ── Paladin prints "Paladin has died" on second death ────────────────
    @Test
    void testPaladinSecondDeathPrintsPaladinHasDied() {
        Paladin p = new Paladin();
        capture(() -> p.receiveDamage(300)); // first kill → resurrect
        String out = capture(() -> p.receiveDamage(300)); // second kill → truly dead
        assertTrue(out.contains("Paladin has died"),
                "Second death should print 'Paladin has died'");
    }
}
