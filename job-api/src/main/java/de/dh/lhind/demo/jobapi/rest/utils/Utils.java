package de.dh.lhind.demo.jobapi.rest.utils;

import de.dh.lhind.demo.jobcore.business.dto.common.BaseClassDTO;
import de.dh.lhind.demo.jobcore.business.dto.service.constants.MessageConstants;

import java.net.URI;
import java.net.URISyntaxException;

public class Utils {

    public static <T extends BaseClassDTO> URI getUriAfterPost(T dto) throws URISyntaxException {
        return new URI("/" + objectNameWithoutDto(dto) + "/" + dto.getId());
    }

    private static <T extends BaseClassDTO> String objectNameWithoutDto(T dto) {
        String className = dto.getClass().getSimpleName();
        if(className.contains("Dto")) {
            return className.replace("Dto", "");
        }
        return className;
    }

}
