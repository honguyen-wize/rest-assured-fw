package pojo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class EntityPlace {
    private EntityLocation location;
    private int accuracy;
    private String name;
    private String phone_number;
    private String address;
    private List<String> types;
    private String website;
    private String language;
}


