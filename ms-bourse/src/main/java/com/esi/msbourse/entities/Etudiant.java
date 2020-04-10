package com.esi.msbourse.entities;

import com.esi.msbourse.model.EtudiantScolarite;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Etudiant {
    @Id
    private Long idEtudiant;

    private Long nCompteCCP;
    private Float salaireParant;
    private Boolean situationImpot;

    @JsonIgnore
    @OneToMany(mappedBy = "etudiant")
    List<Virement> virements;

    @Transient
    EtudiantScolarite etudiantScolarite;
}
