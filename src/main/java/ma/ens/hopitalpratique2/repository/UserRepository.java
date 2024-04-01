package ma.ens.hopitalpratique2.repository;
import ma.ens.hopitalpratique2.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
    User findByUsername(String userName);
}
