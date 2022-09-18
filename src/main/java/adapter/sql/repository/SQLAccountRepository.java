package adapter.sql.repository;

import adapter.sql.model.AccountEntity;
import domain.model.Account;
import domain.repository.AccountRepository;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.NotFoundException;
import java.util.Optional;

@ApplicationScoped
public class SQLAccountRepository implements AccountRepository {

    private static final Logger log = Logger.getLogger(SQLAccountRepository.class);

    @Inject
    PanacheAccountRepository accountRepository;

    @Override
    public Account findByUsername(final String username) {
        final Optional<AccountEntity> potentialAccountEntity = accountRepository.findByUsername(username);
        final AccountEntity foundAccountEntity = potentialAccountEntity.orElseThrow(() -> {
            throw new NotFoundException("Account with username: " + username + " not found");
        });

        try {
            return foundAccountEntity.toDomain();
        } catch (final Exception e) {
            log.error("Error occurred during AccountEntity: " + foundAccountEntity + "to domain mapping");

            throw new InternalServerErrorException("Error occurred during AccountEntity: " + foundAccountEntity + "to domain mapping", e);
        }
    }
}
