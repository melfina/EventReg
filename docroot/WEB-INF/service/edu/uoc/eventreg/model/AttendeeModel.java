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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the Attendee service. Represents a row in the &quot;EVENTREG_Attendee&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link edu.uoc.eventreg.model.impl.AttendeeModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link edu.uoc.eventreg.model.impl.AttendeeImpl}.
 * </p>
 *
 * @author Ana Mendoza
 * @see Attendee
 * @see edu.uoc.eventreg.model.impl.AttendeeImpl
 * @see edu.uoc.eventreg.model.impl.AttendeeModelImpl
 * @generated
 */
public interface AttendeeModel extends BaseModel<Attendee> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a attendee model instance should use the {@link Attendee} interface instead.
	 */

	/**
	 * Returns the primary key of this attendee.
	 *
	 * @return the primary key of this attendee
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this attendee.
	 *
	 * @param primaryKey the primary key of this attendee
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the attendee ID of this attendee.
	 *
	 * @return the attendee ID of this attendee
	 */
	public long getAttendeeId();

	/**
	 * Sets the attendee ID of this attendee.
	 *
	 * @param attendeeId the attendee ID of this attendee
	 */
	public void setAttendeeId(long attendeeId);

	/**
	 * Returns the company ID of this attendee.
	 *
	 * @return the company ID of this attendee
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this attendee.
	 *
	 * @param companyId the company ID of this attendee
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the group ID of this attendee.
	 *
	 * @return the group ID of this attendee
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this attendee.
	 *
	 * @param groupId the group ID of this attendee
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the name of this attendee.
	 *
	 * @return the name of this attendee
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this attendee.
	 *
	 * @param name the name of this attendee
	 */
	public void setName(String name);

	/**
	 * Returns the surname of this attendee.
	 *
	 * @return the surname of this attendee
	 */
	@AutoEscape
	public String getSurname();

	/**
	 * Sets the surname of this attendee.
	 *
	 * @param surname the surname of this attendee
	 */
	public void setSurname(String surname);

	/**
	 * Returns the company of this attendee.
	 *
	 * @return the company of this attendee
	 */
	@AutoEscape
	public String getCompany();

	/**
	 * Sets the company of this attendee.
	 *
	 * @param company the company of this attendee
	 */
	public void setCompany(String company);

	/**
	 * Returns the email of this attendee.
	 *
	 * @return the email of this attendee
	 */
	@AutoEscape
	public String getEmail();

	/**
	 * Sets the email of this attendee.
	 *
	 * @param email the email of this attendee
	 */
	public void setEmail(String email);

	/**
	 * Returns the phone of this attendee.
	 *
	 * @return the phone of this attendee
	 */
	@AutoEscape
	public String getPhone();

	/**
	 * Sets the phone of this attendee.
	 *
	 * @param phone the phone of this attendee
	 */
	public void setPhone(String phone);

	/**
	 * Returns the register date of this attendee.
	 *
	 * @return the register date of this attendee
	 */
	public Date getRegisterDate();

	/**
	 * Sets the register date of this attendee.
	 *
	 * @param registerDate the register date of this attendee
	 */
	public void setRegisterDate(Date registerDate);

	/**
	 * Returns the reservation code of this attendee.
	 *
	 * @return the reservation code of this attendee
	 */
	@AutoEscape
	public String getReservationCode();

	/**
	 * Sets the reservation code of this attendee.
	 *
	 * @param reservationCode the reservation code of this attendee
	 */
	public void setReservationCode(String reservationCode);

	/**
	 * Returns the status of this attendee.
	 *
	 * @return the status of this attendee
	 */
	public int getStatus();

	/**
	 * Sets the status of this attendee.
	 *
	 * @param status the status of this attendee
	 */
	public void setStatus(int status);

	/**
	 * Returns the event option ID of this attendee.
	 *
	 * @return the event option ID of this attendee
	 */
	public long getEventOptionId();

	/**
	 * Sets the event option ID of this attendee.
	 *
	 * @param eventOptionId the event option ID of this attendee
	 */
	public void setEventOptionId(long eventOptionId);

	/**
	 * Returns the managed by of this attendee.
	 *
	 * @return the managed by of this attendee
	 */
	public long getManagedBy();

	/**
	 * Sets the managed by of this attendee.
	 *
	 * @param managedBy the managed by of this attendee
	 */
	public void setManagedBy(long managedBy);

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
	public int compareTo(edu.uoc.eventreg.model.Attendee attendee);

	@Override
	public int hashCode();

	@Override
	public CacheModel<edu.uoc.eventreg.model.Attendee> toCacheModel();

	@Override
	public edu.uoc.eventreg.model.Attendee toEscapedModel();

	@Override
	public edu.uoc.eventreg.model.Attendee toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}