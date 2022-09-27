package adapter.http.response;

import domain.model.Tag;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class TagResponse {

    @Getter
    @Setter
    private String id;
    private String name;

    public Tag toDomain() {
        return new Tag(getId(), getName());
    }

    public TagResponse fromDomain(Tag tag) {
        return new TagResponse(tag.getId(), tag.getName());
    }
}
