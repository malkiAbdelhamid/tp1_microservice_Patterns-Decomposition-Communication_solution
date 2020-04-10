package com.esi.msbourse.api_controller;

import com.esi.msbourse.dao.EtudiantRepository;
import com.esi.msbourse.entities.Etudiant;
import com.esi.msbourse.proxy.ScolariteProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class BourseAPI {

    @Autowired
    EtudiantRepository etudiantRepository;

    @Autowired
    ScolariteProxy scolariteProxy;

    @GetMapping("/etudiant/{id}")
    Etudiant getEtudiantWithScolartirte(@PathVariable("id") Long id)
    {
        Etudiant etudiant=etudiantRepository.findById(id).get();
        etudiant.setEtudiantScolarite(scolariteProxy.getEtudiantScolarite(id,"tobourse"));
  return etudiant;
    }
}
