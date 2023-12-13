package derek.exemple.ticketapi.Services;

import derek.exemple.ticketapi.DTO.UserDTO;
import derek.exemple.ticketapi.DTO.UserResponse;
import derek.exemple.ticketapi.Models.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService   {
     UserDTO getUserById(int id);
     UserDTO createUser(UserDTO user);
     void deleteUserById(int id);
     UserDTO updateUser(UserDTO user, int id);
     UserResponse getAllUsers();
}
