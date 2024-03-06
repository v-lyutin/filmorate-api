package com.filmorate.filmorateapi.media.fact.web;

import com.filmorate.filmorateapi.media.fact.usecase.FactUseCase;
import com.filmorate.filmorateapi.media.fact.web.dto.FactRequest;
import com.filmorate.filmorateapi.media.fact.web.dto.FactResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/persons")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class FactController {
    private final FactUseCase factUseCase;

    @GetMapping(value = "{personId:\\d+}/facts")
    public List<FactResponse> getFactsByPersonId(@PathVariable(name = "personId") Long personId) {
        return factUseCase.getFactsByPersonId(personId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "{personId:\\d+}/facts")
    public FactResponse addFact(
            @PathVariable(name = "personId") Long personId,
            @Valid @RequestBody FactRequest request) {
        return factUseCase.addFact(personId, request);
    }

    @PutMapping(value = "{personId:\\d+}/facts/{factId:\\d+}")
    public FactResponse editFact(
            @PathVariable(name = "personId") Long personId,
            @PathVariable(name = "factId") Long factId,
            @Valid @RequestBody FactRequest request) {
        return factUseCase.editFact(personId, factId, request);
    }

    @DeleteMapping(value = "{personId:\\d+}/facts/{factId:\\d+}")
    public void removeFact(@PathVariable(name = "personId") Long personId,
                           @PathVariable(name = "factId") Long factId) {
        factUseCase.removeFact(personId, factId);
    }

    @DeleteMapping(value = "/{personId:\\d+}/facts")
    public void removeFact(@PathVariable(name = "personId") Long personId) {
        factUseCase.removeAllFactsByPersonId(personId);
    }
}
