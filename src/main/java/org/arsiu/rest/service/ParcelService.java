package org.arsiu.rest.service;

import org.arsiu.rest.dao.ParcelRepository;
import org.arsiu.rest.models.Parcel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.List;

@Service
@ApplicationScope
public class ParcelService {

    @Autowired
    private ParcelRepository parcelRepository;

    public Parcel addParcel(final Parcel parcel) {
        return parcelRepository.save(parcel);
    }

    public Parcel updateParcel(final Parcel parcel) {
        return parcelRepository.save(parcel);
    }

    public List<Parcel> getParcels() {
        return parcelRepository.findAll();
    }

    public Parcel getParcelById(final Integer id) {
        return parcelRepository.findById(id).orElse(null);
    }

    public void deleteParcelById(final Integer id) {
        parcelRepository.deleteById(id);
    }
}
