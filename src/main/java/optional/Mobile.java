package optional;

import java.util.Optional;

public class Mobile {
    private long id;
    private String brand;
    private String name;
    private DisplayFeatures displayFeatures;
    // Like wise we can see MemoryFeatures, CameraFeatures etc.
    // For simplicity, using only one Features

    public Mobile(long id, String brand, String name, DisplayFeatures displayFeatures){
        this.id = id;
        this.brand = brand;
        this.name = name;
        this.displayFeatures = displayFeatures;
    }

    public long getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getName() {
        return name;
    }

    public Optional<DisplayFeatures> getDisplayFeatures() {
        return Optional.ofNullable(displayFeatures);
    }

}
