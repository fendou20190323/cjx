package com.lss.region.model;

import com.lss.common.base.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

@ApiModel(description = "行政区域")
public class Region  {

	@ApiModelProperty(value = "UUID")
	private Integer id;
	@ApiModelProperty(value = "名字")
	private String name;
	@ApiModelProperty(value = "简化名字")
	private String abbr;
	@ApiModelProperty(value = "拼音")
	private String pinyin;
	@ApiModelProperty(value = "繁体名字")
	private String tname;
	@ApiModelProperty(value = "父id")
	private Integer pid;
	@ApiModelProperty(value = "层级")
	private Integer type;
	@ApiModelProperty(value = "zip")
	private String zip;
	@ApiModelProperty(value = "是否可用")
	private Integer enabled;

	/**
	 * UUID
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * UUID
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 名字
	 */
	public String getName() {
		return name;
	}

	/**
	 * 名字
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 简化名字
	 */
	public String getAbbr() {
		return abbr;
	}

	/**
	 * 简化名字
	 */
	public void setAbbr(String abbr) {
		this.abbr = abbr;
	}

	/**
	 * 拼音
	 */
	public String getPinyin() {
		return pinyin;
	}

	/**
	 * 拼音
	 */
	public void setPinyin(String pinyin) {
		this.pinyin = pinyin;
	}

	/**
	 * 繁体名字
	 */
	public String getTname() {
		return tname;
	}

	/**
	 * 繁体名字
	 */
	public void setTname(String tname) {
		this.tname = tname;
	}

	/**
	 * 父id
	 */
	public Integer getPid() {
		return pid;
	}

	/**
	 * 父id
	 */
	public void setPid(Integer pid) {
		this.pid = pid;
	}

	/**
	 * 层级
	 */
	public Integer getType() {
		return type;
	}

	/**
	 * 层级
	 */
	public void setType(Integer type) {
		this.type = type;
	}

	/**
	 * zip
	 */
	public String getZip() {
		return zip;
	}

	/**
	 * zip
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}

	/**
	 * 是否可用
	 */
	public Integer getEnabled() {
		return enabled;
	}

	/**
	 * 是否可用
	 */
	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}

	@Override
	public Region clone() {
		Region instance = new Region();
		instance.setId(this.id);
		instance.setName(this.name);
		instance.setAbbr(this.abbr);
		instance.setPinyin(this.pinyin);
		instance.setTname(this.tname);
		instance.setPid(this.pid);
		instance.setType(this.type);
		instance.setZip(this.zip);
		instance.setEnabled(this.enabled);
		return instance;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Region)) {
			return false;
		}
		Region that = (Region) o;
		return Objects.equals(id, that.id)
        		&& Objects.equals(name, that.name)
        		&& Objects.equals(abbr, that.abbr)
        		&& Objects.equals(pinyin, that.pinyin)
        		&& Objects.equals(tname, that.tname)
        		&& Objects.equals(pid, that.pid)
        		&& Objects.equals(type, that.type)
        		&& Objects.equals(zip, that.zip)
        		&& Objects.equals(enabled, that.enabled)
				;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, abbr, pinyin, tname, pid, type, zip, enabled);
	}
	
}