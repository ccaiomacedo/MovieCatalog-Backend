package com.caiodev.moviecatalog.util;

import com.caiodev.moviecatalog.dto.UserDTO;
import com.caiodev.moviecatalog.services.exceptions.MaxProfileException;

public class ProfileLimit {

    public static void maxLimit(UserDTO userDto) {
        if (userDto.getPlan() == 1 && userDto.getProfiles().size() == 2) {
            throw new MaxProfileException("you are only allowed to create two profiles!");
        }else if (userDto.getPlan() == 2 && userDto.getProfiles().size() == 4) {
            throw new MaxProfileException("you are only allowed to create four profiles!");
        }
    }

}
