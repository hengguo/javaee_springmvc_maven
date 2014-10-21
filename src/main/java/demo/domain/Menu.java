package demo.domain;

import java.io.Serializable;

public class Menu implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 2327533395329117869L;

	/**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column menu.id
     *
     * @mbggenerated Tue Jun 17 07:49:51 CST 2014
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column menu.name
     *
     * @mbggenerated Tue Jun 17 07:49:51 CST 2014
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column menu.pid
     *
     * @mbggenerated Tue Jun 17 07:49:51 CST 2014
     */
    private String pid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column menu.url
     *
     * @mbggenerated Tue Jun 17 07:49:51 CST 2014
     */
    private String url;
    

    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column menu.name
     *
     * @return the value of menu.name
     *
     * @mbggenerated Tue Jun 17 07:49:51 CST 2014
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column menu.name
     *
     * @param name the value for menu.name
     *
     * @mbggenerated Tue Jun 17 07:49:51 CST 2014
     */
    public void setName(String name) {
        this.name = name;
    }


    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column menu.url
     *
     * @return the value of menu.url
     *
     * @mbggenerated Tue Jun 17 07:49:51 CST 2014
     */
    public String getUrl() {
        return url;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column menu.url
     *
     * @param url the value for menu.url
     *
     * @mbggenerated Tue Jun 17 07:49:51 CST 2014
     */
    public void setUrl(String url) {
        this.url = url;
    }
}