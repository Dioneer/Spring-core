package Pegas.dao;

import Pegas.dto.FilterDTO;
import Pegas.dto.QPredicates;
import Pegas.entity.QUser;
import Pegas.entity.User;
import com.querydsl.core.types.dsl.SimplePath;
import com.querydsl.jpa.impl.JPAQuery;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.Predicate;
import lombok.RequiredArgsConstructor;
import static Pegas.entity.QUser.user;
//
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class FilterUserRepositoryImpl implements FilterUserRepository{
    private final EntityManager entityManager;

    @Override
    public List<User> findAllByFilter(FilterDTO filter) {
        var predicate = QPredicates.builder()
                .add(filter.getFirstname(), user.firstname::containsIgnoreCase)
                .add(filter.getLastname(), user.lastname::containsIgnoreCase)
                .add(filter.getBirthday(), user.birthday::before)
                .build();
        return new JPAQuery<User>(entityManager)
                .select(user)
                .from(user)
                .where(predicate)
                .fetch();
    }

//
//    @Override
//    public List<User> findAllByFilter(FilterDTO filter) {
//        var cb = entityManager.getCriteriaBuilder();
//        var criteria = cb.createQuery(User.class);
//        var user = criteria.from(User.class);
//        criteria.select(user);
//
//        List<Predicate> predicates = new ArrayList<>();
//        if(filter.getFirstName() != null && !filter.getFirstName().isBlank()){
//            predicates.add(cb.like(user.get("firstname"), filter.getFirstName()));
//        }
//        if(filter.getLastname() != null && !filter.getLastname().isBlank()){
//            predicates.add(cb.like(user.get("lastname"), filter.getLastname()));
//        }
//        if(filter.getBirthday() != null){
//            predicates.add(cb.lessThan(user.get("birthday"), filter.getBirthday().birthday()));
//        }
//        criteria.where(predicates.toArray(jakarta.persistence.criteria.Predicate[]::new));
//        return entityManager.createQuery(criteria).getResultList();
//    }
}
