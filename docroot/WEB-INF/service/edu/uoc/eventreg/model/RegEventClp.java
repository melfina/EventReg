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
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import edu.uoc.eventreg.service.ClpSerializer;
import edu.uoc.eventreg.service.RegEventLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Ana Mendoza
 */
public class RegEventClp extends BaseModelImpl<RegEvent> implements RegEvent {
	public RegEventClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return RegEvent.class;
	}

	@Override
	public String getModelClassName() {
		return RegEvent.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _id;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _id;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("title", getTitle());
		attributes.put("description", getDescription());
		attributes.put("address", getAddress());
		attributes.put("location", getLocation());
		attributes.put("coordX", getCoordX());
		attributes.put("coordY", getCoordY());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("requiresApproval", getRequiresApproval());
		attributes.put("status", getStatus());
		attributes.put("createdBy", getCreatedBy());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String address = (String)attributes.get("address");

		if (address != null) {
			setAddress(address);
		}

		String location = (String)attributes.get("location");

		if (location != null) {
			setLocation(location);
		}

		String coordX = (String)attributes.get("coordX");

		if (coordX != null) {
			setCoordX(coordX);
		}

		String coordY = (String)attributes.get("coordY");

		if (coordY != null) {
			setCoordY(coordY);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Boolean requiresApproval = (Boolean)attributes.get("requiresApproval");

		if (requiresApproval != null) {
			setRequiresApproval(requiresApproval);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long createdBy = (Long)attributes.get("createdBy");

		if (createdBy != null) {
			setCreatedBy(createdBy);
		}
	}

	@Override
	public long getId() {
		return _id;
	}

	@Override
	public void setId(long id) {
		_id = id;

		if (_regEventRemoteModel != null) {
			try {
				Class<?> clazz = _regEventRemoteModel.getClass();

				Method method = clazz.getMethod("setId", long.class);

				method.invoke(_regEventRemoteModel, id);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_regEventRemoteModel != null) {
			try {
				Class<?> clazz = _regEventRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_regEventRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_regEventRemoteModel != null) {
			try {
				Class<?> clazz = _regEventRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_regEventRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTitle() {
		return _title;
	}

	@Override
	public String getTitle(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getTitle(languageId);
	}

	@Override
	public String getTitle(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getTitle(languageId, useDefault);
	}

	@Override
	public String getTitle(String languageId) {
		return LocalizationUtil.getLocalization(getTitle(), languageId);
	}

	@Override
	public String getTitle(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(getTitle(), languageId,
			useDefault);
	}

	@Override
	public String getTitleCurrentLanguageId() {
		return _titleCurrentLanguageId;
	}

	@Override
	public String getTitleCurrentValue() {
		Locale locale = getLocale(_titleCurrentLanguageId);

		return getTitle(locale);
	}

	@Override
	public Map<Locale, String> getTitleMap() {
		return LocalizationUtil.getLocalizationMap(getTitle());
	}

	@Override
	public void setTitle(String title) {
		_title = title;

		if (_regEventRemoteModel != null) {
			try {
				Class<?> clazz = _regEventRemoteModel.getClass();

				Method method = clazz.getMethod("setTitle", String.class);

				method.invoke(_regEventRemoteModel, title);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public void setTitle(String title, Locale locale) {
		setTitle(title, locale, LocaleUtil.getDefault());
	}

	@Override
	public void setTitle(String title, Locale locale, Locale defaultLocale) {
		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(title)) {
			setTitle(LocalizationUtil.updateLocalization(getTitle(), "Title",
					title, languageId, defaultLanguageId));
		}
		else {
			setTitle(LocalizationUtil.removeLocalization(getTitle(), "Title",
					languageId));
		}
	}

	@Override
	public void setTitleCurrentLanguageId(String languageId) {
		_titleCurrentLanguageId = languageId;
	}

	@Override
	public void setTitleMap(Map<Locale, String> titleMap) {
		setTitleMap(titleMap, LocaleUtil.getDefault());
	}

	@Override
	public void setTitleMap(Map<Locale, String> titleMap, Locale defaultLocale) {
		if (titleMap == null) {
			return;
		}

		ClassLoader portalClassLoader = PortalClassLoaderUtil.getClassLoader();

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(portalClassLoader);
			}

			setTitle(LocalizationUtil.updateLocalization(titleMap, getTitle(),
					"Title", LocaleUtil.toLanguageId(defaultLocale)));
		}
		finally {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	@Override
	public String getDescription() {
		return _description;
	}

	@Override
	public String getDescription(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getDescription(languageId);
	}

	@Override
	public String getDescription(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getDescription(languageId, useDefault);
	}

	@Override
	public String getDescription(String languageId) {
		return LocalizationUtil.getLocalization(getDescription(), languageId);
	}

	@Override
	public String getDescription(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(getDescription(), languageId,
			useDefault);
	}

	@Override
	public String getDescriptionCurrentLanguageId() {
		return _descriptionCurrentLanguageId;
	}

	@Override
	public String getDescriptionCurrentValue() {
		Locale locale = getLocale(_descriptionCurrentLanguageId);

		return getDescription(locale);
	}

	@Override
	public Map<Locale, String> getDescriptionMap() {
		return LocalizationUtil.getLocalizationMap(getDescription());
	}

	@Override
	public void setDescription(String description) {
		_description = description;

		if (_regEventRemoteModel != null) {
			try {
				Class<?> clazz = _regEventRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_regEventRemoteModel, description);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public void setDescription(String description, Locale locale) {
		setDescription(description, locale, LocaleUtil.getDefault());
	}

	@Override
	public void setDescription(String description, Locale locale,
		Locale defaultLocale) {
		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(description)) {
			setDescription(LocalizationUtil.updateLocalization(
					getDescription(), "Description", description, languageId,
					defaultLanguageId));
		}
		else {
			setDescription(LocalizationUtil.removeLocalization(
					getDescription(), "Description", languageId));
		}
	}

	@Override
	public void setDescriptionCurrentLanguageId(String languageId) {
		_descriptionCurrentLanguageId = languageId;
	}

	@Override
	public void setDescriptionMap(Map<Locale, String> descriptionMap) {
		setDescriptionMap(descriptionMap, LocaleUtil.getDefault());
	}

	@Override
	public void setDescriptionMap(Map<Locale, String> descriptionMap,
		Locale defaultLocale) {
		if (descriptionMap == null) {
			return;
		}

		ClassLoader portalClassLoader = PortalClassLoaderUtil.getClassLoader();

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(portalClassLoader);
			}

			setDescription(LocalizationUtil.updateLocalization(descriptionMap,
					getDescription(), "Description",
					LocaleUtil.toLanguageId(defaultLocale)));
		}
		finally {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	@Override
	public String getAddress() {
		return _address;
	}

	@Override
	public String getAddress(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getAddress(languageId);
	}

	@Override
	public String getAddress(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getAddress(languageId, useDefault);
	}

	@Override
	public String getAddress(String languageId) {
		return LocalizationUtil.getLocalization(getAddress(), languageId);
	}

	@Override
	public String getAddress(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(getAddress(), languageId,
			useDefault);
	}

	@Override
	public String getAddressCurrentLanguageId() {
		return _addressCurrentLanguageId;
	}

	@Override
	public String getAddressCurrentValue() {
		Locale locale = getLocale(_addressCurrentLanguageId);

		return getAddress(locale);
	}

	@Override
	public Map<Locale, String> getAddressMap() {
		return LocalizationUtil.getLocalizationMap(getAddress());
	}

	@Override
	public void setAddress(String address) {
		_address = address;

		if (_regEventRemoteModel != null) {
			try {
				Class<?> clazz = _regEventRemoteModel.getClass();

				Method method = clazz.getMethod("setAddress", String.class);

				method.invoke(_regEventRemoteModel, address);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public void setAddress(String address, Locale locale) {
		setAddress(address, locale, LocaleUtil.getDefault());
	}

	@Override
	public void setAddress(String address, Locale locale, Locale defaultLocale) {
		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(address)) {
			setAddress(LocalizationUtil.updateLocalization(getAddress(),
					"Address", address, languageId, defaultLanguageId));
		}
		else {
			setAddress(LocalizationUtil.removeLocalization(getAddress(),
					"Address", languageId));
		}
	}

	@Override
	public void setAddressCurrentLanguageId(String languageId) {
		_addressCurrentLanguageId = languageId;
	}

	@Override
	public void setAddressMap(Map<Locale, String> addressMap) {
		setAddressMap(addressMap, LocaleUtil.getDefault());
	}

	@Override
	public void setAddressMap(Map<Locale, String> addressMap,
		Locale defaultLocale) {
		if (addressMap == null) {
			return;
		}

		ClassLoader portalClassLoader = PortalClassLoaderUtil.getClassLoader();

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(portalClassLoader);
			}

			setAddress(LocalizationUtil.updateLocalization(addressMap,
					getAddress(), "Address",
					LocaleUtil.toLanguageId(defaultLocale)));
		}
		finally {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	@Override
	public String getLocation() {
		return _location;
	}

	@Override
	public String getLocation(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getLocation(languageId);
	}

	@Override
	public String getLocation(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getLocation(languageId, useDefault);
	}

	@Override
	public String getLocation(String languageId) {
		return LocalizationUtil.getLocalization(getLocation(), languageId);
	}

	@Override
	public String getLocation(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(getLocation(), languageId,
			useDefault);
	}

	@Override
	public String getLocationCurrentLanguageId() {
		return _locationCurrentLanguageId;
	}

	@Override
	public String getLocationCurrentValue() {
		Locale locale = getLocale(_locationCurrentLanguageId);

		return getLocation(locale);
	}

	@Override
	public Map<Locale, String> getLocationMap() {
		return LocalizationUtil.getLocalizationMap(getLocation());
	}

	@Override
	public void setLocation(String location) {
		_location = location;

		if (_regEventRemoteModel != null) {
			try {
				Class<?> clazz = _regEventRemoteModel.getClass();

				Method method = clazz.getMethod("setLocation", String.class);

				method.invoke(_regEventRemoteModel, location);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public void setLocation(String location, Locale locale) {
		setLocation(location, locale, LocaleUtil.getDefault());
	}

	@Override
	public void setLocation(String location, Locale locale, Locale defaultLocale) {
		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(location)) {
			setLocation(LocalizationUtil.updateLocalization(getLocation(),
					"Location", location, languageId, defaultLanguageId));
		}
		else {
			setLocation(LocalizationUtil.removeLocalization(getLocation(),
					"Location", languageId));
		}
	}

	@Override
	public void setLocationCurrentLanguageId(String languageId) {
		_locationCurrentLanguageId = languageId;
	}

	@Override
	public void setLocationMap(Map<Locale, String> locationMap) {
		setLocationMap(locationMap, LocaleUtil.getDefault());
	}

	@Override
	public void setLocationMap(Map<Locale, String> locationMap,
		Locale defaultLocale) {
		if (locationMap == null) {
			return;
		}

		ClassLoader portalClassLoader = PortalClassLoaderUtil.getClassLoader();

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(portalClassLoader);
			}

			setLocation(LocalizationUtil.updateLocalization(locationMap,
					getLocation(), "Location",
					LocaleUtil.toLanguageId(defaultLocale)));
		}
		finally {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	@Override
	public String getCoordX() {
		return _coordX;
	}

	@Override
	public void setCoordX(String coordX) {
		_coordX = coordX;

		if (_regEventRemoteModel != null) {
			try {
				Class<?> clazz = _regEventRemoteModel.getClass();

				Method method = clazz.getMethod("setCoordX", String.class);

				method.invoke(_regEventRemoteModel, coordX);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCoordY() {
		return _coordY;
	}

	@Override
	public void setCoordY(String coordY) {
		_coordY = coordY;

		if (_regEventRemoteModel != null) {
			try {
				Class<?> clazz = _regEventRemoteModel.getClass();

				Method method = clazz.getMethod("setCoordY", String.class);

				method.invoke(_regEventRemoteModel, coordY);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_regEventRemoteModel != null) {
			try {
				Class<?> clazz = _regEventRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_regEventRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_regEventRemoteModel != null) {
			try {
				Class<?> clazz = _regEventRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_regEventRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getRequiresApproval() {
		return _requiresApproval;
	}

	@Override
	public boolean isRequiresApproval() {
		return _requiresApproval;
	}

	@Override
	public void setRequiresApproval(boolean requiresApproval) {
		_requiresApproval = requiresApproval;

		if (_regEventRemoteModel != null) {
			try {
				Class<?> clazz = _regEventRemoteModel.getClass();

				Method method = clazz.getMethod("setRequiresApproval",
						boolean.class);

				method.invoke(_regEventRemoteModel, requiresApproval);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		_status = status;

		if (_regEventRemoteModel != null) {
			try {
				Class<?> clazz = _regEventRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", int.class);

				method.invoke(_regEventRemoteModel, status);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCreatedBy() {
		return _createdBy;
	}

	@Override
	public void setCreatedBy(long createdBy) {
		_createdBy = createdBy;

		if (_regEventRemoteModel != null) {
			try {
				Class<?> clazz = _regEventRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedBy", long.class);

				method.invoke(_regEventRemoteModel, createdBy);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getRegEventRemoteModel() {
		return _regEventRemoteModel;
	}

	public void setRegEventRemoteModel(BaseModel<?> regEventRemoteModel) {
		_regEventRemoteModel = regEventRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _regEventRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_regEventRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			RegEventLocalServiceUtil.addRegEvent(this);
		}
		else {
			RegEventLocalServiceUtil.updateRegEvent(this);
		}
	}

	@Override
	public String[] getAvailableLanguageIds() {
		Set<String> availableLanguageIds = new TreeSet<String>();

		Map<Locale, String> titleMap = getTitleMap();

		for (Map.Entry<Locale, String> entry : titleMap.entrySet()) {
			Locale locale = entry.getKey();
			String value = entry.getValue();

			if (Validator.isNotNull(value)) {
				availableLanguageIds.add(LocaleUtil.toLanguageId(locale));
			}
		}

		Map<Locale, String> descriptionMap = getDescriptionMap();

		for (Map.Entry<Locale, String> entry : descriptionMap.entrySet()) {
			Locale locale = entry.getKey();
			String value = entry.getValue();

			if (Validator.isNotNull(value)) {
				availableLanguageIds.add(LocaleUtil.toLanguageId(locale));
			}
		}

		Map<Locale, String> addressMap = getAddressMap();

		for (Map.Entry<Locale, String> entry : addressMap.entrySet()) {
			Locale locale = entry.getKey();
			String value = entry.getValue();

			if (Validator.isNotNull(value)) {
				availableLanguageIds.add(LocaleUtil.toLanguageId(locale));
			}
		}

		Map<Locale, String> locationMap = getLocationMap();

		for (Map.Entry<Locale, String> entry : locationMap.entrySet()) {
			Locale locale = entry.getKey();
			String value = entry.getValue();

			if (Validator.isNotNull(value)) {
				availableLanguageIds.add(LocaleUtil.toLanguageId(locale));
			}
		}

		return availableLanguageIds.toArray(new String[availableLanguageIds.size()]);
	}

	@Override
	public String getDefaultLanguageId() {
		String xml = getTitle();

		if (xml == null) {
			return StringPool.BLANK;
		}

		Locale defaultLocale = LocaleUtil.getDefault();

		return LocalizationUtil.getDefaultLanguageId(xml, defaultLocale);
	}

	@Override
	public void prepareLocalizedFieldsForImport() throws LocaleException {
		prepareLocalizedFieldsForImport(null);
	}

	@Override
	@SuppressWarnings("unused")
	public void prepareLocalizedFieldsForImport(Locale defaultImportLocale)
		throws LocaleException {
		Locale defaultLocale = LocaleUtil.getDefault();

		String modelDefaultLanguageId = getDefaultLanguageId();

		String title = getTitle(defaultLocale);

		if (Validator.isNull(title)) {
			setTitle(getTitle(modelDefaultLanguageId), defaultLocale);
		}
		else {
			setTitle(getTitle(defaultLocale), defaultLocale, defaultLocale);
		}

		String description = getDescription(defaultLocale);

		if (Validator.isNull(description)) {
			setDescription(getDescription(modelDefaultLanguageId), defaultLocale);
		}
		else {
			setDescription(getDescription(defaultLocale), defaultLocale,
				defaultLocale);
		}

		String address = getAddress(defaultLocale);

		if (Validator.isNull(address)) {
			setAddress(getAddress(modelDefaultLanguageId), defaultLocale);
		}
		else {
			setAddress(getAddress(defaultLocale), defaultLocale, defaultLocale);
		}

		String location = getLocation(defaultLocale);

		if (Validator.isNull(location)) {
			setLocation(getLocation(modelDefaultLanguageId), defaultLocale);
		}
		else {
			setLocation(getLocation(defaultLocale), defaultLocale, defaultLocale);
		}
	}

	@Override
	public RegEvent toEscapedModel() {
		return (RegEvent)ProxyUtil.newProxyInstance(RegEvent.class.getClassLoader(),
			new Class[] { RegEvent.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		RegEventClp clone = new RegEventClp();

		clone.setId(getId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setTitle(getTitle());
		clone.setDescription(getDescription());
		clone.setAddress(getAddress());
		clone.setLocation(getLocation());
		clone.setCoordX(getCoordX());
		clone.setCoordY(getCoordY());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setRequiresApproval(getRequiresApproval());
		clone.setStatus(getStatus());
		clone.setCreatedBy(getCreatedBy());

		return clone;
	}

	@Override
	public int compareTo(RegEvent regEvent) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(), regEvent.getCreateDate());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RegEventClp)) {
			return false;
		}

		RegEventClp regEvent = (RegEventClp)obj;

		long primaryKey = regEvent.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", address=");
		sb.append(getAddress());
		sb.append(", location=");
		sb.append(getLocation());
		sb.append(", coordX=");
		sb.append(getCoordX());
		sb.append(", coordY=");
		sb.append(getCoordY());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", requiresApproval=");
		sb.append(getRequiresApproval());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", createdBy=");
		sb.append(getCreatedBy());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(46);

		sb.append("<model><model-name>");
		sb.append("edu.uoc.eventreg.model.RegEvent");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>address</column-name><column-value><![CDATA[");
		sb.append(getAddress());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>location</column-name><column-value><![CDATA[");
		sb.append(getLocation());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>coordX</column-name><column-value><![CDATA[");
		sb.append(getCoordX());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>coordY</column-name><column-value><![CDATA[");
		sb.append(getCoordY());
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
			"<column><column-name>requiresApproval</column-name><column-value><![CDATA[");
		sb.append(getRequiresApproval());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createdBy</column-name><column-value><![CDATA[");
		sb.append(getCreatedBy());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private long _companyId;
	private long _groupId;
	private String _title;
	private String _titleCurrentLanguageId;
	private String _description;
	private String _descriptionCurrentLanguageId;
	private String _address;
	private String _addressCurrentLanguageId;
	private String _location;
	private String _locationCurrentLanguageId;
	private String _coordX;
	private String _coordY;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _requiresApproval;
	private int _status;
	private long _createdBy;
	private BaseModel<?> _regEventRemoteModel;
	private Class<?> _clpSerializerClass = edu.uoc.eventreg.service.ClpSerializer.class;
}