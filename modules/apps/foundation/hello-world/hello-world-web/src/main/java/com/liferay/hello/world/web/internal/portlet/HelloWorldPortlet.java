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

package com.liferay.hello.world.web.internal.portlet;

import com.liferay.hello.world.web.internal.constants.HelloWorldPortletKeys;
import com.liferay.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ReleaseInfo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.service.JournalArticleServiceUtil;

import com.liferay.portal.kernel.util.WebKeys;
import org.osgi.service.component.annotations.Component;

/**
 * @author Peter Fellwock
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.css-class-wrapper=portlet-hello-world",
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.icon=/icons/hello_world.png",
		"com.liferay.portlet.layout-cacheable=true",
		"com.liferay.portlet.preferences-owned-by-group=true",
		"com.liferay.portlet.private-request-attributes=false",
		"com.liferay.portlet.private-session-attributes=false",
		"com.liferay.portlet.remoteable=true",
		"com.liferay.portlet.render-weight=50",
		"com.liferay.portlet.use-default-template=true",
		"javax.portlet.display-name=Hello World",
		"javax.portlet.expiration-cache=0",
		"javax.portlet.init-param.always-display-default-configuration-icons=true",
		"javax.portlet.name=" + HelloWorldPortletKeys.HELLO_WORLD,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=guest,power-user,user",
		"javax.portlet.supports.mime-type=text/html"
	},
	service = Portlet.class
)
public class HelloWorldPortlet extends MVCPortlet {

	@Override
	public void doView(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {

		final long companyId = PortalUtil.getDefaultCompanyId();
		long defGroupId = 0;
		try {
			defGroupId = GroupLocalServiceUtil.getGroup(companyId, "Guest").getGroupId();
		} catch (PortalException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		}

		User currentUser = null;
		try {
			currentUser = PortalUtil.getUser(renderRequest);
		} catch (PortalException e1) {
			e1.printStackTrace();
		} catch (SystemException e1) {
			e1.printStackTrace();
		}
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(
			WebKeys.THEME_DISPLAY);
		if (currentUser == null) {
			currentUser = themeDisplay.getUser();
		}

		String s2 = "";
		//List<JournalArticle> myResults = new ArrayList<JournalArticle>();
		OrderByComparator obc = null;
		MyTestClass mtc = new MyTestClass();
		List<JournalArticle> myResults = mtc.getList(defGroupId,obc);
		try {
			//myResults = JournalArticleLocalServiceUtil.getArticles(defGroupId, 0, 0, 10000, obc);
			// myResults = JournalArticleServiceUtil.getArticles(defGroupId, 0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		renderResponse.setContentType(ContentTypes.TEXT_HTML_UTF8);

		PrintWriter printWriter = renderResponse.getWriter();

		String s = String.format("Group Id = %s --- User = %s --- article count = %s ---", defGroupId, currentUser.getScreenName(), myResults.size());
		printWriter.print(s);
	}

}
