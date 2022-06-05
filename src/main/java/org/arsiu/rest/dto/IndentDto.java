package org.arsiu.rest.dto;

import org.arsiu.rest.models.*;

public class IndentDto {

    private Indent indent;

    public IndentDto(Indent indent) {
        this.indent = indent;
    }

    public Integer getId() {
        return indent.getId();
    }

    public PostOffice getPostOfficeFromId() {
        return indent.getPostOfficeFromId();
    }

    public PostOffice getPostOfficeToId() {
        return indent.getPostOfficeToId();
    }

    public Client getClientBySenderId() {
        return indent.getClientBySenderId();
    }

    public Client getClientByReciverId() {
        return indent.getClientByReciverId();
    }

    public Parcel getParcelId() {
        return indent.getParcelId();
    }

    public Delivery getDeliveryByDeliveryId() {
        return indent.getDeliveryByDeliveryId();
    }

    public String getStatus() {
        return indent.getStatus();
    }
}
