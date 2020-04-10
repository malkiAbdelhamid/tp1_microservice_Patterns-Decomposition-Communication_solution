package com.esi.msformation.proxy;

import com.esi.msformation.model.Etudiant;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="ms-scolarite", url = "localhost:8082")

public interface EtudiantProxy {

    @GetMapping("/etudiants/search/findEtudiantByIdFormation")
    CollectionModel<Etudiant> getLesEtudiants(@RequestParam("idf") Long idf, @RequestParam("projection") String projection);
}


