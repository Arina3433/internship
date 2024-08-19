package academy.tochkavhoda.misc.v2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestShirt {
    @Test
    public void testShirt() {
        Shirt shirt = new Shirt(1, 'M', "cotton");

        assertAll(
                () -> assertEquals(1, shirt.getColor()),
                () -> assertEquals('M', shirt.getSize()),
                () -> assertEquals("cotton", shirt.getMaterial())
        );
    }

    @Test
    public void testSetColorSizeAndMaterial() {
        Shirt shirt = new Shirt(1, 'M', "cotton");
        shirt.setColor(2);
        shirt.setSize('S');
        shirt.setMaterial("linen");

        assertAll(
                () -> assertEquals(2, shirt.getColor()),
                () -> assertEquals('S', shirt.getSize()),
                () -> assertEquals("linen", shirt.getMaterial())
        );
    }

    @Test
    public void testEqualsShirt() {
        Shirt shirt1 = new Shirt(1, 'M', "cotton");
        Shirt shirt2 = new Shirt(1, 'M', "cotton");
        Shirt shirt3 = new Shirt(2, 'S', "linen");
        Shirt shirt4 = new Shirt(1, 'S', "polyester");

        assertEquals(shirt1, shirt2);
        assertNotEquals(shirt1, shirt3);
        assertNotEquals(shirt1, shirt4);
    }
}
