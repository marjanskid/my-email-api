package domain.model.enumeration;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public enum MessageSortingEnum {

    ASC("ascending", "Ascending order"),
    DESC("descending", "Descending order");

    @Getter
    private String name;
    @Getter
    private String description;
}
