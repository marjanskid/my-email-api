package adapter.sql.model;

import domain.model.Account;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "account_entity")
public class AccountEntity {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private String id;

    @Getter
    @Setter
    @Column(name = "smtp")
    private String smtp;

    @Getter
    @Setter
    @Column(name = "pop3_imap")
    private String pop3Imap;

    @Getter
    @Setter
    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Getter
    @Setter
    @Column(name = "password", nullable = false)
    private String password;

    public Account toDomain() {
        return new Account(getId(), getSmtp(), getPop3Imap(), getUsername(), getPassword());
    }

    public static AccountEntity fromDomain(Account account) {
        return new AccountEntity(account.getId(), account.getSmtp(), account.getPop3Imap(), account.getUsername(), account.getPassword());
    }
}
