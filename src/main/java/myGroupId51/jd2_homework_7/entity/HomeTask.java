package myGroupId51.jd2_homework_7.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "home_task")
@DiscriminatorValue("H")
public class HomeTask extends Task {
    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Embedded
    private Address address;
}
