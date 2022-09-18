package adapter.http.response;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AuthResponse {

    @Getter
    @Setter
    private String token;
}
