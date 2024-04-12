package Pegas.http.rest;

import Pegas.dto.FilterDTO;
import Pegas.dto.PageResponse;
import Pegas.dto.UserCreateEditDto;
import Pegas.dto.UserReadDTO;
import Pegas.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserRestController {
    private final UserService userService;

    @GetMapping
    public PageResponse<UserReadDTO> findAll(FilterDTO filterDTO, Pageable pageable){
        Page<UserReadDTO> page = userService.findAll(filterDTO, pageable);
        return PageResponse.of(page);
    }

    @GetMapping("/{id}")
    public UserReadDTO findById(@PathVariable("id") Long id){
        return userService.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
    @GetMapping(value = "/{id}/avatar", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public byte[] findAvatar(@PathVariable("id") Long id){
        return userService.findAvatar(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public UserReadDTO create(@Valid @RequestBody UserCreateEditDto user){
        return userService.create(user);
    }

    @PutMapping("/{id}")
    public UserReadDTO update(@PathVariable("id") Long id, @Valid @RequestBody UserCreateEditDto user){
        return userService.update(id, user)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        if (!userService.delete(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
