package academy.tochkavhoda.figures.v3;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CircleFactoryTest {
    @BeforeEach
    public void setUp() {
        CircleFactory.reset();
    }

    @AfterEach
    public void tearDown() {
        CircleFactory.reset();
    }


    @Test
    public void testCreateCircle() {
        Point center = new Point(1, 1);
        int radius = 1;

        Circle circle = CircleFactory.createCircle(center, radius);

        assertNotNull(circle);
        assertEquals(center, circle.getCenter());
        assertEquals(radius, circle.getRadius());

        assertEquals(1, CircleFactory.getCircleCount());
    }

    @Test
    public void testCreateMultipleCircles() {
        Point center1 = new Point(1, 1);
        int radius1 = 1;
        Point center2 = new Point(2, 2);
        int radius2 = 2;

        CircleFactory.createCircle(center1, radius1);
        CircleFactory.createCircle(center2, radius2);

        assertEquals(2, CircleFactory.getCircleCount());
    }

    @Test
    public void testReset() {
        Point center = new Point(1, 1);
        int radius = 1;

        CircleFactory.createCircle(center, radius);
        assertEquals(1, CircleFactory.getCircleCount());

        CircleFactory.reset();

        assertEquals(0, CircleFactory.getCircleCount());
    }

    @Test
    public void testResetMultipleTimes() {
        Point center = new Point(1, 1);
        int radius = 1;

        CircleFactory.createCircle(center, radius);
        assertEquals(1, CircleFactory.getCircleCount());

        CircleFactory.reset();
        assertEquals(0, CircleFactory.getCircleCount());

        CircleFactory.createCircle(center, radius);
        assertEquals(1, CircleFactory.getCircleCount());

        CircleFactory.reset();
        assertEquals(0, CircleFactory.getCircleCount());
    }
}
