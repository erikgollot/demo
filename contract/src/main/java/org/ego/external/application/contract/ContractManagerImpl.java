package org.ego.external.application.contract;

import org.ego.external.application.mapper.OrikaBeanMapper;
import org.ego.external.domain.dao.contract.ContractDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ContractManagerImpl implements ContractManager{
    @Autowired
    private OrikaBeanMapper orikaBeanMapper;
    @Autowired
    private ContractDAO contractDAO;

    @Override
    public ContractDTO getContract(Long id) {
        return orikaBeanMapper.convertDTO(contractDAO.getOne(id),ContractDTO.class);
    }
}
