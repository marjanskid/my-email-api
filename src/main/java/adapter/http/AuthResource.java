package adapter.http;

import adapter.http.request.AuthRequest;
import adapter.http.response.AuthResponse;
import adapter.util.auth.PBKDF2Encoder;
import adapter.util.auth.TokenUtils;
import domain.model.Account;
import domain.model.UserRole;
import domain.service.AuthService;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.logging.Logger;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collections;

@Path("/secured")
public class AuthResource {

    private static final Logger log = Logger.getLogger(AuthResource.class);

    @ConfigProperty(name = "mp.jwt.verify.issuer")
    String issuer;
    @ConfigProperty(name = "com.marjanskid.myemailapi.jwt.duration")
    Long duration;

    @Inject
    PBKDF2Encoder passwordEncoder;
    @Inject
    AuthService authService;

    @POST
    @Path("login")
    @PermitAll
    @Consumes(MediaType.APPLICATION_JSON)
    public Response login(AuthRequest authRequest) {
        Account account = authService.getByUsername(authRequest.getEmail());
        if (account != null && account.getPassword().equals(passwordEncoder.encode(authRequest.getPassword()))) {
            try {
                log.info("Account: " + account + "found for given username and password combination");

                return Response.ok(new AuthResponse(TokenUtils.generateToken(account.getUsername(), Collections.singleton(UserRole.AUTHENTICATED_USER) , duration, issuer))).build();
            } catch (Exception e) {
                log.info("Account: " + account + "found for given username and password combination but token generator failed", e);

                return Response.status(Response.Status.UNAUTHORIZED).build();
            }
        }

        log.info("Account not found for given username and password combination");

        return Response.status(Response.Status.UNAUTHORIZED).build();
    }
}
