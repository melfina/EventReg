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

import com.liferay.portal.LocaleException;
import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;
import java.util.Locale;
import java.util.Map;

/**
 * The base model interface for the Event service. Represents a row in the &quot;EVENTREG_Event&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link edu.uoc.eventreg.model.impl.EventModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link edu.uoc.eventreg.model.impl.EventImpl}.
 * </p>
 *
 * @author Ana Mendoza
 * @see Event
 * @see edu.uoc.eventreg.model.impl.EventImpl
 * @see edu.uoc.eventreg.model.impl.EventModelImpl
 * @generated
 */
public interface EventModel extends BaseModel<Event> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a event model instance should use the {@link Event} interface instead.
	 */

	/**
	 * Returns the primary key of this event.
	 *
	 * @return the primary key of this event
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this event.
	 *
	 * @param primaryKey the primary key of this event
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the ID of this event.
	 *
	 * @return the ID of this event
	 */
	public long getId();

	/**
	 * Sets the ID of this event.
	 *
	 * @param id the ID of this event
	 */
	public void setId(long id);

	/**
	 * Returns the company ID of this event.
	 *
	 * @return the company ID of this event
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this event.
	 *
	 * @param companyId the company ID of this event
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the group ID of this event.
	 *
	 * @return the group ID of this event
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this event.
	 *
	 * @param groupId the group ID of this event
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the title of this event.
	 *
	 * @return the title of this event
	 */
	public String getTitle();

	/**
	 * Returns the localized title of this event in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized title of this event
	 */
	@AutoEscape
	public String getTitle(Locale locale);

	/**
	 * Returns the localized title of this event in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized title of this event. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getTitle(Locale locale, boolean useDefault);

	/**
	 * Returns the localized title of this event in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized title of this event
	 */
	@AutoEscape
	public String getTitle(String languageId);

	/**
	 * Returns the localized title of this event in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized title of this event
	 */
	@AutoEscape
	public String getTitle(String languageId, boolean useDefault);

	@AutoEscape
	public String getTitleCurrentLanguageId();

	@AutoEscape
	public String getTitleCurrentValue();

	/**
	 * Returns a map of the locales and localized titles of this event.
	 *
	 * @return the locales and localized titles of this event
	 */
	public Map<Locale, String> getTitleMap();

	/**
	 * Sets the title of this event.
	 *
	 * @param title the title of this event
	 */
	public void setTitle(String title);

	/**
	 * Sets the localized title of this event in the language.
	 *
	 * @param title the localized title of this event
	 * @param locale the locale of the language
	 */
	public void setTitle(String title, Locale locale);

	/**
	 * Sets the localized title of this event in the language, and sets the default locale.
	 *
	 * @param title the localized title of this event
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setTitle(String title, Locale locale, Locale defaultLocale);

	public void setTitleCurrentLanguageId(String languageId);

	/**
	 * Sets the localized titles of this event from the map of locales and localized titles.
	 *
	 * @param titleMap the locales and localized titles of this event
	 */
	public void setTitleMap(Map<Locale, String> titleMap);

	/**
	 * Sets the localized titles of this event from the map of locales and localized titles, and sets the default locale.
	 *
	 * @param titleMap the locales and localized titles of this event
	 * @param defaultLocale the default locale
	 */
	public void setTitleMap(Map<Locale, String> titleMap, Locale defaultLocale);

	/**
	 * Returns the description of this event.
	 *
	 * @return the description of this event
	 */
	public String getDescription();

	/**
	 * Returns the localized description of this event in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized description of this event
	 */
	@AutoEscape
	public String getDescription(Locale locale);

	/**
	 * Returns the localized description of this event in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized description of this event. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getDescription(Locale locale, boolean useDefault);

	/**
	 * Returns the localized description of this event in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized description of this event
	 */
	@AutoEscape
	public String getDescription(String languageId);

	/**
	 * Returns the localized description of this event in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized description of this event
	 */
	@AutoEscape
	public String getDescription(String languageId, boolean useDefault);

	@AutoEscape
	public String getDescriptionCurrentLanguageId();

	@AutoEscape
	public String getDescriptionCurrentValue();

	/**
	 * Returns a map of the locales and localized descriptions of this event.
	 *
	 * @return the locales and localized descriptions of this event
	 */
	public Map<Locale, String> getDescriptionMap();

	/**
	 * Sets the description of this event.
	 *
	 * @param description the description of this event
	 */
	public void setDescription(String description);

	/**
	 * Sets the localized description of this event in the language.
	 *
	 * @param description the localized description of this event
	 * @param locale the locale of the language
	 */
	public void setDescription(String description, Locale locale);

	/**
	 * Sets the localized description of this event in the language, and sets the default locale.
	 *
	 * @param description the localized description of this event
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setDescription(String description, Locale locale,
		Locale defaultLocale);

	public void setDescriptionCurrentLanguageId(String languageId);

	/**
	 * Sets the localized descriptions of this event from the map of locales and localized descriptions.
	 *
	 * @param descriptionMap the locales and localized descriptions of this event
	 */
	public void setDescriptionMap(Map<Locale, String> descriptionMap);

	/**
	 * Sets the localized descriptions of this event from the map of locales and localized descriptions, and sets the default locale.
	 *
	 * @param descriptionMap the locales and localized descriptions of this event
	 * @param defaultLocale the default locale
	 */
	public void setDescriptionMap(Map<Locale, String> descriptionMap,
		Locale defaultLocale);

	/**
	 * Returns the address of this event.
	 *
	 * @return the address of this event
	 */
	public String getAddress();

	/**
	 * Returns the localized address of this event in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized address of this event
	 */
	@AutoEscape
	public String getAddress(Locale locale);

	/**
	 * Returns the localized address of this event in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized address of this event. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getAddress(Locale locale, boolean useDefault);

	/**
	 * Returns the localized address of this event in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized address of this event
	 */
	@AutoEscape
	public String getAddress(String languageId);

	/**
	 * Returns the localized address of this event in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized address of this event
	 */
	@AutoEscape
	public String getAddress(String languageId, boolean useDefault);

	@AutoEscape
	public String getAddressCurrentLanguageId();

	@AutoEscape
	public String getAddressCurrentValue();

	/**
	 * Returns a map of the locales and localized addresses of this event.
	 *
	 * @return the locales and localized addresses of this event
	 */
	public Map<Locale, String> getAddressMap();

	/**
	 * Sets the address of this event.
	 *
	 * @param address the address of this event
	 */
	public void setAddress(String address);

	/**
	 * Sets the localized address of this event in the language.
	 *
	 * @param address the localized address of this event
	 * @param locale the locale of the language
	 */
	public void setAddress(String address, Locale locale);

	/**
	 * Sets the localized address of this event in the language, and sets the default locale.
	 *
	 * @param address the localized address of this event
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setAddress(String address, Locale locale, Locale defaultLocale);

	public void setAddressCurrentLanguageId(String languageId);

	/**
	 * Sets the localized addresses of this event from the map of locales and localized addresses.
	 *
	 * @param addressMap the locales and localized addresses of this event
	 */
	public void setAddressMap(Map<Locale, String> addressMap);

	/**
	 * Sets the localized addresses of this event from the map of locales and localized addresses, and sets the default locale.
	 *
	 * @param addressMap the locales and localized addresses of this event
	 * @param defaultLocale the default locale
	 */
	public void setAddressMap(Map<Locale, String> addressMap,
		Locale defaultLocale);

	/**
	 * Returns the location of this event.
	 *
	 * @return the location of this event
	 */
	public String getLocation();

	/**
	 * Returns the localized location of this event in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized location of this event
	 */
	@AutoEscape
	public String getLocation(Locale locale);

	/**
	 * Returns the localized location of this event in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized location of this event. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getLocation(Locale locale, boolean useDefault);

	/**
	 * Returns the localized location of this event in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized location of this event
	 */
	@AutoEscape
	public String getLocation(String languageId);

	/**
	 * Returns the localized location of this event in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized location of this event
	 */
	@AutoEscape
	public String getLocation(String languageId, boolean useDefault);

	@AutoEscape
	public String getLocationCurrentLanguageId();

	@AutoEscape
	public String getLocationCurrentValue();

	/**
	 * Returns a map of the locales and localized locations of this event.
	 *
	 * @return the locales and localized locations of this event
	 */
	public Map<Locale, String> getLocationMap();

	/**
	 * Sets the location of this event.
	 *
	 * @param location the location of this event
	 */
	public void setLocation(String location);

	/**
	 * Sets the localized location of this event in the language.
	 *
	 * @param location the localized location of this event
	 * @param locale the locale of the language
	 */
	public void setLocation(String location, Locale locale);

	/**
	 * Sets the localized location of this event in the language, and sets the default locale.
	 *
	 * @param location the localized location of this event
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setLocation(String location, Locale locale, Locale defaultLocale);

	public void setLocationCurrentLanguageId(String languageId);

	/**
	 * Sets the localized locations of this event from the map of locales and localized locations.
	 *
	 * @param locationMap the locales and localized locations of this event
	 */
	public void setLocationMap(Map<Locale, String> locationMap);

	/**
	 * Sets the localized locations of this event from the map of locales and localized locations, and sets the default locale.
	 *
	 * @param locationMap the locales and localized locations of this event
	 * @param defaultLocale the default locale
	 */
	public void setLocationMap(Map<Locale, String> locationMap,
		Locale defaultLocale);

	/**
	 * Returns the coord x of this event.
	 *
	 * @return the coord x of this event
	 */
	@AutoEscape
	public String getCoordX();

	/**
	 * Sets the coord x of this event.
	 *
	 * @param coordX the coord x of this event
	 */
	public void setCoordX(String coordX);

	/**
	 * Returns the coord y of this event.
	 *
	 * @return the coord y of this event
	 */
	@AutoEscape
	public String getCoordY();

	/**
	 * Sets the coord y of this event.
	 *
	 * @param coordY the coord y of this event
	 */
	public void setCoordY(String coordY);

	/**
	 * Returns the create date of this event.
	 *
	 * @return the create date of this event
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this event.
	 *
	 * @param createDate the create date of this event
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this event.
	 *
	 * @return the modified date of this event
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this event.
	 *
	 * @param modifiedDate the modified date of this event
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the requires approval of this event.
	 *
	 * @return the requires approval of this event
	 */
	public boolean getRequiresApproval();

	/**
	 * Returns <code>true</code> if this event is requires approval.
	 *
	 * @return <code>true</code> if this event is requires approval; <code>false</code> otherwise
	 */
	public boolean isRequiresApproval();

	/**
	 * Sets whether this event is requires approval.
	 *
	 * @param requiresApproval the requires approval of this event
	 */
	public void setRequiresApproval(boolean requiresApproval);

	/**
	 * Returns the status of this event.
	 *
	 * @return the status of this event
	 */
	public int getStatus();

	/**
	 * Sets the status of this event.
	 *
	 * @param status the status of this event
	 */
	public void setStatus(int status);

	/**
	 * Returns the created by of this event.
	 *
	 * @return the created by of this event
	 */
	public long getCreatedBy();

	/**
	 * Sets the created by of this event.
	 *
	 * @param createdBy the created by of this event
	 */
	public void setCreatedBy(long createdBy);

	/**
	 * Returns the start date of this event.
	 *
	 * @return the start date of this event
	 */
	public Date getStartDate();

	/**
	 * Sets the start date of this event.
	 *
	 * @param startDate the start date of this event
	 */
	public void setStartDate(Date startDate);

	/**
	 * Returns the end date of this event.
	 *
	 * @return the end date of this event
	 */
	public Date getEndDate();

	/**
	 * Sets the end date of this event.
	 *
	 * @param endDate the end date of this event
	 */
	public void setEndDate(Date endDate);

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

	public String[] getAvailableLanguageIds();

	public String getDefaultLanguageId();

	public void prepareLocalizedFieldsForImport() throws LocaleException;

	public void prepareLocalizedFieldsForImport(Locale defaultImportLocale)
		throws LocaleException;

	@Override
	public Object clone();

	@Override
	public int compareTo(edu.uoc.eventreg.model.Event event);

	@Override
	public int hashCode();

	@Override
	public CacheModel<edu.uoc.eventreg.model.Event> toCacheModel();

	@Override
	public edu.uoc.eventreg.model.Event toEscapedModel();

	@Override
	public edu.uoc.eventreg.model.Event toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}