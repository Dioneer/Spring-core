package Pegas.dao;

import Pegas.dto.FilterDTO;
import Pegas.entity.User;

import java.util.List;

public interface FilterUserRepository {
    List<User> findAllByFilter(FilterDTO filter);
}
