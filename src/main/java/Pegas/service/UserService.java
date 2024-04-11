package Pegas.service;

import Pegas.dto.*;
import Pegas.dao.UserRepository;
import Pegas.entity.User;
import Pegas.mapper.UserCreateEditMapper;
import Pegas.mapper.UserReadMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static Pegas.entity.QUser.user;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class UserService {
    private final UserRepository userRepository;
    private final UserReadMapper userReadMapper;
    private final UserCreateEditMapper userCreateEditMapper;
    private final ImageService imageService;

    public List<UserReadDTO> findAll(){
        return userRepository.findAll().stream()
                .map(userReadMapper::fromTo)
                .toList();
    }
    public Page<UserReadDTO> findAll(FilterDTO filter, Pageable pageable){
        var predicate = QPredicates.builder()
//                .add(filter.getFirstname(), user.firstname::containsIgnoreCase)
//                .add(filter.getLastname(), user.lastname::containsIgnoreCase)
//                .add(filter.getBirthday(), user.birthday::before)
                .build();

        return userRepository.findAll(predicate, pageable)
                .map(userReadMapper::fromTo);
    }
    public List<UserReadDTO> findAll(FilterDTO filter){
        return userRepository.findAllByFilter(filter).stream()
                .map(userReadMapper::fromTo)
                .toList();
    }
    public Optional<UserReadDTO> findById(Long id) {
        return userRepository.findById(id).map(userReadMapper::fromTo);
    }

    @Transactional
    public UserReadDTO create(UserCreateEditDto userDto){
        return Optional.of(userDto)
                .map(dto -> {uploadImage(dto.getImage());
                    return userCreateEditMapper.fromTo(userDto, new User());})
                .map(userReadMapper::fromTo)
                .orElseThrow();
    }
    @SneakyThrows
    private void uploadImage(MultipartFile image) {
        if(!image.isEmpty()){
            imageService.upload(image.getOriginalFilename(), image.getInputStream());
        }
    }

    @Transactional
    public Optional<UserReadDTO> update(Long id, UserCreateEditDto user) {
        return userRepository.findById(id)
                .map(dto -> {uploadImage(user.getImage());
                    return userCreateEditMapper.fromTo(user, new User());})
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
