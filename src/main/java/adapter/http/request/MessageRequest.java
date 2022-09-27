package adapter.http.request;

import domain.model.enumeration.MessageSortingEnum;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MessageRequest {

    private int offset;
    private int limit;
    private MessageSortingEnum sorting;
    private String searchFilter;
}
