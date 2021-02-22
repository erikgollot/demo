package org.ego.external.infrastructure.external.person;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name="PERSON-REPOSITORY")
public interface PersonExternalService {

    @RequestMapping(value = "/api/person/{personExternalId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    PersonEXT findPersonById(@PathVariable Long personExternalId);

    @RequestMapping(value = "/api/person/{personExternalId}/mainAddress", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    AddressEXT findMainAddressOf(@PathVariable Long personExternalId);
}
