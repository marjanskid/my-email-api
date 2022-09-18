package domain.model;

import java.time.Instant;
import java.util.List;
import java.util.Map;

class Message {

    private String id;
    private Contact from;
    private List<Contact> to;
    private List<Contact> cc;
    private List<Contact> bcc;
    private Instant dateTime;
    private String subject;
    private String content;
    private Map<String, Tag> tags;
    private Map<String, Attachment> attachments;
}
