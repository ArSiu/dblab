package org.arsiu.rest.dao;

import org.arsiu.rest.models.PostOffice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostOfficeRepository extends JpaRepository<PostOffice,Integer> {
}
