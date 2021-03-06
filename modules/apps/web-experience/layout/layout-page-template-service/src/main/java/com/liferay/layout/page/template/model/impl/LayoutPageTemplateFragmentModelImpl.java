/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.layout.page.template.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.layout.page.template.model.LayoutPageTemplateFragment;
import com.liferay.layout.page.template.model.LayoutPageTemplateFragmentModel;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the LayoutPageTemplateFragment service. Represents a row in the &quot;LayoutPageTemplateFragment&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link LayoutPageTemplateFragmentModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link LayoutPageTemplateFragmentImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LayoutPageTemplateFragmentImpl
 * @see LayoutPageTemplateFragment
 * @see LayoutPageTemplateFragmentModel
 * @generated
 */
@ProviderType
public class LayoutPageTemplateFragmentModelImpl extends BaseModelImpl<LayoutPageTemplateFragment>
	implements LayoutPageTemplateFragmentModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a layout page template fragment model instance should use the {@link LayoutPageTemplateFragment} interface instead.
	 */
	public static final String TABLE_NAME = "LayoutPageTemplateFragment";
	public static final Object[][] TABLE_COLUMNS = {
			{ "layoutPageTemplateFragmentId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "layoutPageTemplateEntryId", Types.BIGINT },
			{ "fragmentEntryId", Types.BIGINT },
			{ "position", Types.INTEGER }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("layoutPageTemplateFragmentId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("layoutPageTemplateEntryId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("fragmentEntryId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("position", Types.INTEGER);
	}

	public static final String TABLE_SQL_CREATE = "create table LayoutPageTemplateFragment (layoutPageTemplateFragmentId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,layoutPageTemplateEntryId LONG,fragmentEntryId LONG,position INTEGER)";
	public static final String TABLE_SQL_DROP = "drop table LayoutPageTemplateFragment";
	public static final String ORDER_BY_JPQL = " ORDER BY layoutPageTemplateFragment.layoutPageTemplateFragmentId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY LayoutPageTemplateFragment.layoutPageTemplateFragmentId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.layout.page.template.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.layout.page.template.model.LayoutPageTemplateFragment"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.layout.page.template.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.layout.page.template.model.LayoutPageTemplateFragment"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.layout.page.template.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.layout.page.template.model.LayoutPageTemplateFragment"),
			true);
	public static final long FRAGMENTENTRYID_COLUMN_BITMASK = 1L;
	public static final long GROUPID_COLUMN_BITMASK = 2L;
	public static final long LAYOUTPAGETEMPLATEENTRYID_COLUMN_BITMASK = 4L;
	public static final long LAYOUTPAGETEMPLATEFRAGMENTID_COLUMN_BITMASK = 8L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.layout.page.template.service.util.ServiceProps.get(
				"lock.expiration.time.com.liferay.layout.page.template.model.LayoutPageTemplateFragment"));

	public LayoutPageTemplateFragmentModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _layoutPageTemplateFragmentId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setLayoutPageTemplateFragmentId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _layoutPageTemplateFragmentId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return LayoutPageTemplateFragment.class;
	}

	@Override
	public String getModelClassName() {
		return LayoutPageTemplateFragment.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("layoutPageTemplateFragmentId",
			getLayoutPageTemplateFragmentId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("layoutPageTemplateEntryId",
			getLayoutPageTemplateEntryId());
		attributes.put("fragmentEntryId", getFragmentEntryId());
		attributes.put("position", getPosition());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long layoutPageTemplateFragmentId = (Long)attributes.get(
				"layoutPageTemplateFragmentId");

		if (layoutPageTemplateFragmentId != null) {
			setLayoutPageTemplateFragmentId(layoutPageTemplateFragmentId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long layoutPageTemplateEntryId = (Long)attributes.get(
				"layoutPageTemplateEntryId");

		if (layoutPageTemplateEntryId != null) {
			setLayoutPageTemplateEntryId(layoutPageTemplateEntryId);
		}

		Long fragmentEntryId = (Long)attributes.get("fragmentEntryId");

		if (fragmentEntryId != null) {
			setFragmentEntryId(fragmentEntryId);
		}

		Integer position = (Integer)attributes.get("position");

		if (position != null) {
			setPosition(position);
		}
	}

	@Override
	public long getLayoutPageTemplateFragmentId() {
		return _layoutPageTemplateFragmentId;
	}

	@Override
	public void setLayoutPageTemplateFragmentId(
		long layoutPageTemplateFragmentId) {
		_layoutPageTemplateFragmentId = layoutPageTemplateFragmentId;
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return StringPool.BLANK;
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@Override
	public String getUserName() {
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		_modifiedDate = modifiedDate;
	}

	@Override
	public long getLayoutPageTemplateEntryId() {
		return _layoutPageTemplateEntryId;
	}

	@Override
	public void setLayoutPageTemplateEntryId(long layoutPageTemplateEntryId) {
		_columnBitmask |= LAYOUTPAGETEMPLATEENTRYID_COLUMN_BITMASK;

		if (!_setOriginalLayoutPageTemplateEntryId) {
			_setOriginalLayoutPageTemplateEntryId = true;

			_originalLayoutPageTemplateEntryId = _layoutPageTemplateEntryId;
		}

		_layoutPageTemplateEntryId = layoutPageTemplateEntryId;
	}

	public long getOriginalLayoutPageTemplateEntryId() {
		return _originalLayoutPageTemplateEntryId;
	}

	@Override
	public long getFragmentEntryId() {
		return _fragmentEntryId;
	}

	@Override
	public void setFragmentEntryId(long fragmentEntryId) {
		_columnBitmask |= FRAGMENTENTRYID_COLUMN_BITMASK;

		if (!_setOriginalFragmentEntryId) {
			_setOriginalFragmentEntryId = true;

			_originalFragmentEntryId = _fragmentEntryId;
		}

		_fragmentEntryId = fragmentEntryId;
	}

	public long getOriginalFragmentEntryId() {
		return _originalFragmentEntryId;
	}

	@Override
	public int getPosition() {
		return _position;
	}

	@Override
	public void setPosition(int position) {
		_position = position;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			LayoutPageTemplateFragment.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public LayoutPageTemplateFragment toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (LayoutPageTemplateFragment)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		LayoutPageTemplateFragmentImpl layoutPageTemplateFragmentImpl = new LayoutPageTemplateFragmentImpl();

		layoutPageTemplateFragmentImpl.setLayoutPageTemplateFragmentId(getLayoutPageTemplateFragmentId());
		layoutPageTemplateFragmentImpl.setGroupId(getGroupId());
		layoutPageTemplateFragmentImpl.setCompanyId(getCompanyId());
		layoutPageTemplateFragmentImpl.setUserId(getUserId());
		layoutPageTemplateFragmentImpl.setUserName(getUserName());
		layoutPageTemplateFragmentImpl.setCreateDate(getCreateDate());
		layoutPageTemplateFragmentImpl.setModifiedDate(getModifiedDate());
		layoutPageTemplateFragmentImpl.setLayoutPageTemplateEntryId(getLayoutPageTemplateEntryId());
		layoutPageTemplateFragmentImpl.setFragmentEntryId(getFragmentEntryId());
		layoutPageTemplateFragmentImpl.setPosition(getPosition());

		layoutPageTemplateFragmentImpl.resetOriginalValues();

		return layoutPageTemplateFragmentImpl;
	}

	@Override
	public int compareTo(LayoutPageTemplateFragment layoutPageTemplateFragment) {
		long primaryKey = layoutPageTemplateFragment.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LayoutPageTemplateFragment)) {
			return false;
		}

		LayoutPageTemplateFragment layoutPageTemplateFragment = (LayoutPageTemplateFragment)obj;

		long primaryKey = layoutPageTemplateFragment.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		LayoutPageTemplateFragmentModelImpl layoutPageTemplateFragmentModelImpl = this;

		layoutPageTemplateFragmentModelImpl._originalGroupId = layoutPageTemplateFragmentModelImpl._groupId;

		layoutPageTemplateFragmentModelImpl._setOriginalGroupId = false;

		layoutPageTemplateFragmentModelImpl._setModifiedDate = false;

		layoutPageTemplateFragmentModelImpl._originalLayoutPageTemplateEntryId = layoutPageTemplateFragmentModelImpl._layoutPageTemplateEntryId;

		layoutPageTemplateFragmentModelImpl._setOriginalLayoutPageTemplateEntryId = false;

		layoutPageTemplateFragmentModelImpl._originalFragmentEntryId = layoutPageTemplateFragmentModelImpl._fragmentEntryId;

		layoutPageTemplateFragmentModelImpl._setOriginalFragmentEntryId = false;

		layoutPageTemplateFragmentModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<LayoutPageTemplateFragment> toCacheModel() {
		LayoutPageTemplateFragmentCacheModel layoutPageTemplateFragmentCacheModel =
			new LayoutPageTemplateFragmentCacheModel();

		layoutPageTemplateFragmentCacheModel.layoutPageTemplateFragmentId = getLayoutPageTemplateFragmentId();

		layoutPageTemplateFragmentCacheModel.groupId = getGroupId();

		layoutPageTemplateFragmentCacheModel.companyId = getCompanyId();

		layoutPageTemplateFragmentCacheModel.userId = getUserId();

		layoutPageTemplateFragmentCacheModel.userName = getUserName();

		String userName = layoutPageTemplateFragmentCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			layoutPageTemplateFragmentCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			layoutPageTemplateFragmentCacheModel.createDate = createDate.getTime();
		}
		else {
			layoutPageTemplateFragmentCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			layoutPageTemplateFragmentCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			layoutPageTemplateFragmentCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		layoutPageTemplateFragmentCacheModel.layoutPageTemplateEntryId = getLayoutPageTemplateEntryId();

		layoutPageTemplateFragmentCacheModel.fragmentEntryId = getFragmentEntryId();

		layoutPageTemplateFragmentCacheModel.position = getPosition();

		return layoutPageTemplateFragmentCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{layoutPageTemplateFragmentId=");
		sb.append(getLayoutPageTemplateFragmentId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", layoutPageTemplateEntryId=");
		sb.append(getLayoutPageTemplateEntryId());
		sb.append(", fragmentEntryId=");
		sb.append(getFragmentEntryId());
		sb.append(", position=");
		sb.append(getPosition());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append(
			"com.liferay.layout.page.template.model.LayoutPageTemplateFragment");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>layoutPageTemplateFragmentId</column-name><column-value><![CDATA[");
		sb.append(getLayoutPageTemplateFragmentId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>layoutPageTemplateEntryId</column-name><column-value><![CDATA[");
		sb.append(getLayoutPageTemplateEntryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fragmentEntryId</column-name><column-value><![CDATA[");
		sb.append(getFragmentEntryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>position</column-name><column-value><![CDATA[");
		sb.append(getPosition());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = LayoutPageTemplateFragment.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			LayoutPageTemplateFragment.class
		};
	private long _layoutPageTemplateFragmentId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _layoutPageTemplateEntryId;
	private long _originalLayoutPageTemplateEntryId;
	private boolean _setOriginalLayoutPageTemplateEntryId;
	private long _fragmentEntryId;
	private long _originalFragmentEntryId;
	private boolean _setOriginalFragmentEntryId;
	private int _position;
	private long _columnBitmask;
	private LayoutPageTemplateFragment _escapedModel;
}