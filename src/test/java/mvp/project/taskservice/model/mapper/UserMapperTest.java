package mvp.project.taskservice.model.mapper;

import mvp.project.taskservice.model.dto.UserDTO;
import mvp.project.taskservice.model.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
class UserMapperTest {

    @Test
    void userToUserDto() {
        User user = mock(User.class);
        user.setId(1L);
        user.setFullName("Sonya");
        user.setEmail("sonya@example.com");

        UserDTO userDTO = UserMapper.MAPPER.userToUserDto(user);

        assertEquals(user.getId(), userDTO.getId());
        assertEquals(user.getFullName(), userDTO.getFullName());
        assertEquals(user.getEmail(), userDTO.getEmail());
    }

    @Test
    void userDtoToUser() {
        UserDTO userDTO = mock(UserDTO.class);
        userDTO.setId(1L);
        userDTO.setFullName("Sonya");
        userDTO.setEmail("sonya@example.com");

        User user = UserMapper.MAPPER.userDtoToUser(userDTO);

        assertEquals(user.getId(), userDTO.getId());
        assertEquals(user.getFullName(), userDTO.getFullName());
        assertEquals(user.getEmail(), userDTO.getEmail());
    }
}