package adapter.util.auth;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.enterprise.context.RequestScoped;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

@RequestScoped
public class PBKDF2Encoder {

    @ConfigProperty(name = "com.marjanskid.myemailapi.password.algorithm")
    String algorithm;
    @ConfigProperty(name = "com.marjanskid.myemailapi.password.secret")
    String secret;
    @ConfigProperty(name = "com.marjanskid.myemailapi.password.iteration")
    Integer iteration;
    @ConfigProperty(name = "com.marjanskid.myemailapi.password.keylength")
    Integer keyLength;

    /**
     * More info (https://www.owasp.org/index.php/Hashing_Java) 404 :(
     * @param cs password
     * @return encoded password
     */
    public String encode(CharSequence cs) {
        try {
            byte[] result = SecretKeyFactory.getInstance(algorithm)
                    .generateSecret(new PBEKeySpec(cs.toString().toCharArray(), secret.getBytes(), iteration, keyLength))
                    .getEncoded();

            return Base64.getEncoder().encodeToString(result);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {
            throw new RuntimeException(ex);
        }
    }
}
