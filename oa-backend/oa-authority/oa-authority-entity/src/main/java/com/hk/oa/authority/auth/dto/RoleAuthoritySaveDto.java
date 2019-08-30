package com.hk.oa.authority.auth.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 实体类
 * 角色的资源
 * </p>
 *
 * @author zuihou
 * @since 2019-07-27
 */
@Data
@ApiModel(value = "RoleAuthoritySaveDTO", description = "角色的资源")
public class RoleAuthoritySaveDto implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 菜单ID
     * #auth_menu
     */
    @ApiModelProperty(value = "菜单ID")
    private List<Integer> menuIdList;

    /**
     * 资源id
     * #auth_resource
     */
    @ApiModelProperty(value = "资源ID")
    private List<Integer> resourceIdList;

    /**
     * 角色id
     * #c_auth_role
     */
    @ApiModelProperty(value = "角色id")
    @NotNull(message = "角色id不能为空")
    private Integer roleId;


    private Integer createUser;

}
