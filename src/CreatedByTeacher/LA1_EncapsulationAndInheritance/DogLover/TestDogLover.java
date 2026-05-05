package CreatedByTeacher.LA1_EncapsulationAndInheritance.DogLover;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import static org.junit.jupiter.api.Assertions.*;

/**
 * ACTIVITY: LA1 — Dog Lover
 * File:     TestDogLover.java
 *
 * Place alongside Dog.java.
 */
class TestDogLover {

    // ── Sample Output 1: All fields are private ───────────────────────────
    @Test
    void testFieldsArePrivate() {
        for (Field f : Dog.class.getDeclaredFields()) {
            assertTrue(Modifier.isPrivate(f.getModifiers()),
                    "Field '" + f.getName() + "' must be private");
        }
    }

    // ── Sample Output 2: Dog('m', "gold") toString ────────────────────────
    @Test
    void testMaleGoldToString() {
        Dog d = new Dog('m', "gold");
        assertEquals("My male, gold Golden Retriever", d.toString());
    }

    // ── Sample Output 3: Dog('f', "brown") toString ───────────────────────
    @Test
    void testFemaleBrownToString() {
        Dog d = new Dog('f', "brown");
        assertEquals("My female, brown Golden Retriever", d.toString());
    }

    // ── breed is always "Golden Retriever" ───────────────────────────────
    @Test
    void testBreedIsAlwaysGoldenRetriever() {
        Dog d = new Dog('m', "gold");
        assertEquals("Golden Retriever", d.getBreed());
    }

    // ── Invalid color defaults to "gold" ─────────────────────────────────
    @Test
    void testInvalidColorDefaultsToGold() {
        Dog d = new Dog('m', "purple");
        assertEquals("gold", d.getColor(), "Invalid color should default to 'gold'");
    }

    // ── Invalid gender defaults to 'm' ────────────────────────────────────
    @Test
    void testInvalidGenderDefaultsToMale() {
        Dog d = new Dog('x', "gold");
        assertEquals('m', d.getGender(), "Invalid gender should default to 'm'");
    }

    // ── setColor: valid ───────────────────────────────────────────────────
    @Test
    void testSetColorValid() {
        Dog d = new Dog('m', "gold");
        d.setColor("brown");
        assertEquals("brown", d.getColor());
    }

    // ── setColor: invalid defaults to "gold" ─────────────────────────────
    @Test
    void testSetColorInvalidDefaultsToGold() {
        Dog d = new Dog('m', "brown");
        d.setColor("red");
        assertEquals("gold", d.getColor());
    }

    // ── setGender: valid ──────────────────────────────────────────────────
    @Test
    void testSetGenderValid() {
        Dog d = new Dog('m', "gold");
        d.setGender('f');
        assertEquals('f', d.getGender());
    }

    // ── setGender: invalid defaults to 'm' ───────────────────────────────
    @Test
    void testSetGenderInvalidDefaultsToMale() {
        Dog d = new Dog('f', "gold");
        d.setGender('z');
        assertEquals('m', d.getGender());
    }

    // ── bark(n) prints "Woof" n times ────────────────────────────────────
    @Test
    void testBarkPrintsWoofNTimes() {
        Dog d = new Dog('m', "gold");
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream old = System.out;
        System.setOut(new PrintStream(out));
        d.bark(3);
        System.setOut(old);

        String[] lines = out.toString().trim().split("\\r?\\n");
        assertEquals(3, lines.length, "bark(3) should print exactly 3 lines");
        for (String line : lines) {
            assertEquals("Woof", line.trim());
        }
    }
}
