package adapter.http.response;

import domain.model.Message;
import lombok.*;

import java.time.Instant;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MessageResponse {

    @Getter
    @Setter
    private String id;
    @Getter
    @Setter
    private ContactResponse from;
    @Getter
    @Setter
    private List<ContactResponse> to;
    @Getter
    @Setter
    private List<ContactResponse> cc;
    @Getter
    @Setter
    private List<ContactResponse> bcc;
    @Getter
    @Setter
    private Instant dateTime;
    @Getter
    @Setter
    private String subject;
    @Getter
    @Setter
    private String content;
    @Getter
    @Setter
    private List<TagResponse> tags;
    @Getter
    @Setter
    private List<AttachmentResponse> attachments;

    public Message toDomain() {
        return new Message(getId(), getFrom(), getTo(), getCc(), getBcc(), getDateTime(), getSubject(), getContent());
    }

    public static MessageResponse fromDomain(Message message) {
        return new MessageResponse(message.getId(), message.getQuestionId(), message.getAnswerText(), message.isAnswerCorrect());
    }
}
