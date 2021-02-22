package org.ego.external.domain.dao.contract;

import org.ego.external.domain.model.contract.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractDAO extends JpaRepository<Contract,Long> {
}
