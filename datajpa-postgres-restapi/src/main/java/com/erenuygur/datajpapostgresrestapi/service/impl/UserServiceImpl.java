package com.erenuygur.datajpapostgresrestapi.service.impl;

import com.erenuygur.datajpapostgresrestapi.dto.UserDto;
import com.erenuygur.datajpapostgresrestapi.entity.User;
import com.erenuygur.datajpapostgresrestapi.entity.UserAddress;
import com.erenuygur.datajpapostgresrestapi.repository.UserAddressRepository;
import com.erenuygur.datajpapostgresrestapi.repository.UserRepository;
import com.erenuygur.datajpapostgresrestapi.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserAddressRepository userAddressRepository;

    @Override
    @Transactional
    public UserDto save(UserDto userDto) {
        Assert.notNull(userDto.getName(), "Name is required");
        User user = new User();
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());

        final User registeredUser = userRepository.save(user);

        List<UserAddress> addressList = new ArrayList<>();

        userDto.getUserAddresses().forEach(userDtoAddress-> {
            UserAddress userAddress = new UserAddress();
            userAddress.setAddress(userDtoAddress);
            userAddress.setAddressType(UserAddress.AddressType.OTHER);
            userAddress.setIsActive(true);
            userAddress.setUser(registeredUser);

            addressList.add(userAddress);
        });

        userAddressRepository.saveAll(addressList);

        userDto.setId(registeredUser.getId());

        return userDto;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<UserDto> getAll() {
        List<User> userList = userRepository.findAll();
        List<UserDto> userDtoList = new ArrayList<>();

        userList.forEach(user -> {
            UserDto userDto = new UserDto();
            userDto.setId(user.getId());
            userDto.setName(user.getName());
            userDto.setSurname(user.getSurname());
            userDto.setUserAddresses(user.getUserAddresses().stream()
                    .map(UserAddress::getAddress).collect(Collectors.toList()));

            userDtoList.add(userDto);
        });

        return userDtoList;
    }

    @Override
    public Page<UserDto> getAll(Pageable pageable) {
        return null;
    }
}
