package adapter.http.response;

import domain.model.Account;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AccountResponse {

    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private String smtp;

    @Getter
    @Setter
    private String pop3Imap;

    @Getter
    @Setter
    private String email;

    @Getter
    @Setter
    private String password;

//    private List<domain.model.Message> messages;

//    public Account toDomain() {
//        return new Account(getId(), getSmtp(), getPop3Imap(), getEmail(), getPassword());
//    }

    public static AccountResponse fromDomain(Account account) {
        return new AccountResponse(account.getId(), account.getSmtp(), account.getPop3Imap(), account.getUsername(), account.getPassword());
    }
}
