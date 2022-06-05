package org.arsiu.rest.dao;

import org.arsiu.rest.models.Client;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ClientRepository extends JpaRepository<Client,Integer> {

}