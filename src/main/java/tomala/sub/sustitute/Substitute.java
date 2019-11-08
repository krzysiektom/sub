package tomala.sub.sustitute;



import tomala.sub.ActivityType;
import tomala.sub.PositionType;
import tomala.sub.State;
import tomala.sub.location.Location;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "substitutes")
public class Substitute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Location location;
    private LocalDateTime dateTime;
    private ActivityType activityType;
    private PositionType positionType;
    private BigDecimal price;
    private String additionalInfo;
    private State state;

    public Substitute() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public ActivityType getActivityType() {
        return activityType;
    }

    public void setActivityType(ActivityType activityType) {
        this.activityType = activityType;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Substitute{" +
                "id=" + id +
                ", location=" + location +
                ", dateTime=" + dateTime +
                ", activityType=" + activityType +
                ", positionType=" + positionType +
                ", price=" + price +
                ", additionalInfo='" + additionalInfo + '\'' +
                ", state=" + state +
                '}';
    }
}
