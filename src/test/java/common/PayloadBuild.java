package common;

import entities.EntityLocation;
import entities.EntityPlace;

import java.util.ArrayList;
import java.util.List;

public class PayloadBuild {

    public EntityPlace getAddPlacePayload(String name, String language, String address){
        EntityPlace payloadPlace = new EntityPlace();
        payloadPlace.setName(name);
        payloadPlace.setAccuracy(33);
        payloadPlace.setAddress(address);
        payloadPlace.setLanguage(language);
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

    public String deletePlacePayload(String placeId){
        return "{\r\n    \"place_id\":\"" + placeId + "\"\r\n}\r\n";
    }
}
