package adapter.http.response;

import domain.model.Attachment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Base64;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class AttachmentResponse {

    private String id;
    private Base64 data;
    private String type;
    private String name;

    public Attachment toDomain() {
        return new Attachment(getId(), getData(), getType(), getName());
    }

    public static AttachmentResponse fromDomain(Attachment attachment) {
        return new AttachmentResponse(attachment.getId(), attachment.getData(), attachment.getType(), attachment.getName());
    }
}
