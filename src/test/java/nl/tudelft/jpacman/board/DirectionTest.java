package nl.tudelft.jpacman.board;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/**
 * Additional test cases for the Direction class to verify
 * the movement deltas for different directions.
 */
public class DirectionTest {

    /**
     * Test for NORTH direction: it should move delta Y by -1.
     */
    @Test
    void testNorth() {
        Direction north = Direction.valueOf("NORTH");
        assertThat(north.getDeltaY()).isEqualTo(-1);
        assertThat(north.getDeltaX()).isEqualTo(0); // Additional check for X delta
    }

    /**
     * Test for SOUTH direction: it should move delta Y by +1.
     */
    @Test
    void testSouth() {
        Direction south = Direction.valueOf("SOUTH");
        assertThat(south.getDeltaY()).isEqualTo(1);
        assertThat(south.getDeltaX()).isEqualTo(0); // X delta should remain 0
    }

    /**
     * Test for EAST direction: it should move delta X by +1.
     */
    @Test
    void testEast() {
        Direction east = Direction.valueOf("EAST");
        assertThat(east.getDeltaX()).isEqualTo(1);
        assertThat(east.getDeltaY()).isEqualTo(0); // Y delta should remain 0
    }

    /**
     * Test for WEST direction: it should move delta X by -1.
     */
    @Test
    void testWest() {
        Direction west = Direction.valueOf("WEST");
        assertThat(west.getDeltaX()).isEqualTo(-1);
        assertThat(west.getDeltaY()).isEqualTo(0); // Y delta should remain 0
    }
}
