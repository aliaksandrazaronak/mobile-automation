package business_objects;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MobileDevice {

    private String udid;
    private int systemPort;
}
