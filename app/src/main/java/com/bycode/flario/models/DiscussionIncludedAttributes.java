package com.bycode.flario.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by michal on 25.04.2017.
 */

public class DiscussionIncludedAttributes {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("number")
    @Expose
    private Integer number;
    @SerializedName("time")
    @Expose
    private String time;
    @SerializedName("contentType")
    @Expose
    private String contentType;
    @SerializedName("contentHtml")
    @Expose
    private String contentHtml;
    @SerializedName("editTime")
    @Expose
    private String editTime;
    @SerializedName("canEdit")
    @Expose
    private Boolean canEdit;
    @SerializedName("canDelete")
    @Expose
    private Boolean canDelete;
    @SerializedName("isApproved")
    @Expose
    private Boolean isApproved;
    @SerializedName("canApprove")
    @Expose
    private Boolean canApprove;
    @SerializedName("canFlag")
    @Expose
    private Boolean canFlag;
    @SerializedName("canLike")
    @Expose
    private Boolean canLike;
    @SerializedName("content")
    @Expose
    private DiscussionIncludedAttributesContent content;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("avatarUrl")
    @Expose
    private String avatarUrl;
    @SerializedName("bio")
    @Expose
    private String bio;
    @SerializedName("joinTime")
    @Expose
    private String joinTime;
    @SerializedName("discussionsCount")
    @Expose
    private Integer discussionsCount;
    @SerializedName("commentsCount")
    @Expose
    private Integer commentsCount;
    @SerializedName("lastSeenTime")
    @Expose
    private String lastSeenTime;
    @SerializedName("canSuspend")
    @Expose
    private Boolean canSuspend;
    @SerializedName("nameSingular")
    @Expose
    private String nameSingular;
    @SerializedName("namePlural")
    @Expose
    private String namePlural;
    @SerializedName("color")
    @Expose
    private String color;
    @SerializedName("icon")
    @Expose
    private String icon;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("backgroundUrl")
    @Expose
    private Object backgroundUrl;
    @SerializedName("backgroundMode")
    @Expose
    private Object backgroundMode;
    @SerializedName("iconUrl")
    @Expose
    private Object iconUrl;
    @SerializedName("position")
    @Expose
    private Integer position;
    @SerializedName("defaultSort")
    @Expose
    private Object defaultSort;
    @SerializedName("isChild")
    @Expose
    private Boolean isChild;
    @SerializedName("isHidden")
    @Expose
    private Boolean isHidden;
    @SerializedName("lastTime")
    @Expose
    private String lastTime;
    @SerializedName("canStartDiscussion")
    @Expose
    private Boolean canStartDiscussion;
    @SerializedName("canAddToDiscussion")
    @Expose
    private Boolean canAddToDiscussion;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getContentHtml() {
        return contentHtml;
    }

    public void setContentHtml(String contentHtml) {
        this.contentHtml = contentHtml;
    }

    public String getEditTime() {
        return editTime;
    }

    public void setEditTime(String editTime) {
        this.editTime = editTime;
    }

    public Boolean getCanEdit() {
        return canEdit;
    }

    public void setCanEdit(Boolean canEdit) {
        this.canEdit = canEdit;
    }

    public Boolean getCanDelete() {
        return canDelete;
    }

    public void setCanDelete(Boolean canDelete) {
        this.canDelete = canDelete;
    }

    public Boolean getIsApproved() {
        return isApproved;
    }

    public void setIsApproved(Boolean isApproved) {
        this.isApproved = isApproved;
    }

    public Boolean getCanApprove() {
        return canApprove;
    }

    public void setCanApprove(Boolean canApprove) {
        this.canApprove = canApprove;
    }

    public Boolean getCanFlag() {
        return canFlag;
    }

    public void setCanFlag(Boolean canFlag) {
        this.canFlag = canFlag;
    }

    public Boolean getCanLike() {
        return canLike;
    }

    public void setCanLike(Boolean canLike) {
        this.canLike = canLike;
    }

    public DiscussionIncludedAttributesContent getContent() {
        return content;
    }

    public void setContent(DiscussionIncludedAttributesContent content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(String joinTime) {
        this.joinTime = joinTime;
    }

    public Integer getDiscussionsCount() {
        return discussionsCount;
    }

    public void setDiscussionsCount(Integer discussionsCount) {
        this.discussionsCount = discussionsCount;
    }

    public Integer getCommentsCount() {
        return commentsCount;
    }

    public void setCommentsCount(Integer commentsCount) {
        this.commentsCount = commentsCount;
    }

    public String getLastSeenTime() {
        return lastSeenTime;
    }

    public void setLastSeenTime(String lastSeenTime) {
        this.lastSeenTime = lastSeenTime;
    }

    public Boolean getCanSuspend() {
        return canSuspend;
    }

    public void setCanSuspend(Boolean canSuspend) {
        this.canSuspend = canSuspend;
    }

    public String getNameSingular() {
        return nameSingular;
    }

    public void setNameSingular(String nameSingular) {
        this.nameSingular = nameSingular;
    }

    public String getNamePlural() {
        return namePlural;
    }

    public void setNamePlural(String namePlural) {
        this.namePlural = namePlural;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Object getBackgroundUrl() {
        return backgroundUrl;
    }

    public void setBackgroundUrl(Object backgroundUrl) {
        this.backgroundUrl = backgroundUrl;
    }

    public Object getBackgroundMode() {
        return backgroundMode;
    }

    public void setBackgroundMode(Object backgroundMode) {
        this.backgroundMode = backgroundMode;
    }

    public Object getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(Object iconUrl) {
        this.iconUrl = iconUrl;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Object getDefaultSort() {
        return defaultSort;
    }

    public void setDefaultSort(Object defaultSort) {
        this.defaultSort = defaultSort;
    }

    public Boolean getIsChild() {
        return isChild;
    }

    public void setIsChild(Boolean isChild) {
        this.isChild = isChild;
    }

    public Boolean getIsHidden() {
        return isHidden;
    }

    public void setIsHidden(Boolean isHidden) {
        this.isHidden = isHidden;
    }

    public String getLastTime() {
        return lastTime;
    }

    public void setLastTime(String lastTime) {
        this.lastTime = lastTime;
    }

    public Boolean getCanStartDiscussion() {
        return canStartDiscussion;
    }

    public void setCanStartDiscussion(Boolean canStartDiscussion) {
        this.canStartDiscussion = canStartDiscussion;
    }

    public Boolean getCanAddToDiscussion() {
        return canAddToDiscussion;
    }

    public void setCanAddToDiscussion(Boolean canAddToDiscussion) {
        this.canAddToDiscussion = canAddToDiscussion;
    }
}
