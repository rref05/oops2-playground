//package CreatedByTeacher.LA3_Shapes;
//import java.lang.reflect.Constructor;
//
///**
// * ============================================================
// *  ACTIVITY : LA3 — Shape of You
// *  HOW TO RUN:
// *    1. Place Shape.java, Rectangle.java, Square.java,
// *       Ellipse.java, Circle.java, Triangle.java,
// *       EquilateralTriangle.java in the same folder.
// *    2. Compile:  javac *.java ShapeTestRunner.java
// *    3. Run:      java ShapeTestRunner
// * ============================================================
// *
// *  PI = 3.14159  (as final variable in subclasses as needed)
// *  All area/perimeter printed with %.2f
// */
//public class RunTest {
//
//    static int passed = 0, failed = 0;
//    static final double PI = 3.14159;
//    static final double EPS = 0.005; // tolerance for .2f rounding
//
//    public static void main(String[] args) {
//        System.out.println("=== LA3: Shape of You — Auto Test Runner ===\n");
//
//        testRectangle();
//        testEllipse();
//        testSquare();
//        testCircle();
//        testTriangle();
//        testEquilateralTriangle();
//        testSquareIsRectangle();
//        testCircleIsEllipse();
//        testEquilateralTriangleIsTriangle();
//        testRectangleOneConstructor();
//        testEllipseOneConstructor();
//        testTriangleOneConstructor();
//
//        printSummary();
//    }
//
//    // ── Sample Output 1: Rectangle(15.1, 9.1, "orange") ─────
//    static void testRectangle() {
//        System.out.println("[Sample Output 1] Rectangle(15.1, 9.1, \"orange\")");
//        Rectangle r = new Rectangle(15.1, 9.1, "orange");
//        check("toString", "A shape that is color orange which is also a Rectangle", r.toString());
//        checkDouble("area",      137.41, r.area());
//        checkDouble("perimeter",  48.40, r.perimeter());
//    }
//
//    // ── Sample Output 2: Ellipse(7.4, 5, "black") ───────────
//    static void testEllipse() {
//        System.out.println("[Sample Output 2] Ellipse(7.4, 5, \"black\")");
//        Ellipse e = new Ellipse(7.4, 5, "black");
//        check("toString", "A shape that is color black which is also an Ellipse", e.toString());
//        checkDouble("area",      116.24, e.area());
//        checkDouble("perimeter",  39.32, e.perimeter());
//    }
//
//    // ── Sample Output 3: Square(18.2, "yellow") ─────────────
//    static void testSquare() {
//        System.out.println("[Sample Output 3] Square(18.2, \"yellow\")");
//        Square s = new Square(18.2, "yellow");
//        check("toString", "A shape that is color yellow which is also a Rectangle which is also a Square", s.toString());
//        checkDouble("area",      331.24, s.area());
//        checkDouble("perimeter",  72.80, s.perimeter());
//    }
//
//    // ── Circle ───────────────────────────────────────────────
//    static void testCircle() {
//        System.out.println("[Extra] Circle(5, \"red\")");
//        Circle c = new Circle(5, "red");
//        check("toString", "A shape that is color red which is also an Ellipse which is also a Circle", c.toString());
//        // area = PI * 5 * 5 = 78.53975
//        checkDouble("area",      PI * 5 * 5,    c.area());
//        // perimeter = 2*PI*5 = 31.4159
//        checkDouble("perimeter", 2 * PI * 5,    c.perimeter());
//    }
//
//    // ── Triangle ─────────────────────────────────────────────
//    static void testTriangle() {
//        System.out.println("[Extra] Triangle(base=6, height=4, a=5, c=5, \"blue\")");
//        Triangle t = new Triangle(6, 4, 5, 5, "blue");
//        check("toString", "A shape that is color blue which is also a Triangle", t.toString());
//        checkDouble("area",      12.0, t.area());      // 0.5*6*4
//        checkDouble("perimeter", 16.0, t.perimeter()); // 6+5+5
//    }
//
//    // ── EquilateralTriangle ───────────────────────────────────
//    static void testEquilateralTriangle() {
//        System.out.println("[Extra] EquilateralTriangle(6, \"green\")");
//        EquilateralTriangle et = new EquilateralTriangle(6, "green");
//        check("toString", "A shape that is color green which is also a Triangle which is also an Equilateral Triangle", et.toString());
//        // area = (sqrt(3)/4)*36
//        double expectedArea = (Math.sqrt(3) / 4) * 36;
//        checkDouble("area", expectedArea, et.area());
//    }
//
//    // ── instanceof checks ────────────────────────────────────
//    static void testSquareIsRectangle() {
//        System.out.println("[CheckSquare] Square instanceof Rectangle");
//        Square s = new Square(0, "");
//        if (s instanceof Rectangle) pass("Square is a Rectangle");
//        else fail("Square instanceof Rectangle", "false");
//    }
//
//    static void testCircleIsEllipse() {
//        System.out.println("[CheckCircle] Circle instanceof Ellipse");
//        Circle c = new Circle(0, "");
//        if (c instanceof Ellipse) pass("Circle is an Ellipse");
//        else fail("Circle instanceof Ellipse", "false");
//    }
//
//    static void testEquilateralTriangleIsTriangle() {
//        System.out.println("[CheckEquilateralTriangle] EquilateralTriangle instanceof Triangle");
//        EquilateralTriangle et = new EquilateralTriangle(0, "");
//        if (et instanceof Triangle) pass("EquilateralTriangle is a Triangle");
//        else fail("EquilateralTriangle instanceof Triangle", "false");
//    }
//
//    // ── single constructor checks ─────────────────────────────
//    static void testRectangleOneConstructor() {
//        System.out.println("[CheckConstructor1] Rectangle has exactly 1 declared constructor");
//        Constructor<?>[] ctors = Rectangle.class.getDeclaredConstructors();
//        if (ctors.length == 1) pass("Rectangle has 1 constructor");
//        else fail("Rectangle constructor count", "got " + ctors.length);
//    }
//
//    static void testEllipseOneConstructor() {
//        System.out.println("[CheckConstructor2] Ellipse has exactly 1 declared constructor");
//        Constructor<?>[] ctors = Ellipse.class.getDeclaredConstructors();
//        if (ctors.length == 1) pass("Ellipse has 1 constructor");
//        else fail("Ellipse constructor count", "got " + ctors.length);
//    }
//
//    static void testTriangleOneConstructor() {
//        System.out.println("[CheckConstructor3] Triangle has exactly 1 declared constructor");
//        Constructor<?>[] ctors = Triangle.class.getDeclaredConstructors();
//        if (ctors.length == 1) pass("Triangle has 1 constructor");
//        else fail("Triangle constructor count", "got " + ctors.length);
//    }
//
//    // ── helpers ──────────────────────────────────────────────
//    static void pass(String n) { System.out.println("  PASS: " + n); passed++; }
//    static void fail(String n, String r) { System.out.println("  FAIL: " + n + " → " + r); failed++; }
//    static void check(String l, String ex, String ac) {
//        if (ex.equals(ac)) pass(l); else fail(l, "\n    expected: \"" + ex + "\"\n    got:      \"" + ac + "\"");
//    }
//    static void checkDouble(String l, double ex, double ac) {
//        // compare at 2 decimal places
//        double roundEx = Math.round(ex * 100.0) / 100.0;
//        double roundAc = Math.round(ac * 100.0) / 100.0;
//        if (Math.abs(roundEx - roundAc) < 0.005) pass(l + " ≈ " + String.format("%.2f", ac));
//        else fail(l, "expected " + String.format("%.2f", ex) + " got " + String.format("%.2f", ac));
//    }
//    static void printSummary() {
//        System.out.println("\n==============================");
//        System.out.println("Results: " + passed + " PASSED, " + failed + " FAILED");
//        System.out.println("==============================");
//    }
//}
