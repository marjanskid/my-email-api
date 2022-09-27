package adapter.http;

import adapter.http.request.AuthRequest;
import adapter.http.request.MessageRequest;
import org.jboss.logging.Logger;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class MessageController {

    private static final Logger log = Logger.getLogger(AuthController.class);

    @GET
    @Path("messages")
    @RolesAllowed("AUTHENTICATED_USER")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getMessages(MessageRequest request) {
        return Response.ok().build();
    }
}
