package com.xdc.sparrowShop.generate;

public class Address {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ADDRESS.ID
     *
     * @mbg.generated Sat May 02 15:12:52 CST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ADDRESS.USER_ID
     *
     * @mbg.generated Sat May 02 15:12:52 CST 2020
     */
    private Integer userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ADDRESS.AREA_ID
     *
     * @mbg.generated Sat May 02 15:12:52 CST 2020
     */
    private Integer areaId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ADDRESS.PHONE
     *
     * @mbg.generated Sat May 02 15:12:52 CST 2020
     */
    private String phone;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ADDRESS.DETAIL
     *
     * @mbg.generated Sat May 02 15:12:52 CST 2020
     */
    private String detail;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ADDRESS.NAME
     *
     * @mbg.generated Sat May 02 15:12:52 CST 2020
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ADDRESS.IS_DEFAULT
     *
     * @mbg.generated Sat May 02 15:12:52 CST 2020
     */
    private String isDefault;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ADDRESS.ID
     *
     * @return the value of ADDRESS.ID
     *
     * @mbg.generated Sat May 02 15:12:52 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ADDRESS.ID
     *
     * @param id the value for ADDRESS.ID
     *
     * @mbg.generated Sat May 02 15:12:52 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ADDRESS.USER_ID
     *
     * @return the value of ADDRESS.USER_ID
     *
     * @mbg.generated Sat May 02 15:12:52 CST 2020
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ADDRESS.USER_ID
     *
     * @param userId the value for ADDRESS.USER_ID
     *
     * @mbg.generated Sat May 02 15:12:52 CST 2020
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ADDRESS.AREA_ID
     *
     * @return the value of ADDRESS.AREA_ID
     *
     * @mbg.generated Sat May 02 15:12:52 CST 2020
     */
    public Integer getAreaId() {
        return areaId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ADDRESS.AREA_ID
     *
     * @param areaId the value for ADDRESS.AREA_ID
     *
     * @mbg.generated Sat May 02 15:12:52 CST 2020
     */
    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ADDRESS.PHONE
     *
     * @return the value of ADDRESS.PHONE
     *
     * @mbg.generated Sat May 02 15:12:52 CST 2020
     */
    public String getPhone() {
        return phone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ADDRESS.PHONE
     *
     * @param phone the value for ADDRESS.PHONE
     *
     * @mbg.generated Sat May 02 15:12:52 CST 2020
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ADDRESS.DETAIL
     *
     * @return the value of ADDRESS.DETAIL
     *
     * @mbg.generated Sat May 02 15:12:52 CST 2020
     */
    public String getDetail() {
        return detail;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ADDRESS.DETAIL
     *
     * @param detail the value for ADDRESS.DETAIL
     *
     * @mbg.generated Sat May 02 15:12:52 CST 2020
     */
    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ADDRESS.NAME
     *
     * @return the value of ADDRESS.NAME
     *
     * @mbg.generated Sat May 02 15:12:52 CST 2020
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ADDRESS.NAME
     *
     * @param name the value for ADDRESS.NAME
     *
     * @mbg.generated Sat May 02 15:12:52 CST 2020
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ADDRESS.IS_DEFAULT
     *
     * @return the value of ADDRESS.IS_DEFAULT
     *
     * @mbg.generated Sat May 02 15:12:52 CST 2020
     */
    public String getIsDefault() {
        return isDefault;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ADDRESS.IS_DEFAULT
     *
     * @param isDefault the value for ADDRESS.IS_DEFAULT
     *
     * @mbg.generated Sat May 02 15:12:52 CST 2020
     */
    public void setIsDefault(String isDefault) {
        this.isDefault = isDefault == null ? null : isDefault.trim();
    }
}