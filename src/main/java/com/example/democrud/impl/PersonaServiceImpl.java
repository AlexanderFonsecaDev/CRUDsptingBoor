package com.example.democrud.impl;

import com.example.democrud.commons.GenericServiceImpl;
import com.example.democrud.dao.api.PersonaDaoAPI;
import com.example.democrud.model.Persona;
import com.example.democrud.service.api.PersonaServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonaServiceImpl extends GenericServiceImpl<Persona,Long> implements PersonaServiceAPI
{

    @Autowired
    private PersonaDaoAPI personaDaoAPI;

    @Override
    public CrudRepository<Persona, Long> getDao() {
        return personaDaoAPI;
    }
}
