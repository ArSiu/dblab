package org.arsiu.rest.dao;

import org.arsiu.rest.models.Parcel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParcelRepository extends JpaRepository<Parcel,Integer> {
}
