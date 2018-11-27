package demo.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Random;

@Embeddable
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
class UserInfo {
    String username;
    String address;

    public UserInfo() {
        // default constructor
    }

    public UserInfo(
            @JsonProperty("username") String username,
            @JsonProperty("address") String address
    ) {
        this.username = username;
        this.address = address;
    }
}

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Embeddable
@Table(name="RUNNING_INFORMATION")
@Entity
public class RunningInformation {
    enum WarningLevel {
        HIGH, NORMAL, LOW, INVALID;
        public static WarningLevel getWarningLevel(int heartRate) {
            if (heartRate>120) {
                return HIGH;
            } else if (heartRate>75) {
                return NORMAL;
            } else if (heartRate>=60) {
                return LOW;
            } else {
                return INVALID;
            }
        }
    }
    @Id
    @GeneratedValue
    private long id;

    private String runningId;

    private double latitude;
    private double longitude;
    private double runningDistance;
    private double totalRunningTime;

    private int heartRate;
    private Date timestamp;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "username", column = @Column(name = "userName")),
            @AttributeOverride(name = "address", column = @Column(name = "userAddress"))
    })
    private UserInfo userInfo;

    private WarningLevel warningLevel;

    public RunningInformation() {
        this.userInfo = null;
    }

    @JsonCreator
    public RunningInformation(
            @JsonProperty("runningId") String runningId,
            @JsonProperty("latitude") String latitude,
            @JsonProperty("longitude") String longitude,
            @JsonProperty("runningDistance") String runningDistance,
            @JsonProperty("totalRunningTime") String totalRunningTime,
            UserInfo userInfo,
            @JsonProperty("heartRate") int heartRate
    ) {
        this.runningId = runningId;
        this.latitude = Double.parseDouble(latitude);
        this.longitude = Double.parseDouble(longitude);
        this.runningDistance = Double.parseDouble(runningDistance);
        this.totalRunningTime = Double.parseDouble(totalRunningTime);
        this.heartRate = getHeartRate();
        this.timestamp = new Date();
        this.userInfo = userInfo;
        this.warningLevel = WarningLevel.getWarningLevel(this.heartRate);
    }

    private int getHeartRate() {
        Random rand = new Random();
        return 60+rand.nextInt(200-60+1);
    }
}
