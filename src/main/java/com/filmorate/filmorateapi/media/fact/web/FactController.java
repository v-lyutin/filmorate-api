package com.filmorate.filmorateapi.media.fact.web;

import com.filmorate.filmorateapi.media.fact.usecase.FactUseCase;
import com.filmorate.filmorateapi.media.fact.web.dto.FactAddRequest;
import com.filmorate.filmorateapi.media.fact.web.dto.FactResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/persons")
public class FactController {
    private final FactUseCase factUseCase;

    @PostMapping(value = "/{personId}/facts")
    @ResponseStatus(HttpStatus.CREATED)
    public FactResponse addFact(
            @PathVariable(name = "personId") Long personId,
            @Valid @RequestBody FactAddRequest request) {
        return factUseCase.addFact(personId, request);
    }
}
