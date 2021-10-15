package stepDefinitions;

import io.cucumber.java.Before;

import java.io.FileNotFoundException;

public class Hooks {
    @Before("@DeletePlace")
    public void beforeScenario() throws FileNotFoundException {
        System.out.println("Before hook - Prepare for delete api");
        if(StepDefPlace.placeIdFromAddPlaceResponse == null) {
            StepDefPlace stepDefPlace = new StepDefPlace();
            String newName = "New Name";

            // create the add play payload
            stepDefPlace.add_place_payload_is_created(newName, "English", "New Address");

            //Add place
            stepDefPlace.user_calls_with_http_request("ADD_PLACE_API", "POST");
            stepDefPlace.verify_created_maps_to_using(newName, "GET_PLACE_API");
        }

    }
}
