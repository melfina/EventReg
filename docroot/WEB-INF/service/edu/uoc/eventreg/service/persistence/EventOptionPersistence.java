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

package edu.uoc.eventreg.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import edu.uoc.eventreg.model.EventOption;

/**
 * The persistence interface for the event option service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ana Mendoza
 * @see EventOptionPersistenceImpl
 * @see EventOptionUtil
 * @generated
 */
public interface EventOptionPersistence extends BasePersistence<EventOption> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EventOptionUtil} to access the event option persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the event option in the entity cache if it is enabled.
	*
	* @param eventOption the event option
	*/
	public void cacheResult(edu.uoc.eventreg.model.EventOption eventOption);

	/**
	* Caches the event options in the entity cache if it is enabled.
	*
	* @param eventOptions the event options
	*/
	public void cacheResult(
		java.util.List<edu.uoc.eventreg.model.EventOption> eventOptions);

	/**
	* Creates a new event option with the primary key. Does not add the event option to the database.
	*
	* @param id the primary key for the new event option
	* @return the new event option
	*/
	public edu.uoc.eventreg.model.EventOption create(long id);

	/**
	* Removes the event option with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the event option
	* @return the event option that was removed
	* @throws edu.uoc.eventreg.NoSuchEventOptionException if a event option with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public edu.uoc.eventreg.model.EventOption remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			edu.uoc.eventreg.NoSuchEventOptionException;

	public edu.uoc.eventreg.model.EventOption updateImpl(
		edu.uoc.eventreg.model.EventOption eventOption)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the event option with the primary key or throws a {@link edu.uoc.eventreg.NoSuchEventOptionException} if it could not be found.
	*
	* @param id the primary key of the event option
	* @return the event option
	* @throws edu.uoc.eventreg.NoSuchEventOptionException if a event option with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public edu.uoc.eventreg.model.EventOption findByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			edu.uoc.eventreg.NoSuchEventOptionException;

	/**
	* Returns the event option with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the event option
	* @return the event option, or <code>null</code> if a event option with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public edu.uoc.eventreg.model.EventOption fetchByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the event options.
	*
	* @return the event options
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<edu.uoc.eventreg.model.EventOption> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the event options.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link edu.uoc.eventreg.model.impl.EventOptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of event options
	* @param end the upper bound of the range of event options (not inclusive)
	* @return the range of event options
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<edu.uoc.eventreg.model.EventOption> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the event options.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link edu.uoc.eventreg.model.impl.EventOptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of event options
	* @param end the upper bound of the range of event options (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of event options
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<edu.uoc.eventreg.model.EventOption> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the event options from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of event options.
	*
	* @return the number of event options
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}