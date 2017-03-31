/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Membership;

/**
 *
 * @author situsnow
 */
public class MembershipBean {
    
    private int tier_id;
    
    private String membership_tier;
    
    private int tier_credit;
    
    private double discount;
    
    private String other_rewards;

    public int getTier_id() {
        return tier_id;
    }

    public String getMembership_tier() {
        return membership_tier;
    }

    public int getTier_credit() {
        return tier_credit;
    }

    public double getDiscount() {
        return discount;
    }

    public String getOther_rewards() {
        return other_rewards;
    }

    public void setTier_id(int tier_id) {
        this.tier_id = tier_id;
    }

    public void setMembership_tier(String membership_tier) {
        this.membership_tier = membership_tier;
    }

    public void setTier_credit(int tier_credit) {
        this.tier_credit = tier_credit;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public void setOther_rewards(String other_rewards) {
        this.other_rewards = other_rewards;
    }
    
    
    
}
