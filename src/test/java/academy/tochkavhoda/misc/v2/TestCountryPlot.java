package academy.tochkavhoda.misc.v2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TestCountryPlot {
    private static final double DOUBLE_EPS = 1E-6;

    @Test
    public void testCountryPlot() {
        CountryPlot plot = new CountryPlot(30, 20, true);

        assertAll(
                () -> assertEquals(30, plot.getPlotLength()),
                () -> assertEquals(20, plot.getPlotWidth()),
                () -> assertEquals(true, plot.isHasVegetableGarden())
        );
    }

    @Test
    public void testSetPlotLengthWidthAndHasVegetableGarden() {
        CountryPlot plot = new CountryPlot(30, 20, true);
        plot.setPlotLength(40);
        plot.setPlotWidth(35);
        plot.setHasVegetableGarden(false);

        assertAll(
                () -> assertEquals(40, plot.getPlotLength()),
                () -> assertEquals(35, plot.getPlotWidth()),
                () -> assertEquals(false, plot.isHasVegetableGarden())
        );
    }

    @Test
    public void testGetArea() {
        CountryPlot plot1 = new CountryPlot(30, 20, true);
        CountryPlot plot2 = new CountryPlot(30, 30, true);

        assertEquals(600, plot1.getArea(), DOUBLE_EPS);
        assertEquals(900, plot2.getArea(), DOUBLE_EPS);
    }

    @Test
    public void testEqualsShirt() {
        CountryPlot plot1 = new CountryPlot(30, 20, true);
        CountryPlot plot2 = new CountryPlot(30, 20, true);
        CountryPlot plot3 = new CountryPlot(30, 30, true);
        CountryPlot plot4 = new CountryPlot(25, 15, false);

        assertEquals(plot1, plot2);
        assertNotEquals(plot1, plot3);
        assertNotEquals(plot1, plot4);
    }
}
