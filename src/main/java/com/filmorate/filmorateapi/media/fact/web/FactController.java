package com.filmorate.filmorateapi.media.fact.web;

import com.filmorate.filmorateapi.media.fact.model.FactType;
import com.filmorate.filmorateapi.media.fact.usecase.FactUseCase;
import com.filmorate.filmorateapi.media.fact.util.FactTypeEditor;
import com.filmorate.filmorateapi.media.fact.web.dto.FactRequest;
import com.filmorate.filmorateapi.media.fact.web.dto.FactResponse;
import com.filmorate.filmorateapi.media.fact.web.dto.FactUpdateRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/facts")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class FactController {
    private final FactUseCase factUseCase;

    @InitBinder(value = "factType")
    public void initBinder(WebDataBinder dataBinder) {
        dataBinder.registerCustomEditor(FactType.class, new FactTypeEditor());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public FactResponse addFact(@RequestParam(name = "factType") FactType factType,
                                @Valid @RequestBody FactRequest request) {
        return factUseCase.createFact(factType, request);
    }

    @PutMapping(value = "{factId:\\d+}")
    public FactResponse updateFact(@PathVariable(name = "factId") Long factId,
                                   @Valid @RequestBody FactUpdateRequest request) {
        return factUseCase.updateFact(factId, request);
    }

    @GetMapping
    public List<FactResponse> getAllFactsByFactTypeAndEntityId(@RequestParam(name = "factType") FactType factType,
                                                               @RequestParam(name = "entityId") Long entityId) {
        return factUseCase.getAllFactsByFactTypeAndEntityId(factType, entityId);
    }

    @GetMapping(value = "{factId:\\d+}")
    public FactResponse getFactById(@PathVariable(name = "factId") Long factId) {
        return factUseCase.getFactById(factId);
    }

    @DeleteMapping
    public void removeAllFactsByFactTypeAndEntityId(@RequestParam(name = "factType") FactType factType,
                                                    @RequestParam(name = "entityId") Long entityId) {
        factUseCase.removeAllFactsByFactTypeAndEntityId(factType, entityId);
    }

    @DeleteMapping(value = "{factId:\\d+}")
    public void removeFactById(@PathVariable(name = "factId") Long factId) {
        factUseCase.removeFactById(factId);
    }
}
