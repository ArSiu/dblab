package org.arsiu.rest.dto;

import org.arsiu.rest.models.PostOffice;

public class PostOfficeDto {
    private PostOffice postOffice;

    public PostOfficeDto(PostOffice postOffice) {
        this.postOffice = postOffice;
    }

    public Integer getId() {
        return postOffice.getId();
    }

    public String getName() {
        return postOffice.getName();
    }

    public String getCity() {
        return postOffice.getCity();
    }

    public String getAddress() {
        return postOffice.getAddress();
    }
}
