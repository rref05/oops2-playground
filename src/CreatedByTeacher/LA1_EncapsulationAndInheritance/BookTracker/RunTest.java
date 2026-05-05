package CreatedByTeacher.LA1_EncapsulationAndInheritance.BookTracker;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * ACTIVITY: LA1 — Book Tracker
 * File:     RunTest.java
 *
 * Place this file alongside Book.java.
 * Run via IntelliJ or:
 *   javac -cp junit-platform-console-standalone.jar Book.java RunTest.java
 *   java  -cp .:junit-platform-console-standalone.jar org.junit.platform.console.ConsoleLauncher --select-class=TestBookTracker
 */
public class RunTest {

    // ── Sample Output 1: Book() default constructor ───────────────────────
    @Test
    void testDefaultConstructor() {
        Book b = new Book();
        assertEquals("Unknown", b.title,       "Default title should be 'Unknown'");
        assertEquals("Unknown", b.author,      "Default author should be 'Unknown'");
        assertEquals(0,         b.yearPublished,"Default yearPublished should be 0");
    }

    // ── Sample Output 2: Book("1984", "George Orwell", 1949) ─────────────
    @Test
    void testParameterizedConstructor_1984() {
        Book b = new Book("1984", "George Orwell", 1949);
        assertEquals("1984",          b.title);
        assertEquals("George Orwell", b.author);
        assertEquals(1949,            b.yearPublished);
    }

    // ── Sample Output 3: Book("To Kill a Mockingbird", "Harper Lee", 1960) ──
    @Test
    void testParameterizedConstructor_MockingBird() {
        Book b = new Book("To Kill a Mockingbird", "Harper Lee", 1960);
        assertEquals("To Kill a Mockingbird", b.title);
        assertEquals("Harper Lee",            b.author);
        assertEquals(1960,                    b.yearPublished);
    }

    // ── Extra: Public fields exist ───────────────────────────────────────
    @Test
    void testFieldsArePublic() {
        assertDoesNotThrow(() -> {
            Book.class.getField("title");
            Book.class.getField("author");
            Book.class.getField("yearPublished");
        }, "title, author, yearPublished should be public fields");
    }
}