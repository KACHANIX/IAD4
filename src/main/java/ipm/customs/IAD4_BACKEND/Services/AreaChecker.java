package ipm.customs.IAD4_BACKEND.Services;

import org.springframework.stereotype.Service;

@Service
public class AreaChecker {
    public boolean Check(double x, double y, double r){
        if (x <= 0 && y >= 0 && y <= r && x >= -r/2){
            return true;
        }
        if (x <= 0 && y <= 0 && y >= -2 -2 * x){
            return true;
        }
        if (x >= 0 && y <= 0 && x * x + y * y <= r * r / 4){
            return true;
        }
        return false;
    }
}
