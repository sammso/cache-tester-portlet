package com.sohlman.liferay.cachepoc.portlet;

import com.liferay.portal.kernel.cache.MultiVMPoolUtil;
import com.liferay.portal.kernel.cache.PortalCache;
import com.liferay.portal.kernel.cache.SingleVMPoolUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sohlman.liferay.cachepoc.base.AbstractLiferayCachePortlet;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * Portlet implementation class LiferayCachePocPortlet
 */
public class SingleVmCachePortlet extends AbstractLiferayCachePortlet {

	@Override
	protected PortalCache<String, String> getCache() {
		return SingleVMPoolUtil.getCache(SingleVmCachePortlet.class.getName());
	}
}
