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

package edu.uoc.eventreg.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import edu.uoc.eventreg.model.Image;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Image in entity cache.
 *
 * @author Ana Mendoza
 * @see Image
 * @generated
 */
public class ImageCacheModel implements CacheModel<Image>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{imageId=");
		sb.append(imageId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", eventId=");
		sb.append(eventId);
		sb.append(", dlFileEntryId=");
		sb.append(dlFileEntryId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Image toEntityModel() {
		ImageImpl imageImpl = new ImageImpl();

		imageImpl.setImageId(imageId);
		imageImpl.setCompanyId(companyId);
		imageImpl.setGroupId(groupId);
		imageImpl.setEventId(eventId);

		if (dlFileEntryId == null) {
			imageImpl.setDlFileEntryId(StringPool.BLANK);
		}
		else {
			imageImpl.setDlFileEntryId(dlFileEntryId);
		}

		imageImpl.resetOriginalValues();

		return imageImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		imageId = objectInput.readLong();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		eventId = objectInput.readLong();
		dlFileEntryId = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(imageId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(eventId);

		if (dlFileEntryId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(dlFileEntryId);
		}
	}

	public long imageId;
	public long companyId;
	public long groupId;
	public long eventId;
	public String dlFileEntryId;
}