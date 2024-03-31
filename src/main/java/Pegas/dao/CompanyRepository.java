package Pegas.dao;

import Pegas.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Integer>{

    @Query("select c from Company c join fetch c.locales cl where c.nameCompany = :nameCompany")
    Optional<Company> findByNameCompany(String nameCompany);
//    @Param("name") для изменения названия переменной
    List<Company> findAllByNameCompanyContainingIgnoreCase(String fragment);
}
