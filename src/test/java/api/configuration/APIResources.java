package api.configuration;

public enum  APIResources {

    ADD_PLACE_API("/maps/api/place/add/json"),
    GET_PLACE_API("/maps/api/place/get/json"),
    PUT_PLACE_API("/maps/api/place/update/json"),
    DELETE_PLACE_API("/maps/api/place/delete/json");

    private String resource;

    APIResources(String apiResource){
        this.resource = apiResource;
    }

    public String getResource(){
        return this.resource;
    }
}
