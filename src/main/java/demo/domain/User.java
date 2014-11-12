package demo.domain;
import java.util.Date;
import java.util.List;

/**
 * @describe: User实体类
 * @author:    Nirvana
 * @version:   V1.0  2011-3-11下午06:06:49 create
 */

public class User {

	private long id;

	private String name;

	private String password;

	private Date createTime;

	private List<Group> group;

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Group> getGroup() {
		return group;
	}

	public void setGroup(List<Group> group) {
		this.group = group;
	}
	
	@Override
	public String toString(){
		return this.id +" "+ this.name;
	}
}