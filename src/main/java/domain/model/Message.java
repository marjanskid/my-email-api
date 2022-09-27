package domain.model;

import lombok.*;

import java.time.Instant;
import java.util.List;
import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Message {

    @Getter
    @Setter
    private String id;
    @Getter
    @Setter
    private Contact from;
    @Getter
    @Setter
    private List<Contact> to;
    @Getter
    @Setter
    private List<Contact> cc;
    @Getter
    @Setter
    private List<Contact> bcc;
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
    private List<Tag> tags;
    @Getter
    @Setter
    private List<Attachment> attachments;
}
