package domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Base64;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Attachment {

    private String id;
    private Base64 data;
    private String type;
    private String name;
}
