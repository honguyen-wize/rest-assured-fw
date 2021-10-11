package samples.pojo.entities;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EntityAcademy {
    private String url;
    private String services;
    private String instructor;
    private String expertise;
    private String linkedIn;
    private EntityCourses courses;
}
