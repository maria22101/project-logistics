package com.training.projectlogistics.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString

@Entity
@Table(name = "invoice")
public class Invoice {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
    //no other annotations needed since the identifier is populated with the Delivery_order id
    private Long id;

    @Column(name = "is_paid", nullable = false)
    private boolean isPaid;

    //    @OneToOne(mappedBy = "invoice", cascade = CascadeType.ALL)
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId //this way the id property serves both PrimaryKey and ForeignKey
    private Delivery_order delivery_order;
}
