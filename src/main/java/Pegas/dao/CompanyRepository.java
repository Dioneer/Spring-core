package Pegas.dao;

import Pegas.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Integer>{
}
