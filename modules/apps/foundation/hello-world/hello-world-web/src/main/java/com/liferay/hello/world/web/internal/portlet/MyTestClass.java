package com.liferay.hello.world.web.internal.portlet;

import com.liferay.journal.model.JournalArticle;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.journal.service.JournalArticleLocalServiceUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rimi.saadou on 4/7/2017.
 */
public class MyTestClass {

	public List<JournalArticle> getList(long defGroupId, OrderByComparator obc) {
		return getListImpl( defGroupId,  obc);
	}

	private List<JournalArticle> getListImpl(long defGroupId, OrderByComparator obc) {
		List<JournalArticle> myResults = new ArrayList<JournalArticle>();
		try {
			myResults =
				JournalArticleLocalServiceUtil.getArticles(defGroupId, 0, 0,
					10000, obc);
			// myResults = JournalArticleServiceUtil.getArticles(defGroupId, 0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return myResults;
	}
}
