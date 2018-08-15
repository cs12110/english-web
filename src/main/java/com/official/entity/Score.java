package com.official.entity;

import javax.persistence.*;

@Table(name = "score_t")
public class Score {
    @Id
    private Integer id;

    @Column(name = "cus_id")
    private Integer cusId;

    @Column(name = "sub_id")
    private Integer subId;

    @Column(name = "read_time1")
    private Integer readTime1;

    @Column(name = "read_time2")
    private Integer readTime2;

    @Column(name = "read_time3")
    private Integer readTime3;

    @Column(name = "read_time4")
    private Integer readTime4;

    @Column(name = "read_time5")
    private Integer readTime5;

    private Integer match;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return cus_id
     */
    public Integer getCusId() {
        return cusId;
    }

    /**
     * @param cusId
     */
    public void setCusId(Integer cusId) {
        this.cusId = cusId;
    }

    /**
     * @return sub_id
     */
    public Integer getSubId() {
        return subId;
    }

    /**
     * @param subId
     */
    public void setSubId(Integer subId) {
        this.subId = subId;
    }

    /**
     * @return read_time1
     */
    public Integer getReadTime1() {
        return readTime1;
    }

    /**
     * @param readTime1
     */
    public void setReadTime1(Integer readTime1) {
        this.readTime1 = readTime1;
    }

    /**
     * @return read_time2
     */
    public Integer getReadTime2() {
        return readTime2;
    }

    /**
     * @param readTime2
     */
    public void setReadTime2(Integer readTime2) {
        this.readTime2 = readTime2;
    }

    /**
     * @return read_time3
     */
    public Integer getReadTime3() {
        return readTime3;
    }

    /**
     * @param readTime3
     */
    public void setReadTime3(Integer readTime3) {
        this.readTime3 = readTime3;
    }

    /**
     * @return read_time4
     */
    public Integer getReadTime4() {
        return readTime4;
    }

    /**
     * @param readTime4
     */
    public void setReadTime4(Integer readTime4) {
        this.readTime4 = readTime4;
    }

    /**
     * @return read_time5
     */
    public Integer getReadTime5() {
        return readTime5;
    }

    /**
     * @param readTime5
     */
    public void setReadTime5(Integer readTime5) {
        this.readTime5 = readTime5;
    }

    /**
     * @return match
     */
    public Integer getMatch() {
        return match;
    }

    /**
     * @param match
     */
    public void setMatch(Integer match) {
        this.match = match;
    }
}