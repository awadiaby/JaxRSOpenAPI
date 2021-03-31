package fr.istic.taa.jaxrs.dto;

import fr.istic.taa.jaxrs.domain.Fiche;
import fr.istic.taa.jaxrs.domain.Section;
import fr.istic.taa.jaxrs.domain.TypeSection;

import java.util.ArrayList;
import java.util.List;

import static fr.istic.taa.jaxrs.dto.FicheDTO.fromFiche;

public class SectionDTO {
    private String status;
    private List<FicheDTO> fiches = new ArrayList<>();

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<FicheDTO> getFiches() {
        return fiches;
    }

    public void setFiches(List<FicheDTO> fiches) {
        this.fiches = fiches;
    }

    public static SectionDTO fromSection(Section section) {
        SectionDTO dto = new SectionDTO();
        dto.setStatus(section.getStatus().toString());
        List<FicheDTO> dtoFiches = new ArrayList<>();
        for (Fiche fiche: section.getFiches()) {
            dtoFiches.add(fromFiche(fiche));
        }
        dto.setFiches(dtoFiches);
        return dto;
    }
}
