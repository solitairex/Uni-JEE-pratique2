package ma.ens.hopitalpratique2.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

import ma.ens.hopitalpratique2.entities.Role;
import ma.ens.hopitalpratique2.entities.User;
import ma.ens.hopitalpratique2.repository.RoleRepository;
import ma.ens.hopitalpratique2.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service @Transactional @AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;




    @Override
    public User addNewUser(User user) {
        user.setUserId(UUID.randomUUID().toString());
        return userRepository.save(user);
    }

    @Override
    public Role addNewRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public User findUserByUserName(String userName) {
        return userRepository.findByUsername(userName);
    }

    @Override
    public Role findRoleByRoleName(String roleName) {
        return roleRepository.findByRoleName(roleName);
    }

    @Override
    public void addRoleToUser(String username, String roleName) throws Exception  {
        User user = findUserByUserName(username);
        Role role = findRoleByRoleName(roleName);
        if (user != null) { // Check if user is not null
            if (user.getRoles() != null) {
                user.getRoles().add(role);
                role.getUsers().add(user);
            }
            //userRepository.save(user);
        }

    }

    @Override
    public User authenticate(String userName, String password) {
        User user=userRepository.findByUsername(userName);
        if(user==null) throw new RuntimeException("Bad Data");
        if(user.getPassword().equals(password)){
            return user;
        }
        throw new RuntimeException("Bad Data");
    }}