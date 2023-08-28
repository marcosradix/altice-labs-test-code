package pt.altice.labs.service;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import org.junit.jupiter.api.Test;
import pt.altice.labs.dto.LabseqResponseDTO;
import pt.altice.labs.exception.NegativeNumberException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@QuarkusTest
public class LabseqServiceTest {
    @InjectMock
    private LabseqService labseqService;


    @Test
    void labseqGenerator_ValidIndex_ReturnsResponseDTO() {
        int index = 10;
        int expectedResult = 3;

        LabseqResponseDTO labseqResponseDTO = LabseqResponseDTO.builder().data(expectedResult).build();

        when(labseqService.labseqGenerator(index)).thenReturn(labseqResponseDTO);

        LabseqResponseDTO result = labseqService.labseqGenerator(index);

        assertNotNull(result);
        assertEquals(expectedResult, result.getData());
    }

    @Test
    void labseqGenerator_NegativeIndex_ThrowsException() {
        int negativeIndex = -1;
        when(labseqService.labseqGenerator(negativeIndex))
                .thenThrow(new NegativeNumberException("The index may be any non-negative integer number."));

        assertThrows(NegativeNumberException.class, () -> labseqService.labseqGenerator(negativeIndex));

    }
}