package derek.exemple.ticketapi.Controllers;

import derek.exemple.ticketapi.DTO.UserDTO;
import derek.exemple.ticketapi.DTO.UserResponse;
import derek.exemple.ticketapi.Services.ServicesImpl.UserServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    @Autowired
    private UserServiceImpl userService;
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable(name = "id") int id){
        UserDTO userById = userService.getUserById(id);
        return new ResponseEntity<>(userById, HttpStatus.OK);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<UserDTO> addUser(@Valid @RequestBody UserDTO user) {
        UserDTO userDto = userService.createUser(user);
        ResponseEntity responseEntity = new ResponseEntity<>(userDto, HttpStatus.CREATED);
        return responseEntity;

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteUserById(@Valid @PathVariable int id ) {
        userService.deleteUserById(id);
        return new ResponseEntity<>("l'utilisateur a été supprimé", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<UserDTO> updateUserById(@PathVariable int id, @RequestBody UserDTO user) {
        UserDTO userDto = userService.updateUser(user, id);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<UserResponse> getAll(){
        UserResponse userResponse = userService.getAllUsers();
        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }

}
