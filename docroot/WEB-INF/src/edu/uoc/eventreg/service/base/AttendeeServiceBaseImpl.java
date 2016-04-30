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

package edu.uoc.eventreg.service.base;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.BaseServiceImpl;
import com.liferay.portal.service.persistence.UserPersistence;

import edu.uoc.eventreg.model.Attendee;
import edu.uoc.eventreg.service.AttendeeService;
import edu.uoc.eventreg.service.persistence.AttendeePersistence;
import edu.uoc.eventreg.service.persistence.EventOptionPersistence;
import edu.uoc.eventreg.service.persistence.EventPersistence;
import edu.uoc.eventreg.service.persistence.ImagePersistence;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the attendee remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link edu.uoc.eventreg.service.impl.AttendeeServiceImpl}.
 * </p>
 *
 * @author Ana Mendoza
 * @see edu.uoc.eventreg.service.impl.AttendeeServiceImpl
 * @see edu.uoc.eventreg.service.AttendeeServiceUtil
 * @generated
 */
public abstract class AttendeeServiceBaseImpl extends BaseServiceImpl
	implements AttendeeService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link edu.uoc.eventreg.service.AttendeeServiceUtil} to access the attendee remote service.
	 */

	/**
	 * Returns the attendee local service.
	 *
	 * @return the attendee local service
	 */
	public edu.uoc.eventreg.service.AttendeeLocalService getAttendeeLocalService() {
		return attendeeLocalService;
	}

	/**
	 * Sets the attendee local service.
	 *
	 * @param attendeeLocalService the attendee local service
	 */
	public void setAttendeeLocalService(
		edu.uoc.eventreg.service.AttendeeLocalService attendeeLocalService) {
		this.attendeeLocalService = attendeeLocalService;
	}

	/**
	 * Returns the attendee remote service.
	 *
	 * @return the attendee remote service
	 */
	public edu.uoc.eventreg.service.AttendeeService getAttendeeService() {
		return attendeeService;
	}

	/**
	 * Sets the attendee remote service.
	 *
	 * @param attendeeService the attendee remote service
	 */
	public void setAttendeeService(
		edu.uoc.eventreg.service.AttendeeService attendeeService) {
		this.attendeeService = attendeeService;
	}

	/**
	 * Returns the attendee persistence.
	 *
	 * @return the attendee persistence
	 */
	public AttendeePersistence getAttendeePersistence() {
		return attendeePersistence;
	}

	/**
	 * Sets the attendee persistence.
	 *
	 * @param attendeePersistence the attendee persistence
	 */
	public void setAttendeePersistence(AttendeePersistence attendeePersistence) {
		this.attendeePersistence = attendeePersistence;
	}

	/**
	 * Returns the event local service.
	 *
	 * @return the event local service
	 */
	public edu.uoc.eventreg.service.EventLocalService getEventLocalService() {
		return eventLocalService;
	}

	/**
	 * Sets the event local service.
	 *
	 * @param eventLocalService the event local service
	 */
	public void setEventLocalService(
		edu.uoc.eventreg.service.EventLocalService eventLocalService) {
		this.eventLocalService = eventLocalService;
	}

	/**
	 * Returns the event remote service.
	 *
	 * @return the event remote service
	 */
	public edu.uoc.eventreg.service.EventService getEventService() {
		return eventService;
	}

	/**
	 * Sets the event remote service.
	 *
	 * @param eventService the event remote service
	 */
	public void setEventService(
		edu.uoc.eventreg.service.EventService eventService) {
		this.eventService = eventService;
	}

	/**
	 * Returns the event persistence.
	 *
	 * @return the event persistence
	 */
	public EventPersistence getEventPersistence() {
		return eventPersistence;
	}

	/**
	 * Sets the event persistence.
	 *
	 * @param eventPersistence the event persistence
	 */
	public void setEventPersistence(EventPersistence eventPersistence) {
		this.eventPersistence = eventPersistence;
	}

	/**
	 * Returns the event option local service.
	 *
	 * @return the event option local service
	 */
	public edu.uoc.eventreg.service.EventOptionLocalService getEventOptionLocalService() {
		return eventOptionLocalService;
	}

	/**
	 * Sets the event option local service.
	 *
	 * @param eventOptionLocalService the event option local service
	 */
	public void setEventOptionLocalService(
		edu.uoc.eventreg.service.EventOptionLocalService eventOptionLocalService) {
		this.eventOptionLocalService = eventOptionLocalService;
	}

	/**
	 * Returns the event option remote service.
	 *
	 * @return the event option remote service
	 */
	public edu.uoc.eventreg.service.EventOptionService getEventOptionService() {
		return eventOptionService;
	}

	/**
	 * Sets the event option remote service.
	 *
	 * @param eventOptionService the event option remote service
	 */
	public void setEventOptionService(
		edu.uoc.eventreg.service.EventOptionService eventOptionService) {
		this.eventOptionService = eventOptionService;
	}

	/**
	 * Returns the event option persistence.
	 *
	 * @return the event option persistence
	 */
	public EventOptionPersistence getEventOptionPersistence() {
		return eventOptionPersistence;
	}

	/**
	 * Sets the event option persistence.
	 *
	 * @param eventOptionPersistence the event option persistence
	 */
	public void setEventOptionPersistence(
		EventOptionPersistence eventOptionPersistence) {
		this.eventOptionPersistence = eventOptionPersistence;
	}

	/**
	 * Returns the image local service.
	 *
	 * @return the image local service
	 */
	public edu.uoc.eventreg.service.ImageLocalService getImageLocalService() {
		return imageLocalService;
	}

	/**
	 * Sets the image local service.
	 *
	 * @param imageLocalService the image local service
	 */
	public void setImageLocalService(
		edu.uoc.eventreg.service.ImageLocalService imageLocalService) {
		this.imageLocalService = imageLocalService;
	}

	/**
	 * Returns the image remote service.
	 *
	 * @return the image remote service
	 */
	public edu.uoc.eventreg.service.ImageService getImageService() {
		return imageService;
	}

	/**
	 * Sets the image remote service.
	 *
	 * @param imageService the image remote service
	 */
	public void setImageService(
		edu.uoc.eventreg.service.ImageService imageService) {
		this.imageService = imageService;
	}

	/**
	 * Returns the image persistence.
	 *
	 * @return the image persistence
	 */
	public ImagePersistence getImagePersistence() {
		return imagePersistence;
	}

	/**
	 * Sets the image persistence.
	 *
	 * @param imagePersistence the image persistence
	 */
	public void setImagePersistence(ImagePersistence imagePersistence) {
		this.imagePersistence = imagePersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.service.UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		Class<?> clazz = getClass();

		_classLoader = clazz.getClassLoader();
	}

	public void destroy() {
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	@Override
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	@Override
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	@Override
	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		if (contextClassLoader != _classLoader) {
			currentThread.setContextClassLoader(_classLoader);
		}

		try {
			return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	protected Class<?> getModelClass() {
		return Attendee.class;
	}

	protected String getModelClassName() {
		return Attendee.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = attendeePersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = edu.uoc.eventreg.service.AttendeeLocalService.class)
	protected edu.uoc.eventreg.service.AttendeeLocalService attendeeLocalService;
	@BeanReference(type = edu.uoc.eventreg.service.AttendeeService.class)
	protected edu.uoc.eventreg.service.AttendeeService attendeeService;
	@BeanReference(type = AttendeePersistence.class)
	protected AttendeePersistence attendeePersistence;
	@BeanReference(type = edu.uoc.eventreg.service.EventLocalService.class)
	protected edu.uoc.eventreg.service.EventLocalService eventLocalService;
	@BeanReference(type = edu.uoc.eventreg.service.EventService.class)
	protected edu.uoc.eventreg.service.EventService eventService;
	@BeanReference(type = EventPersistence.class)
	protected EventPersistence eventPersistence;
	@BeanReference(type = edu.uoc.eventreg.service.EventOptionLocalService.class)
	protected edu.uoc.eventreg.service.EventOptionLocalService eventOptionLocalService;
	@BeanReference(type = edu.uoc.eventreg.service.EventOptionService.class)
	protected edu.uoc.eventreg.service.EventOptionService eventOptionService;
	@BeanReference(type = EventOptionPersistence.class)
	protected EventOptionPersistence eventOptionPersistence;
	@BeanReference(type = edu.uoc.eventreg.service.ImageLocalService.class)
	protected edu.uoc.eventreg.service.ImageLocalService imageLocalService;
	@BeanReference(type = edu.uoc.eventreg.service.ImageService.class)
	protected edu.uoc.eventreg.service.ImageService imageService;
	@BeanReference(type = ImagePersistence.class)
	protected ImagePersistence imagePersistence;
	@BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
	protected com.liferay.counter.service.CounterLocalService counterLocalService;
	@BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
	protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
	@BeanReference(type = com.liferay.portal.service.UserLocalService.class)
	protected com.liferay.portal.service.UserLocalService userLocalService;
	@BeanReference(type = com.liferay.portal.service.UserService.class)
	protected com.liferay.portal.service.UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private ClassLoader _classLoader;
	private AttendeeServiceClpInvoker _clpInvoker = new AttendeeServiceClpInvoker();
}