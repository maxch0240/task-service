package mvp.project.taskservice.service;

import mvp.project.taskservice.model.dto.UserDTO;
import mvp.project.taskservice.model.entity.User;
import mvp.project.taskservice.model.mapper.UserMapper;
import mvp.project.taskservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public void saveUser(UserDTO userDTO) {
        User user = UserMapper.MAPPER.userDtoToUser(userDTO);
        userRepository.save(user);
    }

    public void saveAllUsers(List<UserDTO> userListDTO) {
        List<User> userList = userListDTO.stream()
                .map(UserMapper.MAPPER::userDtoToUser)
                .toList();
        userRepository.saveAll(userList);
    }
}
