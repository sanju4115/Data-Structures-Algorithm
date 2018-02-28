package optional;

import java.util.Optional;

public class MobileService {

    public Integer getMobileScreenWidth(Mobile mobile){
        return Optional.ofNullable(mobile).flatMap(Mobile::getDisplayFeatures)
                .flatMap(DisplayFeatures::getResolution)
                .map(ScreenResolution::getWidth)
                .orElse(0);

    }
}
