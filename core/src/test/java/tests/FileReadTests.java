package tests;

import example.demo.Cat;
import example.serialization.Deserializer;
import example.util.FileReader;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.nio.file.Path;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FileReadTests {

    @Mock
    private FileReader fileReader;

    private Deserializer deserializer;

    @BeforeEach
    public void setUp() {
        deserializer = Mockito.spy(new Deserializer(fileReader));
    }

    @AfterEach
    public void resetMocks() {
        Mockito.reset(fileReader);
    }

    @Test
    public void returnsNull_whenFileReadFails() throws IOException {
        // arrange
        when(fileReader.readFile(any())).thenThrow(IOException.class);

        // act
        var result = deserializer.deserializeObjFile(Cat.class, Path.of("RND"));

        // assert
        verify(fileReader, times(1)).readFile(any());
        Assertions.assertNull(result);
    }

    @Test
    public void returnsNotNull_whenFileReadSucceeds() throws IOException {
        // arrange
        Cat cat = new Cat();
        when(fileReader.readFile(eq(Path.of("RND")))).thenReturn("RNDSTR");
        when(deserializer.deserializeObj(Cat.class, "RNDSTR")).thenReturn(cat);

        // act
        var result = deserializer.deserializeObjFile(Cat.class, Path.of("RND"));

        // assert
        verify(fileReader, times(1)).readFile(any());
        Assertions.assertNotNull(result);
    }
}
