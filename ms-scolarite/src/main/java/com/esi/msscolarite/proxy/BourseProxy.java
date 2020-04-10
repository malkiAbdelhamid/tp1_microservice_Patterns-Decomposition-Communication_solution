package com.esi.msscolarite.proxy;

import com.esi.msscolarite.model.Virement;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "ms-bourse", url="localhost:8083")
public interface BourseProxy {

    @GetMapping("/virements/search/findVirementByEtudiant_IdEtudiant")
    public CollectionModel<Virement> getVirements(@RequestParam("ide") Long ide,
                                                  @RequestParam("projection") String projection);

}
