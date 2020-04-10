package com.esi.msbourse.entities;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import java.util.Date;

@Projection(name = "toscolarite", types= Virement.class)
public interface VirementProjection {

    @Value("#{target.idVirement}")
    public Long getIdVirement();

    @Value("#{target.dateVirement}")
    public Date getDateVirement();

    @Value("#{target.etudiant.nCompteCCP}")
    public Long getNCompteCCP();
}
