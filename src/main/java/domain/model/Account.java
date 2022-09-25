package domain.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Account {

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
    private String username;

    @Getter
    @Setter
    private String password;

//    @Getter
//    @Setter
//    @OneToMany (fetch = FetchType.LAZY)
//    private List<Message> messages;
}
