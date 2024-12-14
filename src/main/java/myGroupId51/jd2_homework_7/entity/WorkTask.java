package myGroupId51.jd2_homework_7.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "work_task")
@PrimaryKeyJoinColumn(name = "task_id")
public class WorkTask extends Task {
    @Column
    private Double cost;
}