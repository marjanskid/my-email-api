package adapter.http;

import adapter.http.response.MessageContentResponse;
import org.eclipse.microprofile.jwt.JsonWebToken;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/resource")
public class ResourceController {

    @Inject
    JsonWebToken principal;

    @GET
    @Path("/user")
    @RolesAllowed("AUTHENTICATED_USER")
    @Produces(MediaType.APPLICATION_JSON)
    public Response user() {
        String username = principal.getSubject();

        return Response.ok(new MessageContentResponse("Content for authenticated user '" + username + "'")).build();
    }

    @GET
    @Path("/admin")
    @RolesAllowed("ADMIN")
    @Produces(MediaType.APPLICATION_JSON)
    public Response admin() {
        return Response.ok(new MessageContentResponse("Content for admin")).build();
    }

    @GET
    @Path("/user-or-admin")
    @PermitAll
    @Produces(MediaType.APPLICATION_JSON)
    public Response userOrAdmin() {
        return Response.ok(new MessageContentResponse("Content for unauthenticated user, authenticated user or admin")).build();
    }
}
