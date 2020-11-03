package com.groupeidyal.dgid.service.impl;

import com.groupeidyal.dgid.domain.Contribuable;
import com.groupeidyal.dgid.domain.Infraction;
import com.groupeidyal.dgid.domain.Proposition;
import com.groupeidyal.dgid.dto.AccountDto;
import com.groupeidyal.dgid.dto.AdresseDto;
import com.groupeidyal.dgid.dto.ConfirmationRedressementDto;
import com.groupeidyal.dgid.dto.InfractionDto;
import com.groupeidyal.dgid.repository.ContribuableRepository;
import com.groupeidyal.dgid.repository.ControleRepository;
import com.groupeidyal.dgid.repository.InfractionRepository;
import com.groupeidyal.dgid.repository.PropositionRepository;
import com.groupeidyal.dgid.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.groupeidyal.dgid.domain.*;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@Transactional
public class ConfirmationRedressementServiceImpl implements ConfirmationRedressementService {
    private final ControleRepository controleRepository;
    private final InfractionRepository infractionRepository;
    private final PropositionRepository propositionRepository;
    private final ContribuableRepository contribuableRepository;

    @Autowired
    public ConfirmationRedressementServiceImpl(ControleRepository controleRepository,
                                               InfractionRepository infractionRepository,
                                               PropositionRepository propositionRepository,
                                               ContribuableRepository contribuableRepository){
        this.controleRepository = controleRepository;
        this.infractionRepository = infractionRepository;
        this.propositionRepository = propositionRepository;
        this.contribuableRepository = contribuableRepository;

    }
    @Override
    public ConfirmationRedressementDto findConfirmationRedressementByControleuid(String externalid) {
        List<Infraction> list = infractionRepository.infractionByControle(controleRepository.findByExternalId(externalid).getId());
        List<InfractionDto> listInfrationDtos = InfractionDto.parse(list);
        System.out.print("listInfractionsdto"+ listInfrationDtos);
        Proposition prop = propositionRepository.findById(controleRepository.findByExternalId(externalid).getLinkedProposition().getId());
        System.out.print("proposition"+ prop);
        Contribuable cb = contribuableRepository.findById(prop.getContribuable().getId());
        System.out.print("contribuable"+ cb);
        String nomSociete = cb.getNom();
        AdresseDto adresseSocietedto = AdresseDto.parse(cb.getAdresse());
        com.groupeidyal.dgid.domain.Service serviceParent = controleRepository.findByExternalId(externalid).getService();
        System.out.print("serviceParent"+ serviceParent);
        String nomServiceParent = serviceParent.getNom();
        System.out.print("nomServiceParent"+ nomServiceParent);
        String nomserviceGrandParent = serviceParent.getParent().getNom();
        System.out.print("nomServiceGrandParent"+ nomserviceGrandParent);
        ArrayList<AccountDto> verificateurs = new ArrayList<AccountDto>();
        Collection<ControleAgent> lisControleAgents = controleRepository.findByExternalId(externalid).getControleAgentCollection();
        System.out.print("listControleAgent"+ lisControleAgents);
        lisControleAgents.forEach((ControleAgent controelAgent) -> {
            AccountDto accountDto = AccountDto.parse(controelAgent.getControle().getLinkedAgent());
            System.out.print("acc"+ accountDto);
            verificateurs.add(accountDto);
        });
        System.out.print("verificateurs"+ verificateurs);

        ConfirmationRedressementDto confirmationRedressementDto
                = new ConfirmationRedressementDto(listInfrationDtos,
                                                  nomServiceParent,
                                                  nomserviceGrandParent,
                                                  nomSociete,
                                                  adresseSocietedto,
                                                    "",
                                                    "",
                                                    "",
                                                  verificateurs,
                                                 "");


        return confirmationRedressementDto;
    }
}
