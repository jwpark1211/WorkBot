package SlackWorkBot.WorkBot.Entity;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity @Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"channelId", "userName", "checkInTime", "checkOutTime"})})
public class Attendance {

    @Id
    @Column(name = "att_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String channelId;
    private String userName;
    private String userId;
    private LocalDateTime checkInTime;
    private LocalDateTime checkOutTime;

    @CreationTimestamp
    private LocalDateTime createdAt = LocalDateTime.now();

    @UpdateTimestamp
    private LocalDateTime modifiedAt = LocalDateTime.now();

    @Builder
    public Attendance(String channelId, String userName, String userId, LocalDateTime checkInTime,
                      LocalDateTime checkOutTime, LocalDateTime createdAt){
        this.channelId = channelId;
        this.userName = userName;
        this.userId = userId;
        this.checkInTime = checkInTime;
        this.checkOutTime = checkOutTime;
    }

}
