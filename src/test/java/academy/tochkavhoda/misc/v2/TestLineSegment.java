package academy.tochkavhoda.misc.v2;

import academy.tochkavhoda.figures.v1.Point;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestLineSegment {
    @Test
    public void testLineSegment1() {
        Point initialPoint = new Point(1, 1);
        Point endPoint = new Point(3, 5);
        LineSegment lineSegment = new LineSegment(initialPoint, endPoint);
        assertAll(
                () -> assertEquals(1, lineSegment.getInitialPoint().getX()),
                () -> assertEquals(1, lineSegment.getInitialPoint().getY()),
                () -> assertEquals(3, lineSegment.getEndPoint().getX()),
                () -> assertEquals(5, lineSegment.getEndPoint().getY())
        );
    }

    @Test
    public void testLineSegment2() {
        LineSegment lineSegment = new LineSegment(2, 4, 6, 8);
        assertAll(
                () -> assertEquals(2, lineSegment.getInitialPoint().getX()),
                () -> assertEquals(4, lineSegment.getInitialPoint().getY()),
                () -> assertEquals(6, lineSegment.getEndPoint().getX()),
                () -> assertEquals(8, lineSegment.getEndPoint().getY())
        );
    }

    @Test
    public void testLineSegment3() {
        LineSegment lineSegment = new LineSegment();
        assertAll(
                () -> assertEquals(0, lineSegment.getInitialPoint().getX()),
                () -> assertEquals(0, lineSegment.getInitialPoint().getY()),
                () -> assertEquals(1, lineSegment.getEndPoint().getX()),
                () -> assertEquals(1, lineSegment.getEndPoint().getY())
        );
    }

    @Test
    public void testSetInitialAndEndPoint() {
        LineSegment lineSegment = new LineSegment(2, 4, 6, 8);
        Point newInitialPoint = new Point(4, 5);
        Point newEndPoint = new Point(7, 9);
        lineSegment.setInitialPoint(newInitialPoint);
        lineSegment.setEndPoint(newEndPoint);
        assertAll(
                () -> assertEquals(4, lineSegment.getInitialPoint().getX()),
                () -> assertEquals(5, lineSegment.getInitialPoint().getY()),
                () -> assertEquals(7, lineSegment.getEndPoint().getX()),
                () -> assertEquals(9, lineSegment.getEndPoint().getY())
        );
    }

    @Test
    public void testMoveTo() {
        LineSegment lineSegment = new LineSegment(2, 4, 6, 12);
        lineSegment.moveTo(10, 10);
        assertAll(
                () -> assertEquals(10, lineSegment.getInitialPoint().getX()),
                () -> assertEquals(10, lineSegment.getInitialPoint().getY()),
                () -> assertEquals(14, lineSegment.getEndPoint().getX()),
                () -> assertEquals(18, lineSegment.getEndPoint().getY())
        );
    }

    @Test
    public void testMoveRel() {
        LineSegment lineSegment = new LineSegment(2, 4, 6, 12);
        lineSegment.moveRel(5, 5);
        assertAll(
                () -> assertEquals(7, lineSegment.getInitialPoint().getX()),
                () -> assertEquals(9, lineSegment.getInitialPoint().getY()),
                () -> assertEquals(11, lineSegment.getEndPoint().getX()),
                () -> assertEquals(17, lineSegment.getEndPoint().getY())
        );
    }

    @Test
    public void testResizeLineSegment1() {

        LineSegment lineSegment = new LineSegment(0, 0, 4, 3);
        lineSegment.resize(2);
        assertAll(
                () -> assertEquals(0, lineSegment.getInitialPoint().getX()),
                () -> assertEquals(0, lineSegment.getInitialPoint().getY()),
                () -> assertEquals(8, lineSegment.getEndPoint().getX()),
                () -> assertEquals(6, lineSegment.getEndPoint().getY())
        );
    }

    @Test
    public void testResizeLineSegment2() {

        LineSegment lineSegment = new LineSegment(2, 4, 6, 12);
        lineSegment.resize(0.5);
        assertAll(
                () -> assertEquals(2, lineSegment.getInitialPoint().getX()),
                () -> assertEquals(4, lineSegment.getInitialPoint().getY()),
                () -> assertEquals(4, lineSegment.getEndPoint().getX()),
                () -> assertEquals(8, lineSegment.getEndPoint().getY())
        );
    }

    @Test
    public void testEqualsLineSegment() {
        LineSegment lineSegment1 = new LineSegment(1, 1, 3, 5);
        LineSegment lineSegment2 = new LineSegment(1, 1, 3, 5);
        LineSegment lineSegment3 = new LineSegment(3, 6, 5, 9);
        LineSegment lineSegment4 = new LineSegment(5, 2, 8, 0);

        assertEquals(lineSegment1, lineSegment2);
        assertNotEquals(lineSegment1, lineSegment3);
        assertNotEquals(lineSegment1, lineSegment4);
    }

}
