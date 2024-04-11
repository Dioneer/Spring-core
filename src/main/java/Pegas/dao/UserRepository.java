package Pegas.dao;

import Pegas.dto.FilterDTO;
import Pegas.dto.IPersonalInfo;
import Pegas.entity.*;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long>, FilterUserRepository, QuerydslPredicateExecutor<User> {
    @Query("select u from User u where u.firstname like %:firstname% and u.lastname like %:lastname%")
    List<User> findAllByFirstnameContainingAndLastnameContaining(String firstname, String lastname);

    @Modifying(clearAutomatically = true)
    @Query("update User u set u.role = :role where u.id in (:ids)")
    int updateRole(Role role, Long... ids);

    @Query(value = "select  u.firstname, u.lastname, u.birthday_date from users u where company_id = :companyId", nativeQuery = true)
    List<IPersonalInfo> findAllByCompanyId(Integer companyId);

    Optional<User> findFirstByCompanyIsNotNullOrderByIdDesc();

    List<User> findFirst3By(Sort sort);

    Slice<User> findAllBy(Pageable pageable);

    List<User> findAllByFilter(FilterDTO filter);
}
