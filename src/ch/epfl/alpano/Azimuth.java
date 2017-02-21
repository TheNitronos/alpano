package ch.epfl.alpano;

import static java.lang.Math.PI;
import static ch.epfl.alpano.Math2.PI2;
import static ch.epfl.alpano.Math2.PI_OVER8;
import static ch.epfl.alpano.Math2.floorMod;
import static ch.epfl.alpano.Preconditions.checkArgument;

public interface Azimuth {
    
    /**
     * check if a radian angle is in [0,PI2[
     * @param azimuth radian angle to check
     * @return boolean, true if azimuth is in [0,PI2[, false otherwise
     */
    public static boolean isCanonical(double azimuth) {
        if (azimuth >= 0 && azimuth < PI2) {
            return true;
        }
        
        return false;
    }
    
    public static double canonicalize(double azimuth) {
        return floorMod(azimuth, PI2);
    }
    
    public static double toMath(double azimuth) {
        checkArgument(isCanonical(azimuth));
        
        double angle = PI2 - azimuth;
        
        return canonicalize(angle);
    }
    
    public static double fromMath(double azimuth) {
        checkArgument(isCanonical(azimuth));
        
        double radianAng = PI2 - azimuth;
        
        return canonicalize(radianAng);
        
    }

    public static String toOctantString(double azimuth, String n, String e, String s, String w) {
        checkArgument(isCanonical(azimuth));
        
        String cardinalDirection = "";
        
        if (azimuth > PI2-3*PI_OVER8 || azimuth < 3*PI_OVER8) {
            cardinalDirection += n;
        } else if (azimuth <= PI+3*PI_OVER8 && azimuth >= PI-3*PI_OVER8) {
            cardinalDirection += s;
        }
        
        if (azimuth > PI_OVER8 && azimuth < PI-PI_OVER8) {
            cardinalDirection += e;
        } else if (azimuth > PI+PI_OVER8 && azimuth < PI2-PI_OVER8) {
            cardinalDirection += w;
        }

        return cardinalDirection;
    }

}
