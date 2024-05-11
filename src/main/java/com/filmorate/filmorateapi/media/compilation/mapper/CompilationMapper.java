package com.filmorate.filmorateapi.media.compilation.mapper;

import com.filmorate.filmorateapi.media.compilation.model.Compilation;
import com.filmorate.filmorateapi.media.compilation.web.dto.request.CompilationCreationRequest;
import com.filmorate.filmorateapi.media.compilation.web.dto.request.CompilationUpdateRequest;
import com.filmorate.filmorateapi.media.compilation.web.dto.response.CompilationPageResponse;
import com.filmorate.filmorateapi.media.compilation.web.dto.response.CompilationResponse;
import org.springframework.data.domain.Page;

public interface CompilationMapper {
    Compilation toCompilation(CompilationCreationRequest request);

    CompilationResponse toCompilationResponse(Compilation compilation);

    CompilationPageResponse toCompilationPageResponse(Page<Compilation> pageableCompilations);

    void update(Compilation compilation, CompilationUpdateRequest request);
}
