package org.arsiu.rest.service;

import org.arsiu.rest.dal.DeliveryRepository;
import org.arsiu.rest.dal.IndentRepository;
import org.arsiu.rest.models.Delivery;
import org.arsiu.rest.models.Indent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.List;

@Service
@ApplicationScope
public class IndentService {

    @Autowired
    private IndentRepository indentRepository;

    public Indent addIndent(final Indent indent) {
        return indentRepository.save(indent);
    }

    public Indent updateIndent(final Indent indent) {
        return indentRepository.save(indent);
    }

    public List<Indent> getIndents() {
        return indentRepository.findAll();
    }

    public Indent getIndentById(final Integer id) {
        return indentRepository.findById(id).orElse(null);
    }

    public void deleteIndentById(final Integer id) {
        indentRepository.deleteById(id);
    }
}
