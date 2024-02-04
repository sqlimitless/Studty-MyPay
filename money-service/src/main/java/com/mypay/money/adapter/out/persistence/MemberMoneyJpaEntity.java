package com.mypay.money.adapter.out.persistence;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.NoSuchElementException;

@Entity
@Table(name = "member_money")
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Builder
public class MemberMoneyJpaEntity {

    @Id
    @GeneratedValue
    private Long memberMoneyId;
    private Long membershipId;
    private int balance;

    public void increaseMoney(int increaseMoneyAmount){
        this.balance += increaseMoneyAmount;
    }

    public void decreaseMoney(int decreaseMoneyAmount){
        int balance = this.balance - decreaseMoneyAmount;
        if(balance < 0){
            throw new NoSuchElementException("잔고부족");
        } else {
            this.balance = balance;
        }

    }
}
