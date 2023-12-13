package derek.exemple.ticketapi.Services.ServicesImpl;

import derek.exemple.ticketapi.DTO.UserDTO;
import derek.exemple.ticketapi.DTO.UserResponse;
import derek.exemple.ticketapi.Errors.EntityNotFoundError;
import derek.exemple.ticketapi.Models.User;
import derek.exemple.ticketapi.Repository.UserRepository;
import derek.exemple.ticketapi.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDTO getUserById(int id) {
        User getUser = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundError("l'utilisateur avec l'id " + id + " n'existe pas"));
        return mapToDto(getUser);
    }

    @Override
    public UserDTO createUser(UserDTO user)  {
        User newUser = User.builder().contact(user.getContact()).prenom(user.getPrenom()).nom(user.getNom()).type(user.getType()).email(user.getEmail()).build();
        userRepository.save(newUser);
        return user;
    }

    @Override
    public void deleteUserById(int id) {
        User user = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundError("l'utlisateur avec l'id : " + id + "n'existe pas"));
        userRepository.delete(user);
    }

    @Override
    public UserDTO updateUser(UserDTO user, int id) {
       User findUser = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundError("l'utlisateur avec l'id : " + id + "n'existe pas"));
        return mapToDto(findUser);
    }

    @Override
    public UserResponse getAllUsers() {
        List<User> users = userRepository.findAll();
        List<UserDTO> usersDto = users.stream().map(this::mapToDto).collect(Collectors.toList());
        return new UserResponse(usersDto);
    }


    private User mapToUser(UserDTO userDTO) {
        User newUser = new User();
        newUser.setContact(userDTO.getContact());
        newUser.setNom(userDTO.getNom());
        newUser.setPrenom(userDTO.getPrenom());
        newUser.setEmail(userDTO.getEmail());
        newUser.setType(userDTO.getType());
        newUser.setId(userDTO.getId());
        return newUser;
    }

    private UserDTO mapToDto(User user) {
        UserDTO newUserDto = new UserDTO();
        newUserDto.setEmail(user.getEmail());
        newUserDto.setType(user.getType());
        newUserDto.setNom(user.getNom());
        newUserDto.setPrenom(user.getPrenom());
        newUserDto.setType(user.getType());
        newUserDto.setId(user.getId());
        newUserDto.setContact(user.getContact());
        return newUserDto;
    }


}
