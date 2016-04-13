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

package edu.uoc.eventreg.model;

import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the EventOption service. Represents a row in the &quot;EVENTREG_EventOption&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link edu.uoc.eventreg.model.impl.EventOptionModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link edu.uoc.eventreg.model.impl.EventOptionImpl}.
 * </p>
 *
 * @author Ana Mendoza
 * @see EventOption
 * @see edu.uoc.eventreg.model.impl.EventOptionImpl
 * @see edu.uoc.eventreg.model.impl.EventOptionModelImpl
 * @generated
 */
public interface EventOptionModel extends BaseModel<EventOption> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a event option model instance should use the {@link EventOption} interface instead.
	 */

	/**
	 * Returns the primary key of this event option.
	 *
	 * @return the primary key of this event option
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this event option.
	 *
	 * @param primaryKey the primary key of this event option
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the ID of this event option.
	 *
	 * @return the ID of this event option
	 */
	public long getId();

	/**
	 * Sets the ID of this event option.
	 *
	 * @param id the ID of this event option
	 */
	public void setId(long id);

	/**
	 * Returns the company ID of this event option.
	 *
	 * @return the company ID of this event option
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this event option.
	 *
	 * @param companyId the company ID of this event option
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the group ID of this event option.
	 *
	 * @return the group ID of this event option
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this event option.
	 *
	 * @param groupId the group ID of this event option
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the start date of this event option.
	 *
	 * @return the start date of this event option
	 */
	public Date getStartDate();

	/**
	 * Sets the start date of this event option.
	 *
	 * @param startDate the start date of this event option
	 */
	public void setStartDate(Date startDate);

	/**
	 * Returns the end date of this event option.
	 *
	 * @return the end date of this event option
	 */
	public Date getEndDate();

	/**
	 * Sets the end date of this event option.
	 *
	 * @param endDate the end date of this event option
	 */
	public void setEndDate(Date endDate);

	/**
	 * Returns the price of this event option.
	 *
	 * @return the price of this event option
	 */
	public double getPrice();

	/**
	 * Sets the price of this event option.
	 *
	 * @param price the price of this event option
	 */
	public void setPrice(double price);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(edu.uoc.eventreg.model.EventOption eventOption);

	@Override
	public int hashCode();

	@Override
	public CacheModel<edu.uoc.eventreg.model.EventOption> toCacheModel();

	@Override
	public edu.uoc.eventreg.model.EventOption toEscapedModel();

	@Override
	public edu.uoc.eventreg.model.EventOption toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}