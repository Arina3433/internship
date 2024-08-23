package academy.tochkavhoda.misc.v3;

import academy.tochkavhoda.colors.v3.Color;
import academy.tochkavhoda.colors.v3.ColorErrorCode;
import academy.tochkavhoda.colors.v3.ColorException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestShirt {
    @Test
    public void testShirt1() throws ColorException {
        Shirt shirt = new Shirt(Color.RED, 'M', "cotton");

        assertAll(
                () -> assertEquals(Color.RED, shirt.getColor()),
                () -> assertEquals('M', shirt.getSize()),
                () -> assertEquals("cotton", shirt.getMaterial())
        );
    }

    @Test
    public void testShirt2() throws ColorException {
        Shirt shirt = new Shirt("RED", 'M', "cotton");

        assertAll(
                () -> assertEquals(Color.RED, shirt.getColor()),
                () -> assertEquals('M', shirt.getSize()),
                () -> assertEquals("cotton", shirt.getMaterial())
        );
    }

    @Test
    public void testSetColorSizeAndMaterial() throws ColorException {
        Shirt shirt = new Shirt(Color.RED, 'M', "cotton");
        shirt.setColor(Color.GREEN);
        shirt.setSize('S');
        shirt.setMaterial("linen");

        assertAll(
                () -> assertEquals(Color.GREEN, shirt.getColor()),
                () -> assertEquals('S', shirt.getSize()),
                () -> assertEquals("linen", shirt.getMaterial())
        );
    }

    @Test
    @SuppressWarnings("unused")
    public void testSetWrongColor() {
        try {
            new Shirt("YELLOW", 'M', "cotton");
            fail();
        } catch (ColorException ex) {
            assertEquals(ColorErrorCode.WRONG_COLOR_STRING, ex.getErrorCode());
        }
        try {
            new Shirt((String) null, 'M', "cotton");
            fail();
        } catch (ColorException ex) {
            assertEquals(ColorErrorCode.NULL_COLOR, ex.getErrorCode());
        }
        try {
            new Shirt((Color) null, 'M', "cotton");
            fail();
        } catch (ColorException ex) {
            assertEquals(ColorErrorCode.NULL_COLOR, ex.getErrorCode());
        }
        try {
            Shirt shirt = new Shirt(Color.RED, 'M', "cotton");
            shirt.setColor("YELLOW");
            fail();
        } catch (ColorException ex) {
            assertEquals(ColorErrorCode.WRONG_COLOR_STRING, ex.getErrorCode());
        }
        try {
            Shirt shirt = new Shirt(Color.RED, 'M', "cotton");
            shirt.setColor((Color) null);
            fail();
        } catch (ColorException ex) {
            assertEquals(ColorErrorCode.NULL_COLOR, ex.getErrorCode());
        }
        try {
            Shirt shirt = new Shirt(Color.RED, 'M', "cotton");
            shirt.setColor((String) null);
            fail();
        } catch (ColorException ex) {
            assertEquals(ColorErrorCode.NULL_COLOR, ex.getErrorCode());
        }
    }

    @Test
    public void testEqualsShirt() throws ColorException {
        Shirt shirt1 = new Shirt(Color.GREEN, 'M', "cotton");
        Shirt shirt2 = new Shirt(Color.GREEN, 'M', "cotton");
        Shirt shirt3 = new Shirt(Color.BLUE, 'S', "linen");
        Shirt shirt4 = new Shirt(Color.RED, 'S', "polyester");

        assertEquals(shirt1, shirt2);
        assertNotEquals(shirt1, shirt3);
        assertNotEquals(shirt1, shirt4);
    }
}
