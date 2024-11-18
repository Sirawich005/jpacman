package nl.tudelft.jpacman.level;

import nl.tudelft.jpacman.board.BoardFactory;
import nl.tudelft.jpacman.board.Square;
import nl.tudelft.jpacman.level.LevelFactory;
import nl.tudelft.jpacman.level.MapParser;
import nl.tudelft.jpacman.npc.ghost.Blinky;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

/**
 * This is a test class for MapParser.
 */
@ExtendWith(MockitoExtension.class)
public class MapParserTest {

    @Mock
    private BoardFactory boardFactory;

    @Mock
    private LevelFactory levelFactory;

    @Mock
    private Blinky blinky;

    /**
     * Test for the parseMap method (good map).
     */
    @Test
    public void testParseMapGood() {
        Assertions.assertNotNull(boardFactory);
        Assertions.assertNotNull(levelFactory);

        // Stub the createGhost() method to return the mock Blinky
        Mockito.when(levelFactory.createGhost()).thenReturn(blinky);

        // Create a MapParser instance
        MapParser mapParser = new MapParser(levelFactory, boardFactory);

        // Define a correctly formatted map
        ArrayList<String> map = new ArrayList<>();
        map.add("############");
        map.add("#P        G#");
        map.add("############");

        // Parse the map
        mapParser.parseMap(map);

        // Verify that the createGhost() method is called once
        Mockito.verify(levelFactory, Mockito.times(1)).createGhost();

        // Additional verifications
        Mockito.verify(boardFactory, Mockito.times(1)).createBoard(Mockito.any());
    }

    /**
     * Test for the parseMap method (bad map).
     */
    @Test
    public void testParseMapWrong1() {
        // Expect a specific exception
        RuntimeException thrown = Assertions.assertThrows(RuntimeException.class, () -> {
            Assertions.assertNotNull(boardFactory);
            Assertions.assertNotNull(levelFactory);

            // Create MapParser
            MapParser mapParser = new MapParser(levelFactory, boardFactory);

            // Define a malformed map (e.g., inconsistent row sizes or invalid characters)
            ArrayList<String> map = new ArrayList<>();
            map.add("############");
            map.add("#P   G   $ #"); // Invalid character ($)
            map.add("###########");   // Different size

            // Attempt to parse the malformed map
            mapParser.parseMap(map);
        });

        // Verify the exception message
        Assertions.assertEquals("Invalid map format", thrown.getMessage());
    }
}
