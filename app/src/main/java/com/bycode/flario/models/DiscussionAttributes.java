package com.bycode.flario.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by michal on 19.04.2017.
 */

public class DiscussionAttributes {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("commentsCount")
    @Expose
    private Integer commentsCount;
    @SerializedName("participantsCount")
    @Expose
    private Integer participantsCount;
    @SerializedName("startTime")
    @Expose
    private String startTime;
    @SerializedName("lastTime")
    @Expose
    private String lastTime;
    @SerializedName("lastPostNumber")
    @Expose
    private Integer lastPostNumber;
    @SerializedName("canReply")
    @Expose
    private Boolean canReply;
    @SerializedName("canRename")
    @Expose
    private Boolean canRename;
    @SerializedName("canDelete")
    @Expose
    private Boolean canDelete;
    @SerializedName("canHide")
    @Expose
    private Boolean canHide;
    @SerializedName("isApproved")
    @Expose
    private Boolean isApproved;
    @SerializedName("isLocked")
    @Expose
    private Boolean isLocked;
    @SerializedName("canLock")
    @Expose
    private Boolean canLock;
    @SerializedName("canSplit")
    @Expose
    private Boolean canSplit;
    @SerializedName("isSticky")
    @Expose
    private Boolean isSticky;
    @SerializedName("canSticky")
    @Expose
    private Boolean canSticky;
    @SerializedName("canTag")
    @Expose
    private Boolean canTag;

    private Integer id;

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

    public Integer getCommentsCount() {
        return commentsCount;
    }

    public void setCommentsCount(Integer commentsCount) {
        this.commentsCount = commentsCount;
    }

    public Integer getParticipantsCount() {
        return participantsCount;
    }

    public void setParticipantsCount(Integer participantsCount) {
        this.participantsCount = participantsCount;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getLastTime() {
        return lastTime;
    }

    public void setLastTime(String lastTime) {
        this.lastTime = lastTime;
    }

    public Integer getLastPostNumber() {
        return lastPostNumber;
    }

    public void setLastPostNumber(Integer lastPostNumber) {
        this.lastPostNumber = lastPostNumber;
    }

    public Boolean getCanReply() {
        return canReply;
    }

    public void setCanReply(Boolean canReply) {
        this.canReply = canReply;
    }

    public Boolean getCanRename() {
        return canRename;
    }

    public void setCanRename(Boolean canRename) {
        this.canRename = canRename;
    }

    public Boolean getCanDelete() {
        return canDelete;
    }

    public void setCanDelete(Boolean canDelete) {
        this.canDelete = canDelete;
    }

    public Boolean getCanHide() {
        return canHide;
    }

    public void setCanHide(Boolean canHide) {
        this.canHide = canHide;
    }

    public Boolean getIsApproved() {
        return isApproved;
    }

    public void setIsApproved(Boolean isApproved) {
        this.isApproved = isApproved;
    }

    public Boolean getIsLocked() {
        return isLocked;
    }

    public void setIsLocked(Boolean isLocked) {
        this.isLocked = isLocked;
    }

    public Boolean getCanLock() {
        return canLock;
    }

    public void setCanLock(Boolean canLock) {
        this.canLock = canLock;
    }

    public Boolean getCanSplit() {
        return canSplit;
    }

    public void setCanSplit(Boolean canSplit) {
        this.canSplit = canSplit;
    }

    public Boolean getIsSticky() {
        return isSticky;
    }

    public void setIsSticky(Boolean isSticky) {
        this.isSticky = isSticky;
    }

    public Boolean getCanSticky() {
        return canSticky;
    }

    public void setCanSticky(Boolean canSticky) {
        this.canSticky = canSticky;
    }

    public Boolean getCanTag() {
        return canTag;
    }

    public void setCanTag(Boolean canTag) {
        this.canTag = canTag;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
