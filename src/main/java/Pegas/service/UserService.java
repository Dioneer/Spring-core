package Pegas.service;

import Pegas.dto.UserCreateEditDto;
import Pegas.dao.UserRepository;
import Pegas.dto.UserReadDTO;
import Pegas.mapper.UserCreateEditMapper;
import Pegas.mapper.UserReadMapper;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class UserService {
    private final UserRepository userRepository;
    private final UserReadMapper userReadMapper;
    private final UserCreateEditMapper userCreateEditMapper;

    public List<UserReadDTO> findAll(){
        return userRepository.findAll().stream()
                .map(userReadMapper::fromTo)
                .toList();
    }
    public Optional<UserReadDTO> findById(Long id) {
        return userRepository.findById(id).map(userReadMapper::fromTo);
    }
    @Transactional
    public UserReadDTO create(UserCreateEditDto user){
        return Optional.of(user).map(userCreateEditMapper::fromTo)
                .map(userRepository::save)
                .map(userReadMapper::fromTo)
                .orElseThrow();
    }
    @Transactional
    public Optional<UserReadDTO> update(Long id, UserCreateEditDto user) {
        return userRepository.findById(id)
                .map(i->userCreateEditMapper.fromTo(user,i))
                .map(userRepository::saveAndFlush)
                .map(userReadMapper::fromTo);
    }
    @Transactional
    public boolean delete(Long id){
        return userRepository.findById(id)
                .map(i->{
                    userRepository.delete(i);
                    userRepository.flush();
                    return  true;
                }).orElse(false);
    }
}
