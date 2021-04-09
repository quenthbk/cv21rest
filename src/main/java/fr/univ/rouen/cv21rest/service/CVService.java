package fr.univ.rouen.cv21rest.service;

import fr.univ.rouen.cv21rest.dto.CVDto;

import java.util.List;

public interface CVService {

    List<CVDto> getAll();

    CVDto getById(int id);

    CVDto create(CVDto cv);

    CVDto update(CVDto cv);

    void delete(int id);
}
