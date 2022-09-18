package domain.repository;

import domain.model.Account;

public interface AccountRepository {

    Account findByUsername(final String username);
}
