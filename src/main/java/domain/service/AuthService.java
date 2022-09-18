package domain.service;

import domain.model.Account;
import domain.repository.AccountRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class AuthService {

    @Inject
    AccountRepository accountRepository;

    public Account getByUsername(String username) {
        return accountRepository.findByUsername(username);
    }
}
