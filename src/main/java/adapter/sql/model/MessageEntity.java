package adapter.sql.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.Instant;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "message_entity")
public class MessageEntity {

    private String id;
    private ContactEntity from;
    private List<ContactEntity> to;
    private List<ContactEntity> cc;
    private List<ContactEntity> bcc;
    private Instant dateTime;
    private String subject;
    private String content;
//    private Map<String, Tag> tags;
//    private Map<String, Attachment> attachments;
}
