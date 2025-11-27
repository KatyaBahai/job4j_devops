package ru.job4j.devops.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
@Data
@AllArgsConstructor
@Entity
@Table(name = "calc_events")
@NoArgsConstructor
@Builder
public class CalcEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    private double first;
    private double second;
    private double result;
    @Column(name = "creation_date")
    private Instant creationDate;
    private String type;
}
