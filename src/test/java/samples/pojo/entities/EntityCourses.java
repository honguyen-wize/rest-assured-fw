package samples.pojo.entities;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EntityCourses {
    private List<EntityWebAutomation> webAutomation;
    private List<EntityApi> api;
    private List<EntityMobile> mobile;
}
