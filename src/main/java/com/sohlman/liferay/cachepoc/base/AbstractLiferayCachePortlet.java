package com.sohlman.liferay.cachepoc.base;

import com.liferay.portal.kernel.cache.PortalCache;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sohlman.liferay.cachepoc.model.CacheItem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

public abstract class AbstractLiferayCachePortlet extends MVCPortlet {
	protected abstract PortalCache<String, String> getCache();

	public void updateCache(ActionRequest actionRequest,
			ActionResponse actionResponse) {
		
		String key = ParamUtil.getString(actionRequest, "key");
		String value = ParamUtil.getString(actionRequest, "value");

		if (Validator.isNotNull(key) && Validator.isNotNull(value)) {
			getCache().put(key, value);
		}
	}
	
	
	public void flushCache(ActionRequest actionRequest,
			ActionResponse actionResponse) {

		getCache().removeAll();
	}
	
	public void removeKey(ActionRequest actionRequest,
			ActionResponse actionResponse) {
		String key = ParamUtil.getString(actionRequest, "key");
		getCache().remove(key);
	}

	@Override
	public void render(RenderRequest renderRequest, 
			RenderResponse renderResponse) 
		throws PortletException, IOException {

		PortalCache<String, String> cache = getCache();

		List<CacheItem> list = new ArrayList<CacheItem>(cache.getKeys().size());

		for (int i = 0; i < cache.getKeys().size(); i++) {
			String key = cache.getKeys().get(i);
			list.add(new CacheItem(key, cache.get(key)));
		}

		renderRequest.setAttribute("cacheItems", list);

		super.render(renderRequest, renderResponse);
	}
}
