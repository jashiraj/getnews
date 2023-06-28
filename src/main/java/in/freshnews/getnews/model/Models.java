package in.freshnews.getnews.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Models {
        String category;
        List<DataItem> data;

        Boolean success;
}
