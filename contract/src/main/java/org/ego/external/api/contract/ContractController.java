package org.ego.external.api.contract;

import org.ego.external.application.contract.ContractDTO;
import org.ego.external.application.contract.ContractManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ContractController {
    @Autowired
    private ContractManager manager;

    @GetMapping(value = "/contract/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ContractDTO getPerson(@PathVariable Long id) {
        return manager.getContract(id);
    }
}
