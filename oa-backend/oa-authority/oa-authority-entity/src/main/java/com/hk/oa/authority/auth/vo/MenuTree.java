package com.hk.oa.authority.auth.vo;

import com.hk.oa.authority.auth.entity.Menu;
import com.hk.oa.common.vo.tree.TreeNode;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class MenuTree extends TreeNode {
    /**
     * 菜单名称
     */
    private String name;


    /**
     * 资源编码
     */
    private String code;


    /**
     * 资源路径
     */
    private String href;

    /**
     * 打开方式
     #TargetType{SELF:_self,相同框架;TOP:_top,当前页;BLANK:_blank,新建窗口;PAREN:_parent,父窗口}
     */
    private String target;


    private Integer sortValue;

    /**
     * 菜单图标
     */
    private String icon;

    /**
     * 类型目录 dirt 菜单 menu
     */
    private String type;


    public MenuTree(Menu menu){
        this.id=menu.getId();
        this.parentId=menu.getParentId();
        this.name=menu.getName();
        this.code=menu.getCode();
        this.href=menu.getHref();
        this.target=menu.getTarget();
        this.sortValue=menu.getSortValue();
        this.icon=menu.getIcon();
        this.type=menu.getType();
    }




}