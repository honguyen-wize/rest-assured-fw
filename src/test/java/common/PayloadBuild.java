package common;

import pojo.EntityLocation;
import pojo.EntityPlace;

import java.util.ArrayList;
import java.util.List;

public class PayloadBuild {

    public EntityPlace getAddPlacePayload(){
        EntityPlace payloadPlace = new EntityPlace();
        payloadPlace.setName("Ho Payload");
        payloadPlace.setAccuracy(33);
        payloadPlace.setAddress("Moonlight Park View, KP5");
        payloadPlace.setLanguage("Vietnam - VN");
        payloadPlace.setPhone_number("(+64) 983 893 3937");
        payloadPlace.setWebsite("http://google.com");

        List<String> types = new ArrayList<>();
        types.add("Shoe Park");
        types.add("Aeon Mall");
        payloadPlace.setTypes(types);

        EntityLocation location = new EntityLocation();
        location.setLat(-38.383494);
        location.setLng(33.427362);
        payloadPlace.setLocation(location);

        return payloadPlace;
    }
}
