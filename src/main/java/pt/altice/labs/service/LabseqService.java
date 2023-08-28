package pt.altice.labs.service;

import io.quarkus.cache.CacheResult;
import lombok.extern.slf4j.Slf4j;
import pt.altice.labs.dto.LabseqResponseDTO;
import pt.altice.labs.enuns.CalculateLabSeqValue;
import pt.altice.labs.exception.NegativeNumberException;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@Slf4j
public class LabseqService {

    @CacheResult(cacheName = "recursiveValue-cache")
    public LabseqResponseDTO labseqGenerator(Integer index) {
        log.info("calling data with no cache for index {}", index);
        if (index < 0) {
            throw new NegativeNumberException("The index may be any non-negative integer number.");

        }
        return LabseqResponseDTO.builder().data(CalculateLabSeqValue.RECURSIVE.calculateValue(index)).build();
    }
}
