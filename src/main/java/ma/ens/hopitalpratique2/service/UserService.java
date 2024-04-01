package ma.ens.hopitalpratique2.service;

import ma.ens.hopitalpratique2.entities.Role;
import ma.ens.hopitalpratique2.entities.User;

public interface UserService {
    User addNewUser(User user);
    Role addNewRole(Role role);
    User findUserByUserName(String userName);
    Role findRoleByRoleName(String roleName);
    void addRoleToUser(String username,String roleName) throws Exception;
    User authenticate(String userName, String password);

}
