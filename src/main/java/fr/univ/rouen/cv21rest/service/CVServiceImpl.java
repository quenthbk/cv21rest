package fr.univ.rouen.cv21rest.service;

import fr.univ.rouen.cv21rest.dto.CVDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CVServiceImpl implements CVService {

    @Override
    public List<CVDto> getAll() {
        return null;
    }

    @Override
    public CVDto getById(int id) {
        CVDto cv = new CVDto();
        cv.setId(id);
        cv.setNom("Nom");
        cv.setPrenom("Prenom");
        cv.setDate("2021-03-14");
        cv.setMel("test@test.com");
        return cv;
    }

    @Override
    public CVDto create(CVDto cv) {
        return cv;
    }

    @Override
    public CVDto update(CVDto cv) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
