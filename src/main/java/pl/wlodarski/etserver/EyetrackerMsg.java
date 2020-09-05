package pl.wlodarski.etserver;

import com.sun.xml.internal.ws.developer.Serialization;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@Serialization
@NoArgsConstructor
public class EyetrackerMsg implements Serializable {
    private static final long serialVersionUID = 950824;
    Double x;
    Double y;

    public EyetrackerMsg(Double x, Double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "EyetrackerMsg{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }
}
