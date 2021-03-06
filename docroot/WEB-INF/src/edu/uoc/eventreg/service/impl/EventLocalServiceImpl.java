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

package edu.uoc.eventreg.service.impl;

import java.util.Calendar;
import java.util.List;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Junction;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import edu.uoc.eventreg.model.Event;
import edu.uoc.eventreg.service.EventLocalServiceUtil;
import edu.uoc.eventreg.service.base.EventLocalServiceBaseImpl;
import edu.uoc.eventreg.service.persistence.EventFinderUtil;
import edu.uoc.eventreg.service.persistence.EventUtil;

/**
 * The implementation of the event local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link edu.uoc.eventreg.service.EventLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Ana Mendoza
 * @see edu.uoc.eventreg.service.base.EventLocalServiceBaseImpl
 * @see edu.uoc.eventreg.service.EventLocalServiceUtil
 */
public class EventLocalServiceImpl extends EventLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link edu.uoc.eventreg.service.EventLocalServiceUtil} to access the event local service.
	 */
	
	public List<Object[]> findDayCount (long companyId, long groupId) {
		
		return EventFinderUtil.findDayCount(companyId, groupId);
	}
	
	public long findAvailableSeats (long eventId) {
		return EventFinderUtil.findAvailableSeats(eventId);
	}
	
	public List<Event> findGroupEvents (long companyId, long groupId) {
		List<Event> events = null;
		
		try {
			return EventUtil.findByGroupEvents(companyId, groupId);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		
		return events;
	}
	
	@SuppressWarnings("unchecked")
	public List<Event> findPublicEvents (long companyId, long groupId) {
			
		List<Event> events = null;
		
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Event.class, getClassLoader());
		Junction junction = RestrictionsFactoryUtil.conjunction();
		junction.add(RestrictionsFactoryUtil.eq("companyId", companyId));
		junction.add(RestrictionsFactoryUtil.eq("groupId", groupId));
		junction.add(RestrictionsFactoryUtil.eq("status", WorkflowConstants.STATUS_APPROVED));
		junction.add(RestrictionsFactoryUtil.gt("startDate", Calendar.getInstance().getTime()));
		
		dynamicQuery.add(junction);
		dynamicQuery.addOrder(OrderFactoryUtil.asc("startDate"));
		
		try {
			events = (List<Event>) EventLocalServiceUtil.dynamicQuery(dynamicQuery, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		} catch (SystemException e) {
			e.printStackTrace();
		}
			
		return events;
	}
	
	@SuppressWarnings("unchecked")
	public List<Event> searchEvents (long companyId, long groupId, String title, String description, String location, int status, boolean nextEvents, boolean andSearch, int start, int end) {
			
		List<Event> events = null;
		
		DynamicQuery dynamicQuery = searchEventsQuery(companyId, groupId, title, description, location, status, nextEvents, andSearch);
		
		try {
			events = (List<Event>) EventLocalServiceUtil.dynamicQuery(dynamicQuery, start, end);
		} catch (SystemException e) {
			e.printStackTrace();
		}
			
		return events;
	}
	
	public int searchEventsCount (long companyId, long groupId, String title, String description, String location, int status, boolean nextEvents, boolean andSearch) {

		int count = 0;
		DynamicQuery dynamicQuery = searchEventsQuery(companyId, groupId, title, description, location, status, nextEvents, andSearch);
			
		try {
			count = (int) EventLocalServiceUtil.dynamicQueryCount(dynamicQuery);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		
		return count;
	}
	
	private DynamicQuery searchEventsQuery (long companyId, long groupId, String title, String description, String location, int status, boolean nextEvents, boolean andSearch) {
		
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Event.class, getClassLoader());
		
		Junction junction = null;
		if(andSearch)
			junction = RestrictionsFactoryUtil.conjunction();
		else
			junction = RestrictionsFactoryUtil.disjunction();
		
		if (Validator.isNotNull(title) && !title.isEmpty())
			junction.add(RestrictionsFactoryUtil.ilike("title", "%"+title+"%"));
		
		if (Validator.isNotNull(description) && !description.isEmpty())
			junction.add(RestrictionsFactoryUtil.ilike("description", "%"+description+"%"));
		
		if (Validator.isNotNull(location) && !location.isEmpty())
			junction.add(RestrictionsFactoryUtil.ilike("location", "%"+location+"%"));
	
		if (status != 0)
			junction.add(RestrictionsFactoryUtil.eq("status", status));
		
		Junction groupJunction = RestrictionsFactoryUtil.conjunction();
		groupJunction.add(junction);
		groupJunction.add(RestrictionsFactoryUtil.eq("companyId", companyId));
		groupJunction.add(RestrictionsFactoryUtil.eq("groupId", groupId));

		if (nextEvents) {
			Calendar cal = Calendar.getInstance();
			groupJunction.add(RestrictionsFactoryUtil.gt("startDate", cal.getTime()));
		}
		
		dynamicQuery.add(groupJunction);

		return dynamicQuery;
	}
}