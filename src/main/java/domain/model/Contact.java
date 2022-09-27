package domain.model;

import java.util.List;

public class Contact {

    private String id;
    private String first;
    private String last;
    private String display;
    private String email;
    private ContactFormat format;
    private Photo photo;
    private List<Message> from;
    private List<Message> to;
    private List<Message> cc;
    private List<Message> bcc;
}
