package com.lss.region.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(description = "行政区域")
public class RegionVO {

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

}