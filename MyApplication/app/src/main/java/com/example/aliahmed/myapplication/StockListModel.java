package com.example.aliahmed.myapplication;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class StockListModel implements Serializable {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("shortName")
    @Expose
    private String shortName;
    @SerializedName("bidderName")
    @Expose
    private String bidderName;
    @SerializedName("askerName")
    @Expose
    private String askerName;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("shareQuantity")
    @Expose
    private Integer shareQuantity;
    @SerializedName("transactionTime")
    @Expose
    private String transactionTime;
    @SerializedName("isSyncedWithServer")
    @Expose
    private Boolean isSyncedWithServer;

    /**
     *
     * @return
     * The id
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The shortName
     */
    public String getShortName() {
        return shortName;
    }

    /**
     *
     * @param shortName
     * The shortName
     */
    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    /**
     *
     * @return
     * The bidderName
     */
    public String getBidderName() {
        return bidderName;
    }

    /**
     *
     * @param bidderName
     * The bidderName
     */
    public void setBidderName(String bidderName) {
        this.bidderName = bidderName;
    }

    /**
     *
     * @return
     * The askerName
     */
    public String getAskerName() {
        return askerName;
    }

    /**
     *
     * @param askerName
     * The askerName
     */
    public void setAskerName(String askerName) {
        this.askerName = askerName;
    }

    /**
     *
     * @return
     * The type
     */
    public String getType() {
        return type;
    }

    /**
     *
     * @param type
     * The type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     *
     * @return
     * The shareQuantity
     */
    public Integer getShareQuantity() {
        return shareQuantity;
    }

    /**
     *
     * @param shareQuantity
     * The shareQuantity
     */
    public void setShareQuantity(Integer shareQuantity) {
        this.shareQuantity = shareQuantity;
    }

    /**
     *
     * @return
     * The transactionTime
     */
    public String getTransactionTime() {
        return transactionTime;
    }

    /**
     *
     * @param transactionTime
     * The transactionTime
     */
    public void setTransactionTime(String transactionTime) {
        this.transactionTime = transactionTime;
    }

    /**
     *
     * @return
     * The isSyncedWithServer
     */
    public Boolean getIsSyncedWithServer() {
        return isSyncedWithServer;
    }

    /**
     *
     * @param isSyncedWithServer
     * The isSyncedWithServer
     */
    public void setIsSyncedWithServer(Boolean isSyncedWithServer) {
        this.isSyncedWithServer = isSyncedWithServer;
    }

}