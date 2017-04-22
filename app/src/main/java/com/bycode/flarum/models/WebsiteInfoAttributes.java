package com.bycode.flarum.models;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by michal on 22.04.2017.
 */

public class WebsiteInfoAttributes {
    private String title;
    private String description;
    private Boolean showLanguageSelector;
    private String baseUrl;
    private String basePath;
    private Boolean debug;
    private String apiUrl;
    private String welcomeTitle;
    private String welcomeMessage;
    private String themePrimaryColor;
    private String themeSecondaryColor;
    private Object logoUrl;
    private Object faviconUrl;
    private Object headerHtml;
    private Boolean allowSignUp;
    private String defaultRoute;
    private Boolean canViewDiscussions;
    private Boolean canStartDiscussion;
    private Boolean canViewFlags;
    private Object guidelinesUrl;
    private String pusherKey;
    private Object pusherCluster;
    private String minPrimaryTags;
    private String maxPrimaryTags;
    private String minSecondaryTags;
    private String maxSecondaryTags;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getShowLanguageSelector() {
        return showLanguageSelector;
    }

    public void setShowLanguageSelector(Boolean showLanguageSelector) {
        this.showLanguageSelector = showLanguageSelector;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getBasePath() {
        return basePath;
    }

    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }

    public Boolean getDebug() {
        return debug;
    }

    public void setDebug(Boolean debug) {
        this.debug = debug;
    }

    public String getApiUrl() {
        return apiUrl;
    }

    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
    }

    public String getWelcomeTitle() {
        return welcomeTitle;
    }

    public void setWelcomeTitle(String welcomeTitle) {
        this.welcomeTitle = welcomeTitle;
    }

    public String getWelcomeMessage() {
        return welcomeMessage;
    }

    public void setWelcomeMessage(String welcomeMessage) {
        this.welcomeMessage = welcomeMessage;
    }

    public String getThemePrimaryColor() {
        return themePrimaryColor;
    }

    public void setThemePrimaryColor(String themePrimaryColor) {
        this.themePrimaryColor = themePrimaryColor;
    }

    public String getThemeSecondaryColor() {
        return themeSecondaryColor;
    }

    public void setThemeSecondaryColor(String themeSecondaryColor) {
        this.themeSecondaryColor = themeSecondaryColor;
    }

    public Object getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(Object logoUrl) {
        this.logoUrl = logoUrl;
    }

    public Object getFaviconUrl() {
        return faviconUrl;
    }

    public void setFaviconUrl(Object faviconUrl) {
        this.faviconUrl = faviconUrl;
    }

    public Object getHeaderHtml() {
        return headerHtml;
    }

    public void setHeaderHtml(Object headerHtml) {
        this.headerHtml = headerHtml;
    }

    public Boolean getAllowSignUp() {
        return allowSignUp;
    }

    public void setAllowSignUp(Boolean allowSignUp) {
        this.allowSignUp = allowSignUp;
    }

    public String getDefaultRoute() {
        return defaultRoute;
    }

    public void setDefaultRoute(String defaultRoute) {
        this.defaultRoute = defaultRoute;
    }

    public Boolean getCanViewDiscussions() {
        return canViewDiscussions;
    }

    public void setCanViewDiscussions(Boolean canViewDiscussions) {
        this.canViewDiscussions = canViewDiscussions;
    }

    public Boolean getCanStartDiscussion() {
        return canStartDiscussion;
    }

    public void setCanStartDiscussion(Boolean canStartDiscussion) {
        this.canStartDiscussion = canStartDiscussion;
    }

    public Boolean getCanViewFlags() {
        return canViewFlags;
    }

    public void setCanViewFlags(Boolean canViewFlags) {
        this.canViewFlags = canViewFlags;
    }

    public Object getGuidelinesUrl() {
        return guidelinesUrl;
    }

    public void setGuidelinesUrl(Object guidelinesUrl) {
        this.guidelinesUrl = guidelinesUrl;
    }

    public String getPusherKey() {
        return pusherKey;
    }

    public void setPusherKey(String pusherKey) {
        this.pusherKey = pusherKey;
    }

    public Object getPusherCluster() {
        return pusherCluster;
    }

    public void setPusherCluster(Object pusherCluster) {
        this.pusherCluster = pusherCluster;
    }

    public String getMinPrimaryTags() {
        return minPrimaryTags;
    }

    public void setMinPrimaryTags(String minPrimaryTags) {
        this.minPrimaryTags = minPrimaryTags;
    }

    public String getMaxPrimaryTags() {
        return maxPrimaryTags;
    }

    public void setMaxPrimaryTags(String maxPrimaryTags) {
        this.maxPrimaryTags = maxPrimaryTags;
    }

    public String getMinSecondaryTags() {
        return minSecondaryTags;
    }

    public void setMinSecondaryTags(String minSecondaryTags) {
        this.minSecondaryTags = minSecondaryTags;
    }

    public String getMaxSecondaryTags() {
        return maxSecondaryTags;
    }

    public void setMaxSecondaryTags(String maxSecondaryTags) {
        this.maxSecondaryTags = maxSecondaryTags;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

