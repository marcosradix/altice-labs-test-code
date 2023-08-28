package pt.altice.labs.service;

import org.apache.commons.lang3.math.NumberUtils;
import pt.altice.labs.dto.LabseqResponseDTO;
import pt.altice.labs.enuns.CalculateLabSeqValue;
import pt.altice.labs.exception.NegativeNumberException;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class LabseqService {

    public LabseqResponseDTO labseqGenerator(Integer index) {
        if (index < 0) {
            throw new NegativeNumberException("The index may be any non-negative integer number.");

        }
        return LabseqResponseDTO.builder().data(CalculateLabSeqValue.RECURSIVE.calculateValue(index)).build();
    }
}
