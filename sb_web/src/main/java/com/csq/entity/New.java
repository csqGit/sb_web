package com.csq.entity;

public class New {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column new_tb.id
     *
     * @mbg.generated Thu Apr 18 21:05:01 CST 2019
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column new_tb.new_title
     *
     * @mbg.generated Thu Apr 18 21:05:01 CST 2019
     */
    private String newTitle;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column new_tb.new_type
     *
     * @mbg.generated Thu Apr 18 21:05:01 CST 2019
     */
    private String newType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column new_tb.new_jj
     *
     * @mbg.generated Thu Apr 18 21:05:01 CST 2019
     */
    private String newJj;
    private String newTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column new_tb.new_author
     *
     * @mbg.generated Thu Apr 18 21:05:01 CST 2019
     */
    private String newAuthor;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column new_tb.remarks
     *
     * @mbg.generated Thu Apr 18 21:05:01 CST 2019
     */
    private String remarks;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column new_tb.id
     *
     * @return the value of new_tb.id
     *
     * @mbg.generated Thu Apr 18 21:05:01 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column new_tb.id
     *
     * @param id the value for new_tb.id
     *
     * @mbg.generated Thu Apr 18 21:05:01 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column new_tb.new_title
     *
     * @return the value of new_tb.new_title
     *
     * @mbg.generated Thu Apr 18 21:05:01 CST 2019
     */
    public String getNewTitle() {
        return newTitle;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column new_tb.new_title
     *
     * @param newTitle the value for new_tb.new_title
     *
     * @mbg.generated Thu Apr 18 21:05:01 CST 2019
     */
    public void setNewTitle(String newTitle) {
        this.newTitle = newTitle;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column new_tb.new_type
     *
     * @return the value of new_tb.new_type
     *
     * @mbg.generated Thu Apr 18 21:05:01 CST 2019
     */
    public String getNewType() {
        return newType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column new_tb.new_type
     *
     * @param newType the value for new_tb.new_type
     *
     * @mbg.generated Thu Apr 18 21:05:01 CST 2019
     */
    public void setNewType(String newType) {
        this.newType = newType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column new_tb.new_jj
     *
     * @return the value of new_tb.new_jj
     *
     * @mbg.generated Thu Apr 18 21:05:01 CST 2019
     */
    public String getNewJj() {
        return newJj;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column new_tb.new_jj
     *
     * @param newJj the value for new_tb.new_jj
     *
     * @mbg.generated Thu Apr 18 21:05:01 CST 2019
     */
    public void setNewJj(String newJj) {
        this.newJj = newJj;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column new_tb.new_author
     *
     * @return the value of new_tb.new_author
     *
     * @mbg.generated Thu Apr 18 21:05:01 CST 2019
     */
    public String getNewAuthor() {
        return newAuthor;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column new_tb.new_author
     *
     * @param newAuthor the value for new_tb.new_author
     *
     * @mbg.generated Thu Apr 18 21:05:01 CST 2019
     */
    public void setNewAuthor(String newAuthor) {
        this.newAuthor = newAuthor;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column new_tb.remarks
     *
     * @return the value of new_tb.remarks
     *
     * @mbg.generated Thu Apr 18 21:05:01 CST 2019
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column new_tb.remarks
     *
     * @param remarks the value for new_tb.remarks
     *
     * @mbg.generated Thu Apr 18 21:05:01 CST 2019
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

	public String getNewTime() {
		return newTime;
	}

	public void setNewTime(String newTime) {
		this.newTime = newTime;
	}

	@Override
	public String toString() {
		return "New [id=" + id + ", newTitle=" + newTitle + ", newType=" + newType + ", newJj=" + newJj + ", newTime="
				+ newTime + ", newAuthor=" + newAuthor + ", remarks=" + remarks + "]";
	}

}