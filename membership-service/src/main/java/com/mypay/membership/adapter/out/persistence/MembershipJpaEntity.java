
package com.mypay.membership.adapter.out.persistence;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "membership")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MembershipJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long membershipId;

    private String name;

    private String address;
    private String email;
    private boolean isValid;
    private boolean isCorp;


    @Builder
    public MembershipJpaEntity(Long membershipId, String name, String address, String email, boolean isValid, boolean isCorp) {
        this.membershipId = membershipId;
        this.name = name;
        this.address = address;
        this.email = email;
        this.isValid = isValid;
        this.isCorp = isCorp;
    }
}
