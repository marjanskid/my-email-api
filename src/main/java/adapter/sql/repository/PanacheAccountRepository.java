package adapter.sql.repository;

import adapter.sql.model.AccountEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.Optional;

@ApplicationScoped
public class PanacheAccountRepository implements PanacheRepository<AccountEntity> {

    public Optional<AccountEntity> findByUsername(String username) {
        return find("username", username).stream()
                .findFirst();
    }

//    public Optional<AccountEntity> findByUsername(String username) {
//        return findAll().stream().findFirst();
//    }
}
