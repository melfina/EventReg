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
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.persistence.UserPersistence;

import edu.uoc.eventreg.model.Attendee;
import edu.uoc.eventreg.service.AttendeeLocalService;
import edu.uoc.eventreg.service.persistence.AttendeeFinder;
import edu.uoc.eventreg.service.persistence.AttendeePersistence;
import edu.uoc.eventreg.service.persistence.EventFinder;
import edu.uoc.eventreg.service.persistence.EventOptionFinder;
import edu.uoc.eventreg.service.persistence.EventOptionPersistence;
import edu.uoc.eventreg.service.persistence.EventPersistence;
import edu.uoc.eventreg.service.persistence.ImagePersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the attendee local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link edu.uoc.eventreg.service.impl.AttendeeLocalServiceImpl}.
 * </p>
 *
 * @author Ana Mendoza
 * @see edu.uoc.eventreg.service.impl.AttendeeLocalServiceImpl
 * @see edu.uoc.eventreg.service.AttendeeLocalServiceUtil
 * @generated
 */
public abstract class AttendeeLocalServiceBaseImpl extends BaseLocalServiceImpl
	implements AttendeeLocalService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link edu.uoc.eventreg.service.AttendeeLocalServiceUtil} to access the attendee local service.
	 */

	/**
	 * Adds the attendee to the database. Also notifies the appropriate model listeners.
	 *
	 * @param attendee the attendee
	 * @return the attendee that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Attendee addAttendee(Attendee attendee) throws SystemException {
		attendee.setNew(true);

		return attendeePersistence.update(attendee);
	}

	/**
	 * Creates a new attendee with the primary key. Does not add the attendee to the database.
	 *
	 * @param attendeeId the primary key for the new attendee
	 * @return the new attendee
	 */
	@Override
	public Attendee createAttendee(long attendeeId) {
		return attendeePersistence.create(attendeeId);
	}

	/**
	 * Deletes the attendee with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param attendeeId the primary key of the attendee
	 * @return the attendee that was removed
	 * @throws PortalException if a attendee with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Attendee deleteAttendee(long attendeeId)
		throws PortalException, SystemException {
		return attendeePersistence.remove(attendeeId);
	}

	/**
	 * Deletes the attendee from the database. Also notifies the appropriate model listeners.
	 *
	 * @param attendee the attendee
	 * @return the attendee that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Attendee deleteAttendee(Attendee attendee) throws SystemException {
		return attendeePersistence.remove(attendee);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(Attendee.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return attendeePersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link edu.uoc.eventreg.model.impl.AttendeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return attendeePersistence.findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link edu.uoc.eventreg.model.impl.AttendeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return attendeePersistence.findWithDynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return attendeePersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection) throws SystemException {
		return attendeePersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public Attendee fetchAttendee(long attendeeId) throws SystemException {
		return attendeePersistence.fetchByPrimaryKey(attendeeId);
	}

	/**
	 * Returns the attendee with the primary key.
	 *
	 * @param attendeeId the primary key of the attendee
	 * @return the attendee
	 * @throws PortalException if a attendee with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Attendee getAttendee(long attendeeId)
		throws PortalException, SystemException {
		return attendeePersistence.findByPrimaryKey(attendeeId);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return attendeePersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the attendees.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link edu.uoc.eventreg.model.impl.AttendeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of attendees
	 * @param end the upper bound of the range of attendees (not inclusive)
	 * @return the range of attendees
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Attendee> getAttendees(int start, int end)
		throws SystemException {
		return attendeePersistence.findAll(start, end);
	}

	/**
	 * Returns the number of attendees.
	 *
	 * @return the number of attendees
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getAttendeesCount() throws SystemException {
		return attendeePersistence.countAll();
	}

	/**
	 * Updates the attendee in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param attendee the attendee
	 * @return the attendee that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Attendee updateAttendee(Attendee attendee) throws SystemException {
		return attendeePersistence.update(attendee);
	}

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
	 * Returns the attendee finder.
	 *
	 * @return the attendee finder
	 */
	public AttendeeFinder getAttendeeFinder() {
		return attendeeFinder;
	}

	/**
	 * Sets the attendee finder.
	 *
	 * @param attendeeFinder the attendee finder
	 */
	public void setAttendeeFinder(AttendeeFinder attendeeFinder) {
		this.attendeeFinder = attendeeFinder;
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
	 * Returns the event finder.
	 *
	 * @return the event finder
	 */
	public EventFinder getEventFinder() {
		return eventFinder;
	}

	/**
	 * Sets the event finder.
	 *
	 * @param eventFinder the event finder
	 */
	public void setEventFinder(EventFinder eventFinder) {
		this.eventFinder = eventFinder;
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
	 * Returns the event option finder.
	 *
	 * @return the event option finder
	 */
	public EventOptionFinder getEventOptionFinder() {
		return eventOptionFinder;
	}

	/**
	 * Sets the event option finder.
	 *
	 * @param eventOptionFinder the event option finder
	 */
	public void setEventOptionFinder(EventOptionFinder eventOptionFinder) {
		this.eventOptionFinder = eventOptionFinder;
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

		PersistedModelLocalServiceRegistryUtil.register("edu.uoc.eventreg.model.Attendee",
			attendeeLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"edu.uoc.eventreg.model.Attendee");
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
	@BeanReference(type = AttendeeFinder.class)
	protected AttendeeFinder attendeeFinder;
	@BeanReference(type = edu.uoc.eventreg.service.EventLocalService.class)
	protected edu.uoc.eventreg.service.EventLocalService eventLocalService;
	@BeanReference(type = edu.uoc.eventreg.service.EventService.class)
	protected edu.uoc.eventreg.service.EventService eventService;
	@BeanReference(type = EventPersistence.class)
	protected EventPersistence eventPersistence;
	@BeanReference(type = EventFinder.class)
	protected EventFinder eventFinder;
	@BeanReference(type = edu.uoc.eventreg.service.EventOptionLocalService.class)
	protected edu.uoc.eventreg.service.EventOptionLocalService eventOptionLocalService;
	@BeanReference(type = edu.uoc.eventreg.service.EventOptionService.class)
	protected edu.uoc.eventreg.service.EventOptionService eventOptionService;
	@BeanReference(type = EventOptionPersistence.class)
	protected EventOptionPersistence eventOptionPersistence;
	@BeanReference(type = EventOptionFinder.class)
	protected EventOptionFinder eventOptionFinder;
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
	private AttendeeLocalServiceClpInvoker _clpInvoker = new AttendeeLocalServiceClpInvoker();
}