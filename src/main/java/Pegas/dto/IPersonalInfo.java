package Pegas.dto;

import Pegas.entity.Birthday;

public interface IPersonalInfo {
    String getFirstName();
    String getLastname();
    Birthday birthday();
}
