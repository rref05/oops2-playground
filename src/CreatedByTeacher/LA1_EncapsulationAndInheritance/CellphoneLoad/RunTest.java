package CreatedByTeacher.LA1_EncapsulationAndInheritance.CellphoneLoad;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * ACTIVITY: LA1 — Cellphone Load
 * File:     RunTest.java
 *
 * Place alongside CellphoneLoad.java, CITLoad.java,
 * CTLoad.java, ILoad.java, Phone.java.
 */
public class RunTest {

    // ── Sample Output 1: All fields of CellphoneLoad are private ─────────
    @Test
    void testCellphoneLoadFieldsArePrivate() {
        for (Field f : CellphoneLoad.class.getDeclaredFields()) {
            assertTrue(Modifier.isPrivate(f.getModifiers()),
                    "Field '" + f.getName() + "' must be private");
        }
    }

    // ── Sample Output 2: CellphoneLoad(true, true, 1000) getters ─────────
    @Test
    void testCellphoneLoadGetters() {
        CellphoneLoad cl = new CellphoneLoad(true, true, 1000);
        assertTrue(cl.hasUnlimitedCalls());
        assertTrue(cl.hasUnlimitedTexts());
        assertEquals(1000, cl.getInternetMB());
    }

    @Test
    void testCellphoneLoadGettersFalse() {
        CellphoneLoad cl = new CellphoneLoad(false, false, 500);
        assertFalse(cl.hasUnlimitedCalls());
        assertFalse(cl.hasUnlimitedTexts());
        assertEquals(500, cl.getInternetMB());
    }

    // ── Sample Output 3: CITLoad is a child of CellphoneLoad ─────────────
    @Test
    void testCITLoadIsChildOfCellphoneLoad() {
        CITLoad cit = new CITLoad();
        assertInstanceOf(CellphoneLoad.class, cit,
                "CITLoad should be an instance of CellphoneLoad");
    }

    // ── CITLoad values: unlimited calls & texts, 1000 MB ─────────────────
    @Test
    void testCITLoadValues() {
        CITLoad c = new CITLoad();
        assertTrue(c.hasUnlimitedCalls());
        assertTrue(c.hasUnlimitedTexts());
        assertEquals(1000, c.getInternetMB());
    }

    // ── CTLoad values: unlimited calls & texts, 0 MB ─────────────────────
    @Test
    void testCTLoadValues() {
        CTLoad c = new CTLoad();
        assertTrue(c.hasUnlimitedCalls());
        assertTrue(c.hasUnlimitedTexts());
        assertEquals(0, c.getInternetMB());
    }

    // ── ILoad values: no unlimited, 2000 MB ──────────────────────────────
    @Test
    void testILoadValues() {
        ILoad c = new ILoad();
        assertFalse(c.hasUnlimitedCalls());
        assertFalse(c.hasUnlimitedTexts());
        assertEquals(2000, c.getInternetMB());
    }

    // ── Phone starts with false, false, 0 ────────────────────────────────
    @Test
    void testPhoneInitialState() {
        Phone ph = new Phone();
        assertEquals(
                "Has unlimited calls = false, Has unlimited texts = false, Internet MB = 0",
                ph.toString()
        );
    }

    // ── Phone.load(CITLoad) sets values correctly ─────────────────────────
    @Test
    void testPhoneLoadCITLoad() {
        Phone ph = new Phone();
        ph.load(new CITLoad());
        assertEquals(
                "Has unlimited calls = true, Has unlimited texts = true, Internet MB = 1000",
                ph.toString()
        );
    }

    // ── Phone.load() accumulates internetMB ──────────────────────────────
    @Test
    void testPhoneLoadAccumulatesMB() {
        Phone ph = new Phone();
        ph.load(new ILoad());
        ph.load(new ILoad());
        assertEquals(
                "Has unlimited calls = false, Has unlimited texts = false, Internet MB = 4000",
                ph.toString()
        );
    }
}
